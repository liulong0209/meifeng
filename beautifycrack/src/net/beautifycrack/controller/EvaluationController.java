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
 * 评价相关控制器
 * 
 * EvaluationController.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月26日 下午7:55:41
 * @author liulong
 */
@Scope("prototype")
@Controller
@RequestMapping("/evaluation")
public class EvaluationController
{
    /**
     * 注入评价接口
     */
    @Resource
    private EvaluationService evaluationService;

    /**
     * 分页查询评价信息
     * 
     * @param pu
     * @param gainer
     *            被评价者id
     * @return
     */
    @RequestMapping(value = "/pageList", method = RequestMethod.POST)
    public @ResponseBody Object pageList(PagerUtil pu, Integer gainer)
    {
        pu.setPageSize(10);// 显示10条
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
     * 增加评价信息
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
