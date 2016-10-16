package net.beautifycrack.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.beautifycrack.constant.Common;
import net.beautifycrack.module.UserInfo;
import net.beautifycrack.service.UserInfoService;
import net.beautifycrack.util.MD5Util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 登录控制器
 * 
 * LoginController.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年10月10日 下午6:47:51
 * @author liulong
 */
@Scope("prototype")
@Controller
public class LoginController
{
    @Resource
    private UserInfoService userInfoService;

    /**
     * 登录
     * 
     * @param userName
     * @param password
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/login")
    public @ResponseBody Object login(HttpServletRequest request, HttpServletResponse response, String account,
            String password)
    {
    	UserInfo userInfo = userInfoService.queryUserInfo(account);
        if (userInfo == null)
        {
        	return Common.USERINFO_NOT_EXISTS;
        }
        else
        {
        	//密码不正确
        	if(!userInfo.getPassword().equals(MD5Util.generatePassword(password)))
        	{
        		return Common.USERINFO_PASSWORD_ERROR;
        	}
        }

        
        request.getSession().setAttribute("userInfo", userInfo);
        return 0;
    }

    /**
     * 登出
     * 
     * @param request
     * @param response
     * @throws IOException
     * @return
     */
    public String logout(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        request.getSession().invalidate();
        return "redirect:" + request.getContextPath();
    }
}
