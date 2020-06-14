package com.ruoyi.auth.exception;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.ruoyi.common.core.constant.HttpStatus;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.common.core.web.domain.AjaxResult;

/**
 * 自定义异常返回
 *
 * @author ruoyi
 **/
public class CustomOauthExceptionSerializer extends StdSerializer<CustomOauthException>
{
    private static final long serialVersionUID = 1L;

    private static final Logger log = LoggerFactory.getLogger(CustomOauthExceptionSerializer.class);

    public static final String BAD_CREDENTIALS = "Bad credentials";

    public CustomOauthExceptionSerializer()
    {
        super(CustomOauthException.class);
    }

    @Override
    public void serialize(CustomOauthException e, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException
    {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField(AjaxResult.CODE_TAG, HttpStatus.ERROR);
        if (StringUtils.equals(e.getMessage(), BAD_CREDENTIALS))
        {
            jsonGenerator.writeStringField(AjaxResult.MSG_TAG, "用户名或密码错误");
        }
        else
        {
            log.warn("oauth2 认证异常 {} ", e);
            jsonGenerator.writeStringField(AjaxResult.MSG_TAG, e.getMessage());
        }
        jsonGenerator.writeEndObject();
    }
}