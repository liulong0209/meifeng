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
    List<Providers> pagerList(PagerUtil pager, String type) throws BusinessException;

    /**
     * 显示单条详细信息
     * 
     * @param id
     * @return
     * @throws BusinessException
     */
    Providers showProviders(Integer id) throws BusinessException;

    /**
     * 查询总数
     * 
     * @return
     * @throws BusinessException
     */
    Integer queryTotal() throws BusinessException;

    /**
     * 首页显示的数据，显示4条
     * 
     * @return
     * @throws BusinessException
     */
    List<Providers> providersListIndex(Integer type) throws BusinessException;
}
