package net.beautifycrack.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.beautifycrack.module.Advertisement;
import net.beautifycrack.service.AdvertisementService;
import net.beautifycrack.util.PagerUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * �ֲ���������
 * 
 * AdsController.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��11��15�� ����4:57:12
 * @author liulong
 */
@Controller
public class AdsController
{
    /**
     * ע�������ӿ�
     */
    @Resource
    private AdvertisementService adsService;

    /**
     * ��ת���ֲ�����б�ҳ��
     * 
     * @return
     */
    @RequestMapping(value = "/adsmanager.do")
    public ModelAndView newsIndex()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/ads/adsList");
        return mv;
    }

    /**
     * �������ݣ�ҳ��ͨ��ajax����
     */
    @RequestMapping(value = "/ads/pageList.do", method = RequestMethod.POST)
    public @ResponseBody Object pageList(PagerUtil pu)
    {
        Map<String, Object> dataMaps = new HashMap<String, Object>();
        // ��ѯ����
        List<Advertisement> newList = adsService.pagerList(pu);

        dataMaps.put("dataList", newList);
        // ��ѯ��������
        Integer total = adsService.queryTotal();
        pu.setTotalRecords(total);
        pu.setTotalPage(pu.getTotalPage());
        dataMaps.put("pager", pu);
        return dataMaps;
    }

    /**
     * ��ת���ֲ��������
     * 
     * @param request
     * @param response
     * @param id
     * @return
     */
    @RequestMapping(value = "/ads/showAdd.do", method = RequestMethod.GET)
    public ModelAndView showAdd(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("ads/ads_add");
        return mv;
    }
}
