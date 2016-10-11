package net.beautifycrack.service;

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
}
