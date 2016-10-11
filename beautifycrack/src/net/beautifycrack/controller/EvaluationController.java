package net.beautifycrack.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.beautifycrack.module.Evaluation;
import net.beautifycrack.module.UserInfo;
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
    public @ResponseBody Object pageList(PagerUtil pu, Long gainer)
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
    public @ResponseBody Object addEvaluation(HttpServletRequest request, HttpServletResponse response,
            Evaluation evaluation)
    {
        Map<String, Object> dataMaps = new HashMap<String, Object>();
        try
        {
            // ��ȡ��ǰ�û�����
            UserInfo user = (UserInfo) request.getSession(true).getAttribute("userInfo");
            // �û�û�е�¼�����ܽ�����
            if (user == null)
            {
                // dataMaps.put("result", "0");
                // return dataMaps;

            }
            // evaluation.setReviewer(user.getId());
            evaluationService.addEvaluation(evaluation);
            dataMaps.put("result", "1");
            return dataMaps;
        }
        catch (Exception e)
        {
            dataMaps.put("result", "2");
            return dataMaps;
        }

    }

}
