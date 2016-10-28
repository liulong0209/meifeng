package net.beautifycrack.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.beautifycrack.module.Advertisement;
import net.beautifycrack.service.AdvertisementService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * ��ҳ������
 * 
 * IndexController.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��12�� ����4:14:37
 * @author liulong
 */

@Scope("prototype")
@Controller
@RequestMapping("/index")
public class IndexController
{
    private static Logger logger = LoggerFactory.getLogger(IndexController.class);
    /**
     * ���ӿ�
     */
    @Resource
    private AdvertisementService adService;

    /**
     * ��ת����ҳ
     */
    @RequestMapping(value = "/home")
    public ModelAndView indexPage(HttpServletRequest request, HttpServletResponse response)
    {
        // ��ѯ�ֲ����
        List<Advertisement> slideList = adService.getSlideImg();

        // logger.debug("IndexController->indexPage->slideList size:{}",
        // slideList.size());

        ModelAndView mv = new ModelAndView();
        mv.getModelMap().put("slideList", slideList);
        mv.setViewName("index");
        return mv;
    }
}
