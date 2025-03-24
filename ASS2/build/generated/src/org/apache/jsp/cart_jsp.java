package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Map;
import java.util.HashMap;
import Product.ProductDAO;
import Product.ProductDTO;

public final class cart_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    // Lấy giỏ hàng từ session
    HashMap<Integer, Integer> cart = (HashMap<Integer, Integer>) session.getAttribute("cart");
    if (cart == null) {
        cart = new HashMap<>();
    }

    // Khởi tạo DAO để lấy thông tin sản phẩm
    ProductDAO productDAO = new ProductDAO();
    double totalPrice = 0;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"vi\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>Giỏ hàng - Helios</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.print( request.getContextPath());
      out.write("/css/styles.css\">\r\n");
      out.write("    <style>\r\n");
      out.write("        .cart-container {\r\n");
      out.write("            width: 80%;\r\n");
      out.write("            margin: 50px auto;\r\n");
      out.write("            padding: 20px;\r\n");
      out.write("            background: #fff;\r\n");
      out.write("            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);\r\n");
      out.write("            border-radius: 8px;\r\n");
      out.write("        }\r\n");
      out.write("        .home-btn {\r\n");
      out.write("            display: inline-block;\r\n");
      out.write("            margin-bottom: 15px;\r\n");
      out.write("            padding: 10px 15px;\r\n");
      out.write("            background: #007bff;\r\n");
      out.write("            color: white;\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("        }\r\n");
      out.write("        .home-btn:hover {\r\n");
      out.write("            background: #0056b3;\r\n");
      out.write("        }\r\n");
      out.write("        table {\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            border-collapse: collapse;\r\n");
      out.write("        }\r\n");
      out.write("        th, td {\r\n");
      out.write("            padding: 10px;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            border-bottom: 1px solid #ddd;\r\n");
      out.write("        }\r\n");
      out.write("        th {\r\n");
      out.write("            background: #f4f4f4;\r\n");
      out.write("        }\r\n");
      out.write("        .cart-item img {\r\n");
      out.write("            width: 60px;\r\n");
      out.write("            height: 60px;\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("        }\r\n");
      out.write("        .cart-actions button {\r\n");
      out.write("            padding: 5px 10px;\r\n");
      out.write("            background: #ff4d4d;\r\n");
      out.write("            color: white;\r\n");
      out.write("            border: none;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("            border-radius: 4px;\r\n");
      out.write("        }\r\n");
      out.write("        .cart-actions button:hover {\r\n");
      out.write("            background: #e63939;\r\n");
      out.write("        }\r\n");
      out.write("        .total-price {\r\n");
      out.write("            font-size: 18px;\r\n");
      out.write("            font-weight: bold;\r\n");
      out.write("            text-align: right;\r\n");
      out.write("            margin-top: 20px;\r\n");
      out.write("        }\r\n");
      out.write("        .checkout-btn {\r\n");
      out.write("            display: block;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            background: #28a745;\r\n");
      out.write("            color: white;\r\n");
      out.write("            padding: 10px;\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("            margin-top: 20px;\r\n");
      out.write("        }\r\n");
      out.write("        .checkout-btn:hover {\r\n");
      out.write("            background: #218838;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"cart-container\">\r\n");
      out.write("        <a href=\"MainController?action=loadProducts\" class=\"home-btn\">🏠 Trang chủ</a>\r\n");
      out.write("        <h2>Giỏ hàng của bạn</h2>\r\n");
      out.write("        ");
 if (!cart.isEmpty()) { 
      out.write("\r\n");
      out.write("        <table>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th>Hình ảnh</th>\r\n");
      out.write("                <th>Sản phẩm</th>\r\n");
      out.write("                <th>Số lượng</th>\r\n");
      out.write("                <th>Giá</th>\r\n");
      out.write("                <th>Thành tiền</th>\r\n");
      out.write("                <th>Hành động</th>\r\n");
      out.write("            </tr>\r\n");
      out.write("            ");
 for (Map.Entry<Integer, Integer> entry : cart.entrySet()) {
                ProductDTO product = productDAO.getProductById(entry.getKey().intValue());
                if (product != null) { 
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td><img class=\"cart-item\" src=\"");
      out.print( product.getImageUrl() );
      out.write("\" alt=\"");
      out.print( product.getName() );
      out.write("\"></td>\r\n");
      out.write("                <td>");
      out.print( product.getName() );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( entry.getValue() );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( String.format("%,.0f", product.getPrice()) );
      out.write(" VNĐ</td>\r\n");
      out.write("                <td>");
      out.print( String.format("%,.0f", product.getPrice() * entry.getValue()) );
      out.write(" VNĐ</td>\r\n");
      out.write("                <td class=\"cart-actions\">\r\n");
      out.write("                    <button onclick=\"removeItem(");
      out.print( product.getProductId() );
      out.write(")\">❌ Xóa</button>\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            ");
 totalPrice += product.getPrice() * entry.getValue(); 
      out.write("\r\n");
      out.write("            ");
 } } 
      out.write("\r\n");
      out.write("        </table>\r\n");
      out.write("        <p class=\"total-price\">Tổng cộng: ");
      out.print( String.format("%,.0f", totalPrice) );
      out.write(" VNĐ</p>\r\n");
      out.write("        <a href=\"MainController?action=checkout\" class=\"checkout-btn\">Thanh toán ngay</a>\r\n");
      out.write("        ");
 } else { 
      out.write("\r\n");
      out.write("        <p>Giỏ hàng của bạn đang trống.</p>\r\n");
      out.write("        ");
 } 
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <script>\r\n");
      out.write("        function removeItem(productId) {\r\n");
      out.write("            if (confirm(\"Bạn có chắc muốn xóa sản phẩm này khỏi giỏ hàng?\")) {\r\n");
      out.write("                window.location.href = \"MainController?action=removeFromCart&productId=\" + productId;\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
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
