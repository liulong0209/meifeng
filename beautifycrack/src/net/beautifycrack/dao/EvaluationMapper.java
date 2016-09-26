package net.beautifycrack.dao;

import java.util.List;
import java.util.Map;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.Evaluation;
import net.beautifycrack.module.News;

/**
 * ����dao
 * 
 * EvaluationMapper.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��26�� ����7:45:23
 * @author liulong
 */
public interface EvaluationMapper
{
    /**
     * ��ҳ��ѯ����
     * 
     * @return
     * @throws BusinessException
     */
    List<News> pagerList(Map<String, Object> map) throws BusinessException;

    /**
     * ��ѯ����
     * 
     * @return
     * @throws BusinessException
     */
    Integer queryTotal(Integer providersId) throws BusinessException;

    /**
     * �������ۼ�¼
     * 
     * @param evaluation
     * @throws BusinessException
     */
    void addEvaluation(Evaluation evaluation) throws BusinessException;
}
