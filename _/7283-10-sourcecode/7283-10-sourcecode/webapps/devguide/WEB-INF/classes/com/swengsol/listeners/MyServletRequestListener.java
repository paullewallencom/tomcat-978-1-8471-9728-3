package com.swengsol.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
public class MyServletRequestListener implements ServletRequestListener {
  public void requestDestroyed(ServletRequestEvent sre) {
    System.out.println("> Servlet Request Listener: " + "Request Destroyed");
  }
  public void requestInitialized(ServletRequestEvent sre) {
    System.out.println("> Servlet Request Listener: " + "Request Initialized");
  }
}
