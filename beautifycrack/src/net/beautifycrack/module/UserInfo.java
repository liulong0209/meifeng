package net.beautifycrack.module;

import java.io.Serializable;

/**
 * �û���Ϣ
 * 
 * UserInfo.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��26�� ����6:58:46
 * @author liulong
 */
public class UserInfo implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * ����id
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
