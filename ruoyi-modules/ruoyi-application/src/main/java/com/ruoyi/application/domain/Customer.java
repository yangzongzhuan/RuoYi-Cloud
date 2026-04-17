package com.ruoyi.application.domain;

import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

public class Customer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private Long id;

    @Excel(name = "客户姓名")
    private String name;

    @Excel(name = "手机号")
    private String mobile;

    @Excel(name = "客户地址")
    private String address;

    @Excel(name = "性别", readConverterExp = "0=男,1=女,2=未知")
    private Integer sex;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date bornDate;

    @Excel(name = "客户特征", readConverterExp = "1=好沟通,2=不好沟通,3=爱投诉")
    private Integer feature;

    @Excel(name = "驾驶证号")
    private String driverNum;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "驾驶证到期日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date driverVdate;

    @Excel(name = "身份证号")
    private String idcardNum;

    @Excel(name = "微信昵称")
    private String wechatName;

    @Excel(name = "微信appid")
    private String wechatAppid;

    @Excel(name = "微信openid")
    private String wechatOpenid;

    @Excel(name = "是否可用", readConverterExp = "0=禁用,1=可用")
    private Integer publish;

    private Long createUser;

    private Long updateUser;

    private String delFlag;

    private List<CustomerCar> cars;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public Integer getSex()
    {
        return sex;
    }

    public void setSex(Integer sex)
    {
        this.sex = sex;
    }

    public Date getBornDate()
    {
        return bornDate;
    }

    public void setBornDate(Date bornDate)
    {
        this.bornDate = bornDate;
    }

    public Integer getFeature()
    {
        return feature;
    }

    public void setFeature(Integer feature)
    {
        this.feature = feature;
    }

    public String getDriverNum()
    {
        return driverNum;
    }

    public void setDriverNum(String driverNum)
    {
        this.driverNum = driverNum;
    }

    public Date getDriverVdate()
    {
        return driverVdate;
    }

    public void setDriverVdate(Date driverVdate)
    {
        this.driverVdate = driverVdate;
    }

    public String getIdcardNum()
    {
        return idcardNum;
    }

    public void setIdcardNum(String idcardNum)
    {
        this.idcardNum = idcardNum;
    }

    public String getWechatName()
    {
        return wechatName;
    }

    public void setWechatName(String wechatName)
    {
        this.wechatName = wechatName;
    }

    public String getWechatAppid()
    {
        return wechatAppid;
    }

    public void setWechatAppid(String wechatAppid)
    {
        this.wechatAppid = wechatAppid;
    }

    public String getWechatOpenid()
    {
        return wechatOpenid;
    }

    public void setWechatOpenid(String wechatOpenid)
    {
        this.wechatOpenid = wechatOpenid;
    }

    public Integer getPublish()
    {
        return publish;
    }

    public void setPublish(Integer publish)
    {
        this.publish = publish;
    }

    public Long getCreateUser()
    {
        return createUser;
    }

    public void setCreateUser(Long createUser)
    {
        this.createUser = createUser;
    }

    public Long getUpdateUser()
    {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser)
    {
        this.updateUser = updateUser;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public List<CustomerCar> getCars()
    {
        return cars;
    }

    public void setCars(List<CustomerCar> cars)
    {
        this.cars = cars;
    }
}
