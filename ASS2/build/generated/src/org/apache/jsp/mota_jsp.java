package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class mota_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"vi\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Mô Tả Sản Phẩm - Helios</title>\n");
      out.write("    <!-- Đường dẫn tới file CSS (giả sử bạn để trong thư mục css) -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.print( request.getContextPath());
      out.write("/css/mota.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!-- PHẦN MÔ TẢ SẢN PHẨM -->\n");
      out.write("    <section class=\"product-detail\">\n");
      out.write("        <div class=\"product-images\">\n");
      out.write("            <!-- Bạn có thể chèn ảnh sản phẩm thật tại đây -->\n");
      out.write("            <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/images/DayChuyenTamTiemLuanHoiXa_AnhWeb_2_460x.png\" alt=\"Chill Guy Key Cap Helios Silver\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"product-info\">\n");
      out.write("            <h2>Chill Guy Key Cap Helios Silver</h2>\n");
      out.write("            <p class=\"price\">Đang nhập để hiển thị giá</p>\n");
      out.write("            <div class=\"button-group\">\n");
      out.write("                <button class=\"btn-buy\">Đặt hàng ngay</button>\n");
      out.write("                <button class=\"btn-add-cart\">Thêm vào giỏ hàng</button>\n");
      out.write("            </div>\n");
      out.write("            <p class=\"short-desc\">\n");
      out.write("                Đánh thức chất riêng của bạn với Helios. Chất liệu bạc S925, được chế tác thủ công.\n");
      out.write("            </p>\n");
      out.write("            <ul class=\"product-specs\">\n");
      out.write("                <li>Trọng lượng: ~2.3 gram</li>\n");
      out.write("                <li>Kích thước: 0.25 cm</li>\n");
      out.write("                <li>Chất liệu: Bạc S925</li>\n");
      out.write("            </ul>\n");
      out.write("            <p class=\"long-desc\">\n");
      out.write("                Công dụng: Dùng làm móc khóa, trang trí, và thể hiện cá tính riêng.  \n");
      out.write("                <br><br>\n");
      out.write("                Đằng sau mỗi chiếc tác luôn là một câu chuyện riêng biệt...  \n");
      out.write("                <br>\n");
      out.write("                Đây là đoạn mô tả chi tiết sản phẩm, giải thích ý nghĩa, câu chuyện thiết kế, quy trình chế tác, v.v.\n");
      out.write("            </p>\n");
      out.write("        </div>\n");
      out.write("    </section>\n");
      out.write("\n");
      out.write("    <!-- PHẦN GIỚI THIỆU THÊM / CÂU CHUYỆN THƯƠNG HIỆU -->\n");
      out.write("    <section class=\"brand-story\">\n");
      out.write("        <h2>Từ bàn tay thủ công đến những thành phẩm tinh xảo...</h2>\n");
      out.write("        <p>\n");
      out.write("            Mỗi sản phẩm bạc Helios là kết tinh của thao tác tỉ mỉ, dòng tư tưởng, và lòng tin từ khách hàng.  \n");
      out.write("            Chúng tôi luôn mong muốn mang đến những thiết kế độc đáo, phù hợp với cá tính của mỗi người.\n");
      out.write("        </p>\n");
      out.write("        <p>\n");
      out.write("            8 năm hành trình chế tác thủ công bạc, chúng tôi tin rằng mỗi sản phẩm là một tác phẩm nghệ thuật riêng biệt.  \n");
      out.write("            <br>\n");
      out.write("            Xem thêm &rarr;\n");
      out.write("        </p>\n");
      out.write("    </section>\n");
      out.write("\n");
      out.write("    <!-- PHẦN GỢI Ý SẢN PHẨM LIÊN QUAN / YOU MAY ALSO LIKE -->\n");
      out.write("    <section class=\"related-products\">\n");
      out.write("        <h2>You may also like</h2>\n");
      out.write("        <div class=\"products-grid\">\n");
      out.write("            <div class=\"product-card\">\n");
      out.write("                <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/images/DSC06256_460x.png\" alt=\"Nhẫn 1\">\n");
      out.write("                <h3>Do It Differently Helios Silver</h3>\n");
      out.write("                <p class=\"price\">1.250.000 đ</p>\n");
      out.write("                <p>★★★★★ 7 đánh giá</p>\n");
      out.write("                <button class=\"btn-view\">Xem thêm</button>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"product-card\">\n");
      out.write("                <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/images/DSC02671_540x.png\" alt=\"Nhẫn 2\">\n");
      out.write("                <h3>A.E.F W Helios Silver</h3>\n");
      out.write("                <p class=\"price\">1.900.000 đ</p>\n");
      out.write("                <p>★★★★★ 3 đánh giá</p>\n");
      out.write("                <button class=\"btn-view\">Xem thêm</button>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"product-card\">\n");
      out.write("                <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/images/demo-ring.png\" alt=\"Nhẫn 3\">\n");
      out.write("                <h3>Thiết Kế Helios Silver</h3>\n");
      out.write("                <p class=\"price\">345.000 đ</p>\n");
      out.write("                <p>★★★★★ 10 đánh giá</p>\n");
      out.write("                <button class=\"btn-view\">Xem thêm</button>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"product-card\">\n");
      out.write("                <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/images/demo-ring.png\" alt=\"Nhẫn 4\">\n");
      out.write("                <h3>Double Sk Helios Silver</h3>\n");
      out.write("                <p class=\"price\">510.000 đ</p>\n");
      out.write("                <p>★★★★★ 5 đánh giá</p>\n");
      out.write("                <button class=\"btn-view\">Xem thêm</button>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </section>\n");
      out.write("\n");
      out.write("    <!-- FOOTER -->\n");
      out.write("    <footer class=\"footer\">\n");
      out.write("        <p>© 2025 Helios. All rights reserved.</p>\n");
      out.write("    </footer>\n");
      out.write("\n");
      out.write("</body>\n");
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
