package net.beautifycrack.module;

import java.io.Serializable;

/**
 * ԤԼС��
 * 
 * BookingCommunity.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��26�� ����7:01:54
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
     * С������
     */
    private String communityName;

    /**
     * image id
     */
    private Long imageId;

    /**
     * ��˾ �Ŷ� id
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
