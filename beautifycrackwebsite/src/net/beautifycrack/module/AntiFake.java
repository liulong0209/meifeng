package net.beautifycrack.module;

import java.io.Serializable;

/**
 * ��˾��α��ѯʵ��
 * 
 * AntiFake.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��26�� ����7:02:45
 * @author liulong
 */
public class AntiFake implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1289271229725209759L;

    /**
     * id
     */
    private Long id;

    /**
     * ����
     */
    private String title;

    /**
     * image id
     */
    private Long imageId;

    /**
     * ��˾id
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

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
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
