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
 * 新闻接口实现
 * 
 * NewsServiceImpl.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月14日 下午3:35:47
 * @author liulong
 */
@Scope("prototype")
@Service("newsService")
public class NewsServiceImpl implements NewsService
{
    /**
     * 新闻dao层接口
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
