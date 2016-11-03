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
public interface ProductMapper
{
    /**
     * ��ȡ��Ʒ������Ŀ
     * 
     * @return
     * @throws BusinessException
     */
    List<ProductCategory> getProductCategory(Integer type) throws BusinessException;

    /**
     * ��ҳ��ѯ��Ʒ�б�
     * 
     * @param categoryId
     * @return
     * @throws BusinessException
     */
    List<Product> queryProduct(Map<String, Object> map) throws BusinessException;

    /**
     * ��ѯ����
     * 
     * @param categoryId
     * @return
     * @throws BusinessException
     */
    Integer queryTotal(Long categoryId) throws BusinessException;

    /**
     * ��ҳ��ʾ�Ĳ�Ʒ����
     * 
     * @return
     * @throws BusinessException
     */
    List<Product> indexShow(Integer type) throws BusinessException;

    /**
     * ���ݹ�˾�ͷ����ѯ��Ʒ
     * 
     * @param categoryId
     * @return
     * @throws BusinessException
     */
    List<Product> queryCompanyProduct(Map<String, Object> paramater) throws BusinessException;
}
