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
 * �ṩ�̵Ŀ����������� ��˾ �Ŷ� ����
 * 
 * CompanyController.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��12�� ����4:44:59
 * @author liulong
 */
@Controller
public class ProvidersController
{
    private static Logger logger = LoggerFactory.getLogger(ProvidersController.class);

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
     * ��ת�����칫˾�����б�ҳ��
     */
    @RequestMapping(value = "/companymanager.do")
    public ModelAndView company(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("company/company_list");
        return mv;
    }

    /**
     * ���ع�˾���Ŷӡ������б����ݣ�ǰ̨ͨ��ajax����
     */
    @RequestMapping(value = "/providers/pageList.do", method = RequestMethod.POST)
    public @ResponseBody Object pageList(PagerUtil pu, String type)
    {
        logger.info("ProvidersController->pageList:type{}", type);
        Map<String, Object> dataMaps = new HashMap<String, Object>();
        // ������list����
        List<Integer> list = new ArrayList<Integer>();
        String[] array = type.split(",");
        for (String s : array)
        {
            list.add(Integer.valueOf(s));
        }

        // ��ѯ����
        List<Providers> providersList = providersService.pagerList(pu, list);

        dataMaps.put("dataList", providersList);
        // ��ѯ��������
        Integer total = providersService.queryTotal(list);
        pu.setTotalRecords(total);
        pu.setTotalPage(pu.getTotalPage());
        dataMaps.put("pager", pu);
        return dataMaps;
    }

    /**
     * ��ת���������칫˾ҳ��
     */
    @RequestMapping(value = "/company/showAdd.do")
    public ModelAndView showAddCompany(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("company/company_add");
        return mv;
    }

    /**
     * ���칫˾ �Ŷ� ��������
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
     * ��ת���칫˾����ҳ��
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
     * ���칫˾ �Ŷ� ���˸���
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
     * ���칫˾ �Ŷ� ����ɾ��
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
            logger.debug("ɾ����Ӧ��ʧ�ܣ�ԭ��", e);
            result.put("result", Common.FAIL);
        }

        return result;
    }
}
