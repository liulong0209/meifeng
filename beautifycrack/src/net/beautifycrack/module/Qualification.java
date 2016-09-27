package net.beautifycrack.module;

import java.io.Serializable;

/**
 * ��˾����
 * 
 * Qualification.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��26�� ����7:02:45
 * @author liulong
 */
public class Qualification implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1289271229725209759L;

    /**
     * id
     */
    private Integer id;

    /**
     * ��������
     */
    private String title;

    /**
     * image id
     */
    private Integer imageId;

    /**
     * ��˾ �Ŷ� id
     */
    private Integer providerId;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
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

    public Integer getImageId()
    {
        return imageId;
    }

    public void setImageId(Integer imageId)
    {
        this.imageId = imageId;
    }

    public Integer getProviderId()
    {
        return providerId;
    }

    public void setProviderId(Integer providerId)
    {
        this.providerId = providerId;
    }

}
