package com.swengsol;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.DataSource;

public class ContactListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>" + "Contacts List-MySQL" + "</title>");
    out.println("</head>");
    out.println("<body bgcolor = \"white\">");
    out.println("<a href = \"index.html\">");
    out.println("Return</a>");
    try {
      String caption = (String) new InitialContext().lookup("java:comp/env/contactsTableCaption");
      out.println("<h1>" + caption  + "</h1>");
      out.println("<p>");

      Context myctx = new InitialContext();
      DataSource myDS = (DataSource) myctx.lookup("java:comp/env/jdbc/swengsolDB");
      Connection myConnection = myDS.getConnection();
      myConnection.setAutoCommit(false);
      Statement stmt = myConnection.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT firstname, lastname, email FROM contacts");
      out.println("<table>");
      while (rs.next()) {
        out.println("<tr>");
        String firstname = rs.getString("firstname");
        String lastname = rs.getString("lastname");
        String email = rs.getString("email");
        out.println("<td>" + firstname + "</td> <td>" + lastname + "</td><td> " + email + "</td>");
        out.println("</tr>");
      }
      out.println("</table>");
      myConnection.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    out.println("<p>");
    out.println("</body>");
    out.println("</html>");
  }
}
