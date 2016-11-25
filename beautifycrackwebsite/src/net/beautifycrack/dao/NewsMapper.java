package net.beautifycrack.dao;

import java.util.List;
import java.util.Map;

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
    List<News> pagerList(Map<String, Object> map) throws BusinessException;

    /**
     * ��ʾ������ϸ��Ϣ
     * 
     * @param id
     * @return
     * @throws BusinessException
     */
    News showNews(Long id) throws BusinessException;

    /**
     * ��ѯ����
     * 
     * @return
     * @throws BusinessException
     */
    Integer queryTotal() throws BusinessException;

    /**
     * ��������
     * 
     * @param news
     * @throws BusinessException
     */
    void add(News news) throws BusinessException;

    /**
     * ��������
     * 
     * @param news
     * @throws BusinessException
     */
    void update(News news) throws BusinessException;

    /**
     * ��������
     * 
     * @param newsId
     * @throws BusinessException
     */
    void delete(Long newsId) throws BusinessException;
}
