package net.beautifycrack.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.beautifycrack.dao.ProductCategoryMapper;
import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.ProductCategory;
import net.beautifycrack.service.ProductCategoryService;
import net.beautifycrack.util.PagerUtil;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * 产品接口实现
 * 
 * ProductServiceImpl.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年10月8日 下午2:14:20
 * @author liulong
 */
@Scope("prototype")
@Service("productCategoryService")
public class ProductCategoryServiceImpl implements ProductCategoryService
{
    /**
     * 注入美缝材料dao
     */
    @Resource
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public List<ProductCategory> queryCategories(PagerUtil pager, Integer productType) throws BusinessException
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("productType", productType);
        map.put("startRow", (pager.getPageNo() - 1) * pager.getPageSize());
        map.put("pageSize", pager.getPageSize());
        return productCategoryMapper.queryCategories(map);
    }

    @Override
    public Integer queryCategoriesTotal(Integer productType) throws BusinessException
    {
        return productCategoryMapper.queryCategoriesTotal(productType);
    }

    @Override
    public void add(ProductCategory productCategory) throws BusinessException
    {
        productCategoryMapper.add(productCategory);
    }

    @Override
    public void update(ProductCategory productCategory) throws BusinessException
    {
        productCategoryMapper.update(productCategory);
    }

    @Override
    public void delete(Long id) throws BusinessException
    {
        productCategoryMapper.delete(id);
    }

    @Override
    public ProductCategory queryById(Long id) throws BusinessException
    {
        return productCategoryMapper.queryById(id);
    }

    @Override
    public List<ProductCategory> findCategoryByType(Integer type) throws BusinessException
    {
        return productCategoryMapper.findCategoryByType(type);
    }

}
