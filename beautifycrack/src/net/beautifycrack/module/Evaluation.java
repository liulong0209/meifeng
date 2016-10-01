package net.beautifycrack.module;

import java.io.Serializable;
import java.util.Date;

/**
 * 评价实体
 * 
 * Evaluation.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月26日 下午7:32:23
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
     * 获得者id
     */
    private Integer gainer;

    /**
     * 评价内容
     */
    private String content;

    /**
     * 评价者id
     */
    private Integer reviewer;
    
    /**
     * 评价者名字
     */
    private String reviewerName;

    /**
     * 级别 0好 1中 2差
     */
    private Integer level;

    /**
     * 评价时间
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

	public String getReviewerName() {
		return reviewerName;
	}

	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}
    
}
