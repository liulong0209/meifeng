package net.beautifycrack.constant;

public class Common
{
    /**
     * 分页每页默认显示数量
     */
    public static final Integer PAGE_SIZE_DEFAULT = 10;

    public static final Integer PAGE_SIZE_THIRTY = 30;

    public static final Integer PAGE_SIZE_Eighteen = 18;

    /**
     * 产品类型 0工具 1材料
     */
    public static final Integer PRODUCT_TOOLS = 0;
    public static final Integer PRODUCT_MATERIAL = 1;

    /**
     * 用户相关常量
     */
    /**
     * 用户不存在
     */
    public static final Integer USERINFO_NOT_EXISTS = 10000;

    /**
     * 密码错误
     */
    public static final Integer USERINFO_PASSWORD_ERROR = 10001;

    /**
     * 成功标示
     */
    public static final Integer SUCCESS = 0;

    /**
     * 失败标示
     */
    public static final Integer FAIL = 1;

    /**
     * 草稿
     */
    public static final int DRAFT = 0;

    /**
     * 发布
     */
    public static final int PUBLISH = 1;

    /**
     * 新闻编辑增加的图片
     */
    public static final int FILE_UPLPADER_NEWS = -2;

    /**
     * 图片访问URL
     */
    public static final String IMG_SHOW_URL = "/file/imageshow?s=";

}
