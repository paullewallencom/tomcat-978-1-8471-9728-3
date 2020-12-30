package com.swengsol;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swengsol.helpers.Message;
public class HelloWorldServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      out.println("<html>");
      out.println("<head>");
      String title = "Hello World - Tomcat Developer's Guide";
      out.println("<title>" + title + "</title>");
      out.println("</head>");
      out.println("<body bgcolor = \"white\">");
      Message msg = new Message();
      msg.setMessage("Hello World - Tomcat Developer's Guide");
      out.println("<h1> "+ msg.getMessage() + "</h1>");

      URL u = getServletContext().getResource("/index.html");
      out.println("URL for the resource <i>/index.html</i> is " + u);
      out.println("<p />");

      out.println("Servlet initialization parameter: ");
      out.println(getServletContext().getInitParameter("contextVariable"));
      out.println("</body>");
      out.println("</html>");
  }
}
