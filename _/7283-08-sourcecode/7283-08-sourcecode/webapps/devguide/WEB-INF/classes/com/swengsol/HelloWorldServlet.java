package com.swengsol;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class HelloWorldServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
      if (true) throw new IllegalArgumentException("Illegal call");
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      out.println("<html>");
      out.println("<head>");
      String title = "Hello World - Tomcat Developer's Guide";
      out.println("<title>" + title + "</title>");
      out.println("</head>");
      out.println("<body bgcolor = \"white\">");
      out.println("<h1>Hello World from the Developer's Guide!</h1>");
      out.println("</body>");
      out.println("</html>");
  }
}
