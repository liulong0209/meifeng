package net.beautifycrack.module;

import java.io.Serializable;
import java.util.Date;

/**
 * ����ʵ��
 * 
 * News.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��14�� ����3:19:27
 * @author liulong
 */
public class News implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = -1921657689594159083L;

    /**
     * id
     */
    private Long id;

    /**
     * ����
     */
    private String title;

    /**
     * ����
     */
    private String content;

    /**
     * ״̬
     */
    private Integer state;

    /**
     * ����ʱ��
     */
    private Date publishTime;

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

    public String getContent()
    {
        return content;
    }

    public void setContext(String content)
    {
        this.content = content;
    }

    public Integer getState()
    {
        return state;
    }

    public void setState(Integer state)
    {
        this.state = state;
    }

    public Date getPublishTime()
    {
        return publishTime;
    }

    public void setPublishTime(Date publishTime)
    {
        this.publishTime = publishTime;
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
