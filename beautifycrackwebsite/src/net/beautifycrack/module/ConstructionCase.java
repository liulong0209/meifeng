package net.beautifycrack.module;

import java.io.Serializable;

/**
 * 施工案例
 * 
 * ConstructionCase.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月26日 下午6:58:20
 * @author liulong
 */
public class ConstructionCase implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = -3887766226235918877L;

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
    private Long providersId;

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

    public Long getProvidersId()
    {
        return providersId;
    }

    public void setProvidersId(Long providersId)
    {
        this.providersId = providersId;
    }

}
