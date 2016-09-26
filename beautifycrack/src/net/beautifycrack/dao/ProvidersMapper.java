package net.beautifycrack.dao;

import java.util.List;
import java.util.Map;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.BookingCommunity;
import net.beautifycrack.module.ConstructionCase;
import net.beautifycrack.module.Providers;
import net.beautifycrack.module.Qualification;
import net.beautifycrack.module.UserInfo;

/**
 * 公司dao
 * 
 * CompanyMapper.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月14日 下午3:50:31
 * @author liulong
 */
public interface ProvidersMapper
{
    /**
     * 分页查询数据
     * 
     * @return
     * @throws BusinessException
     */
    List<Providers> pagerList(Map<String, Object> map) throws BusinessException;

    /**
     * 显示单条详细信息
     * 
     * @param id
     * @return
     * @throws BusinessException
     */
    Providers showProviders(Integer id) throws BusinessException;

    /**
     * 查询总数
     * 
     * @return
     * @throws BusinessException
     */
    Integer queryTotal(List<Integer> list) throws BusinessException;

    /**
     * 首页显示的数据，显示4条
     * 
     * @return
     * @throws BusinessException
     */
    List<Providers> providersListIndex(List<Integer> list) throws BusinessException;

    /**
     * 查找施工工人信息,显示3条
     * 
     * @param companyId
     * @return
     * @throws BusinessException
     */
    List<UserInfo> findProviderWorker(Integer providerId) throws BusinessException;

    /**
     * 查找施工案例信息
     * 
     * @param providerId
     * @return
     * @throws BusinessException
     */
    List<ConstructionCase> findConstructionCase(Integer providerId) throws BusinessException;

    /**
     * 查找预约小区信息
     * 
     * @param providerId
     * @return
     * @throws BusinessException
     */
    List<BookingCommunity> findBookingCommunity(Integer providerId) throws BusinessException;

    /**
     * 查找公司资质信息
     * 
     * @param company
     * @return
     * @throws BusinessException
     */
    List<Qualification> findQualification(Integer company) throws BusinessException;
}
