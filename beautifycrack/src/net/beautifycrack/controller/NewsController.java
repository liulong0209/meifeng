package net.beautifycrack.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
