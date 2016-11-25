package net.beautifycrack.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.beautifycrack.constant.Common;
import net.beautifycrack.module.UserInfo;
import net.beautifycrack.service.LoginService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * ��¼������
 * 
 * LoginController.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��11��24�� ����6:43:01
 * @author liulong
 */
@Controller
public class LoginController
{
    /**
     * ע���¼�ӿ�
     */
    @Resource
    private LoginService loginService;

    /**
     * ��ת����¼ҳ��
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
     * ��¼
     * 
     * @param request
     * @param response
     * @param user
     * @return
     */
    @RequestMapping(value = "/login.do")
    public @ResponseBody Map<String, Object> login(HttpServletRequest request, HttpServletResponse response,
            UserInfo user)
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
     * �ǳ�
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
