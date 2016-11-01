package net.beautifycrack.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 存储当前上下文根
 * 
 * ContextPathListener.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月20日 下午8:22:51
 * @author liulong
 */
public class ContextPathListener implements ServletContextListener
{

    @Override
    public void contextDestroyed(ServletContextEvent contextEvent)
    {
        ServletContext sc = contextEvent.getServletContext();
        sc.removeAttribute("contextPath");
    }

    @Override
    public void contextInitialized(ServletContextEvent contextEvent)
    {
        ServletContext sc = contextEvent.getServletContext();
        sc.setAttribute("contextPath", sc.getContextPath());

    }
}
