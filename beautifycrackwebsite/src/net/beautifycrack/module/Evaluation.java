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
    private Long id;

    /**
     * �����id
     */
    private Long gainer;

    /**
     * ��������
     */
    private String content;

    /**
     * ������id
     */
    private Long reviewer;

    /**
     * ����������
     */
    private String reviewerName;

    /**
     * ���� 0�� 1�� 2��
     */
    private String level;

    /**
     * ����ʱ��
     */
    private Date reviewTime;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getGainer()
    {
        return gainer;
    }

    public void setGainer(Long gainer)
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

    public Long getReviewer()
    {
        return reviewer;
    }

    public void setReviewer(Long reviewer)
    {
        this.reviewer = reviewer;
    }

    public String getLevel()
    {
        return level;
    }

    public void setLevel(String level)
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

    public String getReviewerName()
    {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName)
    {
        this.reviewerName = reviewerName;
    }

}
