package net.beautifycrack.service;

import java.util.List;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.News;
import net.beautifycrack.util.PagerUtil;

/**
 * 新闻接口
 * 
 * NewsService.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月14日 下午3:28:33
 * @author liulong
 */
public interface NewsService
{
    /**
     * 分页查询数据
     * 
     * @return
     * @throws BusinessException
     */
    List<News> pagerList(PagerUtil pager) throws BusinessException;

    /**
     * 显示单条详细信息
     * 
     * @param id
     * @return
     * @throws BusinessException
     */
    News showNews(Long id) throws BusinessException;

    /**
     * 查询总数
     * 
     * @return
     * @throws BusinessException
     */
    Integer queryTotal() throws BusinessException;

    /**
     * 增加新闻
     * 
     * @param news
     * @throws BusinessException
     */
    void add(News news) throws BusinessException;

    /**
     * 增加新闻
     * 
     * @param news
     * @throws BusinessException
     */
    void update(News news) throws BusinessException;

    /**
     * 删除新闻
     * 
     * @param newsId
     * @throws BusinessException
     */
    void delete(Long newsId) throws BusinessException;
}
