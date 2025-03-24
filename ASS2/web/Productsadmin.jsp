<%@ page import="java.util.List" %>
<%@ page import="Product.ProductDAO" %>
<%@ page import="Product.ProductDTO" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <title>Products Admin</title>
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/admin.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    </head>
    <body>
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
            <h1>Products</h1>

            <!-- Form tìm kiếm -->
            <form method="GET" action="MainController">
                <input type="hidden" name="action" value="searchProducts">
                <input type="text" name="keyword" id="searchInput" class="search-box" placeholder="Search products..." 
                       value="<%= request.getParameter("keyword") != null ? request.getParameter("keyword") : ""%>">
                <button type="submit">Search</button>
            </form>
        </div>

        <div class="content">
            <section class="page-section">
                <div class="table-container">
                    <table id="productsTable">
                        <thead>
                            <tr>
                                <th>PRODUCT ID</th>
                                <th>NAME</th>
                                <th>MATERIAL</th>
                                <th>PRICE</th>
                                <th>IMAGE</th>
                                <th>AMOUNT</th>
                                <th>RATE</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                ProductDAO productDAO = new ProductDAO();
                                List<ProductDTO> productList;
                                String keyword = request.getParameter("keyword");
                                int pageProduct = 1;
                                int productsPerPage = 5;

                                if (request.getParameter("page") != null) {
                                    pageProduct = Integer.parseInt(request.getParameter("page"));
                                }

                                if (keyword != null && !keyword.trim().isEmpty()) {
                                    productList = productDAO.searchProducts(keyword);
                                } else {
                                    productList = productDAO.getProductsByPage(pageProduct, productsPerPage);
                                }

                                for (ProductDTO product : productList) {
                            %>
                            <tr data-id="<%= product.getProductId()%>">
                                <td><%= product.getProductId()%></td>
                                <td contenteditable="true"><%= product.getName()%></td>
                                <td contenteditable="true"><%= product.getMaterial()%></td>
                                <td contenteditable="true"><%= product.getPrice()%></td>
                                <td>
                                    <img src="<%= product.getImageUrl()%>" alt="Product Image" width="50">
                                </td>
                                <td contenteditable="true"><%= product.getProductAmount()%></td>
                                <td><%= product.getAverageRating()%></td>
                                <td>
                                    <button onclick="saveChanges(this)">Save</button>
                                </td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>
                </div>

                <% if (keyword == null || keyword.trim().isEmpty()) { %>
                <div class="pagination">
                    <% int totalProducts = productDAO.getTotalProducts();
            int totalPages = (int) Math.ceil((double) totalProducts / productsPerPage);
            if (pageProduct > 1) {%>
                    <a href="Productsadmin.jsp?page=<%= pageProduct - 1%>">&laquo; Previous</a>
                    <% }%>
                    <span>Page <%= pageProduct%> of <%= totalPages%></span>
                    <% if (pageProduct < totalPages) {%>
                    <a href="Productsadmin.jsp?page=<%= pageProduct + 1%>">Next &raquo;</a>
                    <% } %>
                </div>
                <% }%>
            </section>
        </div>

        <script>
            function saveChanges(button) {
                let row = button.closest("tr");
                let productId = row.getAttribute("data-id");
                let name = row.children[1].innerText;
                let material = row.children[2].innerText;
                let price = row.children[3].innerText;
                let amount = row.children[5].innerText;

                let data = {
                    action: "updateProduct",
                    productId: productId,
                    name: name,
                    material: material,
                    price: price,
                    amount: amount
                };

                fetch("MainController", {
                    method: "POST",
                    headers: { "Content-Type": "application/x-www-form-urlencoded" },
                    body: new URLSearchParams(data)
                })
                .then(response => response.json())
                .then(result => {
                    if (result.status === "success") {
                        alert("Cập nhật thành công!");
                    } else {
                        alert("Cập nhật thất bại!");
                    }
                })
                .catch(error => console.error("Lỗi:", error));
            }
        </script>
    </body>
</html>
