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
import net.beautifycrack.module.AntiFake;
import net.beautifycrack.module.BookingCommunity;
import net.beautifycrack.module.ConstructionCase;
import net.beautifycrack.module.Providers;
import net.beautifycrack.module.Qualification;
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

    /***************** ʩ������ *****************/
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
     * ���ع�˾���Ŷ��µ�ʩ����Ա�б����ݣ�ǰ̨ͨ��ajax����
     * 
     * @throws BusinessException
     */
    @RequestMapping(value = "/worker/pageList.do", method = RequestMethod.POST)
    public @ResponseBody Object workerPageList(PagerUtil pager, Long providersId) throws BusinessException
    {
        logger.info("ProvidersResourceController->workerPageList->providersId{}", providersId);
        Map<String, Object> dataMaps = new HashMap<String, Object>();

        // ��ѯ����
        List<Worker> workerList = providersResourceService.workerPagerList(pager, providersId);

        dataMaps.put("dataList", workerList);
        // ��ѯ��������
        Integer total = providersResourceService.queryWorkerTotal(providersId);
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
            providersResourceService.addWorker(worker);
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
            providersResourceService.deleteWorker(worker);
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
     * 
     * @param request
     * @param response
     * @param workerId
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/showWorkerEdit.do", method = RequestMethod.GET)
    public ModelAndView showWorkerEdit(HttpServletRequest request, HttpServletResponse response, Long workerId)
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
     * 
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

                Long fileId = Long.valueOf(fileInfoService.uploadImg(uploadPath, providersUploadPath + "/worker",
                        original, imageData.substring("data:image/png;base64,".length())));
                worker.setAvatar(fileId);
            }
            // ͬ�������ݿ�
            providersResourceService.updateWorker(worker);
            result.put("result", Common.SUCCESS);
        }
        catch (Exception e)
        {
            logger.debug("���¹���ʧ�ܣ�ԭ��", e);
            result.put("result", Common.FAIL);
        }

        return result;
    }

    /***************** ʩ������ *****************/
    /**
     * ��ת���ṩ���µ�ʩ�������б�
     * 
     * @param request
     * @param response
     * @param providersId
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/workcaseList.do")
    public ModelAndView workcaseList(HttpServletRequest request, HttpServletResponse response, Long providersId)
            throws BusinessException
    {
        logger.debug("ProvidersResourceController->workcaseList->providersId=" + providersId);
        Providers providers = providersService.queryProvider(providersId);
        ModelAndView mv = new ModelAndView();
        mv.getModelMap().put("providers", providers);
        mv.setViewName("providersResource/workcase_list");
        return mv;
    }

    /**
     * ���ع�˾���Ŷӡ����˵�ʩ�������б����ݣ�ǰ̨ͨ��ajax����
     * 
     * @throws BusinessException
     */
    @RequestMapping(value = "/workcase/pageList.do", method = RequestMethod.POST)
    public @ResponseBody Object workcasePageList(PagerUtil pager, Long providersId) throws BusinessException
    {
        logger.info("ProvidersResourceController->workcasePageList->providersId{}", providersId);
        Map<String, Object> dataMaps = new HashMap<String, Object>();

        // ��ѯ����
        List<ConstructionCase> workcaseList = providersResourceService.workcasePagerList(pager, providersId);

        dataMaps.put("dataList", workcaseList);
        // ��ѯ��������
        Integer total = providersResourceService.queryWorkcaseTotal(providersId);
        pager.setTotalRecords(total);
        pager.setTotalPage(pager.getTotalPage());
        dataMaps.put("pager", pager);
        return dataMaps;
    }

    /**
     * ��ת��ʩ����������ҳ��
     * 
     * @param request
     * @param response
     * @param providersId
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/showWorkcaseAdd.do")
    public ModelAndView showWorkcaseAdd(HttpServletRequest request, HttpServletResponse response, Long providersId)
            throws BusinessException
    {
        logger.debug("ProvidersResourceController->showWorkcaseAdd->providersId=" + providersId);
        Providers providers = providersService.queryProvider(providersId);
        ModelAndView mv = new ModelAndView();
        mv.getModelMap().put("providers", providers);
        mv.setViewName("providersResource/workcase_add");
        return mv;
    }

    /**
     * ����ʩ������
     * 
     * @param request
     * @param response
     * @param case
     * @param imageData
     * @param original
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/addWorkcase.do", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> addWorkcase(HttpServletRequest request, HttpServletResponse response,
            ConstructionCase workcase, String imageData, String original) throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();

        try
        {
            // �ϴ��ļ�
            if (!StringUtils.isEmpty(imageData))
            {

                Long fileId = Long.valueOf(fileInfoService.uploadImg(uploadPath, providersUploadPath + "/workcase",
                        original, imageData.substring("data:image/png;base64,".length())));
                workcase.setImageId(fileId);
            }
            // ��ӵ����ݿ�
            providersResourceService.addWorkcase(workcase);
            result.put("result", Common.SUCCESS);
        }
        catch (IOException e)
        {
            result.put("result", Common.FAIL);
            logger.error("����ʩ������ʧ�ܣ�ԭ��{}", e);
        }
        return result;
    }

    /**
     * ɾ��ʩ������
     * 
     * @param request
     * @param response
     * @param worker
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/deleteWorkcase.do", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> deleteWorkcase(HttpServletRequest request, HttpServletResponse response,
            ConstructionCase workcase) throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();

        try
        {
            providersResourceService.deleteWorkcase(workcase);
            result.put("result", Common.SUCCESS);
        }
        catch (Exception e)
        {
            logger.debug("ɾ��ʩ������ʧ�ܣ�ԭ��", e);
            result.put("result", Common.FAIL);
        }

        return result;
    }

    /**
     * ��ת��ʩ�������޸�ҳ��
     * 
     * @param request
     * @param response
     * @param workerId
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/showWorkcaseEdit.do", method = RequestMethod.GET)
    public ModelAndView showWorkcaseEdit(HttpServletRequest request, HttpServletResponse response, Long workcaseId)
            throws BusinessException
    {
        ModelAndView mv = new ModelAndView();
        ConstructionCase workcase = providersResourceService.findWorkcase(workcaseId);
        Providers providers = providersService.queryProvider(workcase.getProvidersId());
        mv.getModelMap().put("workcase", workcase);
        mv.getModelMap().put("providers", providers);
        mv.setViewName("providersResource/workcase_edit");
        return mv;
    }

    /**
     * ����ʩ������
     * 
     * @param request
     * @param response
     * @param worker
     * @param imageData
     * @param original
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/updateWorkcase.do", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> update(HttpServletRequest request, HttpServletResponse response,
            ConstructionCase workcase, String imageData, String original) throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();

        try
        {
            // �ϴ��ļ�
            if (!StringUtils.isEmpty(imageData))
            {

                Long fileId = Long.valueOf(fileInfoService.uploadImg(uploadPath, providersUploadPath + "/workcase",
                        original, imageData.substring("data:image/png;base64,".length())));
                workcase.setImageId(fileId);
            }
            // ͬ�������ݿ�
            providersResourceService.updateWorkcase(workcase);
            result.put("result", Common.SUCCESS);
        }
        catch (Exception e)
        {
            logger.debug("����ʩ������ʧ�ܣ�ԭ��", e);
            result.put("result", Common.FAIL);
        }

        return result;
    }

    /***************** ԤԼС�� *****************/
    /**
     * ��ת���ṩ���µ�ԤԼС���б�
     * 
     * @param request
     * @param response
     * @param providersId
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/bookingList.do")
    public ModelAndView bookingList(HttpServletRequest request, HttpServletResponse response, Long providersId)
            throws BusinessException
    {
        logger.debug("ProvidersResourceController->bookingList->providersId=" + providersId);
        Providers providers = providersService.queryProvider(providersId);
        ModelAndView mv = new ModelAndView();
        mv.getModelMap().put("providers", providers);
        mv.setViewName("providersResource/booking_list");
        return mv;
    }

    /**
     * ���ع�˾���Ŷӡ����˵�ԤԼС���б����ݣ�ǰ̨ͨ��ajax����
     * 
     * @throws BusinessException
     */
    @RequestMapping(value = "/booking/pageList.do", method = RequestMethod.POST)
    public @ResponseBody Object bookingPageList(PagerUtil pager, Long providersId) throws BusinessException
    {
        logger.info("ProvidersResourceController->bookingPageList->providersId{}", providersId);
        Map<String, Object> dataMaps = new HashMap<String, Object>();

        // ��ѯ����
        List<BookingCommunity> booking = providersResourceService.bookingPagerList(pager, providersId);

        dataMaps.put("dataList", booking);
        // ��ѯ��������
        Integer total = providersResourceService.queryBookingTotal(providersId);
        pager.setTotalRecords(total);
        pager.setTotalPage(pager.getTotalPage());
        dataMaps.put("pager", pager);
        return dataMaps;
    }

    /**
     * ��ת��ԤԼС������ҳ��
     * 
     * @param request
     * @param response
     * @param providersId
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/showBookingAdd.do")
    public ModelAndView showBookingAdd(HttpServletRequest request, HttpServletResponse response, Long providersId)
            throws BusinessException
    {
        logger.debug("ProvidersResourceController->showBookingAdd->providersId=" + providersId);
        Providers providers = providersService.queryProvider(providersId);
        ModelAndView mv = new ModelAndView();
        mv.getModelMap().put("providers", providers);
        mv.setViewName("providersResource/booking_add");
        return mv;
    }

    /**
     * ����ԤԼС��
     * 
     * @param request
     * @param response
     * @param case
     * @param imageData
     * @param original
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/addBooking.do", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> addBooking(HttpServletRequest request, HttpServletResponse response,
            BookingCommunity booking, String imageData, String original) throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();

        try
        {
            // �ϴ��ļ�
            if (!StringUtils.isEmpty(imageData))
            {

                Long fileId = Long.valueOf(fileInfoService.uploadImg(uploadPath, providersUploadPath + "/booking",
                        original, imageData.substring("data:image/png;base64,".length())));
                booking.setImageId(fileId);
            }
            // ��ӵ����ݿ�
            providersResourceService.addBooking(booking);
            result.put("result", Common.SUCCESS);
        }
        catch (IOException e)
        {
            result.put("result", Common.FAIL);
            logger.error("����ԤԼС��ʧ�ܣ�ԭ��{}", e);
        }
        return result;
    }

    /**
     * ɾ��ԤԼС��
     * 
     * @param request
     * @param response
     * @param booking
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/deleteBooking.do", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> deleteBooking(HttpServletRequest request, HttpServletResponse response,
            BookingCommunity booking) throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();

        try
        {
            providersResourceService.deleteBooking(booking);
            result.put("result", Common.SUCCESS);
        }
        catch (Exception e)
        {
            logger.debug("ɾ��ԤԼС��ʧ�ܣ�ԭ��", e);
            result.put("result", Common.FAIL);
        }

        return result;
    }

    /**
     * ��ת��ԤԼС���޸�ҳ��
     * 
     * @param request
     * @param response
     * @param bookingId
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/showBookingEdit.do", method = RequestMethod.GET)
    public ModelAndView showBookingEdit(HttpServletRequest request, HttpServletResponse response, Long bookingId)
            throws BusinessException
    {
        ModelAndView mv = new ModelAndView();
        BookingCommunity booking = providersResourceService.findBooking(bookingId);
        Providers providers = providersService.queryProvider(booking.getProvidersId());
        mv.getModelMap().put("booking", booking);
        mv.getModelMap().put("providers", providers);
        mv.setViewName("providersResource/booking_edit");
        return mv;
    }

    /**
     * ����ԤԼС��
     * 
     * @param request
     * @param response
     * @param booking
     * @param imageData
     * @param original
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/updateBooking.do", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> updateBooking(HttpServletRequest request, HttpServletResponse response,
            BookingCommunity booking, String imageData, String original) throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();

        try
        {
            // �ϴ��ļ�
            if (!StringUtils.isEmpty(imageData))
            {

                Long fileId = Long.valueOf(fileInfoService.uploadImg(uploadPath, providersUploadPath + "/booking",
                        original, imageData.substring("data:image/png;base64,".length())));
                booking.setImageId(fileId);
            }
            // ͬ�������ݿ�
            providersResourceService.updateBooking(booking);
            result.put("result", Common.SUCCESS);
        }
        catch (Exception e)
        {
            logger.debug("����ԤԼС��ʧ�ܣ�ԭ��", e);
            result.put("result", Common.FAIL);
        }

        return result;
    }

    /***************** ��˾���� *****************/
    /**
     * ��ת����˾�����б�
     * 
     * @param request
     * @param response
     * @param providersId
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/qualificationList.do")
    public ModelAndView qualificationList(HttpServletRequest request, HttpServletResponse response, Long providersId)
            throws BusinessException
    {
        logger.debug("ProvidersResourceController->qualificationList->providersId=" + providersId);
        Providers providers = providersService.queryProvider(providersId);
        ModelAndView mv = new ModelAndView();
        mv.getModelMap().put("providers", providers);
        mv.setViewName("providersResource/qualification_list");
        return mv;
    }

    /**
     * ���ع�˾�����б�����
     * 
     * @throws BusinessException
     */
    @RequestMapping(value = "/qualification/pageList.do", method = RequestMethod.POST)
    public @ResponseBody Object qualificationPageList(PagerUtil pager, Long providersId) throws BusinessException
    {
        logger.info("ProvidersResourceController->qualificationPageList->providersId{}", providersId);
        Map<String, Object> dataMaps = new HashMap<String, Object>();

        // ��ѯ����
        List<Qualification> qualificationList = providersResourceService.qualificationPagerList(pager, providersId);

        dataMaps.put("dataList", qualificationList);
        // ��ѯ��������
        Integer total = providersResourceService.queryQualificationTotal(providersId);
        pager.setTotalRecords(total);
        pager.setTotalPage(pager.getTotalPage());
        dataMaps.put("pager", pager);
        return dataMaps;
    }

    /**
     * ��ת����˾��������ҳ��
     * 
     * @param request
     * @param response
     * @param providersId
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/showQualificationAdd.do")
    public ModelAndView showQualificationAdd(HttpServletRequest request, HttpServletResponse response, Long providersId)
            throws BusinessException
    {
        logger.debug("ProvidersResourceController->showQualificationAdd->providersId=" + providersId);
        Providers providers = providersService.queryProvider(providersId);
        ModelAndView mv = new ModelAndView();
        mv.getModelMap().put("providers", providers);
        mv.setViewName("providersResource/qualification_add");
        return mv;
    }

    /**
     * ������˾����
     * 
     * @param request
     * @param response
     * @param qualification
     * @param imageData
     * @param original
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/addQualification.do", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> addQualification(HttpServletRequest request, HttpServletResponse response,
            Qualification qualification, String imageData, String original) throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();

        try
        {
            // �ϴ��ļ�
            if (!StringUtils.isEmpty(imageData))
            {

                Long fileId = Long.valueOf(fileInfoService.uploadImg(uploadPath,
                        providersUploadPath + "/qualification", original,
                        imageData.substring("data:image/png;base64,".length())));
                qualification.setImageId(fileId);
            }
            // ��ӵ����ݿ�
            providersResourceService.addQualification(qualification);
            result.put("result", Common.SUCCESS);
        }
        catch (IOException e)
        {
            result.put("result", Common.FAIL);
            logger.error("������˾����ʧ�ܣ�ԭ��{}", e);
        }
        return result;
    }

    /**
     * ɾ����˾����
     * 
     * @param request
     * @param response
     * @param qualification
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/deleteQualification.do", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> deleteQualification(HttpServletRequest request,
            HttpServletResponse response, Qualification qualification) throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();

        try
        {
            providersResourceService.deleteQualification(qualification);
            result.put("result", Common.SUCCESS);
        }
        catch (Exception e)
        {
            logger.debug("ɾ����˾����ʧ�ܣ�ԭ��", e);
            result.put("result", Common.FAIL);
        }

        return result;
    }

    /**
     * ��ת����˾�����޸�ҳ��
     * 
     * @param request
     * @param response
     * @param qualificationId
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/showQualificationEdit.do", method = RequestMethod.GET)
    public ModelAndView showQualificationEdit(HttpServletRequest request, HttpServletResponse response,
            Long qualificationId) throws BusinessException
    {
        ModelAndView mv = new ModelAndView();
        Qualification qualification = providersResourceService.findQualification(qualificationId);
        Providers providers = providersService.queryProvider(qualification.getProvidersId());
        mv.getModelMap().put("qualification", qualification);
        mv.getModelMap().put("providers", providers);
        mv.setViewName("providersResource/qualification_edit");
        return mv;
    }

    /**
     * ���¹�˾����
     * 
     * @param request
     * @param response
     * @param qualification
     * @param imageData
     * @param original
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/updateQualification.do", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> updateQualification(HttpServletRequest request,
            HttpServletResponse response, Qualification qualification, String imageData, String original)
            throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();

        try
        {
            // �ϴ��ļ�
            if (!StringUtils.isEmpty(imageData))
            {

                Long fileId = Long.valueOf(fileInfoService.uploadImg(uploadPath,
                        providersUploadPath + "/qualification", original,
                        imageData.substring("data:image/png;base64,".length())));
                qualification.setImageId(fileId);
            }
            // ͬ�������ݿ�
            providersResourceService.updateQualification(qualification);
            result.put("result", Common.SUCCESS);
        }
        catch (Exception e)
        {
            logger.debug("���¹�˾����ʧ�ܣ�ԭ��", e);
            result.put("result", Common.FAIL);
        }

        return result;
    }

    /***************** ��α��ѯ *****************/
    /**
     * ��ת����α��ѯ�б�
     * 
     * @param request
     * @param response
     * @param providersId
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/antifakeList.do")
    public ModelAndView antiFakeList(HttpServletRequest request, HttpServletResponse response, Long providersId)
            throws BusinessException
    {
        logger.debug("ProvidersResourceController->antiFakeList->providersId=" + providersId);
        Providers providers = providersService.queryProvider(providersId);
        ModelAndView mv = new ModelAndView();
        mv.getModelMap().put("providers", providers);
        mv.setViewName("providersResource/antifake_list");
        return mv;
    }

    /**
     * ���ط�α��ѯ�б�����
     * 
     * @throws BusinessException
     */
    @RequestMapping(value = "/antiFake/pageList.do", method = RequestMethod.POST)
    public @ResponseBody Object antiFakePageList(PagerUtil pager, Long providersId) throws BusinessException
    {
        logger.info("ProvidersResourceController->antiFakePageList->providersId{}", providersId);
        Map<String, Object> dataMaps = new HashMap<String, Object>();

        // ��ѯ����
        List<AntiFake> antiFakeList = providersResourceService.antiFakePagerList(pager, providersId);

        dataMaps.put("dataList", antiFakeList);
        // ��ѯ��������
        Integer total = providersResourceService.queryAntiFakeTotal(providersId);
        pager.setTotalRecords(total);
        pager.setTotalPage(pager.getTotalPage());
        dataMaps.put("pager", pager);
        return dataMaps;
    }

    /**
     * ��ת����α��ѯ����ҳ��
     * 
     * @param request
     * @param response
     * @param providersId
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/showAntiFakeAdd.do")
    public ModelAndView showAntiFakeAdd(HttpServletRequest request, HttpServletResponse response, Long providersId)
            throws BusinessException
    {
        logger.debug("ProvidersResourceController->showAntiFakeAdd->providersId=" + providersId);
        Providers providers = providersService.queryProvider(providersId);
        ModelAndView mv = new ModelAndView();
        mv.getModelMap().put("providers", providers);
        mv.setViewName("providersResource/antifake_add");
        return mv;
    }

    /**
     * ������α��ѯ
     * 
     * @param request
     * @param response
     * @param antiFake
     * @param imageData
     * @param original
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/addAntiFake.do", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> addAntiFake(HttpServletRequest request, HttpServletResponse response,
            AntiFake antiFake, String imageData, String original) throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();

        try
        {
            // �ϴ��ļ�
            if (!StringUtils.isEmpty(imageData))
            {

                Long fileId = Long.valueOf(fileInfoService.uploadImg(uploadPath, providersUploadPath + "/antiFake",
                        original, imageData.substring("data:image/png;base64,".length())));
                antiFake.setImageId(fileId);
            }
            // ��ӵ����ݿ�
            providersResourceService.addAntiFake(antiFake);
            result.put("result", Common.SUCCESS);
        }
        catch (IOException e)
        {
            result.put("result", Common.FAIL);
            logger.error("������α��ѯʧ�ܣ�ԭ��{}", e);
        }
        return result;
    }

    /**
     * ɾ����α��ѯ
     * 
     * @param request
     * @param response
     * @param antiFake
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/deleteAntiFake.do", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> deleteAntiFake(HttpServletRequest request, HttpServletResponse response,
            AntiFake antiFake) throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();

        try
        {
            providersResourceService.deleteAntiFake(antiFake);
            result.put("result", Common.SUCCESS);
        }
        catch (Exception e)
        {
            logger.debug("ɾ����α��ѯʧ�ܣ�ԭ��", e);
            result.put("result", Common.FAIL);
        }

        return result;
    }

    /**
     * ��ת����α��ѯ�޸�ҳ��
     * 
     * @param request
     * @param response
     * @param antiFakeId
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/showAntiFakeEdit.do", method = RequestMethod.GET)
    public ModelAndView showAntiFakeEdit(HttpServletRequest request, HttpServletResponse response, Long antiFakeId)
            throws BusinessException
    {
        ModelAndView mv = new ModelAndView();
        AntiFake antiFake = providersResourceService.findAntiFake(antiFakeId);
        Providers providers = providersService.queryProvider(antiFake.getProvidersId());
        mv.getModelMap().put("antiFake", antiFake);
        mv.getModelMap().put("providers", providers);
        mv.setViewName("providersResource/antifake_edit");
        return mv;
    }

    /**
     * ���·�α��ѯ
     * 
     * @param request
     * @param response
     * @param antiFake
     * @param imageData
     * @param original
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/updateAntiFake.do", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> updateAntiFake(HttpServletRequest request, HttpServletResponse response,
            AntiFake antiFake, String imageData, String original) throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();

        try
        {
            // �ϴ��ļ�
            if (!StringUtils.isEmpty(imageData))
            {

                Long fileId = Long.valueOf(fileInfoService.uploadImg(uploadPath, providersUploadPath + "/antiFake",
                        original, imageData.substring("data:image/png;base64,".length())));
                antiFake.setImageId(fileId);
            }
            // ͬ�������ݿ�
            providersResourceService.updateAntiFake(antiFake);
            result.put("result", Common.SUCCESS);
        }
        catch (Exception e)
        {
            logger.debug("���·�α��ѯʧ�ܣ�ԭ��", e);
            result.put("result", Common.FAIL);
        }

        return result;
    }

}
