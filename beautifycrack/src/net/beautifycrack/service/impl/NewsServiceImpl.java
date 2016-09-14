package net.beautifycrack.service.impl;

import java.util.List;

import javax.annotation.Resource;

import net.beautifycrack.dao.NewsMapper;
import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.News;
import net.beautifycrack.service.NewsService;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * ���Žӿ�ʵ��
 * 
 * NewsServiceImpl.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��14�� ����3:35:47
 * @author liulong
 */
@Scope("prototype")
@Service("newsService")
public class NewsServiceImpl implements NewsService
{
    /**
     * ����dao��ӿ�
     */
    @Resource
    private NewsMapper newsMapper;

    @Override
    public List<News> pageList() throws BusinessException
    {
        return newsMapper.pageList();
    }

    @Override
    public News showNews(Integer id) throws BusinessException
    {
        return null;
    }

    @Override
    public Integer queryTotal() throws BusinessException
    {
        return newsMapper.queryTotal();
    }

}
