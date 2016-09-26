package net.beautifycrack.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.beautifycrack.dao.EvaluationMapper;
import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.Evaluation;
import net.beautifycrack.module.News;
import net.beautifycrack.service.EvaluationService;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * 评价接口实现
 * 
 * EvaluationServiceImpl.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月26日 下午7:52:01
 * @author liulong
 */
@Scope("prototype")
@Service("evaluationService")
public class EvaluationServiceImpl implements EvaluationService
{
    /**
     * 注入评价dao
     */
    @Resource
    private EvaluationMapper evaluationMapper;

    @Override
    public List<News> pagerList(Map<String, Object> map) throws BusinessException
    {
        return evaluationMapper.pagerList(map);
    }

    @Override
    public Integer queryTotal(Integer providersId) throws BusinessException
    {
        return evaluationMapper.queryTotal(providersId);
    }

    @Override
    public void addEvaluation(Evaluation evaluation) throws BusinessException
    {
        evaluationMapper.addEvaluation(evaluation);
    }

}
