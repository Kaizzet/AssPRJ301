package Product;

import Orders.OrderDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

public class ProductDAO {

    // ✅ Lấy tất cả sản phẩm
    public List<ProductDTO> getAllProducts() {
        List<ProductDTO> products = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                products.add(mapResultSetToProduct(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    // ✅ Lấy sản phẩm theo danh mục
    public List<ProductDTO> getProductsByCategory(String categoryId) {
        List<ProductDTO> products = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE category_id = ? ORDER BY created_at DESC";

        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, categoryId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                products.add(mapResultSetToProduct(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    // ✅ Lấy sản phẩm theo trang (Phân trang)
    public List<ProductDTO> getProductsByPage(int page, int productsPerPage) {
        List<ProductDTO> productList = new ArrayList<>();
        int offset = (page - 1) * productsPerPage;
        String sql = "SELECT * FROM products ORDER BY created_at ASC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, offset);
            ps.setInt(2, productsPerPage);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                productList.add(mapResultSetToProduct(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    // ✅ Đếm tổng số sản phẩm (Hỗ trợ phân trang)
    public int getTotalProducts() {
        int count = 0;
        String sql = "SELECT COUNT(*) FROM products";

        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    // ✅ Lấy sản phẩm theo ID (Fix lỗi UnsupportedOperationException)
    public ProductDTO getProductById(int productId) {
        String sql = "SELECT * FROM products WHERE product_id = ?";

        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return mapResultSetToProduct(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Trả về null nếu không tìm thấy sản phẩm
    }

    // ✅ Hàm tái sử dụng để tạo ProductDTO từ ResultSet
    private ProductDTO mapResultSetToProduct(ResultSet rs) throws SQLException {
        return new ProductDTO(
                rs.getInt("product_id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getDouble("price"),
                rs.getString("material"),
                rs.getInt("category_id"),
                rs.getString("image_url"),
                rs.getTimestamp("created_at").toLocalDateTime(),
                rs.getInt("product_amount")
        );
    }
    
    
    public List<ProductDTO> searchProducts(String keyword) {
    String sql = "SELECT * FROM products WHERE name LIKE ?";
    List<ProductDTO> productList = new ArrayList<>();

    try (Connection conn = DBUtils.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, "%" + keyword + "%"); // Tìm kiếm theo từ khóa
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            productList.add(mapResultSetToProduct(rs)); // Dùng mapResultSetToProduct để tạo đối tượng ProductDTO
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return productList;
}

     public List<OrderDTO> getOrdersByPage(int page, int ordersPerPage) {
        List<OrderDTO> orderList = new ArrayList<>();
        int offset = (page - 1) * ordersPerPage;
        String sql = "SELECT * FROM Orders ORDER BY created_at DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, offset);
            ps.setInt(2, ordersPerPage);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                orderList.add(mapResultSetToOrder(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }
     
      public int getTotalOrders() {
        int count = 0;
        String sql = "SELECT COUNT(*) FROM Orders";

        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

  
    private OrderDTO mapResultSetToOrder(ResultSet rs) throws SQLException {
        OrderDTO order = new OrderDTO();
        order.setOrderId(rs.getInt("order_id"));
        order.setUserId(rs.getInt("user_id"));
        order.setTotalPrice(rs.getDouble("total_price"));
        order.setShippingAddress(rs.getString("shipping_address"));
        order.setStatus(rs.getString("status"));
        order.setCreatedAt(rs.getString("created_at"));

        // ❌ `total_items` không có trong tất cả truy vấn => Tránh lỗi khi không có cột này
        try {
            order.setTotalItems(rs.getInt("total_items"));
        } catch (SQLException e) {
            order.setTotalItems(0);
        }

        return order;
    }
    

  public boolean updateProduct(int productId, String name, String material, double price, int amount) {
    String sql = "UPDATE Products SET Name = ?, Material = ?, Price = ?, Amount = ? WHERE ProductID = ?";
    try (Connection conn = DBUtils.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, name);
        ps.setString(2, material);
        ps.setDouble(3, price);
        ps.setInt(4, amount);
        ps.setInt(5, productId);
        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

}
