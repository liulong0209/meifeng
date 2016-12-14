package net.beautifycrack.service;

import java.io.IOException;
import java.util.List;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.Product;
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
     * 分页展示数据
     * 
     * @param pu
     * @param productType
     * @return
     * @throws BusinessException
     */
    List<Product> pageList(PagerUtil pu, Integer productType) throws BusinessException;

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
    void delete(Product product) throws BusinessException, IOException;
}
