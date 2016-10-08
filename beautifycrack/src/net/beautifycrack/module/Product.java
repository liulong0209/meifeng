package net.beautifycrack.module;

import java.io.Serializable;

/**
 * 
 * Product.java
 * 
 * @Description: <br>
 *               ��Ʒʵ�� <br>
 * @Company: chinasofti
 * @Created on 2016��10��8�� ����6:41:14
 * @author liulong
 */
public class Product implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * ����id
     */
    private Long id;

    /**
     * ��Ʒ����
     */
    private String productName;

    /**
     * ��Ʒ����
     */
    private String profile;

    /**
     * ����ͼid
     */
    private Long imgId;

    /**
     * ��Ʒ����
     */
    private Long category;

    /**
     * ��������
     */
    private String categoryName;

    /**
     * �ṩ��id
     */
    private Long providersId;

    /**
     * �ṩ������
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
