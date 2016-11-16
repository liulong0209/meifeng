package net.beautifycrack.dao;

import java.util.List;
import java.util.Map;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.Advertisement;

/**
 * ��ع�� dao
 * 
 * AdvertisementMapper.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��13�� ����5:27:21
 * @author liulong
 */
public interface AdvertisementMapper
{
    /**
     * ��ҳ��ѯ����
     * 
     * @return
     * @throws BusinessException
     */
    List<Advertisement> pagerList(Map<String, Object> map) throws BusinessException;

    /**
     * ��ѯ����
     * 
     * @return
     * @throws BusinessException
     */
    Integer queryTotal() throws BusinessException;

    /**
     * ��������
     * 
     * @param ads
     * @throws BusinessException
     */
    void add(Advertisement ads) throws BusinessException;

    /**
     * �޸�����
     * 
     * @param ads
     * @throws BusinessException
     */
    void update(Advertisement ads) throws BusinessException;

    /**
     * ����id��ѯ����
     * 
     * @param adsId
     * @throws BusinessException
     */
    void queryById(Long adsId) throws BusinessException;

    /**
     * ����idɾ������
     * 
     * @param adsId
     * @throws BusinessException
     */
    void delete(Long adsId) throws BusinessException;
}
