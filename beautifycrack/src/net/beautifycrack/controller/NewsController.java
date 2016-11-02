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

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
     * 跳转到新闻列表页面
     */
    @RequestMapping(value = "")
    public ModelAndView newsList(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView mv = new ModelAndView();
        mv.getModelMap().put("contextPath", request.getContextPath());
        mv.setViewName("news/newsList");
        return mv;
    }

    /**
     * 加载新闻数据，前台通多ajax调用
     */
    @RequestMapping(value = "/pageList", method = RequestMethod.POST)
    public @ResponseBody Object pageList(PagerUtil pu)
    {
        Map<String, Object> dataMaps = new HashMap<String, Object>();
        // 查询数据
        List<News> newList = newsService.pagerList(pu);

        dataMaps.put("dataList", newList);
        // 查询数据总数
        Integer total = newsService.queryTotal();
        pu.setTotalRecords(total);
        pu.setTotalPage(pu.getTotalPage());
        dataMaps.put("pager", pu);
        return dataMaps;
    }

    /**
     * 展示新闻详情
     * 
     * @param request
     * @param response
     * @param id
     * @return
     */
    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public ModelAndView showDetail(HttpServletRequest request, HttpServletResponse response, @PathVariable Long id)
    {
        ModelAndView mv = new ModelAndView();
        News news = newsService.showNews(id);
        mv.getModelMap().put("news", news);
        if (news.getPublishTime() != null)
        {
            mv.getModelMap().put("publishTime", DateFormatUtils.format(news.getPublishTime(), "yyyy-MM-dd"));
        }
        mv.setViewName("news/newsDetail");
        return mv;
    }

    /**
     * 首页显示的新闻列表，显示最新的15条
     * 
     * @return
     */
    @RequestMapping(value = "/index/newsList", method = RequestMethod.POST)
    public @ResponseBody Object newsListIndex()
    {
        // 查询数据
        return newsService.newsListIndex();
    }
}
