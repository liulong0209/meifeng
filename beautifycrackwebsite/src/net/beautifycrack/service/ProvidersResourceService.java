package net.beautifycrack.service;

import java.io.IOException;
import java.util.List;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.AntiFake;
import net.beautifycrack.module.BookingCommunity;
import net.beautifycrack.module.ConstructionCase;
import net.beautifycrack.module.Qualification;
import net.beautifycrack.module.Worker;
import net.beautifycrack.util.PagerUtil;

/**
 * ��˾ �Ŷ� ���˵���Դ�ӿ� (ʩ��������Ϣ��ʩ��������ԤԼС������˾���ʡ���α��ѯ)
 * 
 * ProvidersResourceService.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��12��15�� ����7:02:56
 * @author liulong
 */
public interface ProvidersResourceService
{
    /***************** ʩ������ *****************/
    /**
     * ��ҳ��ѯ��������
     * 
     * @return
     * @throws BusinessException
     */
    List<Worker> workerPagerList(PagerUtil pager, Long providersId) throws BusinessException;

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
     * @param worker
     * @throws BusinessException
     */
    void deleteWorker(Worker worker) throws BusinessException, IOException;

    /***************** ʩ������ *****************/
    /**
     * ��ҳ��ѯʩ����������
     * 
     * @return
     * @throws BusinessException
     */
    List<ConstructionCase> workcasePagerList(PagerUtil pager, Long providersId) throws BusinessException;

    /**
     * ��ѯ�ṩ����ʩ����������
     * 
     * @return
     * @throws BusinessException
     */
    Integer queryWorkcaseTotal(Long providersId) throws BusinessException;

    /**
     * ����ʩ������
     * 
     * @param workcase
     * @throws BusinessException
     */
    void addWorkcase(ConstructionCase workcase) throws BusinessException;

    /**
     * ����ʩ������
     * 
     * @param workcaseId
     * @return
     * @throws BusinessException
     */
    ConstructionCase findWorkcase(Long workcaseId) throws BusinessException;

    /**
     * ����ʩ������
     * 
     * @param workcase
     * @throws BusinessException
     */
    void updateWorkcase(ConstructionCase workcase) throws BusinessException;

    /**
     * ɾ��ʩ������
     * 
     * @param workcase
     * @throws BusinessException
     */
    void deleteWorkcase(ConstructionCase workcase) throws BusinessException, IOException;

    /***************** ԤԼС�� *****************/
    /**
     * ��ҳ��ѯԤԼС������
     * 
     * @return
     * @throws BusinessException
     */
    List<BookingCommunity> bookingPagerList(PagerUtil pager, Long providersId) throws BusinessException;

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
     * @param booking
     * @throws BusinessException
     */
    void deleteBooking(BookingCommunity booking) throws BusinessException, IOException;

    /***************** ��˾���� *****************/
    /**
     * ��ҳ��ѯ��˾���� ����
     * 
     * @return
     * @throws BusinessException
     */
    List<Qualification> qualificationPagerList(PagerUtil pager, Long providersId) throws BusinessException;

    /**
     * ��ѯ��˾���� ����
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
     * @param qualification
     * @throws BusinessException
     */
    void deleteQualification(Qualification qualification) throws BusinessException, IOException;

    /***************** ��α��ѯ *****************/
    /**
     * ��ҳ��ѯ��α��ѯ ����
     * 
     * @return
     * @throws BusinessException
     */
    List<AntiFake> antiFakePagerList(PagerUtil pager, Long providersId) throws BusinessException;

    /**
     * ��ѯ��α��ѯ ����
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
     * @param antiFake
     * @throws BusinessException
     */
    void deleteAntiFake(AntiFake antiFake) throws BusinessException, IOException;
}
