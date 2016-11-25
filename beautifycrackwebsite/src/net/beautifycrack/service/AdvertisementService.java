package net.beautifycrack.service;

import java.io.IOException;
import java.util.List;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.Advertisement;
import net.beautifycrack.util.PagerUtil;

/**
 * �ֲ��������ӿ�
 * 
 * AdvertisementService.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��13�� ����5:36:50
 * @author liulong
 */
public interface AdvertisementService
{
    /**
     * ��ҳ��ѯ����
     * 
     * @return
     * @throws BusinessException
     */
    List<Advertisement> pagerList(PagerUtil pager) throws BusinessException;

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
    Advertisement queryById(Long adsId) throws BusinessException;

    /**
     * ����idɾ������
     * 
     * @param adsId
     * @throws BusinessException
     */
    void delete(Advertisement ads) throws BusinessException, IOException;
}
