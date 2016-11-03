package net.beautifycrack.module;

import java.io.Serializable;

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

}
