package net.beautifycrack.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.beautifycrack.constant.Common;
import net.beautifycrack.dao.FileInfoMapper;
import net.beautifycrack.dao.ProductMapper;
import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.FileInfo;
import net.beautifycrack.module.Product;
import net.beautifycrack.service.ProductService;
import net.beautifycrack.util.PagerUtil;

import org.apache.commons.io.FileDeleteStrategy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
     * 注入dao
     */
    @Resource
    private ProductMapper productMapper;
    
    /**
     * 文件dao
     */
    @Resource
    private FileInfoMapper fileInfoMapper;

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
        // 产品入库
        productMapper.add(product);

        // 构建公司与产品分类关系
        Map<String, Object> paMap = new HashMap<String, Object>();
        paMap.put("providersId", product.getProvidersId());
        paMap.put("category", product.getCategory());
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
    @Transactional(rollbackFor = Exception.class)
    public void delete(Product product) throws BusinessException, IOException
    {
        productMapper.delete(product.getId());
        
        if (product.getImgId() != null && product.getImgId() != Common.NO_FILE)
        {
            // 删除附件
            FileInfo fileInfo = fileInfoMapper.findFileById(product.getImgId());

            // 删除数据库
            fileInfoMapper.delete(product.getImgId());

            // 删除文件
            FileDeleteStrategy strategy = FileDeleteStrategy.NORMAL;
            File fileToDelete = new File(fileInfo.getFilePath());
            if (fileToDelete.exists())
            {
                strategy.delete(fileToDelete);
            }
        }
    }
}
