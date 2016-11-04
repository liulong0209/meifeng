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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewsController
{
    /**
     * ���Žӿ�
     */
    @Resource
    private NewsService newsService;

    /**
     * ��ת�������б�ҳ��
     * 
     * @return
     */
    @RequestMapping(value = "/newsmanager.do")
    public ModelAndView newsIndex()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/news/newsList");

        return mv;
    }

    /**
     * �����������ݣ�ǰ̨ͨ��ajax����
     */
    @RequestMapping(value = "/news/pageList.do", method = RequestMethod.POST)
    public @ResponseBody Object pageList(PagerUtil pu)
    {
        Map<String, Object> dataMaps = new HashMap<String, Object>();
        // ��ѯ����
        List<News> newList = newsService.pagerList(pu);

        dataMaps.put("dataList", newList);
        // ��ѯ��������
        Integer total = newsService.queryTotal();
        pu.setTotalRecords(total);
        pu.setTotalPage(pu.getTotalPage());
        dataMaps.put("pager", pu);
        return dataMaps;
    }

    /**
     * չʾ��������
     * 
     * @param request
     * @param response
     * @param id
     * @return
     */
    @RequestMapping(value = "/news/show.do", method = RequestMethod.GET)
    public ModelAndView showDetail(HttpServletRequest request, HttpServletResponse response, Long id)
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
}