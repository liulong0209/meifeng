package net.beautifycrack.service;

import java.util.List;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.Product;
import net.beautifycrack.util.PagerUtil;


/**
 * 
 * ProductService.java
 * 
 * @Description: 产品接口
 * 
 * @Company: chinasofti
 * @Created on 2016年10月8日 下午2:02:39
 * @author liulong
 */
public interface ProductService
{
	/**
	 * 分页展示数据
	 * @param pu
	 * @param productType
	 * @return
	 * @throws BusinessException
	 */
	List<Product> pageList(PagerUtil pu,Integer productType) throws BusinessException;
	
	/**
	 * 查询总数
	 * @param productType
	 * @return
	 * @throws BusinessException
	 */
	Integer queryTotal(Integer productType) throws BusinessException;
}
