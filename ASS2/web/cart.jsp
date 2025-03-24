<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Map, java.util.HashMap, Product.ProductDAO, Product.ProductDTO" %>

<%
    // Lấy giỏ hàng từ session
    HashMap<Integer, Integer> cart = (HashMap<Integer, Integer>) session.getAttribute("cart");
    if (cart == null) {
        cart = new HashMap<>();
    }

    // Khởi tạo DAO để lấy thông tin sản phẩm
    ProductDAO productDAO = new ProductDAO();
    double totalPrice = 0;
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Giỏ hàng - Helios</title>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/css/styles.css">
    <style>
        .cart-container {
            width: 80%;
            margin: 50px auto;
            padding: 20px;
            background: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }
        .home-btn {
            display: inline-block;
            margin-bottom: 15px;
            padding: 10px 15px;
            background: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        .home-btn:hover {
            background: #0056b3;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }
        th {
            background: #f4f4f4;
        }
        .cart-item img {
            width: 60px;
            height: 60px;
            border-radius: 5px;
        }
        .cart-actions button {
            padding: 5px 10px;
            background: #ff4d4d;
            color: white;
            border: none;
            cursor: pointer;
            border-radius: 4px;
        }
        .cart-actions button:hover {
            background: #e63939;
        }
        .total-price {
            font-size: 18px;
            font-weight: bold;
            text-align: right;
            margin-top: 20px;
        }
        .checkout-btn {
            display: block;
            text-align: center;
            background: #28a745;
            color: white;
            padding: 10px;
            border-radius: 5px;
            text-decoration: none;
            margin-top: 20px;
        }
        .checkout-btn:hover {
            background: #218838;
        }
    </style>
</head>
<body>
    <div class="cart-container">
        <a href="MainController?action=loadProducts" class="home-btn">🏠 Trang chủ</a>
        <h2>Giỏ hàng của bạn</h2>
        <% if (!cart.isEmpty()) { %>
        <table>
            <tr>
                <th>Hình ảnh</th>
                <th>Sản phẩm</th>
                <th>Số lượng</th>
                <th>Giá</th>
                <th>Thành tiền</th>
                <th>Hành động</th>
            </tr>
            <% for (Map.Entry<Integer, Integer> entry : cart.entrySet()) {
                ProductDTO product = productDAO.getProductById(entry.getKey().intValue());
                if (product != null) { %>
            <tr>
                <td><img class="cart-item" src="<%= product.getImageUrl() %>" alt="<%= product.getName() %>"></td>
                <td><%= product.getName() %></td>
                <td><%= entry.getValue() %></td>
                <td><%= String.format("%,.0f", product.getPrice()) %> VNĐ</td>
                <td><%= String.format("%,.0f", product.getPrice() * entry.getValue()) %> VNĐ</td>
                <td class="cart-actions">
                    <button onclick="removeItem(<%= product.getProductId() %>)">❌ Xóa</button>
                </td>
            </tr>
            <% totalPrice += product.getPrice() * entry.getValue(); %>
            <% } } %>
        </table>
        <p class="total-price">Tổng cộng: <%= String.format("%,.0f", totalPrice) %> VNĐ</p>
        <a href="MainController?action=checkout" class="checkout-btn">Thanh toán ngay</a>
        <% } else { %>
        <p>Giỏ hàng của bạn đang trống.</p>
        <% } %>
    </div>
    <script>
        function removeItem(productId) {
            if (confirm("Bạn có chắc muốn xóa sản phẩm này khỏi giỏ hàng?")) {
                window.location.href = "MainController?action=removeFromCart&productId=" + productId;
            }
        }
    </script>
    <script>
        function updateCartCount() {
    fetch("MainController?action=cartCount")
        .then(response => response.text())
        .then(data => {
            document.getElementById("cart-count").innerText = data;
        })
        .catch(error => console.error("Lỗi cập nhật giỏ hàng:", error));
}

// Gọi hàm này sau khi thêm vào giỏ hàng
document.querySelectorAll(".add-to-cart-btn").forEach(button => {
    button.addEventListener("click", function () {
        let productId = this.getAttribute("data-id");
        fetch("MainController?action=addToCart&productId=" + productId)
            .then(response => response.json())
            .then(() => updateCartCount()); // Cập nhật giỏ hàng ngay lập tức
    });
});

// Cập nhật giỏ hàng khi tải trang
window.onload = updateCartCount;

    </script>
</body>
</html>
