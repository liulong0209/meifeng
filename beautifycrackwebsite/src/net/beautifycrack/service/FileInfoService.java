package net.beautifycrack.service;

import java.io.IOException;
import java.io.InputStream;

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

    /**
     * 
     * @param dir
     *            �ϴ�Ŀ¼
     * @param path
     *            �ϴ�·��
     * @param ext
     *            �ļ���չ��
     * @param original
     *            �ļ�ԭʼ��
     * @param in
     *            �ļ���
     * @return String
     * @throws BusinessException
     */
    String uploadFile(String dir, String path, String ext, String original, InputStream in, String returnValue)
            throws BusinessException, IOException;

    /**
     * �ϴ�ͼƬ
     * 
     * @param dir�ϴ�Ŀ¼
     * @param path�ϴ�·��
     * @param ext�ļ���չ��
     * @param original�ļ�ԭʼ��
     * @param imgBase64Str
     *            ͼƬ��base64������ַ���
     * @throws BusinessException
     *             IOException
     * @return
     */
    Long uploadImg(String dir, String path, String original, String imgBase64Str) throws BusinessException, IOException;

    /**
     * ɾ���ļ�
     * 
     * @param imgId
     * @throws BusinessException
     * @throws IOException
     */
    void deleteFile(Long fileId) throws BusinessException, IOException;
}
