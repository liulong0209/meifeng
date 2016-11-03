package net.beautifycrack.dao;

import java.util.List;

import net.beautifycrack.module.Advertisement;

/**
 * 相关广告 dao
 * 
 * AdvertisementMapper.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月13日 下午5:27:21
 * @author liulong
 */
public interface AdvertisementMapper
{
    /**
     * 获取首页的轮播幻灯片
     * 
     * @return
     */
    List<Advertisement> getSlideImg();
}
