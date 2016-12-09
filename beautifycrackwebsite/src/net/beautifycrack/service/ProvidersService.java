package net.beautifycrack.service;

import java.util.List;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.Providers;
import net.beautifycrack.util.PagerUtil;

/**
 * 公司相关接口
 * 
 * CompanyService.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月14日 下午3:28:33
 * @author liulong
 */
public interface ProvidersService
{
    /**
     * 分页查询数据
     * 
     * @return
     * @throws BusinessException
     */
    List<Providers> pagerList(PagerUtil pager, List<Integer> list) throws BusinessException;

    /**
     * 查询总数
     * 
     * @param list
     *            类型 0公司 1团队 2 个人
     * @return
     * @throws BusinessException
     */
    Integer queryTotal(List<Integer> list) throws BusinessException;

    /**
     * 新增供应商
     * 
     * @param providers
     * @throws BusinessException
     */
    void addProviders(Providers providers) throws BusinessException;

    /**
     * 更新供应商
     * 
     * @param providers
     * @throws BusinessException
     */
    void updateProviders(Providers providers) throws BusinessException;

    /**
     * 删除供应商
     * 
     * @param providers
     * @throws BusinessException
     */
    void deleteProviders(Providers providers) throws BusinessException;

    /**
     * 根据供应商id查询供应商
     * 
     * @param providerId
     * @return
     * @throws BusinessException
     */
    Providers queryProvider(Long providerId) throws BusinessException;
}
