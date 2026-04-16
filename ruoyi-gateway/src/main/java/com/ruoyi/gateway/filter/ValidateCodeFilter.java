package com.ruoyi.gateway.filter;

import java.nio.charset.StandardCharsets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.core.utils.ServletUtils;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.gateway.config.properties.CaptchaProperties;
import com.ruoyi.gateway.service.ValidateCodeService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ValidateCodeFilter extends AbstractGatewayFilterFactory<Object>
{
    private final static String[] VALIDATE_URL = new String[] { "/auth/login", "/auth/register" };

    @Autowired
    private ValidateCodeService validateCodeService;

    @Autowired
    private CaptchaProperties captchaProperties;

    private static final String CODE = "code";

    private static final String UUID = "uuid";

    @Override
    public GatewayFilter apply(Object config)
    {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();

            if (!StringUtils.equalsAnyIgnoreCase(request.getURI().getPath(), VALIDATE_URL) || !captchaProperties.getEnabled())
            {
                return chain.filter(exchange);
            }

            return DataBufferUtils.join(exchange.getRequest().getBody())
                .flatMap(dataBuffer -> {
                    byte[] bytes = new byte[dataBuffer.readableByteCount()];
                    dataBuffer.read(bytes);
                    DataBufferUtils.release(dataBuffer);
                    String bodyString = new String(bytes, StandardCharsets.UTF_8);

                    try
                    {
                        JSONObject obj = JSON.parseObject(bodyString);
                        validateCodeService.checkCaptcha(obj.getString(CODE), obj.getString(UUID));
                    }
                    catch (Exception e)
                    {
                        return ServletUtils.webFluxResponseWriter(exchange.getResponse(), e.getMessage());
                    }

                    ServerHttpRequest mutatedRequest = new ServerHttpRequestDecorator(exchange.getRequest())
                    {
                        @Override
                        public Flux<DataBuffer> getBody()
                        {
                            return Flux.just(exchange.getResponse().bufferFactory().wrap(bytes));
                        }
                    };

                    return chain.filter(exchange.mutate().request(mutatedRequest).build());
                })
                .switchIfEmpty(chain.filter(exchange));
        };
    }
}
