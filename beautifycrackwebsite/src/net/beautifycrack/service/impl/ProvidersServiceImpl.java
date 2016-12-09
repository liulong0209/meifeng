package net.beautifycrack.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.beautifycrack.constant.Common;
import net.beautifycrack.dao.FileInfoMapper;
import net.beautifycrack.dao.ProvidersMapper;
import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.FileInfo;
import net.beautifycrack.module.Providers;
import net.beautifycrack.service.ProvidersService;
import net.beautifycrack.util.PagerUtil;

import org.apache.commons.io.FileDeleteStrategy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    
    /**
     * �ļ�dao
     */
    @Resource
    private FileInfoMapper fileInfoMapper;

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
    public Integer queryTotal(List<Integer> list) throws BusinessException
    {
        return providersMapper.queryTotal(list);
    }

    @Override
    public void addProviders(Providers providers) throws BusinessException
    {
        providersMapper.addProviders(providers);
    }

    @Override
    public void updateProviders(Providers providers) throws BusinessException
    {
        providersMapper.updateProviders(providers);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteProviders(Providers providers) throws BusinessException, IOException
    {
        providersMapper.deleteProviders(providers.getProvidersId());
        if (providers.getLogo() != null && providers.getLogo() != Common.NO_FILE)
        {
            // ɾ������
            FileInfo fileInfo = fileInfoMapper.findFileById(providers.getLogo());

            // ɾ�����ݿ�
            fileInfoMapper.delete(providers.getLogo());

            // ɾ���ļ�
            FileDeleteStrategy strategy = FileDeleteStrategy.NORMAL;
            File fileToDelete = new File(fileInfo.getFilePath());
            if (fileToDelete.exists())
            {
                strategy.delete(fileToDelete);
            }
    }
    }

    @Override
    public Providers queryProvider(Long providerId) throws BusinessException
    {
        return providersMapper.queryProvider(providerId);
    }
}
