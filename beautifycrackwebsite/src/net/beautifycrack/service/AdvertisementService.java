package net.beautifycrack.service;

import java.util.List;

import net.beautifycrack.module.Advertisement;

/**
 * 公告服务接口
 * 
 * AdvertisementService.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月13日 下午5:36:50
 * @author liulong
 */
public interface AdvertisementService
{
    /**
     * 获取首页的轮播幻灯片
     * 
     * @return
     */
    List<Advertisement> getSlideImg();
}
