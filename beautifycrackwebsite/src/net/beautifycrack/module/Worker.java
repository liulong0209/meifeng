package net.beautifycrack.module;

import java.io.Serializable;

/**
 * ʩ������ʵ��
 * 
 * Worker.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��27�� ����6:48:46
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
    private Long id;

    /**
     * ����
     */
    private String name;

    /**
     * ͷ��id
     */
    private Long avatar;

    /**
     * ��˾���Ŷ�id
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

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Long getAvatar()
    {
        return avatar;
    }

    public void setAvatar(Long avatar)
    {
        this.avatar = avatar;
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
