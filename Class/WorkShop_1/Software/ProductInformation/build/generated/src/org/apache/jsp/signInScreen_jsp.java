package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signInScreen_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("  <head>\n");
      out.write("    <meta charset=\"UTF-8\" />\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE-edge\" />\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
      out.write("    <title>Document</title>\n");
      out.write("    <!-- Latest compiled and minified CSS -->\n");
      out.write("    <link\n");
      out.write("      rel=\"stylesheet\"\n");
      out.write("      href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\"\n");
      out.write("    />\n");
      out.write("\n");
      out.write("    <!-- jQuery library -->\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Latest compiled JavaScript -->\n");
      out.write("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n");
      out.write("    <link rel=\"stylesheet\" href=\"newAccount.css\" />\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <h2>Add new account</h2>\n");
      out.write("      <form class=\"form-horizontal\" action=\"#\" method=\"post\">\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <label class=\"control-label col-sm-2\" for=\"account\">Account</label>\n");
      out.write("          <div class=\"col-sm-10\">\n");
      out.write("            <input\n");
      out.write("              type=\"text\"\n");
      out.write("              class=\"form-control\"\n");
      out.write("              name=\"account\"\n");
      out.write("              placeholder=\"Enter email\"\n");
      out.write("            />\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <label class=\"control-label col-sm-2\" for=\"pass\">Password</label>\n");
      out.write("          <div class=\"col-sm-10\">\n");
      out.write("            <input\n");
      out.write("              type=\"password\"\n");
      out.write("              class=\"form-control\"\n");
      out.write("              placeholder=\"Enter password\"\n");
      out.write("              name=\"pass\"\n");
      out.write("            />\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <label class=\"control-label col-sm-2\" for=\"lastName\">Last name</label>\n");
      out.write("          <div class=\"col-sm-10\">\n");
      out.write("            <input\n");
      out.write("              type=\"text\"\n");
      out.write("              class=\"form-control\"\n");
      out.write("              name=\"lastName\"\n");
      out.write("              placeholder=\"Last name\"\n");
      out.write("            />\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <label class=\"control-label col-sm-2\" for=\"firstName\"\n");
      out.write("            >First name</label\n");
      out.write("          >\n");
      out.write("          <div class=\"col-sm-10\">\n");
      out.write("            <input\n");
      out.write("              type=\"text\"\n");
      out.write("              class=\"form-control\"\n");
      out.write("              name=\"firstName\"\n");
      out.write("              placeholder=\"First name\"\n");
      out.write("            />\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <label class=\"control-label col-sm-2\" for=\"phone\">Phone number</label>\n");
      out.write("          <div class=\"col-sm-10\">\n");
      out.write("            <input\n");
      out.write("              type=\"tel\"\n");
      out.write("              class=\"form-control\"\n");
      out.write("              name=\"phone\"\n");
      out.write("              placeholder=\"Phone number\"\n");
      out.write("            />\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <label class=\"control-label col-sm-2\" for=\"birthDay\">Birth day</label>\n");
      out.write("          <div class=\"col-sm-10\">\n");
      out.write("            <input type=\"date\" class=\"form-control\" name=\"birthDay\" />\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <label class=\"control-label col-sm-2\">Gender</label>\n");
      out.write("          <div class=\"col-sm-10\">\n");
      out.write("            <div class=\"form-check form-check-inline\">\n");
      out.write("              <label class=\"gender-radio\"\n");
      out.write("                ><input type=\"radio\" name=\"gender\" checked /> Male</label\n");
      out.write("              >\n");
      out.write("              <label class=\"gender-radio\"\n");
      out.write("                ><input type=\"radio\" name=\"gender\" /> Female</label\n");
      out.write("              >\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <label class=\"control-label col-sm-2\" for=\"role\"\n");
      out.write("            >Role in system</label\n");
      out.write("          >\n");
      out.write("          <div class=\"col-sm-10\">\n");
      out.write("            <select class=\"form-control\" name=\"role\">\n");
      out.write("              <option>Administrator</option>\n");
      out.write("              <option>Staff</option>\n");
      out.write("            </select>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <div class=\"col-sm-offset-2 col-sm-10\">\n");
      out.write("            <div class=\"checkbox\">\n");
      out.write("              <label><input type=\"checkbox\" name=\"isActive\" />Is active</label>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <div class=\"col-sm-offset-2 col-sm-10\">\n");
      out.write("            <button type=\"submit\" class=\"btn btn-default\">Submit</button>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </form>\n");
      out.write("    </div>\n");
      out.write("  </body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
