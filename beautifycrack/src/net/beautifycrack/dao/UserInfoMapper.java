package net.beautifycrack.dao;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.UserInfo;

/**
 * 用户相关dao
 * 
 * UserInfoMapper.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年10月13日 下午2:41:51
 * @author liulong
 */
public interface UserInfoMapper
{
    /**
     * 用户名是否存在
     * 
     * @param userName
     * @return
     * @throws BusinessException
     */
    Integer userNameExist(String userName) throws BusinessException;

    /**
     * 手机号是否存在
     * 
     * @param phone
     * @return
     * @throws BusinessException
     */
    Integer phoneExist(String phone) throws BusinessException;

    /**
     * 增加用户
     * 
     * @param userInfo
     * @throws BusinessException
     */
    void addUser(UserInfo userInfo) throws BusinessException;
}
