package net.beautifycrack.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.beautifycrack.constant.Common;
import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.ProductCategory;
import net.beautifycrack.service.ProductCategoryService;
import net.beautifycrack.util.PagerUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * ����/���Ϸ��������
 * 
 * ProductCategoryController.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��12��12�� ����6:55:36
 * @author liulong
 */
@Controller
public class ProductCategoryController
{
    private static Logger logger = LoggerFactory.getLogger(MaterialController.class);

    /**
     * ע���Ʒ�ӿ�
     */
    @Resource
    private ProductCategoryService productCategoryService;

    /**
     * ��ת������/���Ϸ����б�
     * 
     * @param productType
     *            ��Ʒ���� 0���� 1����
     * @return
     */
    @RequestMapping(value = { "/materialCategory.do", "/toolsCategory.do" })
    public Object productCategory(Integer productType)
    {
        ModelAndView mv = new ModelAndView();
        mv.getModelMap().put("productType", productType);
        mv.setViewName("productCategory/product_category_list");
        return mv;
    }

    /**
     * ����/���߷����ҳչʾ����
     * 
     * @param pu
     * @param categoryId
     * @return
     */
    @RequestMapping(value = "/productCategory/pageList.do", method = RequestMethod.POST)
    public @ResponseBody Object pageCategoryList(PagerUtil pu, Integer productType) throws BusinessException

    {
        logger.debug("MaterialController->pageCategoryList->productType=" + productType);
        Map<String, Object> dataMaps = new HashMap<String, Object>();

        List<ProductCategory> list = productCategoryService.queryCategories(pu, productType);

        dataMaps.put("dataList", list);

        Integer total = productCategoryService.queryCategoriesTotal(productType);
        pu.setPageSize(Common.PAGE_SIZE_Eighteen);
        pu.setTotalRecords(total);
        pu.setTotalPage(pu.getTotalPage());
        dataMaps.put("pager", pu);
        return dataMaps;
    }

    /**
     * ��ת�����칤��/���Ϸ�������ҳ��
     * 
     * @param productType
     *            ��Ʒ���� 0���� 1����
     * @return
     */
    @RequestMapping(value = "/productCategory/showAdd.do")
    public Object productCategoryShowAdd(Integer productType) throws BusinessException

    {
        ModelAndView mv = new ModelAndView();
        mv.getModelMap().put("productType", productType);
        mv.setViewName("productCategory/product_category_add");
        return mv;
    }

    /**
     * ��������
     * 
     * @param productCategory
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/productCategory/add.do")
    public @ResponseBody Map<String, Object> add(ProductCategory productCategory) throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();
        try
        {
            productCategoryService.add(productCategory);
            result.put("result", Common.SUCCESS);
        }
        catch (Exception e)
        {
            result.put("result", Common.FAIL);
            logger.error("������Ʒ����ʧ�ܣ�ԭ��" + e);
        }
        return result;
    }

    /**
     * ��������
     * 
     * @param productCategory
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/productCategory/delete.do")
    public @ResponseBody Map<String, Object> delete(Integer id) throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();
        try
        {
            productCategoryService.delete(id);
            result.put("result", Common.SUCCESS);
        }
        catch (Exception e)
        {
            result.put("result", Common.FAIL);
            logger.error("������Ʒ����ʧ�ܣ�ԭ��" + e);
        }
        return result;
    }

    /**
     * ��ת�����칤��/���Ϸ�������ҳ��
     * 
     * @param productType
     *            ��Ʒ���� 0���� 1����
     * @return
     */
    @RequestMapping(value = "/productCategory/showEdit.do")
    public Object productCategoryShowEdit(Integer id) throws BusinessException

    {
        ModelAndView mv = new ModelAndView();
        ProductCategory productCategory = productCategoryService.queryById(id);
        mv.getModelMap().put("productCategory", productCategory);
        mv.setViewName("productCategory/product_category_edit");
        return mv;
    }

    /**
     * ���·���
     * 
     * @param productCategory
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/productCategory/update.do")
    public @ResponseBody Map<String, Object> update(ProductCategory productCategory) throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();
        try
        {
            productCategoryService.update(productCategory);
            result.put("result", Common.SUCCESS);
        }
        catch (Exception e)
        {
            result.put("result", Common.FAIL);
            logger.error("���²�Ʒ����ʧ�ܣ�ԭ��" + e);
        }
        return result;
    }
}
