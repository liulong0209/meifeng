package net.beautifycrack.service.impl;

import java.util.List;

import javax.annotation.Resource;

import net.beautifycrack.dao.AdvertisementMapper;
import net.beautifycrack.module.Advertisement;
import net.beautifycrack.service.AdvertisementService;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

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

    @Override
    public List<Advertisement> getSlideImg()
    {
        return adMapper.getSlideImg();
    }

}
