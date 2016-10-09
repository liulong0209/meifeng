package net.beautifycrack.service;

import java.util.List;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.Product;
import net.beautifycrack.module.ProductCategory;
import net.beautifycrack.util.PagerUtil;

/**
 * 
 * ProductService.java
 * 
 * @Description: 产品接口
 * 
 * @Company: chinasofti
 * @Created on 2016年10月8日 下午2:02:39
 * @author liulong
 */
public interface ProductService
{
    /**
     * 获取材料分类条目
     * 
     * @param typeId
     * @return
     * @throws BusinessException
     */
    List<ProductCategory> getMaterialCategory() throws BusinessException;

    /**
     * 获取工具分类条目
     * 
     * @param typeId
     * @return
     * @throws BusinessException
     */
    List<ProductCategory> getToolsCategory() throws BusinessException;

    /**
     * 分页查询产品列表
     * 
     * @param categoryId
     * @return
     * @throws BusinessException
     */
    List<Product> queryProduct(PagerUtil pu, Long categoryId) throws BusinessException;

    /**
     * 查询总数
     * 
     * @param categoryId
     * @return
     * @throws BusinessException
     */
    Integer queryTotal(Long categoryId) throws BusinessException;

    /**
     * 首页显示的产品数据
     * 
     * @return
     * @throws BusinessException
     */
    List<Product> indexShow(Integer type) throws BusinessException;
}
