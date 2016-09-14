package net.beautifycrack.dao;

import java.util.List;

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
    List<News> pageList() throws BusinessException;

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
}
