package net.beautifycrack.module;

import java.io.Serializable;

/**
 * 预约小区
 * 
 * BookingCommunity.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月26日 下午7:01:54
 * @author liulong
 */
public class BookingCommunity implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 3962341440874991313L;

    /**
     * id
     */
    private Long id;

    /**
     * 小区名称
     */
    private String communityName;

    /**
     * image id
     */
    private Long imageId;

    /**
     * 公司 团队 id
     */
    private Long providerId;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getCommunityName()
    {
        return communityName;
    }

    public void setCommunityName(String communityName)
    {
        this.communityName = communityName;
    }

    public Long getImageId()
    {
        return imageId;
    }

    public void setImageId(Long imageId)
    {
        this.imageId = imageId;
    }

    public Long getProviderId()
    {
        return providerId;
    }

    public void setProviderId(Long providerId)
    {
        this.providerId = providerId;
    }

}
