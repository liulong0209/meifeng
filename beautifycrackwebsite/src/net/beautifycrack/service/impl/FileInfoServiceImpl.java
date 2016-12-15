package net.beautifycrack.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;

import net.beautifycrack.dao.FileInfoMapper;
import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.FileInfo;
import net.beautifycrack.service.FileInfoService;
import net.beautifycrack.util.UploadUtils;

import org.apache.commons.io.FileDeleteStrategy;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

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
    public String uploadFile(String dir, String path, String ext, String original, InputStream in, String returnValue)
            throws BusinessException, IOException
    {
        String filename = UploadUtils.generateFilename(path, ext);
        String fileId = save(dir, filename, original, ext, in, "", true);
        if ("filename".equals(returnValue))
        {
            return filename;
        }
        else if ("fileId".equals(returnValue))
        {
            return fileId;
        }
        return null;
    }

    @Override
    public Long uploadImg(String dir, String path, String original, String imgBase64Str) throws BusinessException,
            IOException
    {
        String ext = FilenameUtils.getExtension(original);
        String filename = UploadUtils.generateFilename(path, ext);
        String fileId = save(dir, filename, original, ext, null, imgBase64Str, true);
        return Long.valueOf(fileId);
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
     * @return String 返回文件id
     * @throws BusinessException
     */
    private String save(String dir, String path, String filename, String ext, InputStream in, String imgBase64Str,
            boolean isUpdate) throws IOException, BusinessException
    {
        // 文件上传至目录
        if (in != null)
        {
            UploadUtils.generateFileInPath(dir, path, in);
        }
        if (!StringUtils.isEmpty(imgBase64Str))
        {
            byte[] b = Base64Utils.decode(imgBase64Str.getBytes());
            File file = new File(dir + File.separator + path);
            FileUtils.writeByteArrayToFile(file, b);
        }

        FileInfo fileInfo = new FileInfo();
        // 记录入库
        if (isUpdate)
        {
            fileInfo.setFileId(fileInfoMapper.getMaxFileId());
            fileInfo.setOrginName(filename);
            fileInfo.setFileName(path);
            fileInfo.setFilePath(dir + File.separator + path);
            // fileInfo.setCreator(Common.FILE_UPLPADER_NEWS);
            fileInfoMapper.add(fileInfo);
        }

        return fileInfo.getFileId().toString();
    }

    @Override
    public void deleteFile(Long fileId) throws BusinessException, IOException
    {
        FileInfo fileInfo = fileInfoMapper.findFileById(fileId);

        // 删除数据库
        fileInfoMapper.delete(fileId);

        if (fileInfo != null)
        {
            // 删除文件
            FileDeleteStrategy strategy = FileDeleteStrategy.NORMAL;
            File fileToDelete = new File(fileInfo.getFilePath());
            if (fileToDelete.exists())
            {
                strategy.delete(fileToDelete);
            }
        }
    }
}
