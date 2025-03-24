package Orders;

import utils.DBUtils;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    // Lấy danh sách tất cả đơn hàng
   public List<OrderDTO> getAllOrders() {
    List<OrderDTO> orderList = new ArrayList<>();
String sql = "SELECT o.*, COUNT(oi.product_id) AS total_items " +
             "FROM orders o " +
             "LEFT JOIN Order_Items oi ON o.order_id = oi.order_id " +
             "GROUP BY o.order_id, o.user_id, o.created_at, o.status, o.total_price, o.shipping_address";


    try (Connection conn = DBUtils.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            OrderDTO order = new OrderDTO();
            order.setOrderId(rs.getInt("order_id"));
            order.setUserId(rs.getInt("user_id"));
            order.setCreatedAt(rs.getString("created_at"));
            order.setStatus(rs.getString("status"));
            order.setTotalPrice(rs.getDouble("total_price"));
            order.setTotalItems(rs.getInt("total_items")); // ✅ Đếm số lượng sản phẩm từ Order_Items
            order.setShippingAddress(rs.getString("shipping_address"));
            orderList.add(order);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return orderList;
}


    // Lấy đơn hàng theo ID
    public OrderDTO getOrderById(int orderId) {
        String sql = "SELECT * FROM orders WHERE order_id = ?";
        try (Connection conn = DBUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                OrderDTO order = new OrderDTO();
                order.setOrderId(rs.getInt("order_id"));
                order.setUserId(rs.getInt("user_id"));
                order.setStatus(rs.getString("status"));
                order.setTotalPrice(rs.getDouble("total_price"));
                order.setShippingAddress(rs.getString("shipping_address"));
                order.setCreatedAt(rs.getString("created_at")); // created_at là String trong DTO
                return order;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Thêm đơn hàng mới
    public boolean insertOrder(OrderDTO order) {
        String sql = "INSERT INTO orders (user_id, status, total_price, shipping_address, created_at) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, order.getUserId());
            ps.setString(2, order.getStatus());
            ps.setDouble(3, order.getTotalPrice());
            ps.setString(4, order.getShippingAddress());
            ps.setString(5, order.getCreatedAt()); // created_at là String

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    order.setOrderId(rs.getInt(1)); // Lấy ID vừa tạo
                }
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Cập nhật đơn hàng

    // Xóa đơn hàng
    public boolean deleteOrder(int orderId) {
        String sql = "DELETE FROM orders WHERE order_id = ?";
        try (Connection conn = DBUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, orderId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
 public boolean updateOrderStatus(int orderId, String status) {
   String sql = "UPDATE Orders SET status = ? WHERE order_id = ?";
    try (Connection conn = DBUtils.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, status);
        stmt.setInt(2, orderId);
        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
}
