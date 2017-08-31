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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 首页控制器
 * 
 * IndexController.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月12日 下午4:14:37
 * @author liulong
 */

@Scope("prototype")
@Controller
@RequestMapping("/index")
public class IndexController
{
    private static Logger logger = LoggerFactory.getLogger(IndexController.class);
    /**
     * 广告接口
     */
    @Resource
    private AdvertisementService adService;

    /**
     * 跳转到首页
     */
    @RequestMapping(value = "/home")
    public ModelAndView indexPage(HttpServletRequest request, HttpServletResponse response)
    {

        ModelAndView mv = new ModelAndView();

        mv.setViewName("index");
        return mv;
    }

    /**
     * 加载轮播图数据
     */
    @RequestMapping(value = "/slideList", method = RequestMethod.POST)
    public @ResponseBody Object slideList()
    {
        // 查询轮播广告
        List<Advertisement> slideList = adService.getSlideImg();
        logger.debug("IndexController->slideList->slideList size:{}", slideList.size());
        return slideList;
    }
}
