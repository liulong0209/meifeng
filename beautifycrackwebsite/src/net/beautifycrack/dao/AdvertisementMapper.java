package net.beautifycrack.dao;

import java.util.List;
import java.util.Map;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.Advertisement;

/**
 * 相关广告 dao
 * 
 * AdvertisementMapper.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月13日 下午5:27:21
 * @author liulong
 */
public interface AdvertisementMapper
{
    /**
     * 分页查询数据
     * 
     * @return
     * @throws BusinessException
     */
    List<Advertisement> pagerList(Map<String, Object> map) throws BusinessException;

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
    Advertisement queryById(Long adsId) throws BusinessException;

    /**
     * 根据id删除数据
     * 
     * @param adsId
     * @throws BusinessException
     */
    void delete(Long adsId) throws BusinessException;
}
