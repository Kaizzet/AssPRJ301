package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Homepageadmin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"vi\">\r\n");
      out.write("<head>\r\n");
      out.write("  <meta charset=\"UTF-8\">\r\n");
      out.write("  <title>HELIOS - Admin Home</title>\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"");
      out.print( request.getContextPath());
      out.write("/css/admin.css\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/icon?family=Material+Icons\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("  <!-- NAVBAR -->\r\n");
      out.write("  <nav class=\"navbar\">\r\n");
      out.write("    <div class=\"nav-left\">\r\n");
      out.write("      <h2 class=\"logo\">HELIOS</h2>\r\n");
      out.write("      <ul class=\"nav-menu\">\r\n");
      out.write("        <!-- Thêm link Home -->\r\n");
      out.write("        <li><a href=\"Homepageadmin.jsp\" class=\"active\">Home</a></li>\r\n");
      out.write("        <li><a href=\"Ordersadmin.jsp\">Orders</a></li>\r\n");
      out.write("        <li><a href=\"Productsadmin.jsp\">Products</a></li>\r\n");
      out.write("        <li><a href=\"Usersadmin.jsp\">Users</a></li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"nav-right\">\r\n");
      out.write("      <img src=\"../images/avatar.png\" alt=\"Avatar\" class=\"avatar\">\r\n");
      out.write("    </div>\r\n");
      out.write("  </nav>\r\n");
      out.write("\r\n");
      out.write("  <!-- SUB-HEADER -->\r\n");
      out.write("  <div class=\"sub-header\">\r\n");
      out.write("    <h1>Admin Home</h1>\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write("  <!-- CONTENT -->\r\n");
      out.write("  <div class=\"content\">\r\n");
      out.write("    <p>Chào mừng bạn đến với trang quản trị HELIOS. Hãy chọn một mục bên trên để quản lý!</p>\r\n");
      out.write("  </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
