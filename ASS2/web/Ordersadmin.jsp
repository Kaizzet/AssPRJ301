<%@ page import="java.util.List" %>
<%@ page import="Orders.OrderDAO" %>
<%@ page import="Orders.OrderDTO" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    OrderDAO orderDAO = new OrderDAO();
    int pageOrder = 1;
    int ordersPerPage = 5;

    if (request.getParameter("page") != null) {
        try {
            pageOrder = Integer.parseInt(request.getParameter("page"));
        } catch (NumberFormatException e) {
            pageOrder = 1;
        }
    }

    List<OrderDTO> orderList = orderDAO.getOrdersByPage(pageOrder, ordersPerPage);
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Quản lý Đơn hàng</title>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/css/admin.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>
<body>

    <!-- ✅ Thanh điều hướng -->
    <nav class="navbar">
        <div class="nav-left">
            <h2 class="logo">HELIOS</h2>
            <ul class="nav-menu">
                <li><a href="Homepageadmin.jsp">Home</a></li>
                <li><a href="Ordersadmin.jsp" class="active">Orders</a></li>
                <li><a href="Productsadmin.jsp">Products</a></li>
                <li><a href="Usersadmin.jsp">Users</a></li>
            </ul>
        </div>
        <div class="nav-right">
            <img src="../images/avatar.png" alt="Avatar" class="avatar">
        </div>
    </nav>

    <!-- ✅ Header -->
    <div class="sub-header">
        <h1>Quản lý Đơn hàng</h1>
    </div>

    <!-- ✅ Nội dung chính -->
    <div class="content">
        <section class="page-section">
            <div class="table-container">
                <% if (orderList.isEmpty()) { %>
                <p class="no-results">Không có đơn hàng nào.</p>
                <% } else { %>
                <table id="ordersTable">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Ngày tạo</th>
                            <th>Người dùng</th>
                            <th>Trạng thái</th>
                            <th>Tổng tiền</th>
                            <th>Số sản phẩm</th>
                            <th>Địa chỉ</th>
                            <th>Thao tác</th>
                        </tr>
                    </thead>
                    <tbody>
                         <% for (OrderDTO order : orderList) {%>
                        <tr>
                            <td>#<%= order.getOrderId()%></td>
                            <td><%= order.getCreatedAt()%></td>
                            <td><%= order.getUserId()%></td>
                            <td>
                                <select id="status_<%= order.getOrderId()%>" 
                                        onchange="updateOrderStatus(<%= order.getOrderId()%>)">
                                    <option value="Pending" <%= order.getStatus().equals("Pending") ? "selected" : ""%>>Chờ xử lý</option>
                                    <option value="Processing" <%= order.getStatus().equals("Processing") ? "selected" : ""%>>Đang xử lý</option>
                                    <option value="Shipped" <%= order.getStatus().equals("Shipped") ? "selected" : ""%>>Đã giao</option>
                                    <option value="Delivered" <%= order.getStatus().equals("Delivered") ? "selected" : ""%>>Hoàn thành</option>
                                    <option value="Cancelled" <%= order.getStatus().equals("Cancelled") ? "selected" : ""%>>Hủy đơn</option>
                                </select>
                            </td>
                            <td><%= String.format("%,.0f", order.getTotalPrice())%> VNĐ</td>
                            <td>
                                <a href="OrderDetails.jsp?orderId=<%= order.getOrderId()%>" class="view-items">
                                    <%= order.getTotalItems()%>
                                </a>
                            </td>
                            <td><%= order.getShippingAddress()%></td>
                            <td>
                                <span class="material-icons edit-icon" onclick="editOrder(<%= order.getOrderId()%>)">edit</span>
                                <span class="material-icons delete-icon" onclick="deleteOrder(<%= order.getOrderId()%>)">delete</span>
                            </td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
                <% } %>
            </div>

            <!-- ✅ Phân trang -->
            < <%
                    int totalOrders = orderDAO.getTotalOrders();
                    int totalPages = (int) Math.ceil((double) totalOrders / ordersPerPage);
                %>
                <span>Page <%= pageOrder%> of <%= totalPages%></span>

                <% if (pageOrder > 1) {%>
                <a href="Ordersadmin.jsp?page=<%= pageOrder - 1%>">&laquo; Previous</a>
                <% } %>

                <% if (pageOrder < totalPages) {%>
                <a href="Ordersadmin.jsp?page=<%= pageOrder + 1%>">Next &raquo;</a>
                <% } %>
            </div>
        </section>
    </div>

    <!-- ✅ Scripts -->
    <script>
         function editOrder(orderId) {
            window.location.href = `EditOrder.jsp?orderId=${orderId}`;
        }

        function deleteOrder(orderId) {
            if (confirm("Bạn có chắc muốn xóa đơn hàng này không?")) {
                fetch(`MainController?action=deleteOrder&orderId=${orderId}`, {
                    method: "POST",
                    headers: {"Content-Type": "application/x-www-form-urlencoded"}
                })
                .then(response => response.text())
                .then(data => {
                    if (data.trim() === "success") {
                        alert("Đã xóa đơn hàng!");
                        location.reload();
                    } else {
                        alert("Không thể xóa đơn hàng.");
                    }
                })
                .catch(error => console.error("Lỗi:", error));
            }
            }
         function updateOrderStatus(orderId) {
            let statusSelect = document.getElementById("status_" + orderId);
            let newStatus = statusSelect.value;

            fetch("MainController?action=updateOrderStatus", {
                method: "POST",
                headers: {
                    "Content-Type": "application/x-www-form-urlencoded"
                },
                body: `orderId=${orderId}&status=${newStatus}`
            })
            .then(response => response.text())
            .then(data => {
                if (data.trim() === "success") {
                    alert("Cập nhật trạng thái thành công!");
                } else {
                    alert("Cập nhật thất bại!");
                }
            })