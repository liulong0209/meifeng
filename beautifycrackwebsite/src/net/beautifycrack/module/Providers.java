package net.beautifycrack.module;

import java.util.Date;

/**
 * ��Ӧ�� Providers.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��21�� ����6:10:58
 * @author liulong
 */
public class Providers
{
    /**
     * �ṩ��id
     */
    private Long providersId;

    /**
     * �ṩ������
     */
    private String providerName;

    /**
     * ���
     */
    private String profile;

    /**
     * ��ϵ��ʽ
     */
    private String phoneNo;

    /**
     * ��ַ
     */
    private String address;

    /**
     * ��˾logo������Ա��ͷ��
     */
    private Long logo;

    /**
     * 0 ����� 1 δͨ�� 2ͨ��
     */
    private Integer state;

    /**
     * �����
     */
    private Integer orderNo;

    /**
     * ���� 0��˾ 1�Ŷ� 2����
     */
    private Integer type;

    /**
     * ������id
     */
    private Integer head;

    /**
     * ��������id
     */
    private Integer city;

    /**
     * �ṩ�������� 0 �ṩʩ�� 1�ṩ��Ʒ
     */
    private Integer serviceType;

    /**
     * ������
     */
    private Long creator;

    /**
     * ����ʱ��
     */
    private Date createTime;

    /**
     * ����ʱ��
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
