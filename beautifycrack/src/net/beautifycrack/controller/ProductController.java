package net.beautifycrack.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.beautifycrack.constant.Common;
import net.beautifycrack.module.Product;
import net.beautifycrack.module.ProductCategory;
import net.beautifycrack.service.ProductService;
import net.beautifycrack.util.PagerUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * ��Ʒ������(���Ϻ͹���)
 * 
 * ProductController.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��12�� ����4:44:24
 * @author liulong
 */
@Scope("prototype")
@Controller
public class ProductController
{
    private static Logger logger = LoggerFactory.getLogger(ProductController.class);
    /**
     * ע���Ʒ�ӿ�
     */
    @Resource
    private ProductService productService;

    /**
     * ��ת���������ҳ��
     * 
     * @return
     */
    @RequestMapping(value = "/material")
    public Object materialIndex()
    {
        // ��ȡ���Ϸ�����Ŀ
        List<ProductCategory> materialCategory = productService.getMaterialCategory();
        ModelAndView mv = new ModelAndView();
        mv.getModelMap().put("firstCategory", materialCategory.get(0).getId());
        mv.getModelMap().put("productCategory", materialCategory);
        // ���������ʱ�����
        mv.getModelMap().put("type", Common.PRODUCT_MATERIAL);
        mv.setViewName("product/productList");
        return mv;
    }

    /**
     * ��ת�����칤��ҳ��
     * 
     * @return
     */
    @RequestMapping(value = "/tools")
    public Object toolsIndex()
    {
        // ��ȡ���߷�����Ŀ
        List<ProductCategory> toolsCategory = productService.getToolsCategory();
        ModelAndView mv = new ModelAndView();
        mv.getModelMap().put("firstCategory", toolsCategory.get(0).getId());
        mv.getModelMap().put("productCategory", toolsCategory);
        // ���������ʱ�򹤾�
        mv.getModelMap().put("type", Common.PRODUCT_TOOLS);
        mv.setViewName("product/productList");
        return mv;
    }

    /**
     * ��ҳչʾ����
     * 
     * @param pu
     * @param categoryId
     * @return
     */
    @RequestMapping(value = "/product/pageList", method = RequestMethod.POST)
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

    /**
     * ��ҳ��ʾ�Ĳ�Ʒ����(���Ϻ͹���)
     * 
     * @return
     */
    @RequestMapping(value = "/product/indexShow/{type}", method = RequestMethod.POST)
    public @ResponseBody Object indexPageShow(@PathVariable Integer type)
    {
        return productService.indexShow(type);
    }
}
