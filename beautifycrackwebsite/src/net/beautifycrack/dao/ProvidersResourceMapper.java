package net.beautifycrack.dao;

import java.util.List;
import java.util.Map;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.AntiFake;
import net.beautifycrack.module.BookingCommunity;
import net.beautifycrack.module.ConstructionCase;
import net.beautifycrack.module.Qualification;
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
    /***************** 施工工人 *****************/
    /**
     * 分页查询工人数据
     * 
     * @return
     * @throws BusinessException
     */
    List<Worker> workerPagerList(Map<String, Object> param) throws BusinessException;

    /**
     * 查询提供商下工人总数
     * 
     * @return
     * @throws BusinessException
     */
    Integer queryWorkerTotal(Long providersId) throws BusinessException;

    /**
     * 增加工人
     * 
     * @param worker
     * @throws BusinessException
     */
    void addWorker(Worker worker) throws BusinessException;

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
    void updateWorker(Worker worker) throws BusinessException;

    /**
     * 删除工人
     * 
     * @param workerId
     * @throws BusinessException
     */
    void deleteWorker(Long workerId) throws BusinessException;

    /***************** 施工案例 *****************/
    /**
     * 分页查询案例数据
     * 
     * @return
     * @throws BusinessException
     */
    List<ConstructionCase> workcasePagerList(Map<String, Object> param) throws BusinessException;

    /**
     * 查询提供商下案例总数
     * 
     * @return
     * @throws BusinessException
     */
    Integer queryWorkcaseTotal(Long providersId) throws BusinessException;

    /**
     * 增加案例
     * 
     * @param workcase
     * @throws BusinessException
     */
    void addWorkcase(ConstructionCase workcase) throws BusinessException;

    /**
     * 查找案例
     * 
     * @param workcaseId
     * @return
     * @throws BusinessException
     */
    ConstructionCase findWorkcase(Long workcaseId) throws BusinessException;

    /**
     * 更新案例
     * 
     * @param workcase
     * @throws BusinessException
     */
    void updateWorkcase(ConstructionCase workcase) throws BusinessException;

    /**
     * 删除案例
     * 
     * @param workcaseId
     * @throws BusinessException
     */
    void deleteWorkcase(Long workcaseId) throws BusinessException;

    /***************** 预约小区 *****************/
    /**
     * 分页查询预约小区数据
     * 
     * @return
     * @throws BusinessException
     */
    List<BookingCommunity> bookingPagerList(Map<String, Object> param) throws BusinessException;

    /**
     * 查询提供商下预约小区总数
     * 
     * @return
     * @throws BusinessException
     */
    Integer queryBookingTotal(Long providersId) throws BusinessException;

    /**
     * 增加预约小区
     * 
     * @param booking
     * @throws BusinessException
     */
    void addBooking(BookingCommunity booking) throws BusinessException;

    /**
     * 查找预约小区
     * 
     * @param bookingId
     * @return
     * @throws BusinessException
     */
    BookingCommunity findBooking(Long bookingId) throws BusinessException;

    /**
     * 更新预约小区
     * 
     * @param booking
     * @throws BusinessException
     */
    void updateBooking(BookingCommunity booking) throws BusinessException;

    /**
     * 删除预约小区
     * 
     * @param bookingId
     * @throws BusinessException
     */
    void deleteBooking(Long bookingId) throws BusinessException;

    /***************** 公司资质 *****************/
    /**
     * 分页查询公司资质数据
     * 
     * @return
     * @throws BusinessException
     */
    List<Qualification> qualificationPagerList(Map<String, Object> param) throws BusinessException;

    /**
     * 查询提公司资质总数
     * 
     * @return
     * @throws BusinessException
     */
    Integer queryQualificationTotal(Long providersId) throws BusinessException;

    /**
     * 增加公司资质
     * 
     * @param qualification
     * @throws BusinessException
     */
    void addQualification(Qualification qualification) throws BusinessException;

    /**
     * 查找公司资质
     * 
     * @param qualificationId
     * @return
     * @throws BusinessException
     */
    Qualification findQualification(Long qualificationId) throws BusinessException;

    /**
     * 更新公司资质
     * 
     * @param qualification
     * @throws BusinessException
     */
    void updateQualification(Qualification qualification) throws BusinessException;

    /**
     * 删除公司资质
     * 
     * @param qualificationId
     * @throws BusinessException
     */
    void deleteQualification(Long qualificationId) throws BusinessException;

    /***************** 防伪查询 *****************/
    /**
     * 分页查询防伪查询数据
     * 
     * @return
     * @throws BusinessException
     */
    List<AntiFake> antiFakePagerList(Map<String, Object> param) throws BusinessException;

    /**
     * 查询提防伪查询总数
     * 
     * @return
     * @throws BusinessException
     */
    Integer queryAntiFakeTotal(Long providersId) throws BusinessException;

    /**
     * 增加防伪查询
     * 
     * @param antiFake
     * @throws BusinessException
     */
    void addAntiFake(AntiFake antiFake) throws BusinessException;

    /**
     * 查找防伪查询
     * 
     * @param antiFakeId
     * @return
     * @throws BusinessException
     */
    AntiFake findAntiFake(Long antiFakeId) throws BusinessException;

    /**
     * 更新防伪查询
     * 
     * @param antiFake
     * @throws BusinessException
     */
    void updateAntiFake(AntiFake antiFake) throws BusinessException;

    /**
     * 删除防伪查询
     * 
     * @param antiFakeId
     * @throws BusinessException
     */
    void deleteAntiFake(Long antiFakeId) throws BusinessException;
}
