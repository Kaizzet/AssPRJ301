package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import Product.ProductDTO;
import Category.CategoryDTO;

public final class category_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

    List<ProductDTO> products = (List<ProductDTO>) request.getAttribute("products");
    List<CategoryDTO> categories = (List<CategoryDTO>) request.getAttribute("categories");
    String categoryName = (String) request.getAttribute("categoryName");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"vi\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>");
      out.print( categoryName != null ? categoryName : "Danh mục sản phẩm" );
      out.write("</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.print( request.getContextPath());
      out.write("/css/styles.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<!-- HEADER -->\r\n");
      out.write("<header>\r\n");
      out.write("    <nav>\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li class=\"dropdown\">\r\n");
      out.write("                <a href=\"#\">MENU</a>\r\n");
      out.write("                <ul class=\"dropdown-content\">\r\n");
      out.write("                    ");
 if (categories != null && !categories.isEmpty()) {
                        for (CategoryDTO category : categories) { 
      out.write("\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <a href=\"MainController?action=loadCategory&category=");
      out.print( category.getCategoryId() );
      out.write("\">\r\n");
      out.write("                                    ");
      out.print( category.getCategoryName() );
      out.write("\r\n");
      out.write("                                </a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                    ");
  }
                    } else { 
      out.write("\r\n");
      out.write("                        <li><a href=\"#\">Không có danh mục</a></li>\r\n");
      out.write("                    ");
 } 
      out.write("\r\n");
      out.write("                </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </nav>       \r\n");
      out.write("<div class=\"logo\">\r\n");
      out.write("    <a href=\"MainController?action=loadProducts&page=1\">𝓗𝓔𝓛𝓘𝓞𝓢</a>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div class=\"user-options\">\r\n");
      out.write("        <a style=\"color: white\" href=\"");
      out.print( request.getContextPath());
      out.write("/register.jsp\">Đăng ký</a>\r\n");
      out.write("        <span style=\"color: white\">/</span> \r\n");
      out.write("        <a style=\"color: white\" href=\"");
      out.print( request.getContextPath());
      out.write("/login.jsp\"> Đăng nhập</a>\r\n");
      out.write("        <a href=\"#\" class=\"cart\">🛒</a>\r\n");
      out.write("    </div>\r\n");
      out.write("</header>\r\n");
      out.write("\r\n");
      out.write("<!-- TIÊU ĐỀ DANH MỤC -->\r\n");
      out.write("<section class=\"category-header\">\r\n");
      out.write("    <h2>");
      out.print( categoryName != null ? categoryName : "Sản phẩm" );
      out.write("</h2>\r\n");
      out.write("</section>\r\n");
      out.write("\r\n");
      out.write("<!-- DANH SÁCH SẢN PHẨM -->\r\n");
      out.write("<section class=\"products\">\r\n");
      out.write("    <div class=\"product-list\">\r\n");
      out.write("        ");
 if (products != null && !products.isEmpty()) {
            for (ProductDTO p : products) { 
      out.write("\r\n");
      out.write("                <div class=\"product\">\r\n");
      out.write("                    <img src=\"");
      out.print( p.getImageUrl());
      out.write("\" alt=\"");
      out.print( p.getName());
      out.write("\">\r\n");
      out.write("                    <h3>");
      out.print( p.getName());
      out.write("</h3>\r\n");
      out.write("                    <p><strong>");
      out.print( String.format("%,.0f", p.getPrice()));
      out.write(" VNĐ</strong></p>\r\n");
      out.write("                    <p>");
      out.print( p.getDescription());
      out.write("</p>\r\n");
      out.write("                    <button>Thêm nhanh</button>\r\n");
      out.write("                </div>\r\n");
      out.write("        ");
  }
        } else { 
      out.write("\r\n");
      out.write("            <p>Không có sản phẩm nào trong danh mục này.</p>\r\n");
      out.write("        ");
 } 
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</section>\r\n");
      out.write("\r\n");
      out.write("<!-- FOOTER -->\r\n");
      out.write("<footer>\r\n");
      out.write("    <p>&copy; 2025 Helios. All rights reserved.</p>\r\n");
      out.write("</footer>\r\n");
      out.write("\r\n");
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
