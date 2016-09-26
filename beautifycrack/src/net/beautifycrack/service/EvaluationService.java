package net.beautifycrack.service;

import java.util.List;
import java.util.Map;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.Evaluation;
import net.beautifycrack.module.News;

/**
 * 评价接口
 * 
 * EvaluationService.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月26日 下午7:51:20
 * @author liulong
 */
public interface EvaluationService
{
    /**
     * 分页查询数据
     * 
     * @return
     * @throws BusinessException
     */
    List<News> pagerList(Map<String, Object> map) throws BusinessException;

    /**
     * 查询总数
     * 
     * @return
     * @throws BusinessException
     */
    Integer queryTotal(Integer providersId) throws BusinessException;

    /**
     * 增加评价记录
     * 
     * @param evaluation
     * @throws BusinessException
     */
    void addEvaluation(Evaluation evaluation) throws BusinessException;
}
