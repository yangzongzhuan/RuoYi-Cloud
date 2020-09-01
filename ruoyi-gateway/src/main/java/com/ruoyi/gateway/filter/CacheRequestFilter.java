package com.ruoyi.gateway.filter;

import java.util.Collections;
import java.util.List;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CacheRequestFilter extends AbstractGatewayFilterFactory<CacheRequestFilter.Config>
{
    public CacheRequestFilter()
    {
        super(Config.class);
    }

    @Override
    public String name()
    {
        return "CacheRequestFilter";
    }

    @Override
    public GatewayFilter apply(Config config)
    {
        CacheRequestGatewayFilter cacheRequestGatewayFilter = new CacheRequestGatewayFilter();
        Integer order = config.getOrder();
        if (order == null)
        {
            return cacheRequestGatewayFilter;
        }
        return new OrderedGatewayFilter(cacheRequestGatewayFilter, order);
    }

    public static class CacheRequestGatewayFilter implements GatewayFilter
    {
        @Override
        public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain)
        {
            // GET DELETE 不过滤
            HttpMethod method = exchange.getRequest().getMethod();
            if (method == null || method.matches("GET") || method.matches("DELETE"))
            {
                return chain.filter(exchange);
            }
            return DataBufferUtils.join(exchange.getRequest().getBody()).map(dataBuffer -> {
                byte[] bytes = new byte[dataBuffer.readableByteCount()];
                dataBuffer.read(bytes);
                DataBufferUtils.release(dataBuffer);
                return bytes;
            }).defaultIfEmpty(new byte[0]).flatMap(bytes -> {
                DataBufferFactory dataBufferFactory = exchange.getResponse().bufferFactory();
                ServerHttpRequestDecorator decorator = new ServerHttpRequestDecorator(exchange.getRequest())
                {
                    @Override
                    public Flux<DataBuffer> getBody()
                    {
                        if (bytes.length > 0)
                        {
                            return Flux.just(dataBufferFactory.wrap(bytes));
                        }
                        return Flux.empty();
                    }
                };
                return chain.filter(exchange.mutate().request(decorator).build());
            });
        }
    }

    @Override
    public List<String> shortcutFieldOrder()
    {
        return Collections.singletonList("order");
    }

    static class Config
    {
        private Integer order;

        public Integer getOrder()
        {
            return order;
        }

        public void setOrder(Integer order)
        {
            this.order = order;
        }
    }
}