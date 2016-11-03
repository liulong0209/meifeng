package net.beautifycrack.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;

/**
 * 上传工具类
 * 
 * @ClassName: UploadUtils
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author s54322/sunyue
 *
 */
public class UploadUtils
{
    /**
     * 日期格式化对象
     */
    public static final String MONTH_FORMAT = "/yyyyMM/ddHHmmss";

    /**
     * 日期格式化对象
     */
    public static final String DAY_FORMAT = "/yyyyMMdd/HHmmss";

    /**
     * 日期格式化对象
     */
    public static final String YEAR_MONTH_FORMAT = "yyyyMM";

    /**
     * 日期格式化对象
     */
    public static final String YEAR_DAY_FORMAT = "yyyyMMdd";

    /**
     * 日期格式化对象
     */
    public static final String YEAR_MON_DAY_FORMAT = "yyyy-MM-dd";

    /**
     * 随机数长度
     */
    private static final int RANDOM_COUNT = 4;

    /**
     * 
     * @Title: generateFilename
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param path
     *            路径
     * @param ext
     *            扩展名
     * @return String
     * @Version v1.0
     * @author s54322/sunyue
     * @Date 2016年5月19日
     */
    public static String generateFilename(String path, String ext)
    {
        return path + getMonthFormat().format(new Date()) + RandomStringUtils.random(RANDOM_COUNT, Num62.N36_CHARS)
                + "." + ext;
    }

    /**
     * 
     * @Title: generateFilenameByDay
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param path
     *            路径
     * @param ext
     *            扩展名
     * @return String
     * @Version v1.0
     * @author s54322/sunyue
     * @Date 2016年5月20日
     */
    public static String generateFilenameByDay(String path, String ext)
    {
        return path + getDayFormat().format(new Date()) + RandomStringUtils.random(RANDOM_COUNT, Num62.N36_CHARS) + "."
                + ext;
    }

    /**
     * 
     * @Title: generateMonthname
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @return String
     * @Version v1.0
     * @author s54322/sunyue
     * @Date 2016年5月19日
     */
    public static String generateMonthname()
    {
        return getYearMonDayFormat().format(new Date());
    }

    /**
     * 
     * @Title: generateByFilename
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param path
     *            String
     * @param fileName
     *            String
     * @param ext
     *            String
     * @return String
     * @Version v1.0
     * @author s54322/sunyue
     * @Date 2016年5月19日
     */
    public static String generateByFilename(String path, String fileName, String ext)
    {
        return path + fileName + "." + ext;
    }

    /**
     * ILLEGAL_CURRENT_FOLDER_PATTERN
     */
    protected static final Pattern ILLEGAL_CURRENT_FOLDER_PATTERN = Pattern
            .compile("^[^/]|[^/]$|/\\.{1,2}|\\\\|\\||:|\\?|\\*|\"|<|>|\\p{Cntrl}");

    /**
     * Sanitizes a filename from certain chars.<br />
     * 
     * This method enforces the <code>forceSingleExtension</code> property and
     * then replaces all occurrences of \, /, |, :, ?, *, &quot;, &lt;, &gt;,
     * control chars by _ (underscore).
     * 
     * @param filename
     *            a potentially 'malicious' filename
     * @return sanitized filename
     */
    public static String sanitizeFileName(final String filename)
    {

        if (StringUtils.isBlank(filename))
        {
            return filename;
        }

        String name = forceSingleExtension(filename);

        // Remove \ / | : ? * " < > 'Control Chars' with _
        return name.replaceAll("\\\\|/|\\||:|\\?|\\*|\"|<|>|\\p{Cntrl}", "_");
    }

    /**
     * Sanitizes a folder name from certain chars.<br />
     * 
     * This method replaces all occurrences of \, /, |, :, ?, *, &quot;, &lt;,
     * &gt;, control chars by _ (underscore).
     * 
     * @param folderName
     *            a potentially 'malicious' folder name
     * @return sanitized folder name
     */
    public static String sanitizeFolderName(final String folderName)
    {

        if (StringUtils.isBlank(folderName))
        {
            return folderName;
        }

        // Remove . \ / | : ? * " < > 'Control Chars' with _
        return folderName.replaceAll("\\.|\\\\|/|\\||:|\\?|\\*|\"|<|>|\\p{Cntrl}", "_");
    }

    /**
     * Checks whether a path complies with the FCKeditor File Browser <a href=
     * "http://docs.fckeditor.net/FCKeditor_2.x/Developers_Guide/Server_Side_Integration#File_Browser_Requests"
     * target="_blank">rules</a>.
     * 
     * @param path
     *            a potentially 'malicious' path
     * @return <code>true</code> if path complies with the rules, else
     *         <code>false</code>
     */
    public static boolean isValidPath(final String path)
    {
        if (StringUtils.isBlank(path))
        {
            return false;
        }

        if (ILLEGAL_CURRENT_FOLDER_PATTERN.matcher(path).find())
        {
            return false;
        }

        return true;
    }

    /**
     * Replaces all dots in a filename with underscores except the last one.
     * 
     * @param filename
     *            filename to sanitize
     * @return string with a single dot only
     */
    public static String forceSingleExtension(final String filename)
    {
        return filename.replaceAll("\\.(?![^.]+$)", "_");
    }

    /**
     * Checks if a filename contains more than one dot.
     * 
     * @param filename
     *            filename to check
     * @return <code>true</code> if filename contains severals dots, else
     *         <code>false</code>
     */
    public static boolean isSingleExtension(final String filename)
    {
        return filename.matches("[^\\.]+\\.[^\\.]+");
    }

    /**
     * Checks a directory for existence and creates it if non-existent.
     * 
     * @param dir
     *            directory to check/create
     */
    public static void checkDirAndCreate(File dir)
    {
        if (!dir.exists())
        {
            dir.mkdirs();
        }
    }

    /**
     * Iterates over a base name and returns the first non-existent file.<br />
     * This method extracts a file's base name, iterates over it until the first
     * non-existent appearance with <code>basename(n).ext</code>. Where n is a
     * positive integer starting from one.
     * 
     * @param file
     *            base file
     * @return first non-existent file
     */
    public static File getUniqueFile(final File file)
    {
        if (!file.exists())
        {
            return file;
        }

        File tmpFile = new File(file.getAbsolutePath());
        File parentDir = tmpFile.getParentFile();
        int count = 1;
        String extension = FilenameUtils.getExtension(tmpFile.getName());
        String baseName = FilenameUtils.getBaseName(tmpFile.getName());
        do
        {
            tmpFile = new File(parentDir, baseName + "(" + count++ + ")." + extension);
        }
        while (tmpFile.exists());
        return tmpFile;
    }

    /**
     * 写入文件至服务器
     * 
     * @Title: generateFile
     * @Description: 生成文件
     * @param path
     *            文件路径
     * @param filename
     *            文件全名
     * @param in
     *            文件输入流 void
     * @Version v1.0
     * @author s54322/sunyue
     * @Date 2016年5月19日
     */
    public static void generateFileInPath(String path, String filename, InputStream in)
    {
        // 写入文件目录
        byte[] content;
        File file;
        File dir;
        try
        {
            file = new File(path + filename);
            // 目录不存在先创建目录
            dir = new File(file.getParent());
            if (!dir.exists())
            {
                dir.mkdirs();
            }

            content = IOUtils.toByteArray(in);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(content);
            fos.flush();
            fos.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 获取日期值
     * 
     * @Title: getDayName
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @return String
     * @Version v1.0
     * @author s54322/sunyue
     * @Date 2016年5月19日
     */
    public static String getDayName()
    {
        return getYearDayFormat().format(new Date());
    }

    /**
     * @return the monthFormat /yyyyMM/ddHHmmss
     */
    public static DateFormat getMonthFormat()
    {
        return new SimpleDateFormat(MONTH_FORMAT);
    }

    /**
     * @return the dayFormat /yyyyMMdd/HHmmss
     */
    public static DateFormat getDayFormat()
    {
        return new SimpleDateFormat(DAY_FORMAT);
    }

    /**
     * @return the yearMonthFormat yyyyMM
     */
    public static DateFormat getYearMonthFormat()
    {
        return new SimpleDateFormat(YEAR_MONTH_FORMAT);
    }

    /**
     * @return the yearDayFormat yyyyMMdd
     */
    public static DateFormat getYearDayFormat()
    {
        return new SimpleDateFormat(YEAR_DAY_FORMAT);
    }

    /**
     * @return the yearMonDayFormat yyyy-MM-dd
     */
    public static DateFormat getYearMonDayFormat()
    {
        return new SimpleDateFormat(YEAR_MON_DAY_FORMAT);
    }
}
