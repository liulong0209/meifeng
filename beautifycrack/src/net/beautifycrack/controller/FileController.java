package net.beautifycrack.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.beautifycrack.exception.BusinessException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
@Scope("prototype")
@Controller
@RequestMapping("/file")
public class FileController
{
    private static Logger logger = LoggerFactory.getLogger(FileController.class);

    /**
     * 根据图像的id 获取图像
     * 
     * @param request
     * @param response
     * @param imageId
     * @throws BusinessException
     */
    @RequestMapping(value = "/image/get/{imageId}")
    public void getImage(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer imageId)
            throws BusinessException
    {
        logger.debug("FileController->getImage:imageId:{}", imageId);
        FileInputStream fis = null;
        response.setContentType("image/gif");
        try
        {
            String imagePath = "";
            OutputStream out = response.getOutputStream();
            File file = new File(imagePath);
            fis = new FileInputStream(file);
            byte[] b = new byte[fis.available()];
            fis.read(b);
            out.write(b);
            out.flush();
        }
        catch (IOException e)
        {
            e.printStackTrace();
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
}
