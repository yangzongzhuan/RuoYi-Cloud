package com.ruoyi.common.core.utils.web;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.core.exception.CheckedException;
import org.bouncycastle.util.encoders.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class WebUtils extends org.springframework.web.util.WebUtils
{
    private final Logger logger = LoggerFactory.getLogger(WebUtils.class);

    private static final String BASIC_ = "Basic ";

//    /**
//     * 判断是否ajax请求 spring ajax 返回含有 ResponseBody 或者 RestController注解
//     *
//     * @param handlerMethod HandlerMethod
//     * @return 是否ajax请求
//     */
//    public boolean isBody(HandlerMethod handlerMethod)
//    {
//        ResponseBody responseBody = ClassUtils.getAnnotation(handlerMethod, ResponseBody.class);
//        return responseBody != null;
//    }

    /**
     * 读取cookie
     *
     * @param name cookie name
     * @return cookie value
     */
    public String getCookieVal(String name)
    {
        HttpServletRequest request = WebUtils.getRequest();
        Assert.notNull(request, "request from RequestContextHolder is null");
        return getCookieVal(request, name);
    }

    /**
     * 读取cookie
     *
     * @param request HttpServletRequest
     * @param name cookie name
     * @return cookie value
     */
    public String getCookieVal(HttpServletRequest request, String name)
    {
        Cookie cookie = getCookie(request, name);
        return cookie != null ? cookie.getValue() : null;
    }

    /**
     * 清除 某个指定的cookie
     *
     * @param response HttpServletResponse
     * @param key cookie key
     */
    public void removeCookie(HttpServletResponse response, String key)
    {
        setCookie(response, key, null, 0);
    }

    /**
     * 设置cookie
     *
     * @param response HttpServletResponse
     * @param name cookie name
     * @param value cookie value
     * @param maxAgeInSeconds maxage
     */
    public void setCookie(HttpServletResponse response, String name, String value, int maxAgeInSeconds)
    {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAgeInSeconds);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
    }

    /**
     * 获取 HttpServletRequest
     *
     * @return {HttpServletRequest}
     */
    public static HttpServletRequest getRequest()
    {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 获取 HttpServletResponse
     *
     * @return {HttpServletResponse}
     */
    public HttpServletResponse getResponse()
    {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    /**
     * 返回json
     *
     * @param response HttpServletResponse
     * @param result 结果对象
     */
    public void renderJson(HttpServletResponse response, Object result)
    {
        renderJson(response, result, MediaType.APPLICATION_JSON_VALUE);
    }

    /**
     * 返回json
     *
     * @param response HttpServletResponse
     * @param result 结果对象
     * @param contentType contentType
     */
    public void renderJson(HttpServletResponse response, Object result, String contentType)
    {
        response.setCharacterEncoding("UTF-8");
        response.setContentType(contentType);
        try (PrintWriter out = response.getWriter())
        {
            out.append(JSON.toJSONString(result));
        }
        catch (IOException e)
        {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * 从request 获取CLIENT_ID
     *
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String[] getClientId(ServerHttpRequest request) throws UnsupportedEncodingException
    {
        String header = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

        if (header == null || !header.startsWith(BASIC_))
        {
            throw new CheckedException("请求头中client信息为空");
        }
        byte[] base64Token = header.substring(6).getBytes("UTF-8");
        byte[] decoded;
        try
        {
            decoded = Base64.decode(base64Token);
        }
        catch (IllegalArgumentException e)
        {
            throw new CheckedException("Failed to decode basic authentication token");
        }

        String token = new String(decoded, StandardCharsets.UTF_8);

        int delim = token.indexOf(":");

        if (delim == -1)
        {
            throw new CheckedException("Invalid basic authentication token");
        }
        return new String[] { token.substring(0, delim), token.substring(delim + 1) };
    }
}
