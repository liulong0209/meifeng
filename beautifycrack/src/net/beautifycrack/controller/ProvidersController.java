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
@Scope("prototype")
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
     * ��ת����˾�б�ҳ��
     */
    @RequestMapping(value = "/company")
    public ModelAndView company(HttpServletRequest request, HttpServletResponse response)
    {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("company/companyList");
        return mv;
    }

    /**
     * ��ת��ʩ�������б�ҳ��
     */
    @RequestMapping(value = "/worker")
    public ModelAndView worker(HttpServletRequest request, HttpServletResponse response)
    {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("worker/workerList");
        return mv;
    }

    /**
     * ��ת����˾����ҳ��
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
        // request.getSession(true).setAttribute("user", "user");
        return mv;
    }

    /**
     * ��ת��ʩ����������ҳ��
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
     * չʾʩ��������Ϣ(��˾���Ŷӵ�)
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
     * չʾʩ��������Ϣ(�������Ͷ���)
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
     * չʾ��˾ԤԼС����Ϣ
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
     * չʾ��˾������Ϣ
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
     * ���ع�˾���Ŷӡ������б����ݣ�ǰ̨ͨ��ajax����
     */
    @RequestMapping(value = "/providers/pageList", method = RequestMethod.POST)
    public @ResponseBody Object pageList(PagerUtil pu, String type)
    {
        // logger.info("ProvidersController->pageList:type{}", type);
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
     * ��ҳ��ʾ�Ĺ�˾ ʩ������
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
        // ��ѯ����
        return providersService.providersListIndex(list);
    }

    /**
     **************** ���·�����������Ϻ����칤��ʹ��***************************
     */

    /**
     * ��ת�������������ҳ��(չʾ����������˾��Ϣ)
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
     * ��ת�����칤������ҳ��(չʾ����������˾��Ϣ)
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
     * չʾ��˾֤����Ϣ(֤�������ʹ��ͬһ�������Թ���һ��service����)
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
     * չʾ��˾��α��Ϣ
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
     * ��ȡ��˾��Ӫ��Ʒ����
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
