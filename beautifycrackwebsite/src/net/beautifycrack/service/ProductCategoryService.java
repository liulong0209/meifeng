package net.beautifycrack.service;

import java.util.List;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.ProductCategory;
import net.beautifycrack.util.PagerUtil;

/**
 * 材料/工具 分类接口
 * 
 * ProductCategoryService.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年12月12日 下午6:59:11
 * @author liulong
 */
public interface ProductCategoryService
{
    /**
     * 分页查询产品分类条目
     * 
     * @param pager
     * @param productType
     *            类别类型 0工具 1材料
     * @return
     * @throws BusinessException
     */
    List<ProductCategory> queryCategories(PagerUtil pager, Integer productType) throws BusinessException;

    /**
     * 查询产品分类条目总数
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
