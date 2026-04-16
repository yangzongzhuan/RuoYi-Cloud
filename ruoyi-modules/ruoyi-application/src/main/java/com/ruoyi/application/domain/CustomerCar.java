package com.ruoyi.application.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

public class CustomerCar extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private Long id;

    private Long customerId;

    @Excel(name = "车牌号")
    private String carNum;

    @Excel(name = "品牌名称")
    private String brandName;

    @Excel(name = "车系名称")
    private String modelName;

    @Excel(name = "年款名称")
    private String yearName;

    @Excel(name = "配置名称")
    private String styleName;

    @Excel(name = "颜色")
    private Integer color;

    @Excel(name = "vin码")
    private String vin;

    @Excel(name = "发动机号")
    private String engineNum;

    @Excel(name = "行驶证照片")
    private String drivingImg;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "行驶证注册日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date driveRegDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "行驶证发证日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date driveIssueDate;

    private Long createUser;

    private Long updateUser;

    private String delFlag;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getCustomerId()
    {
        return customerId;
    }

    public void setCustomerId(Long customerId)
    {
        this.customerId = customerId;
    }

    public String getCarNum()
    {
        return carNum;
    }

    public void setCarNum(String carNum)
    {
        this.carNum = carNum;
    }

    public String getBrandName()
    {
        return brandName;
    }

    public void setBrandName(String brandName)
    {
        this.brandName = brandName;
    }

    public String getModelName()
    {
        return modelName;
    }

    public void setModelName(String modelName)
    {
        this.modelName = modelName;
    }

    public String getYearName()
    {
        return yearName;
    }

    public void setYearName(String yearName)
    {
        this.yearName = yearName;
    }

    public String getStyleName()
    {
        return styleName;
    }

    public void setStyleName(String styleName)
    {
        this.styleName = styleName;
    }

    public Integer getColor()
    {
        return color;
    }

    public void setColor(Integer color)
    {
        this.color = color;
    }

    public String getVin()
    {
        return vin;
    }

    public void setVin(String vin)
    {
        this.vin = vin;
    }

    public String getEngineNum()
    {
        return engineNum;
    }

    public void setEngineNum(String engineNum)
    {
        this.engineNum = engineNum;
    }

    public String getDrivingImg()
    {
        return drivingImg;
    }

    public void setDrivingImg(String drivingImg)
    {
        this.drivingImg = drivingImg;
    }

    public Date getDriveRegDate()
    {
        return driveRegDate;
    }

    public void setDriveRegDate(Date driveRegDate)
    {
        this.driveRegDate = driveRegDate;
    }

    public Date getDriveIssueDate()
    {
        return driveIssueDate;
    }

    public void setDriveIssueDate(Date driveIssueDate)
    {
        this.driveIssueDate = driveIssueDate;
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
}
