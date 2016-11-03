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
 * �ļ����������
 * 
 * FileController.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��19�� ����7:28:54
 * @author liulong
 */
@Controller
@RequestMapping("/file")
public class FileController
{
    private static Logger logger = LoggerFactory.getLogger(FileController.class);

    /**
     * ��Դ�ļ�·��
     */
    @Value("#{properties['root.upload.path']}")
    private String rootUploadPath;

    /**
     * �ļ��ӿ�
     */
    @Resource
    private FileInfoService fileInfoService;

    /**
     * ����ͼ���id ��ȡͼ��
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
            // ��ѯ�ļ�������ļ�·��
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
            // logger.error("��ȡ����ʧ��", e.getMessage());
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
     * @Description: ��ǰ̨�����ʾͼƬ
     * @param imgSrc
     *            ͼƬ·��
     * @param request
     *            HttpServletRequest
     * @param response
     *            HttpServletResponse
     * @Version v1.0
     * @author s54322/sunyue
     * @Date 2016��5��19��
     */
    @RequestMapping(value = "/imageshow")
    public void showImage(@RequestParam(value = "s") String imgSrc, HttpServletRequest request,
            HttpServletResponse response)
    {
        FileInputStream is;
        try
        {
            is = new FileInputStream(rootUploadPath + new String(imgSrc.getBytes("iso-8859-1"), "utf-8"));
            int i = is.available(); // �õ��ļ���С
            byte[] data = new byte[i];
            is.read(data); // ������
            is.close();
            response.setContentType("image/*"); // ���÷��ص��ļ�����
            OutputStream toClient = response.getOutputStream(); // �õ���ͻ���������������ݵĶ���
            toClient.write(data); // �������
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
