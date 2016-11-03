package net.beautifycrack.module;

import java.io.Serializable;
import java.util.Date;

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
    private Long userId;

    /**
     * �˺�
     */
    private String userName;

    /**
     * ����
     */
    private String password;

    /**
     * �Ա� 0�� 1Ů 2����
     */
    private Integer gender;

    /**
     * ��������
     */
    private Date birthday;

    /**
     * �û�ͷ��id
     */
    private Long avatar;

    /**
     * �ǳ�
     */
    private String nickName;

    /**
     * �ֻ���
     */
    private String phoneNo;

    /**
     * ��ע
     */
    private String remarks;

    /**
     * ����¼ʱ��
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
