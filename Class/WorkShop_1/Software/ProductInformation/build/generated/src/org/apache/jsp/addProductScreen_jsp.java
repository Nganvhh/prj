package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dao.CategoryDAO;
import controllers.IConstant;

public final class addProductScreen_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_set_var_value_nobody.release();
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
      			"error.jsp", true, 8192, true);
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
      out.write(" \n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <h3>Add New Product</h3>\n");
      out.write("                <div class=\"col-md-8\">\n");
      out.write("                    <form action=\"ProductController\" method=\"POST\" class=\"form-horizontal\" accept-charset=\"UTF-8\" enctype=\"multipart/form-data\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"control-label col-sm-2\" for=\"productId\">Product ID</label>\n");
      out.write("                            <div class=\"col-sm-10 check-input\">\n");
      out.write("                                <input\n");
      out.write("                                    type=\"text\"\n");
      out.write("                                    class=\"form-control\"\n");
      out.write("                                    id=\"productId\"\n");
      out.write("                                    name=\"productId\"\n");
      out.write("                                    autocomplete=\"new-productId\"\n");
      out.write("                                    placeholder=\"ID\"\n");
      out.write("                                    value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${IsCreatingProduct.productId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"\n");
      out.write("                                    required\n");
      out.write("                                    />\n");
      out.write("                                <small class=\"form-text\"></small>\n");
      out.write("                                ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"control-label col-sm-2\" for=\"productName\">Product name</label>\n");
      out.write("                            <div class=\"col-sm-10 check-input\">\n");
      out.write("                                <input\n");
      out.write("                                    type=\"text\"\n");
      out.write("                                    class=\"form-control\"\n");
      out.write("                                    id=\"productName\"\n");
      out.write("                                    name=\"productName\"\n");
      out.write("                                    autocomplete=\"new-productName\"\n");
      out.write("                                    placeholder=\"Name\"\n");
      out.write("                                    value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${IsCreatingProduct.productName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"\n");
      out.write("                                    required\n");
      out.write("                                    />\n");
      out.write("                                <small class=\"form-text\"></small>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${IsCreatingProduct.productImage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                            <label class=\"control-label col-sm-2\" for=\"productImage\">Product Image</label>\n");
      out.write("                            <div class=\"col-sm-10\">\n");
      out.write("                                <input type = \"file\" name = \"productImage\" size = \"50\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${IsCreatingProduct.productImage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/><br>\n");
      out.write("                            </div>    \n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"control-label col-sm-2\" for=\"brief\">Brief</label>\n");
      out.write("                            <div class=\"col-sm-10\">\n");
      out.write("                                <input\n");
      out.write("                                    type=\"text\"\n");
      out.write("                                    class=\"form-control\"\n");
      out.write("                                    id=\"productName\"\n");
      out.write("                                    name=\"brief\"\n");
      out.write("                                    autocomplete=\"new-brief\"\n");
      out.write("                                    placeholder=\"brief\"\n");
      out.write("                                    value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${IsCreatingProduct.brief}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"\n");
      out.write("                                    />\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            ");
      //  c:set
      org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
      _jspx_th_c_set_0.setPageContext(_jspx_page_context);
      _jspx_th_c_set_0.setParent(null);
      _jspx_th_c_set_0.setValue( new CategoryDAO().listAll());
      _jspx_th_c_set_0.setVar("listCategories");
      int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
      if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
        return;
      }
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      out.write("\n");
      out.write("                            <label class=\"control-label col-sm-2\" for=\"typeId\">Type</label>\n");
      out.write("                            <div class=\"col-sm-10 check-input\">\n");
      out.write("                                <select class=\"form-control\" name=\"typeId\">\n");
      out.write("                                    ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"control-label col-sm-2\" for=\"unit\">Unit</label>\n");
      out.write("                            <div class=\"col-sm-10\">\n");
      out.write("                                <select class=\"form-control\" name=\"unit\">\n");
      out.write("                                    <option>Cái</option>\n");
      out.write("                                    <option>Chiếc</option>\n");
      out.write("                                    <option>Bộ</option>\n");
      out.write("                                    <option>Đôi</option>\n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"control-label col-sm-2\" for=\"price\">Price</label>\n");
      out.write("                            <div class=\"col-sm-10\">\n");
      out.write("                                <input type=\"number\" min=\"0\" class=\"form-control\" name=\"price\" id=\"price\" value=\"0\"/>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"control-label col-sm-2\" for=\"discount\">Discount</label>\n");
      out.write("                            <div class=\"col-sm-10\">\n");
      out.write("                                <input type=\"number\" min=\"0\" max=\"100\" class=\"form-control\" name=\"discount\" id=\"discount\" value=\"0\"/>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <div class=\"col-sm-offset-2 col-sm-10\">\n");
      out.write("                                <button onclick=\"out(event)\" type=\"submit\" id=\"btn-cancel\" class=\"btn btn-danger\" name=\"productRequest\" value=\"");
      out.print( IConstant.SHOW_PRODUCT );
      out.write("\">Cancel</button>\n");
      out.write("                                <button type=\"submit\" id=\"btn-newProduct\" class=\"btn btn-success\" name=\"productRequest\" value=\"");
      out.print( IConstant.VALIDATION_PRODUCT);
      out.write("\">Submit</button>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("                            \n");
      out.write("        <script>\n");
      out.write("            const btnNewCategory = document.getElementById('btn-newProduct');\n");
      out.write("            const inputEles = document.querySelectorAll('.check-input');\n");
      out.write("            const btnCancel = document.getElementById('btn-cancel');\n");
      out.write("            btnNewCategory.addEventListener('click', function () {\n");
      out.write("                Array.from(inputEles).map((ele) =>\n");
      out.write("                    ele.classList.remove('success', 'error'))\n");
      out.write("                let isValid = checkValidate();\n");
      out.write("                if (isValid) {\n");
      out.write("                    console.log(window.location.href);\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("            function out(event) {\n");
      out.write("                let name = document.getElementById('productName');\n");
      out.write("                let id = document.getElementById('productId');\n");
      out.write("                name.removeAttribute('required');\n");
      out.write("                id.removeAttribute('required');\n");
      out.write("                document.getElementById('btn-cancel').submit();\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            // Truy cập vào các ô input\n");
      out.write("            const productIdEle = document.getElementById('productId');\n");
      out.write("            const productNameEle = document.getElementById('productName');\n");
      out.write("            const typeIdEle = document.getElementById('typeId');\n");
      out.write("            const discountEle = document.getElementById('discount');\n");
      out.write("            // Validate dữ liệu trong các ô input và highlight\n");
      out.write("            function checkValidate() {\n");
      out.write("                let productNameValue = productNameEle.value;\n");
      out.write("                let typeIdValue = typeIdEle.value;\n");
      out.write("                let discountValue = discountEle.value;\n");
      out.write("                let productIdValue = productIdEle.value;\n");
      out.write("                let isCheck = true;\n");
      out.write("\n");
      out.write("                // Kiểm tra trường firstname\n");
      out.write("                if (productNameValue == \"\") {\n");
      out.write("                    setError(productNameEle, \"Product name can not be empty.\");\n");
      out.write("                    isCheck = false;\n");
      out.write("                } else {\n");
      out.write("                    setSuccess(productNameEle);\n");
      out.write("                }\n");
      out.write("\n");
      out.write("\n");
      out.write("                //Kiểm tra trường price\n");
      out.write("\n");
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
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ExistProductId != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                    <small style=\"color: red\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ExistProductId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</small>\n");
        out.write("                                ");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listCategories.keySet()}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("i");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                        <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listCategories.get(i).typeId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listCategories.get(i).categoryName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</option>\n");
          out.write("                                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
