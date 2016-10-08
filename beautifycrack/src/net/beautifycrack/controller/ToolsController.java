package net.beautifycrack.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 工具控制器
 * 
 * ToolsController.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月12日 下午4:46:21
 * @author liulong
 */
@Scope("prototype")
@Controller
@RequestMapping("/tools")
public class ToolsController
{
    /**
     * 跳转到美缝工具页面
     * 
     * @return
     */
    @RequestMapping(value = "")
    public Object toolsIndex()
    {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("tools/toolsList");
        return mv;
    }
}
