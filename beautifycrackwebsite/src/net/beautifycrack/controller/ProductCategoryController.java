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
 * 工具/材料分类控制器
 * 
 * ProductCategoryController.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年12月12日 下午6:55:36
 * @author liulong
 */
@Controller
public class ProductCategoryController
{
    private static Logger logger = LoggerFactory.getLogger(ProductCategoryController.class);

    /**
     * 注入产品接口
     */
    @Resource
    private ProductCategoryService productCategoryService;

    /**
     * 跳转到工具/材料分类列表
     * 
     * @param productType
     *            产品类型 0工具 1材料
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
     * 材料/工具分类分页展示数据
     * 
     * @param pu
     * @param categoryId
     * @return
     */
    @RequestMapping(value = "/productCategory/pageList.do", method = RequestMethod.POST)
    public @ResponseBody Object pageCategoryList(PagerUtil pu, Integer productType) throws BusinessException

    {
        logger.debug("ProductCategoryController->pageCategoryList->productType=" + productType);
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
     * 跳转到美缝工具/材料分类新增页面
     * 
     * @param productType
     *            产品类型 0工具 1材料
     * @return
     */
    @RequestMapping(value = "/productCategory/showAdd.do")
    public Object productCategoryShowAdd(Integer productType) throws BusinessException

    {
        logger.debug("ProductCategoryController->productCategoryShowAdd->productType=" + productType);
        ModelAndView mv = new ModelAndView();
        mv.getModelMap().put("productType", productType);
        mv.setViewName("productCategory/product_category_add");
        return mv;
    }

    /**
     * 新增分类
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
            logger.error("新增产品分类失败，原因：" + e);
        }
        return result;
    }

    /**
     * 新增分类
     * 
     * @param productCategory
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/productCategory/delete.do")
    public @ResponseBody Map<String, Object> delete(Long id) throws BusinessException
    {
        logger.debug("ProductCategoryController->delete->id=" + id);
        Map<String, Object> result = new HashMap<String, Object>();
        try
        {
            productCategoryService.delete(id);
            result.put("result", Common.SUCCESS);
        }
        catch (Exception e)
        {
            result.put("result", Common.FAIL);
            logger.error("新增产品分类失败，原因：" + e);
        }
        return result;
    }

    /**
     * 跳转到美缝工具/材料分类新增页面
     * 
     * @param productType
     *            产品类型 0工具 1材料
     * @return
     */
    @RequestMapping(value = "/productCategory/showEdit.do")
    public Object productCategoryShowEdit(Long id) throws BusinessException

    {
        ModelAndView mv = new ModelAndView();
        ProductCategory productCategory = productCategoryService.queryById(id);
        mv.getModelMap().put("productCategory", productCategory);
        mv.setViewName("productCategory/product_category_edit");
        return mv;
    }

    /**
     * 更新分类
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
            logger.error("更新产品分类失败，原因：" + e);
        }
        return result;
    }
}
