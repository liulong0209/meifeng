package net.beautifycrack.service;

import java.io.IOException;
import java.io.InputStream;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.FileInfo;

/**
 * 文件接口
 * 
 * FileInfoService.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月20日 上午11:26:33
 * @author liulong
 */
public interface FileInfoService
{
    /**
     * 通过id查找文件
     * 
     * @param fileId
     * @return
     * @throws BusinessException
     */
    FileInfo findFileById(Long fileId) throws BusinessException;

    /**
     * 
     * @param dir
     *            上传目录
     * @param path
     *            上传路径
     * @param ext
     *            文件扩展名
     * @param original
     *            文件原始名
     * @param in
     *            文件流
     * @return String
     * @throws BusinessException
     */
    String uploadFile(String dir, String path, String ext, String original, InputStream in) throws BusinessException,
            IOException;
}
