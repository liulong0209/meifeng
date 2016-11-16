package net.beautifycrack.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.beautifycrack.constant.Common;
import net.beautifycrack.module.Product;
import net.beautifycrack.service.ProductService;
import net.beautifycrack.util.PagerUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * ���Ͽ�����
 * 
 * ProductController.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��12�� ����4:44:24
 * @author liulong
 */
@Controller
public class MaterialController
{
    private static Logger logger = LoggerFactory.getLogger(MaterialController.class);
    /**
     * ע���Ʒ�ӿ�
     */
    @Resource
    private ProductService productService;

    /**
     * ��ת����������б�
     * 
     * @return
     */
    @RequestMapping(value = "/materialmanager.do")
    public Object materialIndex()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("material/material_list");
        return mv;
    }

    /**
     * ��ҳչʾ����
     * 
     * @param pu
     * @param categoryId
     * @return
     */
    @RequestMapping(value = "/material/pageList.do", method = RequestMethod.POST)
    public @ResponseBody Object pageList(PagerUtil pu, Long categoryId)
    {
        logger.info("ProductController->pageList->categoryId{}", categoryId);
        Map<String, Object> dataMaps = new HashMap<String, Object>();

        List<Product> list = productService.queryProduct(pu, categoryId);

        dataMaps.put("dataList", list);

        Integer total = productService.queryTotal(categoryId);
        pu.setPageSize(Common.PAGE_SIZE_Eighteen);
        pu.setTotalRecords(total);
        pu.setTotalPage(pu.getTotalPage());
        dataMaps.put("pager", pu);
        return dataMaps;
    }

}