package net.beautifycrack.service;

import java.util.List;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.Product;
import net.beautifycrack.module.ProductCategory;
import net.beautifycrack.util.PagerUtil;

/**
 * 
 * ProductService.java
 * 
 * @Description: ��Ʒ�ӿ�
 * 
 * @Company: chinasofti
 * @Created on 2016��10��8�� ����2:02:39
 * @author liulong
 */
public interface ProductService
{
    /**
     * ��ȡ���Ϸ�����Ŀ
     * 
     * @param typeId
     * @return
     * @throws BusinessException
     */
    List<ProductCategory> getMaterialCategory() throws BusinessException;

    /**
     * ��ȡ���߷�����Ŀ
     * 
     * @param typeId
     * @return
     * @throws BusinessException
     */
    List<ProductCategory> getToolsCategory() throws BusinessException;

    /**
     * ��ҳ��ѯ��Ʒ�б�
     * 
     * @param categoryId
     * @return
     * @throws BusinessException
     */
    List<Product> queryProduct(PagerUtil pu, Long categoryId) throws BusinessException;

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
    List<Product> queryProduct(Long companyId, Long categoryId) throws BusinessException;
}
