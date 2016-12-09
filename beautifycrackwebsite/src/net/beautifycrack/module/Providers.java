package net.beautifycrack.module;

import java.util.Date;

/**
 * 供应商 Providers.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月21日 下午6:10:58
 * @author liulong
 */
public class Providers
{
    /**
     * 提供商id
     */
    private Long providersId;

    /**
     * 提供商名称
     */
    private String providerName;

    /**
     * 简介
     */
    private String profile;

    /**
     * 联系方式
     */
    private String phoneNo;

    /**
     * 地址
     */
    private String address;

    /**
     * 公司logo或者人员的头像
     */
    private Long logo;

    /**
     * 0 待审核 1 未通过 2通过
     */
    private Integer state;

    /**
     * 排序号
     */
    private Integer orderNo;

    /**
     * 类型 0公司 1团队 2个人
     */
    private Integer type;

    /**
     * 负责人id
     */
    private Integer head;

    /**
     * 所属城市id
     */
    private Integer city;

    /**
     * 提供服务类型 0 提供施工 1提供产品
     */
    private Integer serviceType;

    /**
     * 创建者
     */
    private Long creator;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    public Long getProvidersId()
    {
        return providersId;
    }

    public void setProvidersId(Long providersId)
    {
        this.providersId = providersId;
    }

    public String getProviderName()
    {
        return providerName;
    }

    public void setProviderName(String providerName)
    {
        this.providerName = providerName;
    }

    public String getProfile()
    {
        return profile;
    }

    public void setProfile(String profile)
    {
        this.profile = profile;
    }

    public String getPhoneNo()
    {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo)
    {
        this.phoneNo = phoneNo;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public Long getLogo()
    {
        return logo;
    }

    public void setLogo(Long logo)
    {
        this.logo = logo;
    }

    public Integer getState()
    {
        return state;
    }

    public void setState(Integer state)
    {
        this.state = state;
    }

    public Integer getOrderNo()
    {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo)
    {
        this.orderNo = orderNo;
    }

    public Integer getType()
    {
        return type;
    }

    public void setType(Integer type)
    {
        this.type = type;
    }

    public Integer getHead()
    {
        return head;
    }

    public void setHead(Integer head)
    {
        this.head = head;
    }

    public Integer getCity()
    {
        return city;
    }

    public void setCity(Integer city)
    {
        this.city = city;
    }

    public Integer getServiceType()
    {
        return serviceType;
    }

    public void setServiceType(Integer serviceType)
    {
        this.serviceType = serviceType;
    }

    public Long getCreator()
    {
        return creator;
    }

    public void setCreator(Long creator)
    {
        this.creator = creator;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime)
    {
        this.updateTime = updateTime;
    }

}
