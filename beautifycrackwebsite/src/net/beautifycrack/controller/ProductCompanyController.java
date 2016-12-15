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
import net.beautifycrack.module.Providers;
import net.beautifycrack.service.FileInfoService;
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
 * 商品提供商控制器
 * 
 * ProductCompanyController.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月12日 下午4:44:59
 * @author liulong
 */
@Controller
public class ProductCompanyController
{
    private static Logger logger = LoggerFactory.getLogger(ProductCompanyController.class);

    /**
     * 提供商接口注入
     */
    @Resource
    ProvidersService providersService;

    /**
     * 上传文件根路径
     */
    @Value("#{properties['root.upload.path']}")
    private String uploadPath;

    /**
     * 供应商文件目录
     */
    @Value("#{properties['providers.upload.path']}")
    private String providersUploadPath;

    /**
     * 文件接口
     */
    @Resource
    private FileInfoService fileInfoService;

    /**
     * 跳转到工具材料提供公司的列表页面
     */
    @RequestMapping(value = "/productCompanymanager.do")
    public ModelAndView company(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("productCompany/productCompany_list");
        return mv;
    }

    /**
     * 分页显示数据
     * 
     * @throws BusinessException
     */
    @RequestMapping(value = "/productCompany/pageList.do", method = RequestMethod.POST)
    public @ResponseBody Object pageList(PagerUtil pu) throws BusinessException
    {
        Map<String, Object> dataMaps = new HashMap<String, Object>();

        // 查询数据
        List<Providers> providersList = providersService.productCompanyPagerList(pu);

        dataMaps.put("dataList", providersList);
        // 查询数据总数
        Integer total = providersService.queryProductCompanyTotal();
        pu.setTotalRecords(total);
        pu.setTotalPage(pu.getTotalPage());
        dataMaps.put("pager", pu);
        return dataMaps;
    }

    /**
     * 跳转到新增工具材料提供公司页面
     */
    @RequestMapping(value = "/productCompany/showAdd.do")
    public ModelAndView showAddCompany(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("productCompany/productCompany_add");
        return mv;
    }

    /**
     * 工具材料提供公司增加
     * 
     * @param request
     * @param response
     * @param providers
     * @param imageData
     * @param original
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/productCompany/add.do", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> add(HttpServletRequest request, HttpServletResponse response,
            Providers providers, String imageData, String original) throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();

        try
        {
            // 上传文件
            if (!StringUtils.isEmpty(imageData))
            {

                Long fileId = Long.valueOf(fileInfoService.uploadImg(uploadPath, providersUploadPath, original,
                        imageData.substring("data:image/png;base64,".length())));
                providers.setLogo(fileId);
            }
            // 添加到数据库
            providersService.addProviders(providers);
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
     * 跳转工具材料提供公司更新页面
     * 
     * @param request
     * @param response
     * @param companyId
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/productCompany/showEdit.do", method = RequestMethod.GET)
    public ModelAndView showEdit(HttpServletRequest request, HttpServletResponse response, Long companyId)
            throws BusinessException
    {
        ModelAndView mv = new ModelAndView();
        Providers providers = providersService.queryProvider(companyId);
        mv.getModelMap().put("company", providers);
        mv.setViewName("productCompany/productCompany_edit");
        return mv;
    }

    /**
     * 工具材料提供公司更新
     * 
     * @param request
     * @param response
     * @param ads
     * @param file
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/productCompany/update.do", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> update(HttpServletRequest request, HttpServletResponse response,
            Providers providers, String imageData, String original) throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();

        try
        {
            // 上传文件
            if (!StringUtils.isEmpty(imageData))
            {

                Long fileId = Long.valueOf(fileInfoService.uploadImg(uploadPath, providersUploadPath, original,
                        imageData.substring("data:image/png;base64,".length())));
                providers.setLogo(fileId);
            }
            // 同步到数据库
            providersService.updateProviders(providers);
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
     * 工具材料提供公司删除
     * 
     * @param request
     * @param response
     * @param providers
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/productCompany/delete.do", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response,
            Providers providers) throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();

        try
        {
            providersService.deleteProviders(providers);
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
     * 编辑删除图片时更新供应商logo为-1
     * 
     * @param ads
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/productCompany/ajaxUpdate.do", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> ajaxUpdate(Providers providers) throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();
        try
        {
            providersService.updateProviders(providers);
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
