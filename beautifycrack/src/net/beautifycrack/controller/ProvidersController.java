package net.beautifycrack.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.beautifycrack.module.Providers;
import net.beautifycrack.service.ProvidersService;
import net.beautifycrack.util.PagerUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * �ṩ�̵Ŀ����������� ��˾ �Ŷ� ����
 * 
 * CompanyController.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��12�� ����4:44:59
 * @author liulong
 */
@Scope("prototype")
@Controller
public class ProvidersController
{
    private static Logger logger = LoggerFactory.getLogger(IndexController.class);

    /**
     * �ṩ�̽ӿ�ע��
     */
    @Resource
    ProvidersService providersService;

    /**
     * ��ת����˾ҳ��
     */
    @RequestMapping(value = "/company")
    public ModelAndView company(HttpServletRequest request, HttpServletResponse response)
    {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("company/companyList");
        return mv;
    }

    /**
     * ��ת��ʩ������ҳ��
     */
    @RequestMapping(value = "/worker")
    public ModelAndView worker(HttpServletRequest request, HttpServletResponse response)
    {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("worker/workerList");
        return mv;
    }

    /**
     * �����������ݣ�ǰ̨ͨ��ajax����
     */
    @RequestMapping(value = "/providers/pageList", method = RequestMethod.POST)
    public @ResponseBody Object pageList(PagerUtil pu, Integer type)
    {
        logger.info("ProvidersController->pageList:type{}", type);
        Map<String, Object> dataMaps = new HashMap<String, Object>();
        // ��ѯ����
        List<Providers> providersList = providersService.pagerList(pu, type);

        dataMaps.put("dataList", providersList);
        // ��ѯ��������
        Integer total = providersService.queryTotal();
        pu.setTotalRecords(total);
        pu.setTotalPage(pu.getTotalPage());
        dataMaps.put("pager", pu);
        return dataMaps;
    }

    /**
     * ��ҳ��ʾ�Ĺ�˾ ʩ������
     * 
     * @return
     */
    @RequestMapping(value = "/index/providersList", method = RequestMethod.POST)
    public @ResponseBody Object newsListIndex(Integer type)
    {
        // ��ѯ����
        return providersService.providersListIndex(type);
    }

}