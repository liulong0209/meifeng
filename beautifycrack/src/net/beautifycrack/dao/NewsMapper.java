package net.beautifycrack.dao;

import java.util.List;
import java.util.Map;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.News;

/**
 * 新闻dao
 * 
 * NewsMapper.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月14日 下午3:50:31
 * @author liulong
 */
public interface NewsMapper
{
    /**
     * 分页查询数据
     * 
     * @return
     * @throws BusinessException
     */
    List<News> pagerList(Map<String, Object> map) throws BusinessException;

    /**
     * 显示单条详细信息
     * 
     * @param id
     * @return
     * @throws BusinessException
     */
    News showNews(Integer id) throws BusinessException;

    /**
     * 查询总数
     * 
     * @return
     * @throws BusinessException
     */
    Integer queryTotal() throws BusinessException;

    /**
     * 首页显示的新闻列表，显示最新的15条
     * 
     * @return
     * @throws BusinessException
     */
    List<News> newsListIndex() throws BusinessException;
}
