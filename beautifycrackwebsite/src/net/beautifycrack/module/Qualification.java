package net.beautifycrack.module;

import java.io.Serializable;

/**
 * 公司资质
 * 
 * Qualification.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月26日 下午7:02:45
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
     * 资质名称
     */
    private String title;

    /**
     * image id
     */
    private Long imageId;

    /**
     * 公司 团队 id
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
