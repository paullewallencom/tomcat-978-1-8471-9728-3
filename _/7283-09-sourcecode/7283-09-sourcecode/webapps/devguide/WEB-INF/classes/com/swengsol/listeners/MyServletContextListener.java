package com.swengsol.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
public class MyServletContextListener implements ServletContextListener {
  public void contextDestroyed(ServletContextEvent sce) {
    System.out.println("> Servlet Context Listener: " + "Context Destroyed");
  }
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("> Servlet Context Listener: " + "Context initialized");
  }
}
