package net.beautifycrack.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.beautifycrack.constant.Common;
import net.beautifycrack.dao.FileInfoMapper;
import net.beautifycrack.dao.ProvidersResourceMapper;
import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.FileInfo;
import net.beautifycrack.module.Worker;
import net.beautifycrack.service.ProvidersResourceService;
import net.beautifycrack.util.PagerUtil;

import org.apache.commons.io.FileDeleteStrategy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ��˾ �Ŷ� ���˵���Դ�ӿ�ʵ�� (ʩ��������Ϣ��ʩ��������ԤԼС������˾���ʡ���α��ѯ)
 * 
 * ProvidersResourceServiceImpl.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��12��15�� ����7:04:59
 * @author liulong
 */
@Scope("prototype")
@Service("providersResourceService")
public class ProvidersResourceServiceImpl implements ProvidersResourceService
{

    /**
     * ע��dao
     */
    @Resource
    private ProvidersResourceMapper providersResourceMapper;

    /**
     * �ļ�dao
     */
    @Resource
    private FileInfoMapper fileInfoMapper;

    @Override
    public List<Worker> wokerPagerList(PagerUtil pager, Long providersId) throws BusinessException
    {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("providersId", providersId);
        param.put("startRow", (pager.getPageNo() - 1) * pager.getPageSize());
        param.put("pageSize", pager.getPageSize());
        return providersResourceMapper.wokerPagerList(param);
    }

    @Override
    public Integer queryWokerTotal(Long providersId) throws BusinessException
    {
        return providersResourceMapper.queryWokerTotal(providersId);
    }

    @Override
    public void addWork(Worker worker) throws BusinessException
    {
        providersResourceMapper.addWork(worker);
    }

    @Override
    public Worker findWorker(Long workerId) throws BusinessException
    {
        return providersResourceMapper.findWorker(workerId);
    }

    @Override
    public void updateWork(Worker worker) throws BusinessException
    {
        providersResourceMapper.updateWork(worker);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteWork(Worker worker) throws BusinessException, IOException
    {
        providersResourceMapper.deleteWork(worker.getId());

        if (worker.getAvatar() != null && worker.getAvatar() != Common.NO_FILE)
        {
            // ɾ������
            FileInfo fileInfo = fileInfoMapper.findFileById(worker.getAvatar());

            // ɾ�����ݿ�
            fileInfoMapper.delete(worker.getAvatar());

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
