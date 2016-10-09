package net.beautifycrack.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.beautifycrack.constant.Common;
import net.beautifycrack.dao.ProductMapper;
import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.Product;
import net.beautifycrack.module.ProductCategory;
import net.beautifycrack.service.ProductService;
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
@Service("productService")
public class ProductServiceImpl implements ProductService
{
    /**
     * 注入美缝材料dao
     */
    @Resource
    private ProductMapper productMapper;

    @Override
    public List<ProductCategory> getMaterialCategory() throws BusinessException
    {
        return productMapper.getProductCategory(Common.PRODUCT_MATERIAL);
    }

    @Override
    public List<ProductCategory> getToolsCategory() throws BusinessException
    {
        return productMapper.getProductCategory(Common.PRODUCT_TOOLS);
    }

    @Override
    public List<Product> queryProduct(PagerUtil pager, Long categoryId) throws BusinessException
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("categoryId", categoryId);
        map.put("startRow", (pager.getPageNo() - 1) * pager.getPageSize());
        map.put("pageSize", pager.getPageSize());
        return productMapper.queryProduct(map);
    }

    @Override
    public Integer queryTotal(Long categoryId) throws BusinessException
    {
        return productMapper.queryTotal(categoryId);
    }

    @Override
    public List<Product> indexShow(Integer type) throws BusinessException
    {
        return productMapper.indexShow(type);
    }

}
