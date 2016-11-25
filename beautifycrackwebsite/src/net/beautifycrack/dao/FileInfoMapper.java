package net.beautifycrack.dao;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.FileInfo;

/**
 * �ļ�dao
 * 
 * FileInfoMapper.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��20�� ����11:29:42
 * @author liulong
 */
public interface FileInfoMapper
{
    /**
     * ͨ��id�����ļ�
     * 
     * @param fileId
     * @return
     * @throws BusinessException
     */
    FileInfo findFileById(Long fileId) throws BusinessException;

    /**
     * ��ȡ�����ļ�id
     * 
     * @return
     * @throws BusinessException
     */
    Long getMaxFileId() throws BusinessException;

    /**
     * ����
     * 
     * @param fileInfo
     * @throws BusinessException
     */
    void add(FileInfo fileInfo) throws BusinessException;

    /**
     * ɾ��
     * 
     * @param fileInfo
     * @throws BusinessException
     */
    void delete(Long fileId) throws BusinessException;
}
