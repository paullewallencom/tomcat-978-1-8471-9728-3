package com.swengsol.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class MyFilter implements Filter {
  private FilterConfig fc;
  public void init(FilterConfig config) throws ServletException {
    this.fc = config;
    System.out.println("> Filter: " + "Initializing filter");
  }
  public void destroy() {
  }
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    System.out.println("> Filter: " + req.getRequestURI());
    String name = req.getRemoteUser();
    if (name != null) {
      System.out.println("> Filter: " + "User " + name);
      fc.getServletContext().log("User " + name + " is doing something.");
    }
    chain.doFilter(request, response);
  }
}
