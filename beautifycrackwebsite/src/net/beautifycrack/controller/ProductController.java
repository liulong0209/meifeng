package net.beautifycrack.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.beautifycrack.constant.Common;
import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.Product;
import net.beautifycrack.module.ProductCategory;
import net.beautifycrack.module.Providers;
import net.beautifycrack.service.FileInfoService;
import net.beautifycrack.service.ProductCategoryService;
import net.beautifycrack.service.ProductService;
import net.beautifycrack.service.ProvidersService;
import net.beautifycrack.util.PagerUtil;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 材料控制器
 * 
 * ProductController.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月12日 下午4:44:24
 * @author liulong
 */
@Controller
public class ProductController
{
    private static Logger logger = LoggerFactory.getLogger(ProductController.class);

    /**
     * 注入service
     */
    @Resource
    private ProductService productService;

    /**
     * 注入产品分类service
     */
    @Resource
    private ProductCategoryService productCategoryService;

    /**
     * 注入公司service
     */
    @Resource
    private ProvidersService providersService;

    /**
     * 上传文件根路径
     */
    @Value("#{properties['root.upload.path']}")
    private String uploadPath;

    /**
     * 供应商文件目录
     */
    @Value("#{properties['product.upload.path']}")
    private String productUploadPath;

    /**
     * 文件接口
     */
    @Resource
    private FileInfoService fileInfoService;

    /**
     * 跳转到美缝材料管理页面
     * 
     * @return
     */
    @RequestMapping(value = "/materialmanager.do")
    public ModelAndView materialmanager()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("material/material_list");
        return mv;
    }

    /**
     * 跳转到美缝工具管理页面
     * 
     * @return
     */
    @RequestMapping(value = "/toolsmanager.do")
    public ModelAndView toolsmanager()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("tools/tools_list");
        return mv;
    }

    /**
     * 材料分页展示数据
     * 
     * @param pu
     * @param categoryId
     * @return
     */
    @RequestMapping(value = "/product/pageList.do", method = RequestMethod.POST)
    public @ResponseBody Object pageList(PagerUtil pu, Integer productType) throws BusinessException

    {
        logger.debug("MaterialController->pageCategoryList->productType=" + productType);
        Map<String, Object> dataMaps = new HashMap<String, Object>();

        List<Product> list = productService.pageList(pu, productType);

        dataMaps.put("dataList", list);

        Integer total = productService.queryTotal(productType);
        pu.setPageSize(Common.PAGE_SIZE_Eighteen);
        pu.setTotalRecords(total);
        pu.setTotalPage(pu.getTotalPage());
        dataMaps.put("pager", pu);
        return dataMaps;
    }

    /**
     * 跳转到美缝材料新增页面
     * 
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/material/showAdd.do")
    public ModelAndView showMaterialAdd() throws BusinessException
    {
        ModelAndView mv = new ModelAndView();
        // 产品分类
        List<ProductCategory> categoriList = productCategoryService.findCategoryByType(Common.PRODUCT_MATERIAL);

        // 供应公司
        List<Providers> providersList = providersService.findProvideProductCompany();

        mv.getModelMap().put("categoriList", categoriList);
        mv.getModelMap().put("providersList", providersList);
        mv.setViewName("material/material_add");
        return mv;
    }

    /**
     * 跳转到美缝工具新增页面
     * 
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/tools/showAdd.do")
    public ModelAndView showToolsAdd() throws BusinessException
    {
        ModelAndView mv = new ModelAndView();
        // 产品分类
        List<ProductCategory> categoriList = productCategoryService.findCategoryByType(Common.PRODUCT_TOOLS);

        // 供应公司
        List<Providers> providersList = providersService.findProvideProductCompany();

        mv.getModelMap().put("categoriList", categoriList);
        mv.getModelMap().put("providersList", providersList);
        mv.setViewName("tools/tools_add");
        return mv;
    }

    /**
     * 材料增加
     * 
     * @param product
     * @param imageData
     * @param original
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/product/add.do", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> addProduct(Product product, String imageData, String original)
            throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();

        try
        {
            // 上传文件
            if (!StringUtils.isEmpty(imageData))
            {

                Long fileId = Long.valueOf(fileInfoService.uploadImg(uploadPath, productUploadPath, original,
                        imageData.substring("data:image/png;base64,".length())));
                product.setImgId(fileId);
            }
            // 添加到数据库
            productService.add(product);
            result.put("result", Common.SUCCESS);
        }
        catch (IOException e)
        {
            result.put("result", Common.FAIL);
            logger.error("新增美缝公司失败：原因{}", e);
        }
        return result;
    }

    /**
     * 产品删除
     * 
     * @param request
     * @param response
     * @param providers
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/product/delete.do", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response,
            Product product) throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();

        try
        {
            productService.delete(product);
            result.put("result", Common.SUCCESS);
        }
        catch (Exception e)
        {
            logger.debug("删除供应商失败，原因：", e);
            result.put("result", Common.FAIL);
        }

        return result;
    }

    /**
     * 跳转到美缝材料编辑页面
     * 
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/material/showEdit.do")
    public ModelAndView showMaterialEdit(Long productId) throws BusinessException
    {
        ModelAndView mv = new ModelAndView();
        // 产品分类
        List<ProductCategory> categoriList = productCategoryService.findCategoryByType(Common.PRODUCT_MATERIAL);

        // 供应公司
        List<Providers> providersList = providersService.findProvideProductCompany();

        Product product = productService.find(productId);

        mv.getModelMap().put("categoriList", categoriList);
        mv.getModelMap().put("providersList", providersList);
        mv.getModelMap().put("product", product);
        mv.setViewName("material/material_edit");
        return mv;
    }

    /**
     * 跳转到美缝工具编辑页面
     * 
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/tools/showEdit.do")
    public ModelAndView showToolsEdit(Long productId) throws BusinessException
    {
        ModelAndView mv = new ModelAndView();
        // 产品分类
        List<ProductCategory> categoriList = productCategoryService.findCategoryByType(Common.PRODUCT_TOOLS);

        // 供应公司
        List<Providers> providersList = providersService.findProvideProductCompany();

        Product product = productService.find(productId);

        mv.getModelMap().put("categoriList", categoriList);
        mv.getModelMap().put("providersList", providersList);
        mv.getModelMap().put("product", product);
        mv.setViewName("tools/tools_edit");
        return mv;
    }

    /**
     * 美缝公司 团队 个人更新
     * 
     * @param request
     * @param response
     * @param ads
     * @param file
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/product/update.do", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> update(HttpServletRequest request, HttpServletResponse response,
            Product product, String imageData, String original) throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();

        try
        {
            // 上传文件
            if (!StringUtils.isEmpty(imageData))
            {

                Long fileId = Long.valueOf(fileInfoService.uploadImg(uploadPath, productUploadPath, original,
                        imageData.substring("data:image/png;base64,".length())));
                product.setImgId(fileId);
            }
            // 同步到数据库
            productService.update(product);
            result.put("result", Common.SUCCESS);
        }
        catch (Exception e)
        {
            logger.debug("更新供应商失败，原因：", e);
            result.put("result", Common.FAIL);
        }

        return result;
    }

    /**
     * 编辑删除图片时更新供应商logo为-1
     * 
     * @param ads
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/product/ajaxUpdate.do", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> ajaxUpdate(Product product) throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();
        try
        {
            productService.update(product);
            result.put("result", Common.SUCCESS);
        }
        catch (Exception e)
        {
            result.put("result", Common.FAIL);
            logger.debug("更新供应商失败，原因：", e);
        }

        return result;
    }
}
