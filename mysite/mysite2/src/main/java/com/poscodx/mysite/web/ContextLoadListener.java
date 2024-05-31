package com.poscodx.mysite.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoadListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce)  {
		ServletContext sc = sce.getServletContext();
		var contextConfigLocation = sc.getInitParameter("contextConfigLocation");
		System.out.println("Application[MySite2] starts..." + contextConfigLocation);
	}
	
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
}
