package net.beautifycrack.service;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.UserInfo;

/**
 * ��¼service
 * 
 * LoginService.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��11��24�� ����8:08:38
 * @author liulong
 */
public interface LoginService
{
    /**
     * ��¼
     * 
     * @param user
     * @return
     * @throws BusinessException
     */
    int login(UserInfo user) throws BusinessException;
}
