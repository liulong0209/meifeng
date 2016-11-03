package net.beautifycrack.service.impl;

import javax.annotation.Resource;

import net.beautifycrack.dao.UserInfoMapper;
import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.UserInfo;
import net.beautifycrack.service.UserInfoService;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * ע��ӿ�ʵ��
 * 
 * UserInfoServiceImpl.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��10��13�� ����2:49:34
 * @author liulong
 */
@Scope("prototype")
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService
{
    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo queryUserInfo(String account) throws BusinessException
    {
        return userInfoMapper.queryUserInfo(account);
    }

    @Override
    public Boolean userNameExist(String userName) throws BusinessException
    {
        Integer count = userInfoMapper.userNameExist(userName);
        // ��������0 ��ʾ�Ѵ���
        if (count > 0)
        {
            return true;
        }
        return false;
    }

    @Override
    public Boolean phoneExist(String phone) throws BusinessException
    {
        Integer count = userInfoMapper.phoneExist(phone);
        // ��������0 ��ʾ�Ѵ���
        if (count > 0)
        {
            return true;
        }
        return false;
    }

    @Override
    public void addUser(UserInfo userInfo) throws BusinessException
    {
        userInfoMapper.addUser(userInfo);
    }
}
