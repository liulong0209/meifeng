package net.beautifycrack.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.beautifycrack.module.News;
import net.beautifycrack.service.NewsService;
import net.beautifycrack.util.PagerUtil;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * ���Ŷ�̬
 * 
 * NewsController.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��12�� ����4:14:05
 * @author liulong
 */
@Scope("prototype")
@Controller
@RequestMapping("/news")
public class NewsController
{

    /**
     * ���Žӿ�
     */
    @Resource
    private NewsService newsService;

    /**
     * ��ת����ҳ
     */
    @RequestMapping(value = "/list")
    public ModelAndView newsList(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView mv = new ModelAndView();
        mv.getModelMap().put("contextPath", request.getContextPath());
        mv.setViewName("news/newsList");
        return mv;
    }

    /**
     * ��ת����ҳ
     */
    @RequestMapping(value = "/pageList", method = RequestMethod.POST)
    public @ResponseBody Object pageList(PagerUtil pu)
    {
        Map<String, Object> dataMaps = new HashMap<String, Object>();
        // ��ѯ����
        List<News> newList = newsService.pageList();

        dataMaps.put("dataList", newList);
        // ��ѯ��������
        Integer total = newsService.queryTotal();
        pu.setTotalRecords(total);
        pu.setTotalPage(pu.getTotalPage());
        dataMaps.put("pager", pu);
        return dataMaps;
    }
}
