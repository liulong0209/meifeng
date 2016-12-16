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
import net.beautifycrack.module.ConstructionCase;
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
 * 公司 团队 个人的资源控制器 (施工工人信息、施工案例、预约小区、公司资质、防伪查询)
 * 
 * ProvidersResourceController.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年12月15日 下午6:19:37
 * @author liulong
 */
@Controller
@RequestMapping("/providersResource")
public class ProvidersResourceController
{
    private static Logger logger = LoggerFactory.getLogger(ProvidersResourceController.class);

    /**
     * 提供商接口注入
     */
    @Resource
    ProvidersService providersService;

    /**
     * 提供商资源接口注入
     */
    @Resource
    ProvidersResourceService providersResourceService;

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

    /***************** 施工工人 *****************/
    /**
     * 跳转到提供商下的工人列表
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
     * 加载公司、团队下的施工人员列表数据，前台通多ajax调用
     * 
     * @throws BusinessException
     */
    @RequestMapping(value = "/worker/pageList.do", method = RequestMethod.POST)
    public @ResponseBody Object workerPageList(PagerUtil pager, Long providersId) throws BusinessException
    {
        logger.info("ProvidersResourceController->workerPageList->providersId{}", providersId);
        Map<String, Object> dataMaps = new HashMap<String, Object>();

        // 查询数据
        List<Worker> workerList = providersResourceService.workerPagerList(pager, providersId);

        dataMaps.put("dataList", workerList);
        // 查询数据总数
        Integer total = providersResourceService.queryWorkerTotal(providersId);
        pager.setTotalRecords(total);
        pager.setTotalPage(pager.getTotalPage());
        dataMaps.put("pager", pager);
        return dataMaps;
    }

    /**
     * 跳转到工人增加页面
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
     * 增加工人
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
            // 上传文件
            if (!StringUtils.isEmpty(imageData))
            {

                Long fileId = Long.valueOf(fileInfoService.uploadImg(uploadPath, providersUploadPath + "/worker",
                        original, imageData.substring("data:image/png;base64,".length())));
                worker.setAvatar(fileId);
            }
            // 添加到数据库
            providersResourceService.addWorker(worker);
            result.put("result", Common.SUCCESS);
        }
        catch (IOException e)
        {
            result.put("result", Common.FAIL);
            logger.error("新增工人失败：原因{}", e);
        }
        return result;
    }

    /**
     * 删除工人
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
            logger.debug("删除工人失败，原因：", e);
            result.put("result", Common.FAIL);
        }

        return result;
    }

    /**
     * 跳转到工人修改页面
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
     * 更新工人
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
            // 上传文件
            if (!StringUtils.isEmpty(imageData))
            {

                Long fileId = Long.valueOf(fileInfoService.uploadImg(uploadPath, providersUploadPath + "/worker",
                        original, imageData.substring("data:image/png;base64,".length())));
                worker.setAvatar(fileId);
            }
            // 同步到数据库
            providersResourceService.updateWorker(worker);
            result.put("result", Common.SUCCESS);
        }
        catch (Exception e)
        {
            logger.debug("更新工人失败，原因：", e);
            result.put("result", Common.FAIL);
        }

        return result;
    }

    /***************** 施工案例 *****************/
    /**
     * 跳转到提供商下的施工案例列表
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
        logger.debug("ProvidersResourceController->workerList->providersId=" + providersId);
        Providers providers = providersService.queryProvider(providersId);
        ModelAndView mv = new ModelAndView();
        mv.getModelMap().put("providers", providers);
        mv.setViewName("providersResource/workcase_list");
        return mv;
    }

    /**
     * 加载公司、团队、个人的施工案例列表数据，前台通多ajax调用
     * 
     * @throws BusinessException
     */
    @RequestMapping(value = "/workcase/pageList.do", method = RequestMethod.POST)
    public @ResponseBody Object workcasePageList(PagerUtil pager, Long providersId) throws BusinessException
    {
        logger.info("ProvidersResourceController->workerPageList->providersId{}", providersId);
        Map<String, Object> dataMaps = new HashMap<String, Object>();

        // 查询数据
        List<ConstructionCase> workcaseList = providersResourceService.workcasePagerList(pager, providersId);

        dataMaps.put("dataList", workcaseList);
        // 查询数据总数
        Integer total = providersResourceService.queryWorkcaseTotal(providersId);
        pager.setTotalRecords(total);
        pager.setTotalPage(pager.getTotalPage());
        dataMaps.put("pager", pager);
        return dataMaps;
    }

    /**
     * 跳转到施工案例增加页面
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
        logger.debug("ProvidersResourceController->workerList->providersId=" + providersId);
        Providers providers = providersService.queryProvider(providersId);
        ModelAndView mv = new ModelAndView();
        mv.getModelMap().put("providers", providers);
        mv.setViewName("providersResource/workcase_add");
        return mv;
    }

    /**
     * 新增施工案例
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
            // 上传文件
            if (!StringUtils.isEmpty(imageData))
            {

                Long fileId = Long.valueOf(fileInfoService.uploadImg(uploadPath, providersUploadPath + "/workcase",
                        original, imageData.substring("data:image/png;base64,".length())));
                workcase.setImageId(fileId);
            }
            // 添加到数据库
            providersResourceService.addWorkcase(workcase);
            result.put("result", Common.SUCCESS);
        }
        catch (IOException e)
        {
            result.put("result", Common.FAIL);
            logger.error("新增施工案例失败：原因{}", e);
        }
        return result;
    }

    /**
     * 删除施工案例
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
            logger.debug("删除施工案例失败，原因：", e);
            result.put("result", Common.FAIL);
        }

        return result;
    }

    /**
     * 跳转到施工案例修改页面
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
     * 更新施工案例
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
            // 上传文件
            if (!StringUtils.isEmpty(imageData))
            {

                Long fileId = Long.valueOf(fileInfoService.uploadImg(uploadPath, providersUploadPath + "/workcase",
                        original, imageData.substring("data:image/png;base64,".length())));
                workcase.setImageId(fileId);
            }
            // 同步到数据库
            providersResourceService.updateWorkcase(workcase);
            result.put("result", Common.SUCCESS);
        }
        catch (Exception e)
        {
            logger.debug("更新施工案例失败，原因：", e);
            result.put("result", Common.FAIL);
        }

        return result;
    }

}
