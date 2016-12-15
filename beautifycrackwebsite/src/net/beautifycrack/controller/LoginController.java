package net.beautifycrack.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.beautifycrack.constant.Common;
import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.UserInfo;
import net.beautifycrack.service.LoginService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登录控制器
 * 
 * LoginController.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年11月24日 下午6:43:01
 * @author liulong
 */
@Controller
public class LoginController
{
    /**
     * 注入登录接口
     */
    @Resource
    private LoginService loginService;

    /**
     * 跳转到登录页面
     * 
     * @return
     */
    @RequestMapping(value = "/showLogin.do")
    public ModelAndView showLogin()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/login");
        return mv;
    }

    /**
     * 登录
     * 
     * @param request
     * @param response
     * @param user
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/login.do")
    public @ResponseBody Map<String, Object> login(HttpServletRequest request, HttpServletResponse response,
            UserInfo user) throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();
        int status = loginService.login(user);
        if (Common.STATUS_OK == status)
        {
            request.getSession().setAttribute("userInfo", user);
        }
        result.put("result", status);
        return result;
    }

    /**
     * 登出
     * 
     * @param request
     * @param response
     */
    @RequestMapping(value = "/logout.do")
    public String logout(HttpServletRequest request, HttpServletResponse response)
    {
        HttpSession session = request.getSession();
        if (session != null)
        {
            session.invalidate();
        }

        return "redirect:/";
    }

}
