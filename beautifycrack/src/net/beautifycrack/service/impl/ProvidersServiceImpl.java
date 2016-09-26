package net.beautifycrack.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.beautifycrack.dao.ProvidersMapper;
import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.BookingCommunity;
import net.beautifycrack.module.ConstructionCase;
import net.beautifycrack.module.Providers;
import net.beautifycrack.module.Qualification;
import net.beautifycrack.module.UserInfo;
import net.beautifycrack.service.ProvidersService;
import net.beautifycrack.util.PagerUtil;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * �ṩ�̽ӿ�ʵ��
 * 
 * CompanyServiceImpl.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��14�� ����3:35:47
 * @author liulong
 */
@Scope("prototype")
@Service("providersService")
public class ProvidersServiceImpl implements ProvidersService
{
    /**
     * �ṩ��dao��ӿ�
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
    public Providers showProviders(Integer id) throws BusinessException
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
    public List<UserInfo> findProviderWorker(Integer providerId) throws BusinessException
    {
        return providersMapper.findProviderWorker(providerId);
    }

    @Override
    public List<ConstructionCase> findConstructionCase(Integer providerId) throws BusinessException
    {
        return providersMapper.findConstructionCase(providerId);
    }

    @Override
    public List<BookingCommunity> findBookingCommunity(Integer providerId) throws BusinessException
    {
        return providersMapper.findBookingCommunity(providerId);
    }

    @Override
    public List<Qualification> findQualification(Integer company) throws BusinessException
    {
        return providersMapper.findQualification(company);
    }

}
