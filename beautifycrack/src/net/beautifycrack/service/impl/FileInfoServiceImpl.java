package net.beautifycrack.service.impl;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;

import net.beautifycrack.constant.Common;
import net.beautifycrack.dao.FileInfoMapper;
import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.FileInfo;
import net.beautifycrack.service.FileInfoService;
import net.beautifycrack.util.UploadUtils;

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
    public FileInfo findFileById(Long fileId) throws BusinessException
    {
        return fileInfoMapper.findFileById(fileId);
    }

    @Override
    public String uploadFile(String dir, String path, String ext, String original, InputStream in)
            throws BusinessException, IOException
    {
        String filename = UploadUtils.generateFilename(path, ext);
        save(dir, filename, original, ext, in, true);
        return filename;
    }

    /**
     * 
     * @Title: save
     * @Description: TODO(������һ�仰�����������������)
     * @param activityId
     *            ����ID
     * @param dir
     *            �ļ�Ŀ¼
     * @param path
     *            �ļ�·��
     * @param filename
     *            �ļ�����
     * @param ext
     *            ��չ��
     * @param in
     *            �ļ�������
     * @throws IOException
     *             IOException
     * @Version v1.0
     * @author s54322/sunyue
     * @Date 2016��5��18��
     */
    private void save(String dir, String path, String filename, String ext, InputStream in, boolean isUpdate)
            throws IOException
    {
        // �ļ��ϴ���Ŀ¼
        UploadUtils.generateFileInPath(dir, path, in);
        FileInfo fileInfo = new FileInfo();
        // ��¼���
        if (isUpdate)
        {
            fileInfo.setOrginName(filename);
            fileInfo.setFileName(path);
            fileInfo.setFilePath(path + filename);
            fileInfo.setCreator(Common.FILE_UPLPADER_NEWS);
        }
    }

}
