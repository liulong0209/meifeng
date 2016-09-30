package net.beautifycrack.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.beautifycrack.module.Evaluation;
import net.beautifycrack.service.EvaluationService;
import net.beautifycrack.util.PagerUtil;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ������ؿ�����
 * 
 * EvaluationController.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��26�� ����7:55:41
 * @author liulong
 */
@Scope("prototype")
@Controller
@RequestMapping("/evaluation")
public class EvaluationController
{
    /**
     * ע�����۽ӿ�
     */
    @Resource
    private EvaluationService evaluationService;

    /**
     * ��ҳ��ѯ������Ϣ
     * 
     * @param pu
     * @param gainer
     *            ��������id
     * @return
     */
    @RequestMapping(value = "/pageList", method = RequestMethod.POST)
    public @ResponseBody Object pageList(PagerUtil pu, Integer gainer)
    {
        pu.setPageSize(10);// ��ʾ10��
        List<Evaluation> dataList = evaluationService.pagerList(pu, gainer);
        Map<String, Object> dataMaps = new HashMap<String, Object>();
        dataMaps.put("dataList", dataList);

        Integer total = evaluationService.queryTotal(gainer);
        pu.setTotalRecords(total);
        pu.setTotalPage(pu.getTotalPage());
        dataMaps.put("pager", pu);
        return dataMaps;
    }

    /**
     * ����������Ϣ
     * 
     * @param evaluation
     * @return
     */
    @RequestMapping(value = "/evaluate", method = RequestMethod.POST)
    public @ResponseBody Object addEvaluation(Evaluation evaluation)
    {
        evaluationService.addEvaluation(evaluation);
        Map<String, Object> dataMaps = new HashMap<String, Object>();
        return dataMaps;
    }

}
