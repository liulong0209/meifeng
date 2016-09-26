package net.beautifycrack.module;

import java.io.Serializable;
import java.util.Date;

/**
 * ����ʵ��
 * 
 * Evaluation.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��26�� ����7:32:23
 * @author liulong
 */
public class Evaluation implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = -971614229308904673L;

    /**
     * id
     */
    private Integer id;

    /**
     * �����id
     */
    private Integer gainer;

    /**
     * ��������
     */
    private String content;

    /**
     * ������id
     */
    private Integer reviewer;

    /**
     * ���� 0�� 1�� 2��
     */
    private Integer level;

    /**
     * ����ʱ��
     */
    private Date reviewTime;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getGainer()
    {
        return gainer;
    }

    public void setGainer(Integer gainer)
    {
        this.gainer = gainer;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public Integer getReviewer()
    {
        return reviewer;
    }

    public void setReviewer(Integer reviewer)
    {
        this.reviewer = reviewer;
    }

    public Integer getLevel()
    {
        return level;
    }

    public void setLevel(Integer level)
    {
        this.level = level;
    }

    public Date getReviewTime()
    {
        return reviewTime;
    }

    public void setReviewTime(Date reviewTime)
    {
        this.reviewTime = reviewTime;
    }

}
