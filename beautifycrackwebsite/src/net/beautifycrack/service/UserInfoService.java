package net.beautifycrack.service;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.UserInfo;

/**
 * 用户接口
 * 
 * UserInfoService.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年10月13日 下午2:02:02
 * @author liulong
 */
public interface UserInfoService
{
    /**
     * 用户名是否存在
     * 
     * @param userName
     * @return
     * @throws BusinessException
     */
    Boolean userNameExist(String userName) throws BusinessException;

    /**
     * 手机号是否存在
     * 
     * @param phone
     * @return
     * @throws BusinessException
     */
    Boolean phoneExist(String phone) throws BusinessException;

    /**
     * 根据账号或手机号查找用户
     * 
     * @param account
     * @return
     * @throws BusinessException
     */
    UserInfo queryUserInfo(String account) throws BusinessException;

    /**
     * 增加用户
     * 
     * @param userInfo
     * @throws BusinessException
     */
    void addUser(UserInfo userInfo) throws BusinessException;

}
