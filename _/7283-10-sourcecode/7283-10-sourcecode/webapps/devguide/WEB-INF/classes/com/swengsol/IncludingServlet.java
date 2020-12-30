package com.swengsol;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IncludingServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    String servletName = "TemplateGenerator";
    out.println("<html>");
    out.println("<head>");

    out.println("<title>" + "Including Servlet" + "</title>");
    out.println("</head>");
    out.println("<body bgcolor=\"white\">");

    request.setAttribute("bannerType", "header");
    request.getRequestDispatcher(servletName).include(request, response);

    out.println("<h3> Including Servlet </h3>");
    out.println("<p>");

    request.getRequestDispatcher("main.html").include(request, response);

    request.removeAttribute("bannerType");

    String resource = "?bannerType=file&resource=secondary.html";
    request.getRequestDispatcher(servletName + resource).include(request, response);
    resource = "?bannerType=footer";
    request.getRequestDispatcher(servletName + resource).include(request,response);

    out.println("</body>");
    out.println("</html>");
  }
}
