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
 * ע�������
 * 
 * RegisterController.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��10��10�� ����6:47:16
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
     * ��ת��ע����ҳ
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
     * У���û����Ƿ��Ѵ���
     * 
     * @param userName
     * @return
     */
    @RequestMapping(value = "/judgeAccount")
    public @ResponseBody Object judgeAccount(String userName)
    {
        logger.debug("RegisterController->judgeAccount->userName:{}", userName);
        // ����˺��Ѵ��ڣ�ǰ̨У�鲻ͨ��
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
     * У���ֻ����Ƿ��Ѵ���
     * 
     * @param userName
     * @return
     */
    @RequestMapping(value = "/judgePhone")
    public @ResponseBody Object judgePhone(String phoneNo)
    {
        logger.debug("RegisterController->judgePhone->phoneNo:{}", phoneNo);
        // ����ֻ����Ѵ��ڣ�ǰ̨У�鲻ͨ��
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
     * �ύע��
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
    		
    		//ע����Զ���¼
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
