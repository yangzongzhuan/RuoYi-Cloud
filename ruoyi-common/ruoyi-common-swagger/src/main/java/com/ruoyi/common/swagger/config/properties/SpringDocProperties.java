package com.ruoyi.common.swagger.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;

/**
 * Swagger 配置属性
 *
 * @author ruoyi
 */
@ConfigurationProperties(prefix = "springdoc")
public class SpringDocProperties
{
    /**
     * 网关
     */
    private String gatewayUrl;

    /**
     * 文档基本信息
     */
    @NestedConfigurationProperty
    private InfoProperties info = new InfoProperties();

    /**
     * <p>
     * 文档的基础属性信息
     * </p>
     *
     * @see io.swagger.v3.oas.models.info.Info
     *
     * 为了 springboot 自动生产配置提示信息，所以这里复制一个类出来
     */
    public static class InfoProperties
    {
        /**
         * 标题
         */
        private String title = null;

        /**
         * 描述
         */
        private String description = null;

        /**
         * 联系人信息
         */
        @NestedConfigurationProperty
        private Contact contact = null;

        /**
         * 许可证
         */
        @NestedConfigurationProperty
        private License license = null;

        /**
         * 版本
         */
        private String version = null;

        public String getTitle()
        {
            return title;
        }

        public void setTitle(String title)
        {
            this.title = title;
        }

        public String getDescription()
        {
            return description;
        }

        public void setDescription(String description)
        {
            this.description = description;
        }

        public Contact getContact()
        {
            return contact;
        }

        public void setContact(Contact contact)
        {
            this.contact = contact;
        }

        public License getLicense()
        {
            return license;
        }

        public void setLicense(License license)
        {
            this.license = license;
        }

        public String getVersion()
        {
            return version;
        }

        public void setVersion(String version)
        {
            this.version = version;
        }
    }

    public String getGatewayUrl()
    {
        return gatewayUrl;
    }

    public void setGatewayUrl(String gatewayUrl)
    {
        this.gatewayUrl = gatewayUrl;
    }

    public InfoProperties getInfo()
    {
        return info;
    }

    public void setInfo(InfoProperties info)
    {
        this.info = info;
    }
}
