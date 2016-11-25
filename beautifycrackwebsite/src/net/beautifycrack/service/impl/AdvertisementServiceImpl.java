package net.beautifycrack.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.beautifycrack.constant.Common;
import net.beautifycrack.dao.AdvertisementMapper;
import net.beautifycrack.dao.FileInfoMapper;
import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.Advertisement;
import net.beautifycrack.module.FileInfo;
import net.beautifycrack.service.AdvertisementService;
import net.beautifycrack.util.PagerUtil;

import org.apache.commons.io.FileDeleteStrategy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ���ӿ�ʵ��
 * 
 * AdvertisementServiceImpl.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��13�� ����5:39:23
 * @author liulong
 */
@Scope("prototype")
@Service("adService")
public class AdvertisementServiceImpl implements AdvertisementService
{
    /**
     * ���dao
     */
    @Resource
    private AdvertisementMapper adMapper;

    /**
     * �ļ�dao
     */
    @Resource
    private FileInfoMapper fileInfoMapper;

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
        return adMapper.queryTotal();
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
    public Advertisement queryById(Long adsId) throws BusinessException
    {
        return adMapper.queryById(adsId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Advertisement ads) throws BusinessException, IOException
    {
        // ɾ���������
        adMapper.delete(ads.getId());

        if (ads.getImgId() != null && ads.getImgId() != Common.NO_FILE)
        {
            // ɾ������
            FileInfo fileInfo = fileInfoMapper.findFileById(ads.getImgId());

            // ɾ�����ݿ�
            fileInfoMapper.delete(ads.getImgId());

            // ɾ���ļ�
            FileDeleteStrategy strategy = FileDeleteStrategy.NORMAL;
            File fileToDelete = new File(fileInfo.getFilePath());
            if (fileToDelete.exists())
            {
                strategy.delete(fileToDelete);
            }
        }
    }

}
