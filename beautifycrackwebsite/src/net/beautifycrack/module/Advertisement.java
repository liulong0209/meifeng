package net.beautifycrack.module;

import java.io.Serializable;
import java.util.Date;

/**
 * ���ʵ��
 * 
 * Advertisement.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��13�� ����5:33:21
 * @author liulong
 */
public class Advertisement implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1074838515174650977L;

    /**
     * ����id
     */
    private Long id;

    /**
     * ����
     */
    private String title;

    /**
     * ͼƬid
     */
    private Long imgId;

    /**
     * �����
     */
    private Integer orderNo;

    /**
     * ״̬
     */
    private Integer state;

    /**
     * ����ʱ��
     */
    private Date createTime;

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

    public Long getImgId()
    {
        return imgId;
    }

    public void setImgId(Long imgId)
    {
        this.imgId = imgId;
    }

    public Integer getOrderNo()
    {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo)
    {
        this.orderNo = orderNo;
    }

    public Integer getState()
    {
        return state;
    }

    public void setState(Integer state)
    {
        this.state = state;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }
}
