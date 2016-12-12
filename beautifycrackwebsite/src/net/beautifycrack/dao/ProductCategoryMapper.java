package net.beautifycrack.dao;

import java.util.List;
import java.util.Map;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.ProductCategory;

/**
 * ���칤��/���Ϸ���dao
 * 
 * ProductCategoryMapper.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��14�� ����3:50:31
 * @author liulong
 */
public interface ProductCategoryMapper
{
    /**
     * ��ҳ��ѯ��Ʒ������Ŀ
     * 
     * @param map
     * @return
     * @throws BusinessException
     */
    List<ProductCategory> queryCategories(Map<String, Object> map) throws BusinessException;

    /**
     * ��ȡ��������
     * 
     * @param productType
     * @return
     * @throws BusinessException
     */
    Integer queryCategoriesTotal(Integer productType) throws BusinessException;

    /**
     * ����
     * 
     * @param productCategory
     * @throws BusinessException
     */
    void add(ProductCategory productCategory) throws BusinessException;

    /**
     * ����
     * 
     * @param productCategory
     * @throws BusinessException
     */
    void update(ProductCategory productCategory) throws BusinessException;

    /**
     * ɾ��
     * 
     * @param id
     * @throws BusinessException
     */
    void delete(Integer id) throws BusinessException;

    /**
     * ��ѯ����
     * 
     * @param id
     * @return
     * @throws BusinessException
     */
    ProductCategory queryById(Integer id) throws BusinessException;

}
