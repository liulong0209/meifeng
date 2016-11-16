package net.beautifycrack.service;

import java.util.List;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.Advertisement;
import net.beautifycrack.util.PagerUtil;

/**
 * 轮播公告服务接口
 * 
 * AdvertisementService.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月13日 下午5:36:50
 * @author liulong
 */
public interface AdvertisementService
{
    /**
     * 分页查询数据
     * 
     * @return
     * @throws BusinessException
     */
    List<Advertisement> pagerList(PagerUtil pager) throws BusinessException;

    /**
     * 查询总数
     * 
     * @return
     * @throws BusinessException
     */
    Integer queryTotal() throws BusinessException;

    /**
     * 新增数据
     * 
     * @param ads
     * @throws BusinessException
     */
    void add(Advertisement ads) throws BusinessException;

    /**
     * 修改数据
     * 
     * @param ads
     * @throws BusinessException
     */
    void update(Advertisement ads) throws BusinessException;

    /**
     * 根据id查询数据
     * 
     * @param adsId
     * @throws BusinessException
     */
    void queryById(Long adsId) throws BusinessException;

    /**
     * 根据id删除数据
     * 
     * @param adsId
     * @throws BusinessException
     */
    void delete(Long adsId) throws BusinessException;
}
