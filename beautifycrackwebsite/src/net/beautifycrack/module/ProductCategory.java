package net.beautifycrack.module;

import java.io.Serializable;

/**
 * 
 * ProductCategory.java
 * 
 * @Description: 产品分类实体
 * 
 * @Company: chinasofti
 * @Created on 2016年10月8日 下午2:05:28
 * @author liulong
 */
public class ProductCategory implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 类别类型 0工具 1材料
     */
    private Integer type;

    /**
     * 类型名称
     */
    private String typeName;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getType()
    {
        return type;
    }

    public void setType(Integer type)
    {
        this.type = type;
    }

    public String getTypeName()
    {
        return typeName;
    }

    public void setTypeName(String typeName)
    {
        this.typeName = typeName;
    }
}
