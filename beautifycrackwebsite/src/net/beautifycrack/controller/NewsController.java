package net.beautifycrack.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.beautifycrack.constant.Common;
import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.News;
import net.beautifycrack.service.NewsService;
import net.beautifycrack.util.PagerUtil;

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
     * 
     * @throws BusinessException
     */
    @RequestMapping(value = "/news/pageList.do", method = RequestMethod.POST)
    public @ResponseBody Object pageList(PagerUtil pu) throws BusinessException
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
     * ��ת����������
     * 
     * @param request
     * @param response
     * @param id
     * @return
     */
    @RequestMapping(value = "/news/showAdd.do", method = RequestMethod.GET)
    public ModelAndView showAdd(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("news/news_add");
        return mv;
    }

    /**
     * ��������
     * 
     * @param news
     * @return
     */
    @RequestMapping(value = "/news/add.do", method = RequestMethod.POST)
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
     * չʾ���ű༭
     * 
     * @param request
     * @param response
     * @param id
     * @return
     * @throws BusinessException 
     */
    @RequestMapping(value = "/news/showEdit.do", method = RequestMethod.GET)
    public ModelAndView showEdit(HttpServletRequest request, HttpServletResponse response, Long newsId) throws BusinessException
    {
        ModelAndView mv = new ModelAndView();
        News news = newsService.showNews(newsId);
        mv.getModelMap().put("news", news);
        mv.setViewName("/news/news_edit");
        return mv;
    }

    /**
     * ��������
     * 
     * @param news
     * @return
     */
    @RequestMapping(value = "/news/update.do", method = RequestMethod.POST)
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

    /**
     * ɾ������
     * 
     * @param news
     * @return
     */
    @RequestMapping(value = "/news/delete.do", method = RequestMethod.POST)
    public @ResponseBody Object deleteNews(Long newsId)
    {
        Map<String, Object> result = new HashMap<String, Object>();
        try
        {
            newsService.delete(newsId);
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
