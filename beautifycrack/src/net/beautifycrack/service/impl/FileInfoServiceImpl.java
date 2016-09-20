package net.beautifycrack.service.impl;

import javax.annotation.Resource;

import net.beautifycrack.dao.FileInfoMapper;
import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.FileInfo;
import net.beautifycrack.service.FileInfoService;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * �ļ��ӿ�ʵ����
 * 
 * FileInfoServiceImpl.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��20�� ����11:28:45
 * @author liulong
 */
@Scope("prototype")
@Service("fileInfoService")
public class FileInfoServiceImpl implements FileInfoService
{
    /**
     * ע���ļ�dao
     */
    @Resource
    private FileInfoMapper fileInfoMapper;

    @Override
    public FileInfo findFileById(Integer fileId) throws BusinessException
    {
        return fileInfoMapper.findFileById(fileId);
    }

}
