package net.beautifycrack.service;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.UserInfo;

/**
 * �û��ӿ�
 * 
 * UserInfoService.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��10��13�� ����2:02:02
 * @author liulong
 */
public interface UserInfoService
{

    /**
     * �û���¼
     * 
     * @param account
     * @param password
     * @return
     * @throws BusinessException
     */
    Integer verify(String account, String password) throws BusinessException;

    /**
     * �û����Ƿ����
     * 
     * @param userName
     * @return
     * @throws BusinessException
     */
    Boolean userNameExist(String userName) throws BusinessException;

    /**
     * �ֻ����Ƿ����
     * 
     * @param phone
     * @return
     * @throws BusinessException
     */
    Boolean phoneExist(String phone) throws BusinessException;

    /**
     * �����˺Ų����û�
     * 
     * @param account
     * @return
     * @throws BusinessException
     */
    UserInfo queryUserInfo(String account) throws BusinessException;

    /**
     * �����û�
     * 
     * @param userInfo
     * @throws BusinessException
     */
    void addUser(UserInfo userInfo) throws BusinessException;

}
