package net.beautifycrack.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.beautifycrack.constant.Common;
import net.beautifycrack.dao.ProductCategoryMapper;
import net.beautifycrack.dao.ProductMapper;
import net.beautifycrack.dao.ProvidersMapper;
import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.Product;
import net.beautifycrack.module.ProductCategory;
import net.beautifycrack.service.ProductService;
import net.beautifycrack.util.PagerUtil;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ��Ʒ�ӿ�ʵ��
 * 
 * ProductServiceImpl.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��10��8�� ����2:14:20
 * @author liulong
 */
@Scope("prototype")
@Service("productService")
public class ProductServiceImpl implements ProductService
{

    /**
     * ע��dao
     */
    @Resource
    private ProductMapper productMapper;

    /**
     * ע��dao
     */
    @Resource
    private ProvidersMapper providersMapper;

    /**
     * ע��dao
     */
    @Resource
    private ProductCategoryMapper roductCategoryMapper;

    @Override
    public List<Product> pageList(PagerUtil pager, Integer productType) throws BusinessException
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("productType", productType);
        map.put("startRow", (pager.getPageNo() - 1) * pager.getPageSize());
        map.put("pageSize", pager.getPageSize());
        return productMapper.pageList(map);
    }

    @Override
    public Integer queryTotal(Integer productType) throws BusinessException
    {
        return productMapper.queryTotal(productType);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(Product product) throws BusinessException
    {
        // ��Ʒ���
        productMapper.add(product);

        // ������˾���Ʒ�����ϵ
        Map<String, Object> paMap = new HashMap<String, Object>();
        paMap.put("providersId", product.getProvidersId());
        paMap.put("category", product.getCategory());

        ProductCategory category = roductCategoryMapper.queryById(product.getCategory());
        if (category.getType() == Common.PRODUCT_MATERIAL)
        {
            paMap.put("type", 5);
        }
        else if (category.getType() == Common.PRODUCT_TOOLS)
        {
            paMap.put("type", 4);
        }
        if (providersMapper.judgeCompanyproductCategory(paMap) == 0)
        {
            providersMapper.addCompanyproductCategory(paMap);
        }
    }

    @Override
    public void update(Product product) throws BusinessException
    {
        productMapper.update(product);
    }

    @Override
    public Product find(Long productId) throws BusinessException
    {
        return productMapper.find(productId);
    }

    @Override
    public void delete(Product product) throws BusinessException
    {
        productMapper.delete(product.getId());
    }
}
