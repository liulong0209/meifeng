package net.beautifycrack.module;

import java.util.Date;

/**
 * 公司实体 Company.java
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
     * 手机号码
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
     * 状态0 正常 1删除
     */
    private Integer state;

    /**
     * 状态改变时间
     */
    private Date stateDate;

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

    public Date getStateDate()
    {
        return stateDate;
    }

    public void setStateDate(Date stateDate)
    {
        this.stateDate = stateDate;
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

}
