package net.beautifycrack.dao;

import java.util.List;
import java.util.Map;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.Product;

/**
 * 美缝材料dao
 * 
 * ProductMapper.java
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
     * 分页展示数据
     * 
     * @param pu
     * @param productType
     * @return
     * @throws BusinessException
     */
    List<Product> pageList(Map<String, Object> map) throws BusinessException;

    /**
     * 查询总数
     * 
     * @param productType
     * @return
     * @throws BusinessException
     */
    Integer queryTotal(Integer productType) throws BusinessException;

    /**
     * 产品新增
     * 
     * @param product
     * @throws BusinessException
     */
    void add(Product product) throws BusinessException;

    /**
     * 产品更新
     * 
     * @param product
     * @throws BusinessException
     */
    void update(Product product) throws BusinessException;

    /**
     * 产品查询
     * 
     * @param productId
     * @return
     * @throws BusinessException
     */
    Product find(Long productId) throws BusinessException;

    /**
     * 产品删除
     * 
     * @param product
     * @throws BusinessException
     */
    void delete(Long productId) throws BusinessException;
}
