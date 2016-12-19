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
    private Long id;

    /**
     * ��������
     */
    private String title;

    /**
     * image id
     */
    private Long imageId;

    /**
     * ��˾ �Ŷ� id
     */
    private Long providersId;

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

    public Long getProvidersId()
    {
        return providersId;
    }

    public void setProvidersId(Long providersId)
    {
        this.providersId = providersId;
    }

}
