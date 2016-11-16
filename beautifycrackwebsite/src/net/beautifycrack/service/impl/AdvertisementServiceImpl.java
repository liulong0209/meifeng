package net.beautifycrack.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.beautifycrack.dao.AdvertisementMapper;
import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.Advertisement;
import net.beautifycrack.service.AdvertisementService;
import net.beautifycrack.util.PagerUtil;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * 广告接口实现
 * 
 * AdvertisementServiceImpl.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月13日 下午5:39:23
 * @author liulong
 */
@Scope("prototype")
@Service("adService")
public class AdvertisementServiceImpl implements AdvertisementService
{
    /**
     * 广告dao
     */
    @Resource
    private AdvertisementMapper adMapper;

    @Override
    public List<Advertisement> pagerList(PagerUtil pager) throws BusinessException
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startRow", (pager.getPageNo() - 1) * pager.getPageSize());
        map.put("pageSize", pager.getPageSize());
        return adMapper.pagerList(map);
    }

    @Override
    public Integer queryTotal() throws BusinessException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void add(Advertisement ads) throws BusinessException
    {
        adMapper.add(ads);
    }

    @Override
    public void update(Advertisement ads) throws BusinessException
    {
        adMapper.update(ads);
    }

    @Override
    public void queryById(Long adsId) throws BusinessException
    {
        adMapper.queryById(adsId);
    }

    @Override
    public void delete(Long adsId) throws BusinessException
    {
        adMapper.delete(adsId);
    }

}
