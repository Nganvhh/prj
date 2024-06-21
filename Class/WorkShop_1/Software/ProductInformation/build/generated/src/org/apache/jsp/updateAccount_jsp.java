package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class updateAccount_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <h2>Add new account</h2>\n");
      out.write("            <form action=\"MainController?action=register&behaviour=checkValid\" class=\"form-horizontal\" method=\"post\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"control-label col-sm-2\" for=\"account\">Username</label>\n");
      out.write("                    <div class=\"col-sm-10 check-input\">\n");
      out.write("                        <input\n");
      out.write("                            type=\"text\"\n");
      out.write("                            class=\"form-control\"\n");
      out.write("                            id=\"username\"\n");
      out.write("                            name=\"account\"\n");
      out.write("                            placeholder=\"Username\"\n");
      out.write("                            value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${updatedAccount.account}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"\n");
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
      out.write("                    <label class=\"control-label col-sm-2\" for=\"pass\">Password</label>\n");
      out.write("                    <div class=\"col-sm-10 check-input\">\n");
      out.write("                        <input\n");
      out.write("                            type=\"password\"\n");
      out.write("                            class=\"form-control\"\n");
      out.write("                            id=\"password\"\n");
      out.write("                            placeholder=\"Password\"\n");
      out.write("                            name=\"pass\"\n");
      out.write("                            value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${updatedAccount.pass}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"\n");
      out.write("                            required\n");
      out.write("                            />\n");
      out.write("                        <small class=\"form-text\"></small>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"control-label col-sm-2\" for=\"confirm\">Confirm Password</label>\n");
      out.write("                    <div class=\"col-sm-10 check-input\">\n");
      out.write("                        <input\n");
      out.write("                            type=\"password\"\n");
      out.write("                            class=\"form-control\"\n");
      out.write("                            id=\"confirm-password\"\n");
      out.write("                            placeholder=\"Confirm password\"\n");
      out.write("                            name=\"confirm\"\n");
      out.write("                            required\n");
      out.write("                            />\n");
      out.write("                        <small class=\"form-text\"></small>\n");
      out.write("                        ");
      if (_jspx_meth_c_if_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"control-label col-sm-2\" for=\"lastName\">Last name</label>\n");
      out.write("                    <div class=\"col-sm-10\">\n");
      out.write("                        <input\n");
      out.write("                            type=\"text\"\n");
      out.write("                            class=\"form-control\"\n");
      out.write("                            name=\"lastName\"\n");
      out.write("                            placeholder=\"Last name\"\n");
      out.write("                            value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${updatedAccount.lastName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"\n");
      out.write("                            id=\"lastname\"\n");
      out.write("                            />\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"control-label col-sm-2\" for=\"firstName\">First name</label>\n");
      out.write("                    <div class=\"col-sm-10 check-input\">\n");
      out.write("                        <input\n");
      out.write("                            type=\"text\"\n");
      out.write("                            class=\"form-control\"\n");
      out.write("                            id=\"firstname\"\n");
      out.write("                            name=\"firstName\"\n");
      out.write("                            placeholder=\"First name\"\n");
      out.write("                            value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${updatedAccount.fistName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"\n");
      out.write("                            required\n");
      out.write("                            />\n");
      out.write("                        <small class=\"form-text\"></small>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"control-label col-sm-2\" for=\"phone\">Phone number</label>\n");
      out.write("                    <div class=\"col-sm-10\">\n");
      out.write("                        <input\n");
      out.write("                            type=\"tel\"\n");
      out.write("                            class=\"form-control\"\n");
      out.write("                            id=\"phone\"\n");
      out.write("                            name=\"phone\"\n");
      out.write("                            placeholder=\"Phone number\"\n");
      out.write("                            value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${updatedAccount.phone}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"\n");
      out.write("                            />\n");
      out.write("                        ");
      if (_jspx_meth_c_if_3(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"control-label col-sm-2\" for=\"birthDay\">Birth day</label>\n");
      out.write("                    <div class=\"col-sm-10\">\n");
      out.write("                        <input id=\"dob\" type=\"date\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${updatedAccount.birthDay}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" name=\"birthDay\" />\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"control-label col-sm-2\" for=\"gender\">Gender</label>\n");
      out.write("                    <div class=\"col-sm-10\">\n");
      out.write("                        <div class=\"form-check form-check-inline\">\n");
      out.write("                            <label class=\"radio-inline\"><input type=\"radio\" name=\"gender\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${updatedAccount.gender = true?\"clicked\":\"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" /> Male</label                            >\n");
      out.write("                            <label class=\"radio-inline\"><input type=\"radio\" name=\"gender\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${updatedAccount.gender = false?\"clicked\":\"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" /> Female</label>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"control-label col-sm-2\" for=\"isUse\">In Use</label>\n");
      out.write("                    <div class=\"col-sm-10\">\n");
      out.write("                        <div class=\"form-check form-check-inline\">\n");
      out.write("                            <label class=\"radio-inline\"><input type=\"radio\" name=\"isUse\" checked /> Yes</label                            >\n");
      out.write("                            <label class=\"radio-inline\"><input type=\"radio\" name=\"isUse\" /> No</label>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"control-label col-sm-2\" for=\"role\"\n");
      out.write("                           >Role in system</label>\n");
      out.write("                    <div class=\"col-sm-10\">\n");
      out.write("                        <select class=\"form-control\" name=\"role\">\n");
      out.write("                            <option ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(updatedAccount.roleInSystem == 0)? \"selected\":\"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">Customer</option>\n");
      out.write("                            <option ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(updatedAccount.roleInSystem == 1)? \"selected\":\"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">Administrator</option>\n");
      out.write("                            <option ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(updatedAccount.roleInSystem == 2)? \"selected\":\"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">Staff</option>\n");
      out.write("                        </select>\n");
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
      out.write("                // Kiểm tra trường account\n");
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
      out.write("                        setError(confirmEle, \"Those passwords didn’t match. Try again.\");\n");
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

  private boolean _jspx_meth_c_if_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent(null);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ConfirmFalse != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                            <small style=\"color: red\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ConfirmFalse}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</small>\n");
        out.write("                        ");
        int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
    return false;
  }

  private boolean _jspx_meth_c_if_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_3.setPageContext(_jspx_page_context);
    _jspx_th_c_if_3.setParent(null);
    _jspx_th_c_if_3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ErrorPhoneFormat != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_3 = _jspx_th_c_if_3.doStartTag();
    if (_jspx_eval_c_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                            <small style=\"color: red\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ErrorPhoneFormat}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</small>\n");
        out.write("                        ");
        int evalDoAfterBody = _jspx_th_c_if_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
    return false;
  }
}
