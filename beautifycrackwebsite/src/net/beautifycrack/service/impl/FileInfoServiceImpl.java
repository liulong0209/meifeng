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
 * 文件接口实现类
 * 
 * FileInfoServiceImpl.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月20日 上午11:28:45
 * @author liulong
 */
@Scope("prototype")
@Service("fileInfoService")
public class FileInfoServiceImpl implements FileInfoService
{
    /**
     * 注入文件dao
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
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param activityId
     *            管理ID
     * @param dir
     *            文件目录
     * @param path
     *            文件路径
     * @param filename
     *            文件名称
     * @param ext
     *            扩展名
     * @param in
     *            文件输入流
     * @throws IOException
     *             IOException
     * @Version v1.0
     * @author s54322/sunyue
     * @Date 2016年5月18日
     */
    private void save(String dir, String path, String filename, String ext, InputStream in, boolean isUpdate)
            throws IOException
    {
        // 文件上传至目录
        UploadUtils.generateFileInPath(dir, path, in);
        FileInfo fileInfo = new FileInfo();
        // 记录入库
        if (isUpdate)
        {
            fileInfo.setOrginName(filename);
            fileInfo.setFileName(path);
            fileInfo.setFilePath(path + filename);
            fileInfo.setCreator(Common.FILE_UPLPADER_NEWS);
        }
    }

}
