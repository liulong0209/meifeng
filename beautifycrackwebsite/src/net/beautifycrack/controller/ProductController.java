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
public class ProductController
{
    private static Logger logger = LoggerFactory.getLogger(ProductController.class);

    /**
     * ע��service
     */
    @Resource
    private ProductService productService;

    /**
     * ע���Ʒ����service
     */
    @Resource
    private ProductCategoryService productCategoryService;

    /**
     * ע�빫˾service
     */
    @Resource
    private ProvidersService providersService;

    /**
     * �ϴ��ļ���·��
     */
    @Value("#{properties['root.upload.path']}")
    private String uploadPath;

    /**
     * ��Ӧ���ļ�Ŀ¼
     */
    @Value("#{properties['product.upload.path']}")
    private String productUploadPath;

    /**
     * �ļ��ӿ�
     */
    @Resource
    private FileInfoService fileInfoService;

    /**
     * ��ת��������Ϲ���ҳ��
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
     * ��ת�����칤�߹���ҳ��
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
     * ���Ϸ�ҳչʾ����
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
     * ��ת�������������ҳ��
     * 
     * @return
     */
    @RequestMapping(value = "/material/showAdd.do")
    public ModelAndView showMaterialAdd()
    {
        ModelAndView mv = new ModelAndView();
        // ��Ʒ����
        List<ProductCategory> categoriList = productCategoryService.findCategoryByType(Common.PRODUCT_MATERIAL);

        // ��Ӧ��˾
        List<Providers> providersList = providersService.findProvideProductCompany();

        mv.getModelMap().put("categoriList", categoriList);
        mv.getModelMap().put("providersList", providersList);
        mv.setViewName("material/material_add");
        return mv;
    }

    /**
     * ��ת�����칤������ҳ��
     * 
     * @return
     */
    @RequestMapping(value = "/tools/showAdd.do")
    public ModelAndView showToolsAdd()
    {
        ModelAndView mv = new ModelAndView();
        // ��Ʒ����
        List<ProductCategory> categoriList = productCategoryService.findCategoryByType(Common.PRODUCT_TOOLS);

        // ��Ӧ��˾
        List<Providers> providersList = providersService.findProvideProductCompany();

        mv.getModelMap().put("categoriList", categoriList);
        mv.getModelMap().put("providersList", providersList);
        mv.setViewName("tools/tools_add");
        return mv;
    }

    /**
     * ��������
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
            // �ϴ��ļ�
            if (!StringUtils.isEmpty(imageData))
            {

                Long fileId = Long.valueOf(fileInfoService.uploadImg(uploadPath, productUploadPath, original,
                        imageData.substring("data:image/png;base64,".length())));
                product.setImgId(fileId);
            }
            // ��ӵ����ݿ�
            productService.add(product);
            result.put("result", Common.SUCCESS);
        }
        catch (IOException e)
        {
            result.put("result", Common.FAIL);
            logger.error("�������칫˾ʧ�ܣ�ԭ��{}", e);
        }
        return result;
    }
    
    /**
     * ��Ʒɾ��
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
            logger.debug("ɾ����Ӧ��ʧ�ܣ�ԭ��", e);
            result.put("result", Common.FAIL);
        }

        return result;
    }
    
    /**
     * ��ת��������ϱ༭ҳ��
     * 
     * @return
     */
    @RequestMapping(value = "/material/showEdit.do")
    public ModelAndView showMaterialEdit(Long productId)
    {
        ModelAndView mv = new ModelAndView();
        // ��Ʒ����
        List<ProductCategory> categoriList = productCategoryService.findCategoryByType(Common.PRODUCT_MATERIAL);

        // ��Ӧ��˾
        List<Providers> providersList = providersService.findProvideProductCompany();
        
        Product product = productService.find(productId);

        mv.getModelMap().put("categoriList", categoriList);
        mv.getModelMap().put("providersList", providersList);
        mv.getModelMap().put("product", product);
        mv.setViewName("material/material_edit");
        return mv;
    }
    
    /**
     * ���칫˾ �Ŷ� ���˸���
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
            // �ϴ��ļ�
            if (!StringUtils.isEmpty(imageData))
            {

                Long fileId = Long.valueOf(fileInfoService.uploadImg(uploadPath, productUploadPath, original,
                        imageData.substring("data:image/png;base64,".length())));
                product.setImgId(fileId);
            }
            // ͬ�������ݿ�
            productService.update(product);
            result.put("result", Common.SUCCESS);
        }
        catch (Exception e)
        {
            logger.debug("���¹�Ӧ��ʧ�ܣ�ԭ��", e);
            result.put("result", Common.FAIL);
        }

        return result;
    }
    
    /**
     * �༭ɾ��ͼƬʱ���¹�Ӧ��logoΪ-1
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
            logger.debug("���¹�Ӧ��ʧ�ܣ�ԭ��", e);
        }

        return result;
    }
}
