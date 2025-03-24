<%@ page import="java.util.List" %>
<%@ page import="Orders.OrderDAO" %>
<%@ page import="Orders.OrderDTO" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    OrderDAO orderDAO = new OrderDAO();
    List<OrderDTO> orderList = orderDAO.getAllOrders();
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Orders Admin</title>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/css/admin.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>
<body>

    <!-- NAVBAR -->
    <nav class="navbar">
        <div class="nav-left">
            <h2 class="logo">HELIOS</h2>
            <ul class="nav-menu">
                <li><a href="Homepageadmin.jsp" class="active">Home</a></li>
                <li><a href="Ordersadmin.jsp">Orders</a></li>
                <li><a href="Productsadmin.jsp">Products</a></li>
                <li><a href="Usersadmin.jsp">Users</a></li>
            </ul>
        </div>
        <div class="nav-right">
            <img src="../images/avatar.png" alt="Avatar" class="avatar">
        </div>
    </nav>

    <div class="sub-header">
        <h1>Orders</h1>
        <input type="text" id="searchInput" class="search-box" placeholder="Search orders..." onkeyup="searchTable()">
    </div>

    <div class="content">
        <section class="page-section">
            <div class="table-container">
                <table id="ordersTable">
                    <thead>
                        <tr>
                            <th><input type="checkbox" onclick="toggleAll('ordersTable')"></th>
                            <th>ORDER ID</th>
                            <th>DATE</th>
                            <th>USER ID</th>
                            <th>STATUS</th>
                            <th>TOTAL</th>
                            <th>ITEMS</th>
                            <th>ADDRESS</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
    <% for (OrderDTO order : orderList) { %>
    <tr>
        <td><input type="checkbox"></td>
        <td><%= order.getOrderId()%></td>
        <td><%= order.getCreatedAt()%></td>
        <td><%= order.getUserId()%></td>
        <td>
            <select id="status_<%= order.getOrderId() %>" onchange="updateOrderStatus(<%= order.getOrderId() %>)">
                <option value="Pending" <%= order.getStatus().equals("Pending") ? "selected" : "" %>>Chờ xử lý</option>
                <option value="Processing" <%= order.getStatus().equals("Processing") ? "selected" : "" %>>Đang xử lý</option>
                <option value="Shipped" <%= order.getStatus().equals("Shipped") ? "selected" : "" %>>Đã giao</option>
                <option value="Delivered" <%= order.getStatus().equals("Delivered") ? "selected" : "" %>>Hoàn thành</option>
                <option value="Cancelled" <%= order.getStatus().equals("Cancelled") ? "selected" : "" %>>Hủy đơn</option>
            </select>
        </td>

        <td><%= order.getTotalPrice()%></td>
        <td>
            <a href="OrderDetails.jsp?orderId=<%= order.getOrderId()%>" class="view-items">
                <%= order.getTotalItems()%>
            </a>
        </td>
        <td><%= order.getShippingAddress()%></td>
        <td>
            <span class="material-icons edit-icon" onclick="editRow(<%= order.getOrderId()%>)">edit</span>
            <span class="material-icons delete-icon" onclick="deleteRow(<%= order.getOrderId()%>)">delete</span>
        </td>
    </tr>
    <% } %>
</tbody>

                </table>
            </div>
            <div class="pagination">
                <a href="#">&laquo; Previous</a>
                <a href="#" class="active">1</a>
                <a href="#">Next &raquo;</a>
            </div>
        </section>
    </div>

    <!-- JavaScript -->
    <script>
        function searchTable() {
            const keyword = document.getElementById('searchInput').value.toLowerCase();
            const rows = document.getElementById('ordersTable').querySelectorAll('tbody tr');
            rows.forEach(row => {
                const text = row.innerText.toLowerCase();
                row.style.display = text.indexOf(keyword) > -1 ? '' : 'none';
            });
        }

        function toggleAll(tableId) {
            const table = document.getElementById(tableId);
            const headCB = table.querySelector('thead input[type="checkbox"]');
            const rowCBs = table.querySelectorAll('tbody input[type="checkbox"]');
            rowCBs.forEach(cb => cb.checked = headCB.checked);
        }

        function editRow(orderId) {
            window.location.href = "EditOrder.jsp?orderId=" + orderId;
        }

        function deleteRow(orderId) {
            if (confirm("Are you sure you want to delete this order?")) {
                fetch("DeleteOrder.jsp?orderId=" + orderId, { method: "GET" })
                    .then(response => response.text())
                    .then(data => {
                        if (data.trim() === "success") {
                            alert("Order deleted successfully!");
                            location.reload();
                        } else {
                            alert("Failed to delete order.");
                        }
                    })
                    .catch(error => console.error("Error:", error));
            }
        }
        function updateOrderStatus(orderId) {
    const status = document.getElementById("status_" + orderId).value;

    console.log("Updating order:", orderId, "with status:", status); // Debug

    if (!orderId || isNaN(orderId)) {
        alert("Lỗi: orderId không hợp lệ!");
        return;
    }

    fetch("MainController?action=updateOrderStatus", {
        method: "POST",
        headers: { "Content-Type": "application/x-www-form-urlencoded" },
        body: `orderId=${orderId}&status=${status}`
    })
    .then(response => response.text())
    .then(data => {
        console.log("Server response:", data); // Debug

        if (data.trim() === "success") {
            alert("Cập nhật trạng thái thành công!");
            location.reload();
        } else {
            alert("Lỗi khi cập nhật trạng thái: " + data);
        }
    })
    .catch(error => console.error("Error:", error));
}
    </script>

</body>
</html>
