package net.beautifycrack.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.FileInfo;
import net.beautifycrack.service.FileInfoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @RequestMapping(value = "/image/get/{imageId}")
    public void getImage(HttpServletRequest request, HttpServletResponse response, @PathVariable Long imageId)
            throws BusinessException
    {
        // logger.debug("FileController->getImage:imageId:{}", imageId);
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
            // logger.error("获取附件失败", e.getMessage());
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
                    e.printStackTrace();
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
    @RequestMapping(value = "/imageshow")
    public void showImage(@RequestParam(value = "s") String imgSrc, HttpServletRequest request,
            HttpServletResponse response)
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
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
