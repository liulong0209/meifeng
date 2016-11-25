package net.beautifycrack.controller;

import static net.beautifycrack.constant.Common.IMG_SHOW_URL;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.beautifycrack.service.FileInfoService;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * UEditor控制器
 * 
 * UEditorController.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年11月3日 下午3:35:10
 * @author liulong
 */
@Controller
public class UEditorController
{

    /**
     * 日志记录器
     */
    private static final Logger LOG = LoggerFactory.getLogger(UEditorController.class);

    /**
     * 状态
     */
    private static final String STATE = "state";

    /**
     * 上传成功
     */
    private static final String SUCCESS = "SUCCESS";

    /**
     * URL
     */
    private static final String URL = "url";

    /**
     * 文件类型
     */
    private static final String FILE_TYPE = "fileType";

    /**
     * 文件原名
     */
    private static final String ORIGINAL = "original";

    /**
     * 标题
     */
    private static final String TITLE = "title";

    /**
     * 默认分发action名称
     */
    private static final String DEFAULT_ACTION_NAME = "config";

    /**
     * 默认上传类型
     */
    private static final String DEFAULT_TYPE = "file";

    /**
     * 允许文件类型后缀
     */
    private static final String ALLOW_FILES_SUFFIX = "AllowFiles";

    /**
     * 允许文件大小后缀
     */
    private static final String ALLOW_MAX_SIZE = "MaxSize";

    /**
     * 1mb - 1024kb
     */
    private static final int MB_KB = 1024;

    /**
     * ueditor配置文件
     */
    private Map<String, Object> config = new HashMap<String, Object>();

    public void setConfig(Map<String, Object> config)
    {
        this.config = config;
    }

    /**
     * 上传文件根路径
     */
    @Value("#{properties['root.upload.path']}")
    private String uploadPath;

    /**
     * ueditor配置文件路径
     */
    @Value("#{properties['ue.config.path']}")
    private String ueConfigPath;

    /**
     * 上传路径
     */
    @Value("#{properties['ue.upload.path']}")
    private String ueUploadPath;

    /**
     * 文件接口
     */
    @Resource
    private FileInfoService fileInfoService;

    /**
     * UEditor上传请求分发器
     * 
     * @param actionName
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/ueditor.do")
    public String dispatcher(@RequestParam(value = "action", required = false) String actionName,
            HttpServletRequest request, HttpServletResponse response)
    {
        String action = actionName;
        if (StringUtils.isEmpty(action))
        {
            action = DEFAULT_ACTION_NAME;
        }
        return "forward:ueditor/" + action + ".do";
    }

    /**
     * 设置Http响应头信息
     * 
     * @Title: responseInit
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param response
     *            Http响应
     * @Version v1.0
     */
    private void responseInit(HttpServletResponse response)
    {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setHeader("Cache-Control", "no-cache");
    }

    /**
     * 
     * @Title: config
     * @Description: 给UEditor前端返回配置文件
     * @param action
     *            action
     * @param request
     *            HttpServletRequest
     * @param response
     *            HttpServletResponse
     * @return Map<String,Object>
     * @Version v1.0
     */
    @ResponseBody
    @RequestMapping(value = "/ueditor/config.do")
    public Map<String, Object> config(@RequestParam(value = "action", required = false) String action,
            HttpServletRequest request, HttpServletResponse response)
    {
        responseInit(response);
        @SuppressWarnings("deprecation")
        String fullFileName = request.getRealPath(ueConfigPath);
        Reader reader = null;
        Gson gson = new Gson();

        try
        {
            reader = new FileReader(new File(fullFileName));
            config = gson.fromJson(reader, new TypeToken<Map<String, Object>>()
            {
            }.getType());
            reader.close();
        }
        catch (IOException e)
        {
            LOG.error("close reader occurrence an error : " + e.getMessage());
        }
        return config;
    }

    /**
     * 文件上传
     * 
     * @Title: uploadFile
     * @Description: 包括(文本、图片、音视频文件等)
     * @param action
     *            上传类型
     * @param mark
     *            生成缩略
     * @param request
     *            HttpServletRequest
     * @param response
     *            HttpServletResponse
     * @throws Exception
     *             void
     * @Version v1.0
     */
    @RequestMapping(value = { "/ueditor/uploadfile.do", "/ueditor/uploadimage.do", "/ueditor/uploadvideo.do",
            "/ueditor/uploadscrawl.do" }, method = RequestMethod.POST)
    public void uploadFile(@RequestParam(value = "action", required = false) String action, Boolean mark,
            HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        responseInit(response);
        String type = action;
        Boolean markFlag = mark;
        if (StringUtils.isEmpty(type))
        {
            type = DEFAULT_TYPE;
        }
        else
        {
            type = type.replaceFirst("upload", "");
        }
        if (null == markFlag)
        {
            markFlag = false;
        }
        JSONObject json = new JSONObject();
        JSONObject ob = validateUpload(request, type);
        if (null == ob)
        {
            json = doUpload(request, type, markFlag);
        }
        else
        {
            json = ob;
        }
        renderJson(response, json.toString());
    }

    /**
     * 上传文件校验
     * 
     * @Title: validateUpload
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param request
     *            HttpServletRequest
     * @param type
     *            文件类型
     * @return JSONObject
     * @throws JSONException
     *             JSONObject
     * @Version v1.0
     * @Date 2016年5月18日
     */
    private JSONObject validateUpload(HttpServletRequest request, String type) throws JSONException
    {
        JSONObject result = new JSONObject();
        MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
        MultipartFile upFile = mRequest.getFileMap().entrySet().iterator().next().getValue();
        String fileName = FilenameUtils.getName(upFile.getOriginalFilename());
        int fileSize = (int) (upFile.getSize() / MB_KB);
        String ext = FilenameUtils.getExtension(fileName).toLowerCase(Locale.ENGLISH);

        // 非允许的后缀
        if (!isAllowSuffix(type, ext))
        {
            result.put(STATE, "不支持的文件格式");
            return result;
        }

        // 超出附件大小限制
        if (!isAllowMaxFile(type, fileSize))
        {
            result.put(STATE, "超出最大限制" + config.get(type + ALLOW_MAX_SIZE) + "kb");
            return result;
        }
        // 超出每日上传限制

        // 非允许上传类型
        return null;
    }

    /**
     * 
     * @Title: isAllowSuffix
     * @Description: 是否允许的后缀
     * @param type
     *            上传文件类型
     * @param ext
     *            扩展名
     * @return boolean
     * @Version v1.0
     * @Date 2016年5月19日
     */
    @SuppressWarnings("unchecked")
    private boolean isAllowSuffix(String type, String ext)
    {
        if (StringUtils.isBlank(type))
        {
            return true;
        }

        List<String> types = (List<String>) config.get(type + ALLOW_FILES_SUFFIX);
        if (CollectionUtils.isEmpty(types))
        {
            return true;
        }
        for (String suffix : types)
        {
            if ((FilenameUtils.EXTENSION_SEPARATOR_STR + ext).equalsIgnoreCase(suffix))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * 执行文件上传
     * 
     * @Title: doUpload
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param request
     *            HttpServletRequest
     * @param typeStr
     *            String
     * @param mark
     *            Boolean
     * @return JSONObject
     * @throws Exception
     *             JSONObject
     * @Version v1.0
     * @Date 2016年5月18日
     */
    private JSONObject doUpload(HttpServletRequest request, String type, Boolean mark) throws Exception
    {
        JSONObject result = new JSONObject();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile uplFile = multipartRequest.getFileMap().entrySet().iterator().next().getValue();
        // filename
        String filename = FilenameUtils.getName(uplFile.getOriginalFilename());
        LOG.debug("Parameter NewFile: {}", filename);
        String ext = FilenameUtils.getExtension(filename);

        String fileUrl = fileInfoService.uploadFile(uploadPath, ueUploadPath, ext, filename, uplFile.getInputStream(),
                "filename");

        fileUrl = request.getContextPath() + IMG_SHOW_URL + fileUrl;

        result.put(STATE, SUCCESS);
        result.put(URL, fileUrl);
        result.put(ORIGINAL, filename);
        result.put(TITLE, filename);
        result.put(FILE_TYPE, "." + ext);
        return result;
    }

    /**
     * 发送json。使用UTF-8编码。
     * 
     * @param response
     *            HttpServletResponse
     * @param text
     *            发送的字符串
     */
    private void renderJson(HttpServletResponse response, String text)
    {
        render(response, "application/json;charset=UTF-8", text);
    }

    /**
     * 发送内容。使用UTF-8编码。
     * 
     * @param response
     * @param contentType
     * @param text
     */
    private void render(HttpServletResponse response, String contentType, String text)
    {
        response.setContentType(contentType);
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        try
        {
            response.getWriter().write(text);
        }
        catch (IOException e)
        {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * 
     * @Title: isAllowMaxFile
     * @Description: 是否超出限制大小
     * @param type
     *            上传类型
     * @param size
     *            文件大小
     * @return boolean
     * @Version v1.0
     * @Date 2016年5月19日
     */
    private boolean isAllowMaxFile(String type, int size)
    {
        if (StringUtils.isBlank(type))
        {
            return true;
        }
        if (0 == size)
        {
            return true;
        }
        Double allowSize = (Double) config.get(type + ALLOW_MAX_SIZE);
        return allowSize > size;
    }
}
