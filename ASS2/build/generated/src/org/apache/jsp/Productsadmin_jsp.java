package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import Product.ProductDAO;
import Product.ProductDTO;

public final class Productsadmin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"vi\">\r\n");
      out.write("<head>\r\n");
      out.write("  <meta charset=\"UTF-8\">\r\n");
      out.write("  <title>Products Admin</title>\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"");
      out.print( request.getContextPath());
      out.write("/css/admin.css\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/icon?family=Material+Icons\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("  <nav class=\"navbar\">\r\n");
      out.write("    <div class=\"nav-left\">\r\n");
      out.write("      <h2 class=\"logo\">HELIOS</h2>\r\n");
      out.write("      <ul class=\"nav-menu\">\r\n");
      out.write("        <li><a href=\"Homepageadmin.jsp\">Home</a></li>\r\n");
      out.write("        <li><a href=\"Ordersadmin.jsp\">Orders</a></li>\r\n");
      out.write("        <li><a href=\"Productsadmin.jsp\" class=\"active\">Products</a></li>\r\n");
      out.write("        <li><a href=\"Employeesadmin.jsp\">Employees</a></li>\r\n");
      out.write("        <li><a href=\"Reviewsadmin.jsp\">Reviews</a></li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"nav-right\">\r\n");
      out.write("      <img src=\"../images/avatar.png\" alt=\"Avatar\" class=\"avatar\">\r\n");
      out.write("    </div>\r\n");
      out.write("  </nav>\r\n");
      out.write("  <div class=\"sub-header\">\r\n");
      out.write("    <h1>Products</h1>\r\n");
      out.write("    <input type=\"text\" id=\"searchInput\" class=\"search-box\" placeholder=\"Search products...\" onkeyup=\"searchTable()\">\r\n");
      out.write("  </div>\r\n");
      out.write("  <div class=\"content\">\r\n");
      out.write("    <section class=\"page-section\">\r\n");
      out.write("      <div class=\"table-container\">\r\n");
      out.write("        <table id=\"productsTable\">\r\n");
      out.write("          <thead>\r\n");
      out.write("            <tr>\r\n");
      out.write("              <th><input type=\"checkbox\" onclick=\"toggleAll('productsTable')\"></th>\r\n");
      out.write("              <th>PRODUCT ID</th>\r\n");
      out.write("              <th>NAME</th>\r\n");
      out.write("              <th>MATERIAL</th>\r\n");
      out.write("              <th>PRICE</th>\r\n");
      out.write("              <th>IMAGE</th>\r\n");
      out.write("              <th>AMOUNT</th>\r\n");
      out.write("              <th>RATE</th>\r\n");
      out.write("              <th>Action</th>\r\n");
      out.write("            </tr>\r\n");
      out.write("          </thead>\r\n");
      out.write("          <tbody>\r\n");
      out.write("            ");
 
                ProductDAO productDAO = new ProductDAO();
                List<ProductDTO> productList = productDAO.getAllProducts();
                for (ProductDTO product : productList) { 
            
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td><input type=\"checkbox\"></td>\r\n");
      out.write("              <td>");
      out.print( product.getProductId() );
      out.write("</td>\r\n");
      out.write("              <td>");
      out.print( product.getName() );
      out.write("</td>\r\n");
      out.write("              <td>");
      out.print( product.getMaterial() );
      out.write("</td>\r\n");
      out.write("              <td>$");
      out.print( product.getPrice() );
      out.write("</td>\r\n");
      out.write("              <td><img src=\"");
      out.print( product.getImageUrl() );
      out.write("\" alt=\"Product Image\" width=\"50\"></td>\r\n");
      out.write("              <td>");
      out.print( product.getProductAmount() );
      out.write("</td>\r\n");
      out.write("              <td>");
      out.print( product.getAverageRating() );
      out.write("</td>\r\n");
      out.write("              <td>\r\n");
      out.write("                <span class=\"material-icons edit-icon\" onclick=\"editRow(this)\">edit</span>\r\n");
      out.write("                <span class=\"material-icons delete-icon\" onclick=\"deleteRow(this)\">delete</span>\r\n");
      out.write("              </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            ");
 } 
      out.write("\r\n");
      out.write("          </tbody>\r\n");
      out.write("        </table>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"pagination\">\r\n");
      out.write("        <a href=\"#\">&laquo; Previous</a>\r\n");
      out.write("        <a href=\"#\" class=\"active\">1</a>\r\n");
      out.write("        <a href=\"#\">Next &raquo;</a>\r\n");
      out.write("      </div>\r\n");
      out.write("    </section>\r\n");
      out.write("  </div>\r\n");
      out.write("  <script>\r\n");
      out.write("    function searchTable() {\r\n");
      out.write("      const keyword = document.getElementById('searchInput').value.toLowerCase();\r\n");
      out.write("      const rows = document.getElementById('productsTable').querySelectorAll('tbody tr');\r\n");
      out.write("      rows.forEach(row => {\r\n");
      out.write("        const text = row.innerText.toLowerCase();\r\n");
      out.write("        row.style.display = text.indexOf(keyword) > -1 ? '' : 'none';\r\n");
      out.write("      });\r\n");
      out.write("    }\r\n");
      out.write("    function toggleAll(tableId) {\r\n");
      out.write("      const table = document.getElementById(tableId);\r\n");
      out.write("      const headCB = table.querySelector('thead input[type=\"checkbox\"]');\r\n");
      out.write("      const rowCBs = table.querySelectorAll('tbody input[type=\"checkbox\"]');\r\n");
      out.write("      rowCBs.forEach(cb => cb.checked = headCB.checked);\r\n");
      out.write("    }\r\n");
      out.write("    function editRow(elem) {\r\n");
      out.write("      alert(\"Edit row (demo).\");\r\n");
      out.write("    }\r\n");
      out.write("    function deleteRow(elem) {\r\n");
      out.write("      alert(\"Delete row (demo).\");\r\n");
      out.write("    }\r\n");
      out.write("  </script>\r\n");
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
