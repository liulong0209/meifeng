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
 * 轮播广告控制器
 * 
 * AdsController.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年11月15日 下午4:57:12
 * @author liulong
 */
@Controller
public class AdsController
{
    /**
     * 日志记录器
     */
    private static final Logger LOG = LoggerFactory.getLogger(UEditorController.class);

    /**
     * 注入广告管理接口
     */
    @Resource
    private AdvertisementService adsService;

    /**
     * 上传文件根路径
     */
    @Value("#{properties['root.upload.path']}")
    private String uploadPath;

    /**
     * 轮播广告上传的路径
     */
    @Value("#{properties['ads.upload.path']}")
    private String adsUploadPath;

    /**
     * 文件接口
     */
    @Resource
    private FileInfoService fileInfoService;

    /**
     * 跳转到轮播广告列表页面
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
     * 加载数据，页面通多ajax调用
     * 
     * @throws BusinessException
     */
    @RequestMapping(value = "/ads/pageList.do", method = RequestMethod.POST)
    public @ResponseBody Object pageList(PagerUtil pu) throws BusinessException
    {
        Map<String, Object> dataMaps = new HashMap<String, Object>();
        // 查询数据
        List<Advertisement> newList = adsService.pagerList(pu);

        dataMaps.put("dataList", newList);
        // 查询数据总数
        Integer total = adsService.queryTotal();
        pu.setTotalRecords(total);
        pu.setTotalPage(pu.getTotalPage());
        dataMaps.put("pager", pu);
        return dataMaps;
    }

    /**
     * 跳转到轮播广告新增
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
     * 轮播广告新增
     * 
     * @param request
     * @param response
     * @param ads
     *            轮播广告对象
     * @param imageData
     *            图片文件base64编码字符串
     * @param ext
     *            图片后缀名
     * @param original
     *            文件原始名
     * @return
     */
    @RequestMapping(value = "/ads/add.do", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> add(HttpServletRequest request, HttpServletResponse response,
            Advertisement ads, String imageData, String original) throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();

        try
        {
            // 上传文件
            if (!StringUtils.isEmpty(imageData))
            {

                Long fileId = Long.valueOf(fileInfoService.uploadImg(uploadPath, adsUploadPath, original,
                        imageData.substring("data:image/png;base64,".length())));
                ads.setImgId(fileId);
            }
            // 添加到数据库
            adsService.add(ads);
            result.put("result", Common.SUCCESS);
        }
        catch (IOException e)
        {
            result.put("result", Common.FAIL);
            LOG.error("新增轮播广告失败：原因{}", e);
        }
        return result;
    }

    /**
     * 跳转到轮播广告更新
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
     * 更新轮播广告
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
            // 上传文件
            if (!StringUtils.isEmpty(imageData))
            {

                Long fileId = Long.valueOf(fileInfoService.uploadImg(uploadPath, adsUploadPath, original,
                        imageData.substring("data:image/png;base64,".length())));
                ads.setImgId(fileId);
            }
            // 添加到数据库
            adsService.update(ads);
            result.put("result", Common.SUCCESS);
        }
        catch (Exception e)
        {
            LOG.debug("更新公告失败，原因：", e);
            result.put("result", Common.FAIL);
        }

        return result;
    }

    /**
     * 更新轮播广告图片
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
            LOG.debug("更新公告失败，原因：", e);
        }

        return result;
    }

    /**
     * 删除轮播广告
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
            LOG.debug("删除公告失败，原因：", e);
        }
        return result;
    }
}
