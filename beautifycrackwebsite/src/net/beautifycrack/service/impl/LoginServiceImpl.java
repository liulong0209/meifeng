package net.beautifycrack.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import net.beautifycrack.constant.Common;
import net.beautifycrack.dao.UserInfoMapper;
import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.UserInfo;
import net.beautifycrack.service.LoginService;
import net.beautifycrack.util.MD5Util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * ��¼ʵ��
 * 
 * LoginServiceImpl.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��11��24�� ����8:18:18
 * @author liulong
 */
@Scope("prototype")
@Service("LoginService")
public class LoginServiceImpl implements LoginService
{
    /**
     * ע���û�dao
     */
    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public int login(UserInfo user) throws BusinessException
    {
        UserInfo dbUser = userInfoMapper.queryUserInfo(user.getUserName());
        // �û�������
        if (dbUser == null)
        {
            return Common.USERINFO_NOT_EXISTS;
        }

        if (!dbUser.getPassword().equals(MD5Util.generatePassword(user.getPassword())))
        {
            return Common.USERINFO_PASSWORD_ERROR;
        }
        user.setUserId(dbUser.getUserId());
        user.setUserName(dbUser.getUserName());
        user.setPassword("");

        // ��¼�ɹ���������һ�ε�¼ʱ��
        UserInfo u = new UserInfo();
        u.setUserId(dbUser.getUserId());
        u.setLastLoginTime(new Date(System.currentTimeMillis()));
        userInfoMapper.update(u);

        return Common.STATUS_OK;
    }

}
