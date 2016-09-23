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
    public List<Providers> pagerList(PagerUtil pager, String type) throws BusinessException
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("type", type);
        map.put("startRow", (pager.getPageNo() - 1) * pager.getPageSize());
        map.put("pageSize", pager.getPageSize());
        return providersMapper.pagerList(map);
    }

    @Override
    public Providers showProviders(Integer id) throws BusinessException
    {
        return providersMapper.showProviders(id);
    }

    @Override
    public Integer queryTotal() throws BusinessException
    {
        return providersMapper.queryTotal();
    }

    @Override
    public List<Providers> providersListIndex(String type) throws BusinessException
    {
        return providersMapper.providersListIndex(type);
    }

}
