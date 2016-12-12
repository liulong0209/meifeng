package net.beautifycrack.dao;

import java.util.List;
import java.util.Map;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.Product;
import net.beautifycrack.util.PagerUtil;


/**
 * 美缝材料dao
 * 
 * ProductMapper.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月14日 下午3:50:31
 * @author liulong
 */
public interface ProductMapper
{
	/**
	 * 分页展示数据
	 * @param pu
	 * @param productType
	 * @return
	 * @throws BusinessException
	 */
	List<Product> pageList(Map<String, Object> map) throws BusinessException;
	
	/**
	 * 查询总数
	 * @param productType
	 * @return
	 * @throws BusinessException
	 */
	Integer queryTotal(Integer productType) throws BusinessException;
}
