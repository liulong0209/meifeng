package net.beautifycrack.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.beautifycrack.module.UserInfo;
import net.beautifycrack.service.UserInfoService;
import net.beautifycrack.util.MD5Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    private static Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @Resource
    private UserInfoService userInfoService;

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
     * 校验用户名是否已存在
     * 
     * @param userName
     * @return
     */
    @RequestMapping(value = "/judgeAccount")
    public @ResponseBody Object judgeAccount(String userName)
    {
        logger.debug("RegisterController->judgeAccount->userName:{}", userName);
        // 如果账号已存在，前台校验不通过
        if (userInfoService.userNameExist(userName))
        {
            return "{\"valid\": false  }";
        }
        else
        {
            return "{\"valid\": true  }";
        }
    }

    /**
     * 校验手机号是否已存在
     * 
     * @param userName
     * @return
     */
    @RequestMapping(value = "/judgePhone")
    public @ResponseBody Object judgePhone(String phoneNo)
    {
        logger.debug("RegisterController->judgePhone->phoneNo:{}", phoneNo);
        // 如果手机号已存在，前台校验不通过
        if (userInfoService.phoneExist(phoneNo))
        {
            return "{\"valid\": false  }";
        }
        else
        {
            return "{\"valid\": true  }";
        }
    }

    /**
     * 提交注册
     * 
     * @return
     */
    @RequestMapping(value = "/commit")
    public @ResponseBody Object registerCommit(HttpServletRequest request,String userName, String password, String phoneNo)
    {
    	try
    	{
    		UserInfo userInfo = new UserInfo();
    		userInfo.setUserName(userName);
    		userInfo.setPassword(MD5Util.generatePassword(password));
    		userInfo.setPhoneNo(phoneNo);
    		userInfoService.addUser(userInfo);
    		
    		//注册后自动登录
    		UserInfo user = userInfoService.queryUserInfo(userName);
    		request.getSession().setAttribute("userInfo", user);
    		return 0;
    	}
    	catch (Exception e) 
    	{
    		return 1;
		}
    }

}
