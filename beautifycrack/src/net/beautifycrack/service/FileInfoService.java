package net.beautifycrack.service;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.FileInfo;

/**
 * �ļ��ӿ�
 * 
 * FileInfoService.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��20�� ����11:26:33
 * @author liulong
 */
public interface FileInfoService
{
    /**
     * ͨ��id�����ļ�
     * 
     * @param fileId
     * @return
     * @throws BusinessException
     */
    FileInfo findFileById(Long fileId) throws BusinessException;
}
