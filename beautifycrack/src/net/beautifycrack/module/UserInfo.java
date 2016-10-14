package net.beautifycrack.module;

import java.io.Serializable;
import java.util.Date;

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
    private Long userId;

    /**
     * 账号
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别 0男 1女 2保密
     */
    private Integer gender;

    /**
     * 出生年月
     */
    private Date birthday;

    /**
     * 用户头像id
     */
    private Long avatar;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 手机号
     */
    private String phoneNo;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 最后登录时间
     */
    private Date lastLoginTime;

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Integer getGender()
    {
        return gender;
    }

    public void setGender(Integer gender)
    {
        this.gender = gender;
    }

    public Date getBirthday()
    {
        return birthday;
    }

    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    public Long getAvatar()
    {
        return avatar;
    }

    public void setAvatar(Long avatar)
    {
        this.avatar = avatar;
    }

    public String getNickName()
    {
        return nickName;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    public String getPhoneNo()
    {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo)
    {
        this.phoneNo = phoneNo;
    }

    public String getRemarks()
    {
        return remarks;
    }

    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }

    public Date getLastLoginTime()
    {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime)
    {
        this.lastLoginTime = lastLoginTime;
    }
}
