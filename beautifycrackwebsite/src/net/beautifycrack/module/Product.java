package net.beautifycrack.module;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * Product.java
 * 
 * @Description: <br>
 *               产品实体 <br>
 * @Company: chinasofti
 * @Created on 2016年10月8日 下午6:41:14
 * @author liulong
 */
public class Product implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品介绍
     */
    private String profile;

    /**
     * 缩略图id
     */
    private Long imgId;

    /**
     * 产品分类
     */
    private Long category;

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 提供商id
     */
    private Long providersId;

    /**
     * 提供商名称
     */
    private String providersName;

    /**
     * 排序号
     */
    private Integer orderNo;

    /**
     * 状态 0 正常
     */
    private Integer state;

    /**
     * 新建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public Long getImgId()
    {
        return imgId;
    }

    public void setImgId(Long imgId)
    {
        this.imgId = imgId;
    }

    public Long getCategory()
    {
        return category;
    }

    public void setCategory(Long category)
    {
        this.category = category;
    }

    public String getCategoryName()
    {
        return categoryName;
    }

    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }

    public Long getProvidersId()
    {
        return providersId;
    }

    public void setProvidersId(Long providersId)
    {
        this.providersId = providersId;
    }

    public String getProvidersName()
    {
        return providersName;
    }

    public void setProvidersName(String providersName)
    {
        this.providersName = providersName;
    }

    public String getProfile()
    {
        return profile;
    }

    public void setProfile(String profile)
    {
        this.profile = profile;
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

    public Date getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime)
    {
        this.updateTime = updateTime;
    }

}
