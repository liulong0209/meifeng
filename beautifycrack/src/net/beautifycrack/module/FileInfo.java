package net.beautifycrack.module;

import java.util.Date;

/**
 * �ļ�ʵ��
 * 
 * FileInfo.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��19�� ����8:14:55
 * @author liulong
 */
public class FileInfo
{
    /**
     * �ļ�id
     */
    private Long fileId;

    /**
     * �ļ�ԭʼ��
     */
    private String orginName;

    /**
     * �ļ��洢����
     */
    private String fileName;

    /**
     * �ļ�·��
     */
    private String filePath;

    /**
     * �ϴ���id
     */
    private Integer creator;

    /**
     * �ϴ�ʱ��
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
