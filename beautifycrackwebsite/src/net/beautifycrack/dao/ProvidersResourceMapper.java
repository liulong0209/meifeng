package net.beautifycrack.dao;

import java.util.List;
import java.util.Map;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.Worker;

/**
 * 公司 团队 个人的资源dao (施工工人信息、施工案例、预约小区、公司资质、防伪查询)
 * 
 * ProvidersResourceMapper.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年12月15日 下午7:02:56
 * @author liulong
 */
public interface ProvidersResourceMapper
{
    /**
     * 分页查询工人数据
     * 
     * @return
     * @throws BusinessException
     */
    List<Worker> wokerPagerList(Map<String, Object> param) throws BusinessException;

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
     * @param workerId
     * @throws BusinessException
     */
    void deleteWork(Long workerId) throws BusinessException;
}
