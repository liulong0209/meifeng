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
 * ��˾ �Ŷ� ���˵���Դdao (ʩ��������Ϣ��ʩ��������ԤԼС������˾���ʡ���α��ѯ)
 * 
 * ProvidersResourceMapper.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��12��15�� ����7:02:56
 * @author liulong
 */
public interface ProvidersResourceMapper
{
    /***************** ʩ������ *****************/
    /**
     * ��ҳ��ѯ��������
     * 
     * @return
     * @throws BusinessException
     */
    List<Worker> workerPagerList(Map<String, Object> param) throws BusinessException;

    /**
     * ��ѯ�ṩ���¹�������
     * 
     * @return
     * @throws BusinessException
     */
    Integer queryWorkerTotal(Long providersId) throws BusinessException;

    /**
     * ���ӹ���
     * 
     * @param worker
     * @throws BusinessException
     */
    void addWorker(Worker worker) throws BusinessException;

    /**
     * ���ҹ���
     * 
     * @param workerId
     * @return
     * @throws BusinessException
     */
    Worker findWorker(Long workerId) throws BusinessException;

    /**
     * ���¹���
     * 
     * @param worker
     * @throws BusinessException
     */
    void updateWorker(Worker worker) throws BusinessException;

    /**
     * ɾ������
     * 
     * @param workerId
     * @throws BusinessException
     */
    void deleteWorker(Long workerId) throws BusinessException;

    /***************** ʩ������ *****************/
    /**
     * ��ҳ��ѯ��������
     * 
     * @return
     * @throws BusinessException
     */
    List<ConstructionCase> workcasePagerList(Map<String, Object> param) throws BusinessException;

    /**
     * ��ѯ�ṩ���°�������
     * 
     * @return
     * @throws BusinessException
     */
    Integer queryWorkcaseTotal(Long providersId) throws BusinessException;

    /**
     * ���Ӱ���
     * 
     * @param workcase
     * @throws BusinessException
     */
    void addWorkcase(ConstructionCase workcase) throws BusinessException;

    /**
     * ���Ұ���
     * 
     * @param workcaseId
     * @return
     * @throws BusinessException
     */
    ConstructionCase findWorkcase(Long workcaseId) throws BusinessException;

    /**
     * ���°���
     * 
     * @param workcase
     * @throws BusinessException
     */
    void updateWorkcase(ConstructionCase workcase) throws BusinessException;

    /**
     * ɾ������
     * 
     * @param workcaseId
     * @throws BusinessException
     */
    void deleteWorkcase(Long workcaseId) throws BusinessException;

    /***************** ԤԼС�� *****************/
    /**
     * ��ҳ��ѯԤԼС������
     * 
     * @return
     * @throws BusinessException
     */
    List<BookingCommunity> bookingPagerList(Map<String, Object> param) throws BusinessException;

    /**
     * ��ѯ�ṩ����ԤԼС������
     * 
     * @return
     * @throws BusinessException
     */
    Integer queryBookingTotal(Long providersId) throws BusinessException;

    /**
     * ����ԤԼС��
     * 
     * @param booking
     * @throws BusinessException
     */
    void addBooking(BookingCommunity booking) throws BusinessException;

    /**
     * ����ԤԼС��
     * 
     * @param bookingId
     * @return
     * @throws BusinessException
     */
    BookingCommunity findBooking(Long bookingId) throws BusinessException;

    /**
     * ����ԤԼС��
     * 
     * @param booking
     * @throws BusinessException
     */
    void updateBooking(BookingCommunity booking) throws BusinessException;

    /**
     * ɾ��ԤԼС��
     * 
     * @param bookingId
     * @throws BusinessException
     */
    void deleteBooking(Long bookingId) throws BusinessException;

    /***************** ��˾���� *****************/
    /**
     * ��ҳ��ѯ��˾��������
     * 
     * @return
     * @throws BusinessException
     */
    List<Qualification> qualificationPagerList(Map<String, Object> param) throws BusinessException;

    /**
     * ��ѯ�ṫ˾��������
     * 
     * @return
     * @throws BusinessException
     */
    Integer queryQualificationTotal(Long providersId) throws BusinessException;

    /**
     * ���ӹ�˾����
     * 
     * @param qualification
     * @throws BusinessException
     */
    void addQualification(Qualification qualification) throws BusinessException;

    /**
     * ���ҹ�˾����
     * 
     * @param qualificationId
     * @return
     * @throws BusinessException
     */
    Qualification findQualification(Long qualificationId) throws BusinessException;

    /**
     * ���¹�˾����
     * 
     * @param qualification
     * @throws BusinessException
     */
    void updateQualification(Qualification qualification) throws BusinessException;

    /**
     * ɾ����˾����
     * 
     * @param qualificationId
     * @throws BusinessException
     */
    void deleteQualification(Long qualificationId) throws BusinessException;

    /***************** ��α��ѯ *****************/
    /**
     * ��ҳ��ѯ��α��ѯ����
     * 
     * @return
     * @throws BusinessException
     */
    List<AntiFake> antiFakePagerList(Map<String, Object> param) throws BusinessException;

    /**
     * ��ѯ���α��ѯ����
     * 
     * @return
     * @throws BusinessException
     */
    Integer queryAntiFakeTotal(Long providersId) throws BusinessException;

    /**
     * ���ӷ�α��ѯ
     * 
     * @param antiFake
     * @throws BusinessException
     */
    void addAntiFake(AntiFake antiFake) throws BusinessException;

    /**
     * ���ҷ�α��ѯ
     * 
     * @param antiFakeId
     * @return
     * @throws BusinessException
     */
    AntiFake findAntiFake(Long antiFakeId) throws BusinessException;

    /**
     * ���·�α��ѯ
     * 
     * @param antiFake
     * @throws BusinessException
     */
    void updateAntiFake(AntiFake antiFake) throws BusinessException;

    /**
     * ɾ����α��ѯ
     * 
     * @param antiFakeId
     * @throws BusinessException
     */
    void deleteAntiFake(Long antiFakeId) throws BusinessException;
}
