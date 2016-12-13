package net.beautifycrack.service;

import java.util.List;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.ProductCategory;
import net.beautifycrack.util.PagerUtil;

/**
 * ����/���� ����ӿ�
 * 
 * ProductCategoryService.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��12��12�� ����6:59:11
 * @author liulong
 */
public interface ProductCategoryService
{
    /**
     * ��ҳ��ѯ��Ʒ������Ŀ
     * 
     * @param pager
     * @param productType
     *            ������� 0���� 1����
     * @return
     * @throws BusinessException
     */
    List<ProductCategory> queryCategories(PagerUtil pager, Integer productType) throws BusinessException;

    /**
     * ��ѯ��Ʒ������Ŀ����
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
    void delete(Long id) throws BusinessException;

    /**
     * ��ѯ����
     * 
     * @param id
     * @return
     * @throws BusinessException
     */
    ProductCategory queryById(Long id) throws BusinessException;

    /**
     * �������ͻ�ȡ��Ʒ����(0���� 1����)
     * 
     * @param type
     * @return
     * @throws BusinessException
     */
    List<ProductCategory> findCategoryByType(Integer type) throws BusinessException;
}
