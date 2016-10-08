package net.beautifycrack.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.beautifycrack.module.Product;
import net.beautifycrack.module.ProductCategory;
import net.beautifycrack.service.MaterialService;
import net.beautifycrack.util.PagerUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * ���Ͽ�����
 * 
 * MaterialController.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��12�� ����4:44:24
 * @author liulong
 */
@Scope("prototype")
@Controller
@RequestMapping("/material")
public class MaterialController
{
    private static Logger logger = LoggerFactory.getLogger(MaterialController.class);
    /**
     * ע����Ͻӿ�
     */
    @Resource
    private MaterialService materialService;

    /**
     * ��ת���������ҳ��
     * 
     * @return
     */
    @RequestMapping(value = "")
    public Object materialIndex()
    {
        // ��ȡ���Ϸ�����Ŀ
        List<ProductCategory> materialCategory = materialService.getMaterialCategory();
        ModelAndView mv = new ModelAndView();
        mv.getModelMap().put("firstCategory", materialCategory.get(0).getId());
        mv.getModelMap().put("materialCategory", materialCategory);
        mv.setViewName("material/materialList");
        return mv;
    }

    /**
     * ��ҳչʾ����
     * 
     * @param pu
     * @param categoryId
     * @return
     */
    @RequestMapping(value = "/pageList", method = RequestMethod.POST)
    public @ResponseBody Object pageList(PagerUtil pu, Long categoryId)
    {
        logger.info("MaterialController->pageList->categoryId{}", categoryId);
        Map<String, Object> dataMaps = new HashMap<String, Object>();

        List<Product> list = materialService.queryMaterial(pu, categoryId);

        dataMaps.put("dataList", list);

        Integer total = materialService.queryTotal(categoryId);
        pu.setTotalRecords(total);
        pu.setTotalPage(pu.getTotalPage());
        dataMaps.put("pager", pu);
        return dataMaps;
    }
}
