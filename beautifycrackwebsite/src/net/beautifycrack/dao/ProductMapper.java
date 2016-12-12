package net.beautifycrack.dao;

import java.util.List;
import java.util.Map;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.Product;
import net.beautifycrack.util.PagerUtil;


/**
 * �������dao
 * 
 * ProductMapper.java
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
	 * ��ҳչʾ����
	 * @param pu
	 * @param productType
	 * @return
	 * @throws BusinessException
	 */
	List<Product> pageList(Map<String, Object> map) throws BusinessException;
	
	/**
	 * ��ѯ����
	 * @param productType
	 * @return
	 * @throws BusinessException
	 */
	Integer queryTotal(Integer productType) throws BusinessException;
}
