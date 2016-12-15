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
 * ��Ʒ�ṩ�̿�����
 * 
 * ProductCompanyController.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��12�� ����4:44:59
 * @author liulong
 */
@Controller
public class ProductCompanyController
{
    private static Logger logger = LoggerFactory.getLogger(ProductCompanyController.class);

    /**
     * �ṩ�̽ӿ�ע��
     */
    @Resource
    ProvidersService providersService;

    /**
     * �ϴ��ļ���·��
     */
    @Value("#{properties['root.upload.path']}")
    private String uploadPath;

    /**
     * ��Ӧ���ļ�Ŀ¼
     */
    @Value("#{properties['providers.upload.path']}")
    private String providersUploadPath;

    /**
     * �ļ��ӿ�
     */
    @Resource
    private FileInfoService fileInfoService;

    /**
     * ��ת�����߲����ṩ��˾���б�ҳ��
     */
    @RequestMapping(value = "/productCompanymanager.do")
    public ModelAndView company(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("productCompany/productCompany_list");
        return mv;
    }

    /**
     * ��ҳ��ʾ����
     * 
     * @throws BusinessException
     */
    @RequestMapping(value = "/productCompany/pageList.do", method = RequestMethod.POST)
    public @ResponseBody Object pageList(PagerUtil pu) throws BusinessException
    {
        Map<String, Object> dataMaps = new HashMap<String, Object>();

        // ��ѯ����
        List<Providers> providersList = providersService.productCompanyPagerList(pu);

        dataMaps.put("dataList", providersList);
        // ��ѯ��������
        Integer total = providersService.queryProductCompanyTotal();
        pu.setTotalRecords(total);
        pu.setTotalPage(pu.getTotalPage());
        dataMaps.put("pager", pu);
        return dataMaps;
    }

    /**
     * ��ת���������߲����ṩ��˾ҳ��
     */
    @RequestMapping(value = "/productCompany/showAdd.do")
    public ModelAndView showAddCompany(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("productCompany/productCompany_add");
        return mv;
    }

    /**
     * ���߲����ṩ��˾����
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
            // �ϴ��ļ�
            if (!StringUtils.isEmpty(imageData))
            {

                Long fileId = Long.valueOf(fileInfoService.uploadImg(uploadPath, providersUploadPath, original,
                        imageData.substring("data:image/png;base64,".length())));
                providers.setLogo(fileId);
            }
            // ��ӵ����ݿ�
            providersService.addProviders(providers);
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
     * ��ת���߲����ṩ��˾����ҳ��
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
     * ���߲����ṩ��˾����
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
            // �ϴ��ļ�
            if (!StringUtils.isEmpty(imageData))
            {

                Long fileId = Long.valueOf(fileInfoService.uploadImg(uploadPath, providersUploadPath, original,
                        imageData.substring("data:image/png;base64,".length())));
                providers.setLogo(fileId);
            }
            // ͬ�������ݿ�
            providersService.updateProviders(providers);
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
     * ���߲����ṩ��˾ɾ��
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
            logger.debug("ɾ����Ӧ��ʧ�ܣ�ԭ��", e);
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
            logger.debug("���¹�Ӧ��ʧ�ܣ�ԭ��", e);
        }

        return result;
    }
}
