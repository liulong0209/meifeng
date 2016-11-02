package net.beautifycrack.console.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.beautifycrack.constant.Common;
import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.News;
import net.beautifycrack.service.NewsService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 后台新闻管理页面
 * 
 * NewsController.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年11月2日 下午3:21:16
 * @author liulong
 */
@Controller(value = "adminNews")
@RequestMapping("/console/newsmanager")
public class NewsController
{
    /**
     * 新闻接口
     */
    @Resource
    private NewsService newsService;

    /**
     * 跳转到新闻增加页面
     * 
     * @return
     */
    @RequestMapping(value = "/showAdd", method = RequestMethod.GET)
    public ModelAndView showAdd()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/console/news/news_add");
        return mv;
    }

    /**
     * 增加新闻
     * 
     * @param news
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public @ResponseBody Object addNews(News news)
    {
        Map<String, Object> result = new HashMap<String, Object>();
        try
        {
            newsService.add(news);
            result.put("result", Common.SUCCESS);
            return result;
        }
        catch (BusinessException e)
        {
            result.put("result", Common.FAIL);
            return result;
        }
    }

    /**
     * 展示新闻详情
     * 
     * @param request
     * @param response
     * @param id
     * @return
     */
    @RequestMapping(value = "/showEdit/{id}", method = RequestMethod.GET)
    public ModelAndView showDetail(HttpServletRequest request, HttpServletResponse response, @PathVariable Long id)
    {
        ModelAndView mv = new ModelAndView();
        News news = newsService.showNews(id);
        mv.getModelMap().put("news", news);
        mv.setViewName("/console/news/news_edit");
        return mv;
    }
    
    /**
     * 更新新闻
     * 
     * @param news
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public @ResponseBody Object updateNews(News news)
    {
        Map<String, Object> result = new HashMap<String, Object>();
        try
        {
            newsService.update(news);
            result.put("result", Common.SUCCESS);
            return result;
        }
        catch (BusinessException e)
        {
            result.put("result", Common.FAIL);
            return result;
        }
    }
}
