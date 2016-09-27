package net.beautifycrack.module;

import java.io.Serializable;

/**
 * 施工工人实体
 * 
 * Worker.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月27日 下午6:48:46
 * @author liulong
 */
public class Worker implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 2689798164405721840L;

    /**
     * id
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 头像id
     */
    private Integer avatar;

    /**
     * 公司或团队id
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

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getAvatar()
    {
        return avatar;
    }

    public void setAvatar(Integer avatar)
    {
        this.avatar = avatar;
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
