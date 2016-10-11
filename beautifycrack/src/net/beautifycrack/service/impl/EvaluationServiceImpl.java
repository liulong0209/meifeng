package net.beautifycrack.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.beautifycrack.dao.EvaluationMapper;
import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.Evaluation;
import net.beautifycrack.service.EvaluationService;
import net.beautifycrack.util.PagerUtil;

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
    public List<Evaluation> pagerList(PagerUtil pager, Long gainer) throws BusinessException
    {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("providersId", gainer);
        parameter.put("startRow", (pager.getPageNo() - 1) * pager.getPageSize());
        parameter.put("pageSize", pager.getPageSize());
        return evaluationMapper.pagerList(parameter);
    }

    @Override
    public Integer queryTotal(Long providersId) throws BusinessException
    {
        return evaluationMapper.queryTotal(providersId);
    }

    @Override
    public void addEvaluation(Evaluation evaluation) throws BusinessException
    {
        evaluationMapper.addEvaluation(evaluation);
    }

}
