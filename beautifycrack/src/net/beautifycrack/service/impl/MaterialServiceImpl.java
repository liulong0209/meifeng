package net.beautifycrack.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.beautifycrack.dao.MaterialMapper;
import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.Product;
import net.beautifycrack.module.ProductCategory;
import net.beautifycrack.service.MaterialService;
import net.beautifycrack.util.PagerUtil;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * ������Ͻӿ�ʵ�� MaterialServiceImpl.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��10��8�� ����2:14:20
 * @author liulong
 */
@Scope("prototype")
@Service("materialService")
public class MaterialServiceImpl implements MaterialService
{
    /**
     * ע���������dao
     */
    @Resource
    private MaterialMapper materialMapper;

    @Override
    public List<ProductCategory> getMaterialCategory() throws BusinessException
    {
        return materialMapper.getMaterialCategory();
    }

    @Override
    public List<Product> queryMaterial(PagerUtil pager, Long categoryId) throws BusinessException
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("categoryId", categoryId);
        map.put("startRow", (pager.getPageNo() - 1) * pager.getPageSize());
        map.put("pageSize", pager.getPageSize());
        return materialMapper.queryMaterial(map);
    }

    @Override
    public Integer queryTotal(Long categoryId) throws BusinessException
    {
        return materialMapper.queryTotal(categoryId);
    }

}
