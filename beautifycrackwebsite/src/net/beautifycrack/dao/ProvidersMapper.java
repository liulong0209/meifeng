package net.beautifycrack.dao;

import java.util.List;
import java.util.Map;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.Providers;
import net.beautifycrack.util.PagerUtil;

/**
 * 公司dao
 * 
 * CompanyMapper.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月14日 下午3:50:31
 * @author liulong
 */
public interface ProvidersMapper
{
    /**
     * 分页查询数据
     * 
     * @return
     * @throws BusinessException
     */
    List<Providers> pagerList(Map<String, Object> map) throws BusinessException;

    /**
     * 查询总数
     * 
     * @return
     * @throws BusinessException
     */
    Integer queryTotal(List<Integer> list) throws BusinessException;
    
    /**
     * 分页查询商品提供公司数据
     * 
     * @return
     * @throws BusinessException
     */
    List<Providers> productCompanyPagerList(Map<String, Object> map) throws BusinessException;

    /**
     * 查询商品提供公司总数
     * 
     * @return
     * @throws BusinessException
     */
    Integer queryProductCompanyTotal() throws BusinessException;

    /**
     * 新增供应商
     * 
     * @param providers
     * @return
     * @throws BusinessException
     */
    void addProviders(Providers providers) throws BusinessException;

    /**
     * 更新供应商
     * 
     * @param providers
     * @return
     * @throws BusinessException
     */
    void updateProviders(Providers providers) throws BusinessException;

    /**
     * 删除供应商
     * 
     * @param providers
     * @return
     * @throws BusinessException
     */
    void deleteProviders(Long providerId) throws BusinessException;

    /**
     * 显示单条详细信息
     * 
     * @param providerId
     * @return
     * @throws BusinessException
     */
    Providers queryProvider(Long providerId) throws BusinessException;

    /**
     * 查询提供产品的公司
     * 
     * @return
     * @throws BusinessException
     */
    List<Providers> findProvideProductCompany() throws BusinessException;

    /**
     * 判断公司是否已经有某个产品分类
     * 
     * @param paMap
     * @return
     */
    Integer judgeCompanyproductCategory(Map<String, Object> paMap);

    /**
     * 增加公司产品分类
     * 
     * @param paMap
     */
    void addCompanyproductCategory(Map<String, Object> paMap);
}
