package net.beautifycrack.module;

import java.io.Serializable;

/**
 * 用户信息
 * 
 * UserInfo.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月26日 下午6:58:46
 * @author liulong
 */
public class UserInfo implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

}
