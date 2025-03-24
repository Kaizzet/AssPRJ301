package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Product.ProductDAO;
import Category.CategoryDTO;
import java.util.List;
import java.util.Map;
import Product.ProductDTO;

public final class Main_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");

    List<ProductDTO> products = (List<ProductDTO>) request.getAttribute("products");
    List<CategoryDTO> categories = (List<CategoryDTO>) request.getAttribute("categories");
    int currentPage = (request.getAttribute("currentPage") != null) ? (Integer) request.getAttribute("currentPage") : 1;
    int totalPages = (request.getAttribute("totalPages") != null) ? (Integer) request.getAttribute("totalPages") : 1;
    Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"vi\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <title>Helios Clone</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.print( request.getContextPath());
      out.write("/css/styles.css\">\r\n");
      out.write("        <style>\r\n");
      out.write("            .cart-dropdown {\r\n");
      out.write("                display: none;\r\n");
      out.write("                position: absolute;\r\n");
      out.write("                background-color: white;\r\n");
      out.write("                border: 1px solid #ccc;\r\n");
      out.write("                width: 300px;\r\n");
      out.write("                right: 0;\r\n");
      out.write("                top: 30px;\r\n");
      out.write("                padding: 10px;\r\n");
      out.write("                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);\r\n");
      out.write("                border-radius: 5px;\r\n");
      out.write("            }\r\n");
      out.write("            .cart:hover .cart-dropdown {\r\n");
      out.write("                display: block;\r\n");
      out.write("            }\r\n");
      out.write("            .cart-item {\r\n");
      out.write("                display: flex;\r\n");
      out.write("                align-items: center;\r\n");
      out.write("                justify-content: space-between;\r\n");
      out.write("                padding: 10px 0;\r\n");
      out.write("                border-bottom: 1px solid #ddd;\r\n");
      out.write("            }\r\n");
      out.write("            .cart-item img {\r\n");
      out.write("                width: 50px;\r\n");
      out.write("                height: 50px;\r\n");
      out.write("                margin-right: 10px;\r\n");
      out.write("                border-radius: 5px;\r\n");
      out.write("            }\r\n");
      out.write("            .cart-item-details {\r\n");
      out.write("                flex-grow: 1;\r\n");
      out.write("            }\r\n");
      out.write("            .cart-item-remove {\r\n");
      out.write("                cursor: pointer;\r\n");
      out.write("                color: red;\r\n");
      out.write("            }\r\n");
      out.write("        </style>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        \r\n");
      out.write("        <header>\r\n");
      out.write("            <nav>\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <li class=\"dropdown\">\r\n");
      out.write("                        <a href=\"#\">MENU</a>\r\n");
      out.write("                        <ul class=\"dropdown-content\">\r\n");
      out.write("                            ");
 if (categories != null && !categories.isEmpty()) {
                                    for (CategoryDTO category : categories) {
      out.write("\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <a href=\"MainController?action=loadCategory&category=");
      out.print( category.getCategoryId());
      out.write("\">\r\n");
      out.write("                                    ");
      out.print( category.getCategoryName());
      out.write("\r\n");
      out.write("                                </a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            ");
  }
                            } else { 
      out.write("\r\n");
      out.write("                            <li><a href=\"#\">Không có danh mục</a></li>\r\n");
      out.write("                                ");
 }
      out.write("\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </nav>       \r\n");
      out.write("            <div class=\"logo\">𝓗𝓔𝓛𝓘𝓞𝓢</div>\r\n");
      out.write("            <div class=\"user-options\">\r\n");
      out.write("                <a style=\"color: white\" href=\"");
      out.print( request.getContextPath());
      out.write("/register.jsp\">Đăng ký</a>\r\n");
      out.write("                <span style=\"color: white\">/</span> \r\n");
      out.write("                <a style=\"color: white\" href=\"");
      out.print( request.getContextPath());
      out.write("/login.jsp\"> Đăng nhập</a>\r\n");
      out.write("                <div class=\"cart\" >\r\n");
      out.write("                    <a href=\"#\">🛒</a>\r\n");
      out.write("                    <div class=\"cart-dropdown\">\r\n");
      out.write("                        ");
 if (cart != null && !cart.isEmpty()) {
                            for (Map.Entry<Integer, Integer> entry : cart.entrySet()) {
                                ProductDTO product = new ProductDAO().getProductById(entry.getKey());
                                if (product != null) { 
      out.write("\r\n");
      out.write("                        <div class=\"cart-item\">\r\n");
      out.write("                            <img src=\"");
      out.print( product.getImageUrl() );
      out.write("\" alt=\"");
      out.print( product.getName() );
      out.write("\">\r\n");
      out.write("                            <div class=\"cart-item-details\">\r\n");
      out.write("                                <span><strong>");
      out.print( product.getName() );
      out.write("</strong></span>\r\n");
      out.write("                                <span>x");
      out.print( entry.getValue() );
      out.write("</span>\r\n");
      out.write("                                <span>");
      out.print( String.format("%,.0f", product.getPrice() * entry.getValue()) );
      out.write(" VNĐ</span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <span class=\"cart-item-remove\">❌</span>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        ");
 } } 
      out.write("\r\n");
      out.write("                        <a href=\"MainController?action=viewCart\">Xem giỏ hàng</a>\r\n");
      out.write("                        ");
 } else { 
      out.write("\r\n");
      out.write("                        <p>Giỏ hàng trống</p>\r\n");
      out.write("                        ");
 } 
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </header>\r\n");
      out.write("\r\n");
      out.write("        <section class=\"banner\">\r\n");
      out.write("            <img src=\"https://raw.githubusercontent.com/tuanptse/ASSprj/main/ASS2/web/images/banner.jpg\" alt=\"Helios Banner\">\r\n");
      out.write("        </section>\r\n");
      out.write("\r\n");
      out.write("        <section class=\"products\">\r\n");
      out.write("            <h2 class=\"sanphammoi\">Sản phẩm mới</h2>\r\n");
      out.write("            <div class=\"product-list\">\r\n");
      out.write("                ");
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
      out.write("                    <button class=\"add-to-cart\" data-product-id=\"");
      out.print( p.getProductId());
      out.write("\">Thêm nhanh</button>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");
  }
                } else { 
      out.write("\r\n");
      out.write("                <p>Không có sản phẩm nào để hiển thị.</p>\r\n");
      out.write("                ");
 }
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </section>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "paging.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <footer>\r\n");
      out.write("            <p>&copy; 2025 Helios. All rights reserved.</p>\r\n");
      out.write("        </footer>\r\n");
      out.write("\r\n");
      out.write("        <script>\r\n");
      out.write("            document.addEventListener(\"DOMContentLoaded\", function () {\r\n");
      out.write("                let header = document.querySelector(\"header\");\r\n");
      out.write("\r\n");
      out.write("                // Khi không di chuột vào, header sẽ mất màu\r\n");
      out.write("                header.classList.add(\"transparent\");\r\n");
      out.write("\r\n");
      out.write("                // Khi trỏ chuột vào header, nó hiện màu đen\r\n");
      out.write("                header.addEventListener(\"mouseenter\", function () {\r\n");
      out.write("                    header.classList.remove(\"transparent\");\r\n");
      out.write("                });\r\n");
      out.write("\r\n");
      out.write("                // Khi chuột rời khỏi header, nó trở lại trong suốt\r\n");
      out.write("                header.addEventListener(\"mouseleave\", function () {\r\n");
      out.write("                    header.classList.add(\"transparent\");\r\n");
      out.write("                });\r\n");
      out.write("            });\r\n");
      out.write("            document.addEventListener(\"DOMContentLoaded\", function () {\r\n");
      out.write("                document.querySelectorAll(\".add-to-cart\").forEach(button => {\r\n");
      out.write("                    button.addEventListener(\"click\", function () {\r\n");
      out.write("                        let productId = this.getAttribute(\"data-product-id\");\r\n");
      out.write("                        fetch(\"MainController?action=addToCart&productId=\" + productId, { method: \"GET\" })\r\n");
      out.write("                            .then(response => response.json())\r\n");
      out.write("                            .then(data => {\r\n");
      out.write("                                alert(\"Sản phẩm đã được thêm vào giỏ hàng!\");\r\n");
      out.write("                            })\r\n");
      out.write("                            .catch(error => console.error(\"Lỗi:\", error));\r\n");
      out.write("                    });\r\n");
      out.write("                });\r\n");
      out.write("            });\r\n");
      out.write("        </script>\r\n");
      out.write("    </body>\r\n");
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
}
