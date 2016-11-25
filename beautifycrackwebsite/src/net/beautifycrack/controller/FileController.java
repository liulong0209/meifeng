package net.beautifycrack.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.beautifycrack.constant.Common;
import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.FileInfo;
import net.beautifycrack.service.FileInfoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 文件管理控制器
 * 
 * FileController.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月19日 下午7:28:54
 * @author liulong
 */
@Controller
@RequestMapping("/file")
public class FileController
{
    private static Logger logger = LoggerFactory.getLogger(FileController.class);

    /**
     * 资源文件路径
     */
    @Value("#{properties['root.upload.path']}")
    private String rootUploadPath;

    /**
     * 文件接口
     */
    @Resource
    private FileInfoService fileInfoService;

    /**
     * 根据图像的id 获取图像
     * 
     * @param request
     * @param response
     * @param imageId
     * @throws BusinessException
     */
    @RequestMapping(value = "/image/get.do")
    public void getImage(HttpServletRequest request, HttpServletResponse response, Long imageId)
            throws BusinessException
    {
        logger.debug("FileController->getImage:imageId:{}", imageId);
        if (imageId == null)
        {
            return;
        }
        FileInputStream fis = null;
        FileInfo fileInfo = null;
        response.setContentType("image/gif");
        try
        {
            // 查询文件，获得文件路径
            fileInfo = fileInfoService.findFileById(imageId);
            OutputStream out = response.getOutputStream();
            File file = new File(fileInfo.getFilePath());
            fis = new FileInputStream(file);
            byte[] b = new byte[fis.available()];
            fis.read(b);
            out.write(b);
            out.flush();
        }
        catch (IOException e)
        {
            logger.error("获取附件失败", e.getMessage());
        }
        finally
        {
            if (fis != null)
            {
                try
                {
                    fis.close();
                }
                catch (IOException e)
                {
                    logger.error("获取附件失败", e.getMessage());
                }
            }
        }
    }

    /**
     * 
     * @Title: showImage
     * @Description: 往前台输出显示图片
     * @param imgSrc
     *            图片路径
     * @param request
     *            HttpServletRequest
     * @param response
     *            HttpServletResponse
     * @Version v1.0
     * @author s54322/sunyue
     * @Date 2016年5月19日
     */
    @RequestMapping(value = "/imageshow.do")
    public void showImage(@RequestParam(value = "s") String imgSrc, HttpServletRequest request,
            HttpServletResponse response) throws BusinessException
    {
        FileInputStream is;
        try
        {
            is = new FileInputStream(rootUploadPath + new String(imgSrc.getBytes("iso-8859-1"), "utf-8"));
            int i = is.available(); // 得到文件大小
            byte[] data = new byte[i];
            is.read(data); // 读数据
            is.close();
            response.setContentType("image/*"); // 设置返回的文件类型
            OutputStream toClient = response.getOutputStream(); // 得到向客户端输出二进制数据的对象
            toClient.write(data); // 输出数据
            toClient.close();
        }
        catch (FileNotFoundException e)
        {
            logger.error("往前台输出显示图片失败，原因：", e);
        }
        catch (IOException e)
        {
            logger.error("往前台输出显示图片失败，原因：", e);
        }
    }

    /**
     * 删除文件
     * 
     * @param imgId
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/delete.do", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> deleteFile(Long fileId) throws BusinessException
    {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try
        {
            fileInfoService.deleteFile(fileId);
            resultMap.put("result", Common.SUCCESS);
        }
        catch (Exception e)
        {
            resultMap.put("result", Common.FAIL);
            logger.error("删除文件失败，原因：", e);
        }
        return resultMap;
    }
}
