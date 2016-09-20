package net.beautifycrack.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * ��˾�Ŀ�����
 * 
 * CompanyController.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��12�� ����4:44:59
 * @author liulong
 */
@Scope("prototype")
@Controller
@RequestMapping("/company")
public class CompanyController
{
    private static Logger logger = LoggerFactory.getLogger(IndexController.class);

    /**
     * ��ת����˾�б�
     */
    @RequestMapping(value = "")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response)
    {

        ModelAndView mv = new ModelAndView();
        mv.getModelMap().put("contextPath", request.getContextPath());
        logger.debug("IndexController->list:contextPath:{}", request.getContextPath());
        mv.setViewName("company/companyList");
        return mv;
    }
}
