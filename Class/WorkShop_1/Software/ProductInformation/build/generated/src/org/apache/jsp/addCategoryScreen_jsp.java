package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import controllers.IConstant;

public final class addCategoryScreen_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\" />\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE-edge\" />\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
      out.write("        <title>Document</title>\n");
      out.write("        <!-- Latest compiled and minified CSS -->\n");
      out.write("        <link\n");
      out.write("            rel=\"stylesheet\"\n");
      out.write("            href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\"\n");
      out.write("            />\n");
      out.write("\n");
      out.write("        <!-- jQuery library -->\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Latest compiled JavaScript -->\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"newAccount.css\" />\n");
      out.write("        <style>\n");
      out.write("            .header_button-icon {\n");
      out.write("                color: #212529;\n");
      out.write("                margin-right: 10px;\n");
      out.write("            }\n");
      out.write("            .header_button a {\n");
      out.write("                color: #212529;\n");
      out.write("            }\n");
      out.write("            .header_button ul {\n");
      out.write("                list-style-type: none;\n");
      out.write("                /*font-size: 16px;*/\n");
      out.write("            }\n");
      out.write("            .header_button ul li {\n");
      out.write("                display: inline;\n");
      out.write("                margin-left: 15px;\n");
      out.write("            }\n");
      out.write("            .header_button {\n");
      out.write("                text-align: right;\n");
      out.write("                margin-top: 10px;\n");
      out.write("                margin-right: 15px;\n");
      out.write("                font-size: 16px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        <header>\n");
      out.write("            <div class=\"header_button\">\n");
      out.write("                <ul>\n");
      out.write("                    <li style=\"display: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${loginedAccount != null?\"\":\"none\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                        <a href=\"MainController?action=logout\"><span class=\"glyphicon glyphicon-log-out header_button-icon\"></span>Sign out</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <nav class=\"navbar navbar-inverse\">\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                    <div class=\"navbar-header\">\n");
      out.write("                        <a class=\"navbar-brand\" href=\"MainController?action=home\"><strong style=\"font-size: 1.5em\">WS1</strong></a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("        </header>\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <h2>New category</h2>\n");
      out.write("            <form action=\"CategoryController?category=");
      out.print( IConstant.VALIDATIOM_CATEGORY);
      out.write("\" class=\"form-horizontal\" method=\"post\" accept-charset=\"UTF-8\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"control-label col-sm-2\" for=\"categoryName\">Category name</label>\n");
      out.write("                    <div class=\"col-sm-10 check-input\">\n");
      out.write("                        <input\n");
      out.write("                            type=\"text\"\n");
      out.write("                            class=\"form-control\"\n");
      out.write("                            id=\"categoryName\"\n");
      out.write("                            name=\"categoryName\"\n");
      out.write("                            autocomplete=\"new-name\"\n");
      out.write("                            placeholder=\"Name\"\n");
      out.write("                            required\n");
      out.write("                            />\n");
      out.write("                        <small class=\"form-text\"></small>\n");
      out.write("                        ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"control-label col-sm-2\" for=\"memo\">Memo</label>\n");
      out.write("                    <div class=\"col-sm-10\">\n");
      out.write("                        <textarea style=\"width: 100%\" rows=\"5\"\"></textarea>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <div class=\"col-sm-offset-2 col-sm-10\">\n");
      out.write("                        <button type=\"submit\" id=\"btn-register\" class=\"btn btn-default\">Register</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            const btnRegister = document.getElementById('btn-register');\n");
      out.write("            const inputEles = document.querySelectorAll('.check-input');\n");
      out.write("\n");
      out.write("            btnRegister.addEventListener('click', function () {\n");
      out.write("                Array.from(inputEles).map((ele) =>\n");
      out.write("                    ele.classList.remove('success', 'error'))\n");
      out.write("                let isValid = checkValidate();\n");
      out.write("                if (isValid) {\n");
      out.write("                    console.log(window.location.href);\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("\n");
      out.write("\n");
      out.write("            // Truy cập vào các ô input\n");
      out.write("            const userEle = document.getElementById('username');\n");
      out.write("            const passEle = document.getElementById('password');\n");
      out.write("            const confirmEle = document.getElementById('confirm-password');\n");
      out.write("            const firstnameEle = document.getElementById('firstname');\n");
      out.write("\n");
      out.write("            // Validate dữ liệu trong các ô input và highlight\n");
      out.write("            function checkValidate() {\n");
      out.write("                let userValue = userEle.value;\n");
      out.write("                let passValue = passEle.value;\n");
      out.write("                let confirmValue = confirmEle.value;\n");
      out.write("                let firstnameValue = firstnameEle.value;\n");
      out.write("                let isCheck = true;\n");
      out.write("                // Kiểm tra trường Username/account\n");
      out.write("                if (userValue == '') {\n");
      out.write("                    setError(userEle, \"Username can not be empty.\");\n");
      out.write("                    isCheck = false;\n");
      out.write("                } else {\n");
      out.write("                    setSuccess(userEle);\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                // Kiểm tra trường password\n");
      out.write("                if (passValue == '' || confirmValue == '') {\n");
      out.write("                    if (passValue == '') {\n");
      out.write("                        setError(passEle, \"Password can not be empty.\");\n");
      out.write("                        isCheck = false;\n");
      out.write("                    } else {\n");
      out.write("                        setError(confirmEle, \"Confirm your password.\");\n");
      out.write("                        isCheck = false;\n");
      out.write("                    }\n");
      out.write("                } else {\n");
      out.write("                    if (passValue == confirmValue) {\n");
      out.write("                        setSuccess(passEle);\n");
      out.write("                        setError(confirmEle);\n");
      out.write("                    } else {\n");
      out.write("                        setError(confirmEle, \"Those passwords didn't match. Try again.\");\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                // Kiểm tra trường firstname\n");
      out.write("                if (firstnameValue == '') {\n");
      out.write("                    setError(firstnameEle, \"First name can not be empty.\");\n");
      out.write("                    isCheck = false;\n");
      out.write("                } else {\n");
      out.write("                    setSuccess(firstnameEle);\n");
      out.write("                }\n");
      out.write("                return isCheck;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function setError(ele, message) {\n");
      out.write("                let parentEle = ele.parentNode;\n");
      out.write("                parentEle.classList.add('error');\n");
      out.write("                parentEle.querySelector('small').innerText = message;\n");
      out.write("                parentEle.querySelector('small').style.color = \"red\"\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function setSuccess(ele) {\n");
      out.write("                ele.parentNode.classList.add('success');\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${loginedAccount != null && modify == 0}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("            ");
        if (true) {
          _jspx_page_context.forward("MainController?action=home");
          return true;
        }
        out.write("\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ExistAccount != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                            <small style=\"color: red\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ExistAccount}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</small>\n");
        out.write("                        ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }
}
