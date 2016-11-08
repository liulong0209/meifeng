package net.beautifycrack.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.beautifycrack.module.Providers;
import net.beautifycrack.service.ProvidersService;
import net.beautifycrack.util.PagerUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
@Scope("prototype")
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
     * 跳转到公司列表页面
     */
    @RequestMapping(value = "/company")
    public ModelAndView company(HttpServletRequest request, HttpServletResponse response)
    {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("company/companyList");
        return mv;
    }

    /**
     * 跳转到施工工人列表页面
     */
    @RequestMapping(value = "/worker")
    public ModelAndView worker(HttpServletRequest request, HttpServletResponse response)
    {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("worker/workerList");
        return mv;
    }

    /**
     * 跳转到公司详情页面
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "/company/showDetail/{id}")
    public ModelAndView showCompany(HttpServletRequest request, HttpServletResponse response, @PathVariable Long id)
    {
        ModelAndView mv = new ModelAndView();
        Providers company = providersService.showProviders(id);
        mv.getModel().put("company", company);
        mv.setViewName("company/companyDetail");
        return mv;
    }

    /**
     * 跳转到施工工人详情页面
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "/worker/showDetail/{id}")
    public ModelAndView showWorker(@PathVariable Long id)
    {
        ModelAndView mv = new ModelAndView();
        Providers worker = providersService.showProviders(id);
        mv.getModel().put("worker", worker);
        mv.setViewName("worker/workerDetail");
        return mv;
    }

    /**
     * 展示施工工人信息(公司、团队的)
     * 
     * @param companyId
     * @return
     */
    @RequestMapping(value = "/providers/showWorker/{companyId}")
    public @ResponseBody Object showWorkerData(@PathVariable Long companyId)
    {
        return providersService.findProviderWorker(companyId);
    }

    /**
     * 展示施工案例信息(三种类型都有)
     * 
     * @param companyId
     * @return
     */
    @RequestMapping(value = "/providers/showCase/{companyId}")
    public @ResponseBody Object showCaseData(@PathVariable Long companyId)
    {
        return providersService.findConstructionCase(companyId);
    }

    /**
     * 展示公司预约小区信息
     * 
     * @param companyId
     * @return
     */
    @RequestMapping(value = "/company/showBookingCommunity/{companyId}")
    public @ResponseBody Object showBookingCommunityData(@PathVariable Long companyId)
    {
        return providersService.findBookingCommunity(companyId);
    }

    /**
     * 展示公司资质信息
     * 
     * @param companyId
     * @return
     */
    @RequestMapping(value = "/company/showQualification/{companyId}")
    public @ResponseBody Object showQualificationData(@PathVariable Long companyId)
    {
        return providersService.findQualification(companyId);
    }

    /**
     * 加载公司、团队、个人列表数据，前台通多ajax调用
     */
    @RequestMapping(value = "/providers/pageList", method = RequestMethod.POST)
    public @ResponseBody Object pageList(PagerUtil pu, String type)
    {
        // logger.info("ProvidersController->pageList:type{}", type);
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
     * 首页显示的公司 施工工人
     * 
     * @return
     */
    @RequestMapping(value = "/index/providersList", method = RequestMethod.POST)
    public @ResponseBody Object providersListIndex(String type)
    {
        List<Integer> list = new ArrayList<Integer>();
        String[] array = type.split(",");
        for (String s : array)
        {
            list.add(Integer.valueOf(s));
        }
        // 查询数据
        return providersService.providersListIndex(list);
    }

    /**
     **************** 以下方法在美缝材料和美缝工具使用***************************
     */

    /**
     * 跳转到美缝材料详情页面(展示材料所属公司信息)
     * 
     * @param providerId
     * @return
     */
    @RequestMapping(value = "/material/showCompanyMaterial/{providerId}")
    public Object showCompanyMaterial(@PathVariable Long providerId)
    {
        ModelAndView mv = new ModelAndView();
        Providers company = providersService.showProviders(providerId);
        mv.getModel().put("company", company);
        mv.setViewName("product/productCompany");
        return mv;
    }

    /**
     * 跳转到美缝工具详情页面(展示工具所属公司信息)
     * 
     * @param providerId
     * @return
     */
    @RequestMapping(value = "/tools/showCompanyTools/{providerId}")
    public Object showCompanyTools(@PathVariable Long providerId)
    {
        ModelAndView mv = new ModelAndView();
        Providers company = providersService.showProviders(providerId);
        mv.getModel().put("company", company);
        mv.setViewName("product/productCompany");
        return mv;
    }

    /**
     * 展示公司证书信息(证书和资质使用同一个表，所以共用一个service方法)
     * 
     * @param companyId
     * @return
     */
    @RequestMapping(value = "/company/certificate/{companyId}")
    public @ResponseBody Object showCertificateData(@PathVariable Long companyId)
    {
        return providersService.findQualification(companyId);
    }

    /**
     * 展示公司防伪信息
     * 
     * @param companyId
     * @return
     */
    @RequestMapping(value = "/company/antifake/{companyId}")
    public @ResponseBody Object showAntifakeData(@PathVariable Long companyId)
    {
        return providersService.findAntiFake(companyId);
    }

    /**
     * 获取公司经营产品分类
     * 
     * @param companyId
     * @return
     */
    @RequestMapping(value = "/company/productCategory/{companyId}")
    public @ResponseBody Object showProductCategory(@PathVariable Long companyId)
    {
        return providersService.findProductCategory(companyId);
    }

}
