package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_choose;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_otherwise;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_when_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_otherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_choose.release();
    _jspx_tagPool_c_otherwise.release();
    _jspx_tagPool_c_when_test.release();
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n");
      out.write("        <title>Header</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n");
      out.write("        <!--<link href=\"Styles/login.css\" rel=\"stylesheet\" type=\"text/css\" />-->\n");
      out.write("        <!-- Latest compiled and minified CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("        <!-- jQuery library -->\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Latest compiled JavaScript -->\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"styles/headerStyle.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            ");
      if (_jspx_meth_c_choose_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        </header>\n");
      out.write("    </body>\n");
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

  private boolean _jspx_meth_c_choose_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_0.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_0.setParent(null);
    int _jspx_eval_c_choose_0 = _jspx_th_c_choose_0.doStartTag();
    if (_jspx_eval_c_choose_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                ");
        if (_jspx_meth_c_when_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                ");
        if (_jspx_meth_c_otherwise_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_c_choose_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_choose_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
      return true;
    }
    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
    return false;
  }

  private boolean _jspx_meth_c_when_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_0.setPageContext(_jspx_page_context);
    _jspx_th_c_when_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    _jspx_th_c_when_0.setTest(false);
    int _jspx_eval_c_when_0 = _jspx_th_c_when_0.doStartTag();
    if (_jspx_eval_c_when_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                    ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${loginedAccount}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\n");
        out.write("                    ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${modify}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\n");
        out.write("                    <div class=\"header_button\">\n");
        out.write("                        <ul>\n");
        out.write("                            <li style=\"display: ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${loginedAccount != null?\"\":\"none\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\">\n");
        out.write("                                <a href=\"MainController?action=logout\"><span class=\"glyphicon glyphicon-log-out header_button-icon\"></span>Đăng xuất</a>\n");
        out.write("                            </li>\n");
        out.write("                        </ul>\n");
        out.write("                    </div>\n");
        out.write("\n");
        out.write("                    <nav class=\"navbar navbar-inverse\">\n");
        out.write("                        <div class=\"container-fluid\">\n");
        out.write("                            <div class=\"navbar-header\">\n");
        out.write("                                <a class=\"navbar-brand\" href=\"MainController?action=home\"><strong class=\"brand\">WS1</strong></a>\n");
        out.write("\n");
        out.write("                                <p>Welcome to <span>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${loginedAccount.account}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</span>[");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${loginedAccount.lastName.concat(\" \").concat(firstName)}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("]</p>\n");
        out.write("                            </div>\n");
        out.write("                            <ul class=\"nav navbar-nav  navbar-inverse\">\n");
        out.write("                                <li>\n");
        out.write("                                    <a href=\"MainController?action=home\">Home</a>\n");
        out.write("                                </li>\n");
        out.write("                                <li>\n");
        out.write("                                    <a href=\"MainController?action=showListAccount\">Accounts</a>\n");
        out.write("                                </li>\n");
        out.write("                                <li>Categories</li>\n");
        out.write("                                <li>Products</li>\n");
        out.write("                            </ul>\n");
        out.write("\n");
        out.write("                            <form class=\"navbar-form navbar-right\" action=\"#\">\n");
        out.write("                                <div class=\"form-group has-feedback has-search\">\n");
        out.write("                                    <input\n");
        out.write("                                        type=\"text\"\n");
        out.write("                                        class=\"form-control\"\n");
        out.write("                                        placeholder=\"Tìm kiếm\"\n");
        out.write("                                        />\n");
        out.write("                                    <span\n");
        out.write("                                        class=\"glyphicon glyphicon-search form-control-feedback\"></span>\n");
        out.write("                                </div>\n");
        out.write("                            </form>\n");
        out.write("                        </div>\n");
        out.write("                    </nav>\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_c_when_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
    return false;
  }

  private boolean _jspx_meth_c_otherwise_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_otherwise_0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_otherwise_0.setPageContext(_jspx_page_context);
    _jspx_th_c_otherwise_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    int _jspx_eval_c_otherwise_0 = _jspx_th_c_otherwise_0.doStartTag();
    if (_jspx_eval_c_otherwise_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                    <div class=\"header_button\">\n");
        out.write("                        <ul>\n");
        out.write("                            <li style=\"display:");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${loginedAccount == null?\"\":\"none\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\">\n");
        out.write("                                <a href=\"MainController?action=register\"><span class=\"glyphicon glyphicon-user text-dark header_button-icon\"></span>Đăng ký</a>\n");
        out.write("                            </li>\n");
        out.write("\n");
        out.write("                            <li style=\"display: ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${loginedAccount == null?\"\":\"none\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\">\n");
        out.write("                                <a href=\"MainController?action=login&firstLogin=1\"><span class=\"glyphicon glyphicon-log-in header_button-icon\"></span>Đăng nhập</a>\n");
        out.write("                            </li>\n");
        out.write("                            <li style=\"display: ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${loginedAccount != null?\"\":\"none\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\">\n");
        out.write("                                <a href=\"MainController?action=logout\"><span class=\"glyphicon glyphicon-log-out header_button-icon\"></span>Đăng xuất</a>\n");
        out.write("                            </li>\n");
        out.write("                        </ul>\n");
        out.write("\n");
        out.write("                    </div>\n");
        out.write("\n");
        out.write("                    <nav class=\"navbar navbar-inverse\">\n");
        out.write("                        <div class=\"container-fluid\">\n");
        out.write("                            <div class=\"navbar-header\">\n");
        out.write("                                <a class=\"navbar-brand\" href=\"MainController?action=home\"><strong class=\"brand\">WS1</strong></a>\n");
        out.write("\n");
        out.write("                            </div>\n");
        out.write("                            <ul class=\"nav navbar-nav  navbar-inverse\">\n");
        out.write("                                <li>\n");
        out.write("                                    <a href=\"MainController?action=home\">Home</a>\n");
        out.write("                                </li>\n");
        out.write("                                <li>\n");
        out.write("                                    <a href=\"MainController?action=dashboard&\"></a>\n");
        out.write("                                </li>\n");
        out.write("                            </ul>\n");
        out.write("\n");
        out.write("                            <form class=\"navbar-form navbar-right\" action=\"#\">\n");
        out.write("                                <div class=\"form-group has-feedback has-search\">\n");
        out.write("                                    <input\n");
        out.write("                                        type=\"text\"\n");
        out.write("                                        class=\"form-control\"\n");
        out.write("                                        placeholder=\"Tìm kiếm\"/>\n");
        out.write("                                    <span class=\"glyphicon glyphicon-search form-control-feedback\"></span>\n");
        out.write("                                </div>\n");
        out.write("                            </form>\n");
        out.write("                        </div>\n");
        out.write("                    </nav>\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_c_otherwise_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_otherwise_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
      return true;
    }
    _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
    return false;
  }
}
