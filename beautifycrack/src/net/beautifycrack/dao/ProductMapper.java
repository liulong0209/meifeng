package net.beautifycrack.dao;

import java.util.List;
import java.util.Map;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.Product;
import net.beautifycrack.module.ProductCategory;

/**
 * 美缝材料dao
 * 
 * MaterialMapper.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月14日 下午3:50:31
 * @author liulong
 */
public interface ProductMapper
{
    /**
     * 获取产品分类条目
     * 
     * @return
     * @throws BusinessException
     */
    List<ProductCategory> getProductCategory(Integer type) throws BusinessException;

    /**
     * 分页查询产品列表
     * 
     * @param categoryId
     * @return
     * @throws BusinessException
     */
    List<Product> queryProduct(Map<String, Object> map) throws BusinessException;

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

    /**
     * 根据公司和分类查询产品
     * 
     * @param categoryId
     * @return
     * @throws BusinessException
     */
    List<Product> queryCompanyProduct(Map<String, Object> paramater) throws BusinessException;
}
