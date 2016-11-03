package net.beautifycrack.service;

import java.util.List;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.News;
import net.beautifycrack.util.PagerUtil;

/**
 * ���Žӿ�
 * 
 * NewsService.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��14�� ����3:28:33
 * @author liulong
 */
public interface NewsService
{
    /**
     * ��ҳ��ѯ����
     * 
     * @return
     * @throws BusinessException
     */
    List<News> pagerList(PagerUtil pager) throws BusinessException;

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
}
