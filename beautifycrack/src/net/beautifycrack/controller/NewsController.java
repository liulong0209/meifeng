package net.beautifycrack.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.beautifycrack.module.News;
import net.beautifycrack.service.NewsService;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 新闻动态
 * 
 * NewsController.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月12日 下午4:14:05
 * @author liulong
 */
@Scope("prototype")
@Controller
@RequestMapping("/news")
public class NewsController
{

    /**
     * 新闻接口
     */
    @Resource
    private NewsService newsService;

    /**
     * 跳转到首页
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
     * 跳转到首页
     */
    @RequestMapping(value = "/pageList", method = RequestMethod.POST)
    public @ResponseBody Object pageList()
    {
        List<News> newList = newsService.pageList();
        Integer total = newsService.queryTotal();
        return newList;
    }
}
