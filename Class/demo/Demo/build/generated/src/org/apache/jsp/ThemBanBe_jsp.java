package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ThemBanBe_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <!-- Latest compiled and minified CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("        <!-- jQuery library -->\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Latest compiled JavaScript -->\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body class=\"container\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-md-12\">\n");
      out.write("                <h1>Chức năng thêm bạn mới</h1>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-md-4\">\n");
      out.write("                <img style=\"width: 100%\" src=\"Images/addFriend.png\" alt=\"\"/>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-8\">\n");
      out.write("                <form action=\"addFriend\" method=\"post\">\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"soDT\">Phone:</label>\n");
      out.write("                        <input type=\"tel\" class=\"form-control\" name=\"soDT\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"hoTen\">Full Name:</label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"hoTen\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-check\">\n");
      out.write("                        <label><input type=\"radio\" name=\"gioiTinh\" checked> Male</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-check\">\n");
      out.write("                        <label><input type=\"radio\" name=\"gioiTinh\"> Female</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"ngaySinh\">Day Of Birth:</label>\n");
      out.write("                        <input type=\"date\" class=\"form-control\" name=\"ngaySinh\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"diaChi\">Address:</label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"diaChi\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"loaiQuanHe\">Type of Relationship:</label>\n");
      out.write("                        <div>\n");
      out.write("                            <select id=\"\" class=\"form-control\" name=\"loaiQuanHe\">\n");
      out.write("                                <option>1</option>\n");
      out.write("                                <option>2</option>\n");
      out.write("                                <option>3</option>\n");
      out.write("                            </select> \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"ghiChu\">Memo:</label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"ghiChu\">\n");
      out.write("                    </div>\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-default\">Submit</button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
