package net.beautifycrack.service;

import java.util.List;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.BookingCommunity;
import net.beautifycrack.module.ConstructionCase;
import net.beautifycrack.module.Providers;
import net.beautifycrack.module.Qualification;
import net.beautifycrack.module.UserInfo;
import net.beautifycrack.util.PagerUtil;

/**
 * ��˾��ؽӿ�
 * 
 * CompanyService.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��14�� ����3:28:33
 * @author liulong
 */
public interface ProvidersService
{
    /**
     * ��ҳ��ѯ����
     * 
     * @return
     * @throws BusinessException
     */
    List<Providers> pagerList(PagerUtil pager, List<Integer> list) throws BusinessException;

    /**
     * ��ʾ������ϸ��Ϣ
     * 
     * @param id
     * @return
     * @throws BusinessException
     */
    Providers showProviders(Integer id) throws BusinessException;

    /**
     * ��ѯ����
     * 
     * @param list
     *            ���� 0��˾ 1�Ŷ� 2 ����
     * @return
     * @throws BusinessException
     */
    Integer queryTotal(List<Integer> list) throws BusinessException;

    /**
     * ��ҳ��ʾ�����ݣ���ʾ4��
     * 
     * @return
     * @throws BusinessException
     */
    List<Providers> providersListIndex(List<Integer> list) throws BusinessException;

    /**
     * ����ʩ��������Ϣ ��ʾ����
     * 
     * @param companyId
     * @return
     * @throws BusinessException
     */
    List<UserInfo> findProviderWorker(Integer providerId) throws BusinessException;

    /**
     * ����ʩ��������Ϣ
     * 
     * @param providerId
     * @return
     * @throws BusinessException
     */
    List<ConstructionCase> findConstructionCase(Integer providerId) throws BusinessException;

    /**
     * ����ԤԼС����Ϣ
     * 
     * @param providerId
     * @return
     * @throws BusinessException
     */
    List<BookingCommunity> findBookingCommunity(Integer providerId) throws BusinessException;

    /**
     * ���ҹ�˾������Ϣ
     * 
     * @param company
     * @return
     * @throws BusinessException
     */
    List<Qualification> findQualification(Integer company) throws BusinessException;
}
