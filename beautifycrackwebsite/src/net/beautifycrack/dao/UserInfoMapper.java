package net.beautifycrack.dao;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.UserInfo;

/**
 * �û����dao
 * 
 * UserInfoMapper.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��10��13�� ����2:41:51
 * @author liulong
 */
public interface UserInfoMapper
{
    /**
     * �û����Ƿ����
     * 
     * @param userName
     * @return
     * @throws BusinessException
     */
    Integer userNameExist(String userName) throws BusinessException;

    /**
     * �ֻ����Ƿ����
     * 
     * @param phone
     * @return
     * @throws BusinessException
     */
    Integer phoneExist(String phone) throws BusinessException;

    /**
     * �����û�
     * 
     * @param userInfo
     * @throws BusinessException
     */
    void addUser(UserInfo userInfo) throws BusinessException;

    /**
     * �����˺Ż��ֻ��Ų����û�
     * 
     * @param account
     * @return
     * @throws BusinessException
     */
    UserInfo queryUserInfo(String account) throws BusinessException;

    /**
     * �û��޸�
     * 
     * @param userInfo
     * @throws BusinessException
     */
    void update(UserInfo userInfo) throws BusinessException;
}
