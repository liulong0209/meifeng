package net.beautifycrack.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.beautifycrack.module.UserInfo;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * �ж��û��Ƿ��¼
 * 
 * SessionInterceptor.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��11��24�� ����7:49:35
 * @author liulong
 */
public class SessionInterceptor implements HandlerInterceptor
{

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception e)
            throws Exception
    {

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView mv)
            throws Exception
    {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception
    {
        UserInfo user = (UserInfo) request.getSession().getAttribute("userInfo");
        if (user == null)
        {
            String requestType = request.getHeader("X-Requested-With");
            // �����ajax����
            if ("XMLHttpRequest".equalsIgnoreCase(requestType))
            {
                response.setHeader("sessionstatus", "timeout");
                response.setHeader("loginPath", request.getContextPath());
            }
            else
            {
                response.sendRedirect(request.getContextPath());
            }
        }
        return true;
    }

}
