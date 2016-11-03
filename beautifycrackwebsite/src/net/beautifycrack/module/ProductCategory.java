package net.beautifycrack.module;

import java.io.Serializable;

/**
 * 
 * ProductCategory.java
 * 
 * @Description: ��Ʒ����ʵ��
 * 
 * @Company: chinasofti
 * @Created on 2016��10��8�� ����2:05:28
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
     * ��������
     */
    private String name;

    /**
     * ������� 0���� 1����
     */
    private Integer type;

    /**
     * ��������
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
