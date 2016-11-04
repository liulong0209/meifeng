package net.beautifycrack.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.beautifycrack.constant.Common;
import net.beautifycrack.dao.NewsMapper;
import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.News;
import net.beautifycrack.service.NewsService;
import net.beautifycrack.util.PagerUtil;

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
    public List<News> pagerList(PagerUtil pager) throws BusinessException
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startRow", (pager.getPageNo() - 1) * pager.getPageSize());
        map.put("pageSize", pager.getPageSize());
        return newsMapper.pagerList(map);
    }

    @Override
    public News showNews(Long id) throws BusinessException
    {
        return newsMapper.showNews(id);
    }

    @Override
    public Integer queryTotal() throws BusinessException
    {
        return newsMapper.queryTotal();
    }

    @Override
    public void add(News news) throws BusinessException
    {
        // ����Ƿ��������÷���ʱ��
        if (news.getState().intValue() == Common.PUBLISH)
        {
            news.setPublishTime(new Date(System.currentTimeMillis()));
        }
        newsMapper.add(news);
    }

    @Override
    public void update(News news) throws BusinessException
    {
        // ����Ƿ��������÷���ʱ��
        if (news.getState()!=null && news.getState().intValue() == Common.PUBLISH)
        {
            news.setPublishTime(new Date(System.currentTimeMillis()));
        }
        newsMapper.update(news);
    }
}
