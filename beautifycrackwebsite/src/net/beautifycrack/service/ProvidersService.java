package net.beautifycrack.service;

import java.io.IOException;
import java.util.List;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.Providers;
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
     * ��ѯ����
     * 
     * @param list
     *            ���� 0��˾ 1�Ŷ� 2 ����
     * @return
     * @throws BusinessException
     */
    Integer queryTotal(List<Integer> list) throws BusinessException;

    /**
     * ������Ӧ��
     * 
     * @param providers
     * @throws BusinessException
     */
    void addProviders(Providers providers) throws BusinessException;

    /**
     * ���¹�Ӧ��
     * 
     * @param providers
     * @throws BusinessException
     */
    void updateProviders(Providers providers) throws BusinessException;

    /**
     * ɾ����Ӧ��
     * 
     * @param providers
     * @throws BusinessException
     */
    void deleteProviders(Providers providers) throws BusinessException, IOException;

    /**
     * ���ݹ�Ӧ��id��ѯ��Ӧ��
     * 
     * @param providerId
     * @return
     * @throws BusinessException
     */
    Providers queryProvider(Long providerId) throws BusinessException;
}
