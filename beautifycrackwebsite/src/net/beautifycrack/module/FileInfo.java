package net.beautifycrack.module;

import java.util.Date;

/**
 * 文件实体
 * 
 * FileInfo.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月19日 下午8:14:55
 * @author liulong
 */
public class FileInfo
{
    /**
     * 文件id
     */
    private Long fileId;

    /**
     * 文件原始名
     */
    private String orginName;

    /**
     * 文件存储名称
     */
    private String fileName;

    /**
     * 文件路径
     */
    private String filePath;

    /**
     * 上传者id
     */
    private Integer creator;

    /**
     * 上传时间
     */
    private Date createTime;

    public Long getFileId()
    {
        return fileId;
    }

    public void setFileId(Long fileId)
    {
        this.fileId = fileId;
    }

    public String getOrginName()
    {
        return orginName;
    }

    public void setOrginName(String orginName)
    {
        this.orginName = orginName;
    }

    public String getFileName()
    {
        return fileName;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public String getFilePath()
    {
        return filePath;
    }

    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }

    public Integer getCreator()
    {
        return creator;
    }

    public void setCreator(Integer creator)
    {
        this.creator = creator;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

}
