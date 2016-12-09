package net.beautifycrack.controller;

import java.io.IOException;
import java.util.ArrayList;
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
 * 提供商的控制器，包括 公司 团队 个人
 * 
 * CompanyController.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月12日 下午4:44:59
 * @author liulong
 */
@Controller
public class ProvidersController
{
    private static Logger logger = LoggerFactory.getLogger(ProvidersController.class);

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
     * 跳转到美缝公司管理列表页面
     */
    @RequestMapping(value = "/companymanager.do")
    public ModelAndView company(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("company/company_list");
        return mv;
    }

    /**
     * 加载公司、团队、个人列表数据，前台通多ajax调用
     */
    @RequestMapping(value = "/providers/pageList.do", method = RequestMethod.POST)
    public @ResponseBody Object pageList(PagerUtil pu, String type)
    {
        logger.info("ProvidersController->pageList:type{}", type);
        Map<String, Object> dataMaps = new HashMap<String, Object>();
        // 类型以list传入
        List<Integer> list = new ArrayList<Integer>();
        String[] array = type.split(",");
        for (String s : array)
        {
            list.add(Integer.valueOf(s));
        }

        // 查询数据
        List<Providers> providersList = providersService.pagerList(pu, list);

        dataMaps.put("dataList", providersList);
        // 查询数据总数
        Integer total = providersService.queryTotal(list);
        pu.setTotalRecords(total);
        pu.setTotalPage(pu.getTotalPage());
        dataMaps.put("pager", pu);
        return dataMaps;
    }

    /**
     * 跳转到新增美缝公司页面
     */
    @RequestMapping(value = "/company/showAdd.do")
    public ModelAndView showAddCompany(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("company/company_add");
        return mv;
    }

    /**
     * 美缝公司 团队 个人增加
     * 
     * @param request
     * @param response
     * @param providers
     * @param imageData
     * @param original
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/providers/add.do", method = RequestMethod.POST)
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
     * 跳转美缝公司更新页面
     * 
     * @param request
     * @param response
     * @param companyId
     * @return
     */
    @RequestMapping(value = "/company/showEdit.do", method = RequestMethod.GET)
    public ModelAndView showEdit(HttpServletRequest request, HttpServletResponse response, Long companyId)
    {
        ModelAndView mv = new ModelAndView();
        Providers providers = providersService.queryProvider(companyId);
        mv.getModelMap().put("company", providers);
        mv.setViewName("company/company_edit");
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
    @RequestMapping(value = "/providers/update.do", method = RequestMethod.POST)
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
     * 美缝公司 团队 个人删除
     * 
     * @param request
     * @param response
     * @param providers
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/providers/delete.do", method = RequestMethod.POST)
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
}
