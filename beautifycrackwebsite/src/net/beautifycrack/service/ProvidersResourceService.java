package net.beautifycrack.service;

import java.io.IOException;
import java.util.List;

import net.beautifycrack.exception.BusinessException;
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
    /**
     * ��ҳ��ѯ��������
     * 
     * @return
     * @throws BusinessException
     */
    List<Worker> wokerPagerList(PagerUtil pager, Long providersId) throws BusinessException;

    /**
     * ��ѯ�ṩ���¹�������
     * 
     * @return
     * @throws BusinessException
     */
    Integer queryWokerTotal(Long providersId) throws BusinessException;

    /**
     * ���ӹ���
     * 
     * @param worker
     * @throws BusinessException
     */
    void addWork(Worker worker) throws BusinessException;

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
    void updateWork(Worker worker) throws BusinessException;

    /**
     * ɾ������
     * 
     * @param worker
     * @throws BusinessException
     */
    void deleteWork(Worker worker) throws BusinessException, IOException;
}
