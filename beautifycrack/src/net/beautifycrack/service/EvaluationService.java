package net.beautifycrack.service;

import java.util.List;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.Evaluation;
import net.beautifycrack.util.PagerUtil;

/**
 * ���۽ӿ�
 * 
 * EvaluationService.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��26�� ����7:51:20
 * @author liulong
 */
public interface EvaluationService
{
    /**
     * ��ҳ��ѯ����
     * 
     * @return
     * @throws BusinessException
     */
    List<Evaluation> pagerList(PagerUtil pu, Long gainer) throws BusinessException;

    /**
     * ��ѯ����
     * 
     * @return
     * @throws BusinessException
     */
    Integer queryTotal(Long providersId) throws BusinessException;

    /**
     * �������ۼ�¼
     * 
     * @param evaluation
     * @throws BusinessException
     */
    void addEvaluation(Evaluation evaluation) throws BusinessException;
}
