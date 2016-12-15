package net.beautifycrack.exception;

/**
 * �Զ����쳣
 * 
 * BusinessException.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��14�� ����3:33:29
 * @author liulong
 */
public class BusinessException extends Exception
{

    private static final long serialVersionUID = 1L;

    /**
     * ������
     */
    private Integer errorCode;

    public Integer getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode)
    {
        this.errorCode = errorCode;
    }

    public BusinessException()
    {
    }

    public BusinessException(String msg)
    {
        super(msg);
    }

    public BusinessException(Integer code)
    {
        super();
        this.errorCode = code;
    }

    public BusinessException(String msg, Integer code)
    {
        super(msg);
        this.errorCode = code;
    }

    public BusinessException(String msg, Throwable cause, Integer code)
    {
        super(msg, cause);
        this.errorCode = code;
    }

    public BusinessException(String msg, Throwable cause)
    {
        super(msg, cause);
    }

}