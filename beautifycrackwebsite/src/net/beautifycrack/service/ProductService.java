package net.beautifycrack.service;

import java.util.List;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.Product;
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
	 * ��ҳչʾ����
	 * @param pu
	 * @param productType
	 * @return
	 * @throws BusinessException
	 */
	List<Product> pageList(PagerUtil pu,Integer productType) throws BusinessException;
	
	/**
	 * ��ѯ����
	 * @param productType
	 * @return
	 * @throws BusinessException
	 */
	Integer queryTotal(Integer productType) throws BusinessException;
}
