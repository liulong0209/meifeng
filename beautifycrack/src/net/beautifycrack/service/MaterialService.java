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
 * @Description: ������Ͻӿ�
 * 
 * @Company: chinasofti
 * @Created on 2016��10��8�� ����2:02:39
 * @author liulong
 */
public interface MaterialService
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
     * ��ҳ��ѯ�����б�
     * 
     * @param categoryId
     * @return
     * @throws BusinessException
     */
    List<Product> queryMaterial(PagerUtil pu, Long categoryId) throws BusinessException;

    /**
     * ��ѯ����
     * 
     * @param categoryId
     * @return
     * @throws BusinessException
     */
    Integer queryTotal(Long categoryId) throws BusinessException;
}
