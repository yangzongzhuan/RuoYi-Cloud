package com.ruoyi.auth.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * oauth2自定义异常
 *
 * @author ruoyi
 **/
@JsonSerialize(using = CustomOauthExceptionSerializer.class)
public class CustomOauthException extends OAuth2Exception
{
    private static final long serialVersionUID = 1L;

    public CustomOauthException(String msg)
    {
        super(msg);
    }
}