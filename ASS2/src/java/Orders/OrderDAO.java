package Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

public class OrderDAO {
    public List<OrderDTO> getAllOrders() throws SQLException {
        List<OrderDTO> orders = new ArrayList<>();
        String sql = "SELECT * FROM Orders";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                OrderDTO order = new OrderDTO();
                order.setOrderId(rs.getInt("id"));
                order.setUserId(rs.getInt("userId"));
                order.setTotalPrice(rs.getDouble("totalPrice"));
                order.setShippingAddress(rs.getString("shippingAddress"));
                order.setStatus(rs.getString("status"));
                order.setCreatedAt(rs.getString("createdAt"));
                orders.add(order);
            }
        }
        return orders;
    }
}
