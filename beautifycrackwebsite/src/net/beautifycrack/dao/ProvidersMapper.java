package net.beautifycrack.dao;

import java.util.List;
import java.util.Map;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.Providers;

/**
 * ��˾dao
 * 
 * CompanyMapper.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��14�� ����3:50:31
 * @author liulong
 */
public interface ProvidersMapper
{
    /**
     * ��ҳ��ѯ����
     * 
     * @return
     * @throws BusinessException
     */
    List<Providers> pagerList(Map<String, Object> map) throws BusinessException;

    /**
     * ��ѯ����
     * 
     * @return
     * @throws BusinessException
     */
    Integer queryTotal(List<Integer> list) throws BusinessException;

    /**
     * ������Ӧ��
     * 
     * @param providers
     * @return
     * @throws BusinessException
     */
    void addProviders(Providers providers) throws BusinessException;

    /**
     * ���¹�Ӧ��
     * 
     * @param providers
     * @return
     * @throws BusinessException
     */
    void updateProviders(Providers providers) throws BusinessException;

    /**
     * ɾ����Ӧ��
     * 
     * @param providers
     * @return
     * @throws BusinessException
     */
    void deleteProviders(Long providerId) throws BusinessException;

    /**
     * ��ʾ������ϸ��Ϣ
     * 
     * @param providerId
     * @return
     * @throws BusinessException
     */
    Providers queryProvider(Long providerId) throws BusinessException;
}
