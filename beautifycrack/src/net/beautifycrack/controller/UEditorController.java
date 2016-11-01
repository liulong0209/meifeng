package net.beautifycrack.controller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

@Controller
public class UEditorController
{

    /**
     * ��־��¼��
     */
    private static final Logger LOG = LoggerFactory.getLogger(UEditorController.class);

    /**
     * ״̬
     */
    private static final String STATE = "state";

    /**
     * �ϴ��ɹ�
     */
    private static final String SUCCESS = "SUCCESS";

    /**
     * URL
     */
    private static final String URL = "url";

    /**
     * �ļ�����
     */
    private static final String FILE_TYPE = "fileType";

    /**
     * �ļ�ԭ��
     */
    private static final String ORIGINAL = "original";

    /**
     * ����
     */
    private static final String TITLE = "title";

    /**
     * Ĭ�Ϸַ�action����
     */
    private static final String DEFAULT_ACTION_NAME = "config";

    /**
     * Ĭ���ϴ�����
     */
    private static final String DEFAULT_TYPE = "file";

    /**
     * �����ļ����ͺ�׺
     */
    private static final String ALLOW_FILES_SUFFIX = "AllowFiles";

    /**
     * �����ļ���С��׺
     */
    private static final String ALLOW_MAX_SIZE = "MaxSize";

    /**
     * 1mb - 1024kb
     */
    private static final int MB_KB = 1024;

    /**
     * ueditor�����ļ�
     */
    private Map<String, Object> config = new HashMap<String, Object>();

    public void setConfig(Map<String, Object> config)
    {
        this.config = config;
    }

    @Value("#{properties['ue.config.path']}")
    private String ueConfigPath;

    /**
     * UEditor�ϴ�����ַ���
     * 
     * @param actionName
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/ueditor")
    public String dispatcher(@RequestParam(value = "action", required = false) String actionName,
            HttpServletRequest request, HttpServletResponse response)
    {
        String action = actionName;
        if (StringUtils.isEmpty(action))
        {
            action = DEFAULT_ACTION_NAME;
        }
        return "forward:ueditor/" + action;
    }

    /**
     * ����Http��Ӧͷ��Ϣ
     * 
     * @Title: responseInit
     * @Description: TODO(������һ�仰�����������������)
     * @param response
     *            Http��Ӧ
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
     * @Description: ��UEditorǰ�˷��������ļ�
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
    @RequestMapping(value = "/ueditor/config")
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
     * �ļ��ϴ�
     * 
     * @Title: uploadFile
     * @Description: ����(�ı���ͼƬ������Ƶ�ļ���)
     * @param action
     *            �ϴ�����
     * @param mark
     *            ��������
     * @param request
     *            HttpServletRequest
     * @param response
     *            HttpServletResponse
     * @throws Exception
     *             void
     * @Version v1.0
     */
    @RequestMapping(value = { "/ueditor/uploadfile", "/ueditor/uploadimage", "/ueditor/uploadvideo",
            "/ueditor/uploadscrawl" }, method = RequestMethod.POST)
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
     * �ϴ��ļ�У��
     * 
     * @Title: validateUpload
     * @Description: TODO(������һ�仰�����������������)
     * @param request
     *            HttpServletRequest
     * @param type
     *            �ļ�����
     * @return JSONObject
     * @throws JSONException
     *             JSONObject
     * @Version v1.0
     * @author s54322/sunyue
     * @Date 2016��5��18��
     */
    private JSONObject validateUpload(HttpServletRequest request, String type) throws JSONException
    {
        JSONObject result = new JSONObject();
        MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
        MultipartFile upFile = mRequest.getFileMap().entrySet().iterator().next().getValue();
        String fileName = FilenameUtils.getName(upFile.getOriginalFilename());
        int fileSize = (int) (upFile.getSize() / MB_KB);
        String ext = FilenameUtils.getExtension(fileName).toLowerCase(Locale.ENGLISH);

        // ������ĺ�׺
        if (!isAllowSuffix(type, ext))
        {
            result.put(STATE, "��֧�ֵ��ļ���ʽ");
            return result;
        }

        // ����������С����
        if (!isAllowMaxFile(type, fileSize))
        {
            result.put(STATE, "�����������" + config.get(type + ALLOW_MAX_SIZE) + "kb");
            return result;
        }
        // ����ÿ���ϴ�����

        // �������ϴ�����
        return null;
    }

    /**
     * 
     * @Title: isAllowSuffix
     * @Description: �Ƿ�����ĺ�׺
     * @param type
     *            �ϴ��ļ�����
     * @param ext
     *            ��չ��
     * @return boolean
     * @Version v1.0
     * @author s54322/sunyue
     * @Date 2016��5��19��
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
     * ִ���ļ��ϴ�
     * 
     * @Title: doUpload
     * @Description: TODO(������һ�仰�����������������)
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
     * @author s54322/sunyue
     * @Date 2016��5��18��
     */
    private JSONObject doUpload(HttpServletRequest request, String type, Boolean mark) throws Exception
    {
        @SuppressWarnings("deprecation")
        JSONObject result = new JSONObject();
        // MultipartHttpServletRequest multipartRequest =
        // (MultipartHttpServletRequest) request;
        // MultipartFile uplFile =
        // multipartRequest.getFileMap().entrySet().iterator().next().getValue();
        // // filename
        // String filename =
        // FilenameUtils.getName(uplFile.getOriginalFilename());
        // LOG.debug("Parameter NewFile: {}", filename);
        // String ext = FilenameUtils.getExtension(filename);
        //
        // String fileUrl="http://localhost:8080/mf/style/images/logo.png";

        // result.put(STATE, SUCCESS);
        // result.put(URL, fileUrl);
        // result.put(ORIGINAL, filename);
        // result.put(TITLE, filename);
        // result.put(FILE_TYPE, "." + ext);
        result.put(STATE, SUCCESS);
        result.put(URL, "http://localhost:8080/mf/style/images/logo.png");
        result.put(ORIGINAL, "test");
        result.put(TITLE, "test");
        result.put(FILE_TYPE, "." + "png");
        return result;
    }

    /**
     * ����json��ʹ��UTF-8���롣
     * 
     * @param response
     *            HttpServletResponse
     * @param text
     *            ���͵��ַ���
     */
    private void renderJson(HttpServletResponse response, String text)
    {
        render(response, "application/json;charset=UTF-8", text);
    }

    /**
     * �������ݡ�ʹ��UTF-8���롣
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
     * @Description: �Ƿ񳬳����ƴ�С
     * @param type
     *            �ϴ�����
     * @param size
     *            �ļ���С
     * @return boolean
     * @Version v1.0
     * @author s54322/sunyue
     * @Date 2016��5��19��
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
