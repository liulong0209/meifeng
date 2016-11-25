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
    String uploadFile(String dir, String path, String ext, String original, InputStream in, String returnValue)
            throws BusinessException, IOException;

    /**
     * 上传图片
     * 
     * @param dir上传目录
     * @param path上传路径
     * @param ext文件扩展名
     * @param original文件原始名
     * @param imgBase64Str
     *            图片以base64编码的字符串
     * @throws BusinessException
     *             IOException
     * @return
     */
    Long uploadImg(String dir, String path, String original, String imgBase64Str) throws BusinessException, IOException;

    /**
     * 删除文件
     * 
     * @param imgId
     * @throws BusinessException
     * @throws IOException
     */
    void deleteFile(Long fileId) throws BusinessException, IOException;
}
