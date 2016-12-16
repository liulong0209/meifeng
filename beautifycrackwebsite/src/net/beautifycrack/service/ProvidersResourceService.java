package net.beautifycrack.service;

import java.io.IOException;
import java.util.List;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.ConstructionCase;
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
}
