package net.beautifycrack.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * �洢��ǰ�����ĸ�
 * 
 * ContextPathListener.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��20�� ����8:22:51
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
