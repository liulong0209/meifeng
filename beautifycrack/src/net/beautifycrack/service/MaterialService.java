package net.beautifycrack.service;

import java.util.List;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.Product;
import net.beautifycrack.module.ProductCategory;
import net.beautifycrack.util.PagerUtil;

/**
 * 
 * MaterialService.java
 * 
 * @Description: 美缝材料接口
 * 
 * @Company: chinasofti
 * @Created on 2016年10月8日 下午2:02:39
 * @author liulong
 */
public interface MaterialService
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
     * 分页查询材料列表
     * 
     * @param categoryId
     * @return
     * @throws BusinessException
     */
    List<Product> queryMaterial(PagerUtil pu, Long categoryId) throws BusinessException;

    /**
     * 查询总数
     * 
     * @param categoryId
     * @return
     * @throws BusinessException
     */
    Integer queryTotal(Long categoryId) throws BusinessException;
}
