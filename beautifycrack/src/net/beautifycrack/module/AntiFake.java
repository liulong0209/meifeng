package net.beautifycrack.module;

import java.io.Serializable;

/**
 * 公司防伪查询实体
 * 
 * AntiFake.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月26日 下午7:02:45
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
     * 名称
     */
    private String title;

    /**
     * image id
     */
    private Long imageId;

    /**
     * 公司id
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
