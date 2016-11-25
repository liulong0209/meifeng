package net.beautifycrack.service;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.UserInfo;

/**
 * 登录service
 * 
 * LoginService.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年11月24日 下午8:08:38
 * @author liulong
 */
public interface LoginService
{
    /**
     * 登录
     * 
     * @param user
     * @return
     * @throws BusinessException
     */
    int login(UserInfo user) throws BusinessException;
}
