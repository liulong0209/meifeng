package net.beautifycrack.dao;

import java.util.List;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.News;

/**
 * ����dao
 * 
 * NewsMapper.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��14�� ����3:50:31
 * @author liulong
 */
public interface NewsMapper
{
    /**
     * ��ҳ��ѯ����
     * 
     * @return
     * @throws BusinessException
     */
    List<News> pageList() throws BusinessException;

    /**
     * ��ʾ������ϸ��Ϣ
     * 
     * @param id
     * @return
     * @throws BusinessException
     */
    News showNews(Integer id) throws BusinessException;

    /**
     * ��ѯ����
     * 
     * @return
     * @throws BusinessException
     */
    Integer queryTotal() throws BusinessException;
}
