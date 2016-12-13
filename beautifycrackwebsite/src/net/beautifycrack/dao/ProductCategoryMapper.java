package net.beautifycrack.dao;

import java.util.List;
import java.util.Map;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.ProductCategory;

/**
 * 美缝工具/材料分类dao
 * 
 * ProductCategoryMapper.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月14日 下午3:50:31
 * @author liulong
 */
public interface ProductCategoryMapper
{
    /**
     * 分页查询产品分类条目
     * 
     * @param map
     * @return
     * @throws BusinessException
     */
    List<ProductCategory> queryCategories(Map<String, Object> map) throws BusinessException;

    /**
     * 获取分类总数
     * 
     * @param productType
     * @return
     * @throws BusinessException
     */
    Integer queryCategoriesTotal(Integer productType) throws BusinessException;

    /**
     * 新增
     * 
     * @param productCategory
     * @throws BusinessException
     */
    void add(ProductCategory productCategory) throws BusinessException;

    /**
     * 更新
     * 
     * @param productCategory
     * @throws BusinessException
     */
    void update(ProductCategory productCategory) throws BusinessException;

    /**
     * 删除
     * 
     * @param id
     * @throws BusinessException
     */
    void delete(Long id) throws BusinessException;

    /**
     * 查询分类
     * 
     * @param id
     * @return
     * @throws BusinessException
     */
    ProductCategory queryById(Long id) throws BusinessException;

    /**
     * 根据类型获取产品分类(0工具 1材料)
     * 
     * @param type
     * @return
     * @throws BusinessException
     */
    List<ProductCategory> findCategoryByType(Integer type) throws BusinessException;

}
