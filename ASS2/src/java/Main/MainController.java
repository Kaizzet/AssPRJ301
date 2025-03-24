package Main;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Product.ProductDAO;
import Product.ProductDTO;
import Orders.OrderDAO;
import Orders.OrderDTO;
import Users.UserDAO;
import Users.UserDTO;
import Category.CategoryDAO;
import Category.CategoryDTO;
import java.util.HashMap;

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
        HttpSession session = request.getSession();

        try {
            switch (action) {
                case "login":
                    String email = request.getParameter("email");
                    String password = request.getParameter("password");

                    UserDAO dao = new UserDAO();
                    UserDTO user = dao.checkLogin(email, password);

                    if (user != null) {
                        HttpSession sessions = request.getSession();
                        sessions.setAttribute("loggedInUser", user);

                        // Kiểm tra role của user
                        if ("admin".equalsIgnoreCase(user.getRole())) {
                            response.sendRedirect("Ordersadmin.jsp"); // Admin vào trang quản lý
                        } else {
                            response.sendRedirect("MainController?action=loadProducts&page=1"); // User vào trang chính
                        }
                    } else {
                        request.setAttribute("ERROR", "Sai email hoặc mật khẩu!");
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    }

                    break;

                case "logout":
                    session.invalidate(); // Xóa session để đăng xuất
                    response.sendRedirect("MainController?action=loadProducts&page=1");
                    break;
                    
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
                    List<ProductDTO> categoryProducts = productDAO.getProductsByCategory(categoryId);
                    List<CategoryDTO> allCategories = new CategoryDAO().getAllCategories();

                    request.setAttribute("products", categoryProducts);
                    request.setAttribute("categories", allCategories);
                    request.setAttribute("selectedCategory", categoryId);
                    request.getRequestDispatcher("category.jsp").forward(request, response);
                    break;

                case "viewProduct":
                    int productId = Integer.parseInt(request.getParameter("id"));
                    ProductDTO product = productDAO.getProductById(productId);
                    request.setAttribute("product", product);
                    request.getRequestDispatcher("Main.jsp").forward(request, response);
                    break;

                case "viewCart":
                    request.getRequestDispatcher("cart.jsp").forward(request, response);
                    break;

                case "addToCart":
                    int cartProductId = Integer.parseInt(request.getParameter("productId"));
                    HashMap<Integer, Integer> cart = (HashMap<Integer, Integer>) session.getAttribute("cart");
                    if (cart == null) {
                        cart = new HashMap<>();
                    }
                    cart.put(cartProductId, cart.getOrDefault(cartProductId, 0) + 1);
                    session.setAttribute("cart", cart);
                    response.setContentType("application/json");
                    response.getWriter().write("{\"status\":\"success\"}");
                    break;

                case "removeFromCart":
                    int removeProductId = Integer.parseInt(request.getParameter("productId"));
                    cart = (HashMap<Integer, Integer>) session.getAttribute("cart");
                    if (cart != null && cart.containsKey(removeProductId)) {
                        cart.remove(removeProductId);
                        session.setAttribute("cart", cart);
                    }
                    response.sendRedirect("MainController?action=viewCart");
                    break;

                case "getCart":
                    cart = (HashMap<Integer, Integer>) session.getAttribute("cart");
                    response.setContentType("application/json");
                    StringBuilder json = new StringBuilder("{");
                    if (cart != null && !cart.isEmpty()) {
                        for (Map.Entry<Integer, Integer> entry : cart.entrySet()) {
                            json.append("\"").append(entry.getKey()).append("\":").append(entry.getValue()).append(",");
                        }
                        json.deleteCharAt(json.length() - 1); // Xóa dấu phẩy cuối cùng
                    }
                    json.append("}");
                    response.getWriter().write(json.toString());
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
                case "deleteUser":
                    try {
                        int userId = Integer.parseInt(request.getParameter("userId"));
                        boolean deleted = userDAO.deleteUser(userId);
                        if (deleted) {
                            response.sendRedirect("MainController?action=manageUsers");
                        } else {
                            request.setAttribute("error", "Không thể xóa người dùng.");
                            request.getRequestDispatcher("Users.jsp").forward(request, response);
                        }
                    } catch (Exception e) {
                        request.setAttribute("error", "Lỗi khi xóa người dùng: " + e.getMessage());
                        request.getRequestDispatcher("Users.jsp").forward(request, response);
                    }
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
