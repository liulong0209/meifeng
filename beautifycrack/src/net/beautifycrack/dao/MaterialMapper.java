package net.beautifycrack.dao;

import java.util.List;
import java.util.Map;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.Product;
import net.beautifycrack.module.ProductCategory;

/**
 * �������dao
 * 
 * MaterialMapper.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��14�� ����3:50:31
 * @author liulong
 */
public interface MaterialMapper
{
    /**
     * ��ȡ���Ϸ�����Ŀ
     * 
     * @return
     * @throws BusinessException
     */
    List<ProductCategory> getMaterialCategory() throws BusinessException;

    /**
     * ��ҳ��ѯ�����б�
     * 
     * @param categoryId
     * @return
     * @throws BusinessException
     */
    List<Product> queryMaterial(Map<String, Object> map) throws BusinessException;

    /**
     * ��ѯ����
     * 
     * @param categoryId
     * @return
     * @throws BusinessException
     */
    Integer queryTotal(Long categoryId) throws BusinessException;
}
