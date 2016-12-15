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
import net.beautifycrack.module.Worker;
import net.beautifycrack.service.FileInfoService;
import net.beautifycrack.service.ProvidersResourceService;
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
 * ��˾ �Ŷ� ���˵���Դ������ (ʩ��������Ϣ��ʩ��������ԤԼС������˾���ʡ���α��ѯ)
 * 
 * ProvidersResourceController.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��12��15�� ����6:19:37
 * @author liulong
 */
@Controller
@RequestMapping("/providersResource")
public class ProvidersResourceController
{
    private static Logger logger = LoggerFactory.getLogger(ProvidersResourceController.class);

    /**
     * �ṩ�̽ӿ�ע��
     */
    @Resource
    ProvidersService providersService;

    /**
     * �ṩ����Դ�ӿ�ע��
     */
    @Resource
    ProvidersResourceService providersResourceService;

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
     * ��ת���ṩ���µĹ����б�
     * 
     * @param request
     * @param response
     * @param providersId
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/workerList.do")
    public ModelAndView workerList(HttpServletRequest request, HttpServletResponse response, Long providersId)
            throws BusinessException
    {
        logger.debug("ProvidersResourceController->workerList->providersId=" + providersId);
        Providers providers = providersService.queryProvider(providersId);
        ModelAndView mv = new ModelAndView();
        mv.getModelMap().put("providers", providers);
        mv.setViewName("providersResource/worker_list");
        return mv;
    }

    /**
     * ���ع�˾���Ŷӡ������б����ݣ�ǰ̨ͨ��ajax����
     * 
     * @throws BusinessException
     */
    @RequestMapping(value = "/worker/pageList.do", method = RequestMethod.POST)
    public @ResponseBody Object workerPageList(PagerUtil pager, Long providersId) throws BusinessException
    {
        logger.info("ProvidersResourceController->workerPageList->providersId{}", providersId);
        Map<String, Object> dataMaps = new HashMap<String, Object>();

        // ��ѯ����
        List<Worker> workerList = providersResourceService.wokerPagerList(pager, providersId);

        dataMaps.put("dataList", workerList);
        // ��ѯ��������
        Integer total = providersResourceService.queryWokerTotal(providersId);
        pager.setTotalRecords(total);
        pager.setTotalPage(pager.getTotalPage());
        dataMaps.put("pager", pager);
        return dataMaps;
    }

    /**
     * ��ת����������ҳ��
     * 
     * @param request
     * @param response
     * @param providersId
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/showWorkerAdd.do")
    public ModelAndView showWorkerAdd(HttpServletRequest request, HttpServletResponse response, Long providersId)
            throws BusinessException
    {
        logger.debug("ProvidersResourceController->workerList->providersId=" + providersId);
        Providers providers = providersService.queryProvider(providersId);
        ModelAndView mv = new ModelAndView();
        mv.getModelMap().put("providers", providers);
        mv.setViewName("providersResource/worker_add");
        return mv;
    }

    /**
     * ���ӹ���
     * 
     * @param request
     * @param response
     * @param worker
     * @param imageData
     * @param original
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/addWorker.do", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> addWorker(HttpServletRequest request, HttpServletResponse response,
            Worker worker, String imageData, String original) throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();

        try
        {
            // �ϴ��ļ�
            if (!StringUtils.isEmpty(imageData))
            {

                Long fileId = Long.valueOf(fileInfoService.uploadImg(uploadPath, providersUploadPath + "/worker",
                        original, imageData.substring("data:image/png;base64,".length())));
                worker.setAvatar(fileId);
            }
            // ��ӵ����ݿ�
            providersResourceService.addWork(worker);
            result.put("result", Common.SUCCESS);
        }
        catch (IOException e)
        {
            result.put("result", Common.FAIL);
            logger.error("��������ʧ�ܣ�ԭ��{}", e);
        }
        return result;
    }

    /**
     * ɾ������
     * 
     * @param request
     * @param response
     * @param worker
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/deleteWorker.do", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> deleteWorker(HttpServletRequest request, HttpServletResponse response,
            Worker worker) throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();

        try
        {
            providersResourceService.deleteWork(worker);
            result.put("result", Common.SUCCESS);
        }
        catch (Exception e)
        {
            logger.debug("ɾ������ʧ�ܣ�ԭ��", e);
            result.put("result", Common.FAIL);
        }

        return result;
    }

    /**
     * ��ת�������޸�ҳ��
     * @param request
     * @param response
     * @param workerId
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/showWorkerEdit.do", method = RequestMethod.GET)
    public ModelAndView showEdit(HttpServletRequest request, HttpServletResponse response, Long workerId)
            throws BusinessException
    {
        ModelAndView mv = new ModelAndView();
        Worker worker = providersResourceService.findWorker(workerId);
        Providers providers = providersService.queryProvider(worker.getProvidersId());
        mv.getModelMap().put("worker", worker);
        mv.getModelMap().put("providers", providers);
        mv.setViewName("providersResource/worker_edit");
        return mv;
    }
    
    /**
     * ���¹���
     * @param request
     * @param response
     * @param worker
     * @param imageData
     * @param original
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/updateWorker.do", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> update(HttpServletRequest request, HttpServletResponse response,
            Worker worker, String imageData, String original) throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();

        try
        {
            // �ϴ��ļ�
            if (!StringUtils.isEmpty(imageData))
            {

                Long fileId = Long.valueOf(fileInfoService.uploadImg(uploadPath, providersUploadPath+ "/worker", original,
                        imageData.substring("data:image/png;base64,".length())));
                worker.setAvatar(fileId);
            }
            // ͬ�������ݿ�
            providersResourceService.updateWork(worker);
            result.put("result", Common.SUCCESS);
        }
        catch (Exception e)
        {
            logger.debug("���¹���ʧ�ܣ�ԭ��", e);
            result.put("result", Common.FAIL);
        }

        return result;
    }
}
