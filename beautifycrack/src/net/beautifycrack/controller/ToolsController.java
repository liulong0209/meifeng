package net.beautifycrack.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * ���߿�����
 * 
 * ToolsController.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��12�� ����4:46:21
 * @author liulong
 */
@Scope("prototype")
@Controller
@RequestMapping("/tools")
public class ToolsController
{
    /**
     * ��ת�����칤��ҳ��
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
