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
public interface MaterialMapper
{
    /**
     * 获取材料分类条目
     * 
     * @return
     * @throws BusinessException
     */
    List<ProductCategory> getMaterialCategory() throws BusinessException;

    /**
     * 分页查询材料列表
     * 
     * @param categoryId
     * @return
     * @throws BusinessException
     */
    List<Product> queryMaterial(Map<String, Object> map) throws BusinessException;

    /**
     * 查询总数
     * 
     * @param categoryId
     * @return
     * @throws BusinessException
     */
    Integer queryTotal(Long categoryId) throws BusinessException;
}
