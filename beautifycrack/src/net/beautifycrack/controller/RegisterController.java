package net.beautifycrack.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 注册控制器
 * 
 * RegisterController.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年10月10日 下午6:47:16
 * @author liulong
 */
@Scope("prototype")
@Controller
@RequestMapping("/register")
public class RegisterController
{
    /**
     * 跳转到注册首页
     * 
     * @return
     */
    @RequestMapping(value = "/index")
    public Object registerPage()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/register");
        return mv;
    }

    /**
     * 提交注册
     * 
     * @return
     */
    @RequestMapping(value = "/commit")
    public Object registerCommit()
    {
        return null;
    }
}
