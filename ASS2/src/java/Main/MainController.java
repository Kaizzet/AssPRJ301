package Main;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Product.ProductDAO;
import Product.ProductDTO;
import Orders.OrderDAO;
import Orders.OrderDTO;
import Users.UserDAO;
import Users.UserDTO;
import Category.CategoryDAO;
import Category.CategoryDTO;

@WebServlet(name = "MainController", urlPatterns = {"/MainController", "/"})
public class MainController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null || action.isEmpty()) {
            response.sendRedirect("MainController?action=loadProducts&page=1");
            return;
        }

        ProductDAO productDAO = new ProductDAO();
        OrderDAO orderDAO = new OrderDAO();
        UserDAO userDAO = new UserDAO();
        try {
            switch (action) {
                case "loadProducts":
                    int page = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;
                    int productsPerPage = 4;

                    List<ProductDTO> products = productDAO.getProductsByPage(page, productsPerPage);
                    int totalProducts = productDAO.getTotalProducts();
                    int totalPages = (int) Math.ceil((double) totalProducts / productsPerPage);

                    CategoryDAO categoryDAO = new CategoryDAO();
                    List<CategoryDTO> categories = categoryDAO.getAllCategories();

                    request.setAttribute("products", products);
                    request.setAttribute("categories", categories);
                    request.setAttribute("currentPage", page);
                    request.setAttribute("totalPages", totalPages);

                    request.getRequestDispatcher("Main.jsp").forward(request, response);
                    break;

                case "loadCategory":
                    String categoryId = request.getParameter("category");

                    // ✅ Lấy danh sách sản phẩm theo danh mục được chọn
                    List<ProductDTO> categoryProducts = productDAO.getProductsByCategory(categoryId);

                    // ✅ Lấy lại danh sách tất cả danh mục để hiển thị menu
                    CategoryDAO categoryDAO2 = new CategoryDAO();
                    List<CategoryDTO> allCategories = categoryDAO2.getAllCategories();

                    request.setAttribute("products", categoryProducts);
                    request.setAttribute("categories", allCategories);
                    request.setAttribute("selectedCategory", categoryId); // Để xác định danh mục nào đang được chọn

                    request.getRequestDispatcher("category.jsp").forward(request, response);
                    break;

                case "viewProduct":
                    int productId = Integer.parseInt(request.getParameter("id"));
                    ProductDTO product = productDAO.getProductById(productId);
                    request.setAttribute("product", product);
                    request.getRequestDispatcher("productDetail.jsp").forward(request, response);
                    break;

                case "viewCart":
                    request.getRequestDispatcher("cart.jsp").forward(request, response);
                    break;

                case "checkout":
                    request.getRequestDispatcher("checkout.jsp").forward(request, response);
                    break;

                case "manageOrders":
                    List<OrderDTO> orders = orderDAO.getAllOrders();
                    request.setAttribute("orders", orders);
                    request.getRequestDispatcher("manageOrders.jsp").forward(request, response);
                    break;

                case "manageUsers":
                    List<UserDTO> users = userDAO.getAllUsers();
                    request.setAttribute("users", users);
                    request.getRequestDispatcher("manageUsers.jsp").forward(request, response);
                    break;
                default:
                    request.getRequestDispatcher("Main.jsp").forward(request, response);
                    break;
            }
        } catch (Exception e) {
            request.setAttribute("error", "Lỗi khi xử lý yêu cầu: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Main Controller - Quản lý tất cả các chức năng chính";
    }
}
