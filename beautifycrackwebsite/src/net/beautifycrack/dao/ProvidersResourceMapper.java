package net.beautifycrack.dao;

import java.util.List;
import java.util.Map;

import net.beautifycrack.exception.BusinessException;
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
    /**
     * ��ҳ��ѯ��������
     * 
     * @return
     * @throws BusinessException
     */
    List<Worker> wokerPagerList(Map<String, Object> param) throws BusinessException;

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
     * @param workerId
     * @throws BusinessException
     */
    void deleteWork(Long workerId) throws BusinessException;
}
