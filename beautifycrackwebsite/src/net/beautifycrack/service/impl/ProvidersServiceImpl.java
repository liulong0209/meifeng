package net.beautifycrack.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.beautifycrack.dao.ProvidersMapper;
import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.AntiFake;
import net.beautifycrack.module.BookingCommunity;
import net.beautifycrack.module.ConstructionCase;
import net.beautifycrack.module.ProductCategory;
import net.beautifycrack.module.Providers;
import net.beautifycrack.module.Qualification;
import net.beautifycrack.module.Worker;
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
    public Providers showProviders(Long id) throws BusinessException
    {
        return providersMapper.showProviders(id);
    }

    @Override
    public Integer queryTotal(List<Integer> list) throws BusinessException
    {
        return providersMapper.queryTotal(list);
    }

    @Override
    public List<Providers> providersListIndex(List<Integer> list) throws BusinessException
    {
        return providersMapper.providersListIndex(list);
    }

    @Override
    public List<Worker> findProviderWorker(Long providerId) throws BusinessException
    {
        return providersMapper.findProviderWorker(providerId);
    }

    @Override
    public List<ConstructionCase> findConstructionCase(Long providerId) throws BusinessException
    {
        return providersMapper.findConstructionCase(providerId);
    }

    @Override
    public List<BookingCommunity> findBookingCommunity(Long providerId) throws BusinessException
    {
        return providersMapper.findBookingCommunity(providerId);
    }

    @Override
    public List<Qualification> findQualification(Long company) throws BusinessException
    {
        return providersMapper.findQualification(company);
    }

    @Override
    public List<AntiFake> findAntiFake(Long company) throws BusinessException
    {
        return providersMapper.findAntiFake(company);
    }

    @Override
    public List<ProductCategory> findProductCategory(Long company) throws BusinessException
    {
        return providersMapper.findProductCategory(company);
    }

}
