package net.beautifycrack.dao;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.FileInfo;

/**
 * 文件dao
 * 
 * FileInfoMapper.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月20日 上午11:29:42
 * @author liulong
 */
public interface FileInfoMapper
{
    /**
     * 通过id查找文件
     * 
     * @param fileId
     * @return
     * @throws BusinessException
     */
    FileInfo findFileById(Integer fileId) throws BusinessException;
}
