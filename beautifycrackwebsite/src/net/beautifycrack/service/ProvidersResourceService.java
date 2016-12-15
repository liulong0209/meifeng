package net.beautifycrack.service;

import java.io.IOException;
import java.util.List;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.Worker;
import net.beautifycrack.util.PagerUtil;

/**
 * 公司 团队 个人的资源接口 (施工工人信息、施工案例、预约小区、公司资质、防伪查询)
 * 
 * ProvidersResourceService.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年12月15日 下午7:02:56
 * @author liulong
 */
public interface ProvidersResourceService
{
    /**
     * 分页查询工人数据
     * 
     * @return
     * @throws BusinessException
     */
    List<Worker> wokerPagerList(PagerUtil pager, Long providersId) throws BusinessException;

    /**
     * 查询提供商下工人总数
     * 
     * @return
     * @throws BusinessException
     */
    Integer queryWokerTotal(Long providersId) throws BusinessException;

    /**
     * 增加工人
     * 
     * @param worker
     * @throws BusinessException
     */
    void addWork(Worker worker) throws BusinessException;

    /**
     * 查找工人
     * 
     * @param workerId
     * @return
     * @throws BusinessException
     */
    Worker findWorker(Long workerId) throws BusinessException;

    /**
     * 更新工人
     * 
     * @param worker
     * @throws BusinessException
     */
    void updateWork(Worker worker) throws BusinessException;

    /**
     * 删除工人
     * 
     * @param worker
     * @throws BusinessException
     */
    void deleteWork(Worker worker) throws BusinessException, IOException;
}
