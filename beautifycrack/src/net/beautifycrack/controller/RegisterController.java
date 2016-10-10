package net.beautifycrack.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
     * �ύע��
     * 
     * @return
     */
    @RequestMapping(value = "/commit")
    public Object registerCommit()
    {
        return null;
    }
}
