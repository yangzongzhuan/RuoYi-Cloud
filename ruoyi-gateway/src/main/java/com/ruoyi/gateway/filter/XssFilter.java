package com.ruoyi.gateway.filter;

import java.nio.charset.StandardCharsets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.core.io.buffer.NettyDataBufferFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.common.core.utils.html.EscapeUtil;
import com.ruoyi.gateway.config.properties.XssProperties;
import io.netty.buffer.ByteBufAllocator;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 跨站脚本过滤器
 *
 * @author ruoyi
 */
@Component
@ConditionalOnProperty(value = "security.xss.enabled", havingValue = "true")
public class XssFilter implements GlobalFilter, Ordered
{
    // 跨站脚本的 xss 配置，nacos自行添加
    @Autowired
    private XssProperties xss;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain)
    {
        ServerHttpRequest request = exchange.getRequest();
        // xss开关未开启 或 通过nacos关闭，不过滤
        if (!xss.getEnabled())
        {
            return chain.filter(exchange);
        }
        // GET DELETE 不过滤
        HttpMethod method = request.getMethod();
        if (method == null || method == HttpMethod.GET || method == HttpMethod.DELETE)
        {
            return chain.filter(exchange);
        }
        // 非json类型，不过滤
        if (!isJsonRequest(exchange))
        {
            return chain.filter(exchange);
        }
        // excludeUrls 不过滤
        String url = request.getURI().getPath();
        if (StringUtils.matches(url, xss.getExcludeUrls()))
        {
            return chain.filter(exchange);
        }
        ServerHttpRequestDecorator httpRequestDecorator = requestDecorator(exchange);
        return chain.filter(exchange.mutate().request(httpRequestDecorator).build());

    }

    private ServerHttpRequestDecorator requestDecorator(ServerWebExchange exchange)
    {
        ServerHttpRequestDecorator serverHttpRequestDecorator = new ServerHttpRequestDecorator(exchange.getRequest())
        {
            @Override
            public Flux<DataBuffer> getBody()
            {
                Flux<DataBuffer> body = super.getBody();
                return body.buffer().map(dataBuffers -> {
                    DataBufferFactory dataBufferFactory = new DefaultDataBufferFactory();
                    DataBuffer join = dataBufferFactory.join(dataBuffers);
                    byte[] content = new byte[join.readableByteCount()];
                    join.read(content);
                    DataBufferUtils.release(join);
                    String bodyStr = new String(content, StandardCharsets.UTF_8);
                    // 防xss攻击过滤
                    bodyStr = EscapeUtil.clean(bodyStr);
                    // 转成字节
                    byte[] bytes = bodyStr.getBytes();
                    NettyDataBufferFactory nettyDataBufferFactory = new NettyDataBufferFactory(ByteBufAllocator.DEFAULT);
                    DataBuffer buffer = nettyDataBufferFactory.allocateBuffer(bytes.length);
                    buffer.write(bytes);
                    return buffer;
                });
            }

            @Override
            public HttpHeaders getHeaders()
            {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.putAll(super.getHeaders());
                // 由于修改了请求体的body，导致content-length长度不确定，因此需要删除原先的content-length
                httpHeaders.remove(HttpHeaders.CONTENT_LENGTH);
                httpHeaders.set(HttpHeaders.TRANSFER_ENCODING, "chunked");
                return httpHeaders;
            }

        };
        return serverHttpRequestDecorator;
    }

    /**
     * 是否是Json请求
     * 
     * @param exchange HTTP请求
     */
    public boolean isJsonRequest(ServerWebExchange exchange)
    {
        String header = exchange.getRequest().getHeaders().getFirst(HttpHeaders.CONTENT_TYPE);
        return StringUtils.startsWithIgnoreCase(header, MediaType.APPLICATION_JSON_VALUE);
    }

    @Override
    public int getOrder()
    {
        return -100;
    }
}
