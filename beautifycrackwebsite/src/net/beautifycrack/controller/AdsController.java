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
import net.beautifycrack.module.Advertisement;
import net.beautifycrack.service.AdvertisementService;
import net.beautifycrack.service.FileInfoService;
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
 * �ֲ���������
 * 
 * AdsController.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��11��15�� ����4:57:12
 * @author liulong
 */
@Controller
public class AdsController
{
    /**
     * ��־��¼��
     */
    private static final Logger LOG = LoggerFactory.getLogger(UEditorController.class);

    /**
     * ע�������ӿ�
     */
    @Resource
    private AdvertisementService adsService;

    /**
     * �ϴ��ļ���·��
     */
    @Value("#{properties['root.upload.path']}")
    private String uploadPath;

    /**
     * �ֲ�����ϴ���·��
     */
    @Value("#{properties['ads.upload.path']}")
    private String adsUploadPath;

    /**
     * �ļ��ӿ�
     */
    @Resource
    private FileInfoService fileInfoService;

    /**
     * ��ת���ֲ�����б�ҳ��
     * 
     * @return
     */
    @RequestMapping(value = "/adsmanager.do")
    public ModelAndView newsIndex()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/ads/adsList");
        return mv;
    }

    /**
     * �������ݣ�ҳ��ͨ��ajax����
     * 
     * @throws BusinessException
     */
    @RequestMapping(value = "/ads/pageList.do", method = RequestMethod.POST)
    public @ResponseBody Object pageList(PagerUtil pu) throws BusinessException
    {
        Map<String, Object> dataMaps = new HashMap<String, Object>();
        // ��ѯ����
        List<Advertisement> newList = adsService.pagerList(pu);

        dataMaps.put("dataList", newList);
        // ��ѯ��������
        Integer total = adsService.queryTotal();
        pu.setTotalRecords(total);
        pu.setTotalPage(pu.getTotalPage());
        dataMaps.put("pager", pu);
        return dataMaps;
    }

    /**
     * ��ת���ֲ��������
     * 
     * @param request
     * @param response
     * @param id
     * @return
     */
    @RequestMapping(value = "/ads/showAdd.do", method = RequestMethod.GET)
    public ModelAndView showAdd(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("ads/ads_add");
        return mv;
    }

    /**
     * �ֲ��������
     * 
     * @param request
     * @param response
     * @param ads
     *            �ֲ�������
     * @param imageData
     *            ͼƬ�ļ�base64�����ַ���
     * @param ext
     *            ͼƬ��׺��
     * @param original
     *            �ļ�ԭʼ��
     * @return
     */
    @RequestMapping(value = "/ads/add.do", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> add(HttpServletRequest request, HttpServletResponse response,
            Advertisement ads, String imageData, String original) throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();

        try
        {
            // �ϴ��ļ�
            if (!StringUtils.isEmpty(imageData))
            {

                Long fileId = Long.valueOf(fileInfoService.uploadImg(uploadPath, adsUploadPath, original,
                        imageData.substring("data:image/png;base64,".length())));
                ads.setImgId(fileId);
            }
            // ��ӵ����ݿ�
            adsService.add(ads);
            result.put("result", Common.SUCCESS);
        }
        catch (IOException e)
        {
            result.put("result", Common.FAIL);
            LOG.error("�����ֲ����ʧ�ܣ�ԭ��{}", e);
        }
        return result;
    }

    /**
     * ��ת���ֲ�������
     * 
     * @param request
     * @param response
     * @param id
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/ads/showEdit.do", method = RequestMethod.GET)
    public ModelAndView showEdit(HttpServletRequest request, HttpServletResponse response, Long adsId)
            throws BusinessException
    {
        ModelAndView mv = new ModelAndView();
        Advertisement ads = adsService.queryById(adsId);
        mv.getModelMap().put("ads", ads);
        mv.setViewName("ads/ads_edit");
        return mv;
    }

    /**
     * �����ֲ����
     * 
     * @param request
     * @param response
     * @param ads
     * @param file
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/ads/update.do", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> update(HttpServletRequest request, HttpServletResponse response,
            Advertisement ads, String imageData, String original) throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();

        try
        {
            // �ϴ��ļ�
            if (!StringUtils.isEmpty(imageData))
            {

                Long fileId = Long.valueOf(fileInfoService.uploadImg(uploadPath, adsUploadPath, original,
                        imageData.substring("data:image/png;base64,".length())));
                ads.setImgId(fileId);
            }
            // ��ӵ����ݿ�
            adsService.update(ads);
            result.put("result", Common.SUCCESS);
        }
        catch (Exception e)
        {
            LOG.debug("���¹���ʧ�ܣ�ԭ��", e);
            result.put("result", Common.FAIL);
        }

        return result;
    }

    /**
     * �����ֲ����ͼƬ
     * 
     * @param ads
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/ads/ajaxUpdate.do", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> ajaxUpdate(Advertisement ads) throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();
        try
        {
            adsService.update(ads);
            result.put("result", Common.SUCCESS);
        }
        catch (Exception e)
        {
            result.put("result", Common.FAIL);
            LOG.debug("���¹���ʧ�ܣ�ԭ��", e);
        }

        return result;
    }

    /**
     * ɾ���ֲ����
     * 
     * @param request
     * @param response
     * @param adsId
     * @param imgId
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/ads/delete.do", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response,
            Advertisement ads) throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();
        try
        {
            adsService.delete(ads);
            result.put("result", Common.SUCCESS);
        }
        catch (IOException e)
        {
            result.put("result", Common.FAIL);
            LOG.debug("ɾ������ʧ�ܣ�ԭ��", e);
        }
        return result;
    }
}
