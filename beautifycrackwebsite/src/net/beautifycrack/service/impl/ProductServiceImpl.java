package net.beautifycrack.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.beautifycrack.dao.ProductMapper;
import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.Product;
import net.beautifycrack.service.ProductService;
import net.beautifycrack.util.PagerUtil;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * 产品接口实现
 * 
 * ProductServiceImpl.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年10月8日 下午2:14:20
 * @author liulong
 */
@Scope("prototype")
@Service("productService")
public class ProductServiceImpl implements ProductService
{

	/**
	 * 注入dao
	 */
	@Resource
	private ProductMapper productMapper;
	
	@Override
	public List<Product> pageList(PagerUtil pager, Integer productType)
			throws BusinessException {
		Map<String, Object> map = new HashMap<String, Object>();
        map.put("productType", productType);
        map.put("startRow", (pager.getPageNo() - 1) * pager.getPageSize());
        map.put("pageSize", pager.getPageSize());
		return productMapper.pageList(map);
	}

	@Override
	public Integer queryTotal(Integer productType) throws BusinessException {
		return productMapper.queryTotal(productType);
	}

}
