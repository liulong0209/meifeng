package net.beautifycrack.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.beautifycrack.dao.ProvidersMapper;
import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.Providers;
import net.beautifycrack.service.ProvidersService;
import net.beautifycrack.util.PagerUtil;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * 提供商接口实现
 * 
 * CompanyServiceImpl.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月14日 下午3:35:47
 * @author liulong
 */
@Scope("prototype")
@Service("providersService")
public class ProvidersServiceImpl implements ProvidersService
{
    /**
     * 提供商dao层接口
     */
    @Resource
    private ProvidersMapper providersMapper;

    @Override
    public List<Providers> pagerList(PagerUtil pager, List<Integer> list) throws BusinessException
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", list);
        map.put("startRow", (pager.getPageNo() - 1) * pager.getPageSize());
        map.put("pageSize", pager.getPageSize());
        return providersMapper.pagerList(map);
    }

    @Override
    public Integer queryTotal(List<Integer> list) throws BusinessException
    {
        return providersMapper.queryTotal(list);
    }

    @Override
    public void addProviders(Providers providers) throws BusinessException
    {
        providersMapper.addProviders(providers);
    }

    @Override
    public void updateProviders(Providers providers) throws BusinessException
    {
        providersMapper.updateProviders(providers);
    }

    @Override
    public void deleteProviders(Providers providers) throws BusinessException
    {
        providersMapper.deleteProviders(providers.getProvidersId());
    }

    @Override
    public Providers queryProvider(Long providerId) throws BusinessException
    {
        return providersMapper.queryProvider(providerId);
    }
}
