<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, Product.ProductDTO, Category.CategoryDTO" %>

<%
    List<ProductDTO> products = (List<ProductDTO>) request.getAttribute("products");
    List<CategoryDTO> categories = (List<CategoryDTO>) request.getAttribute("categories");
    String categoryName = (String) request.getAttribute("categoryName");
%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><%= categoryName != null ? categoryName : "Danh mục sản phẩm" %></title>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/css/styles.css">
</head>
<body>

<!-- HEADER -->
<header>
    <nav>
        <ul>
            <li class="dropdown">
                <a href="#">MENU</a>
                <ul class="dropdown-content">
                    <% if (categories != null && !categories.isEmpty()) {
                        for (CategoryDTO category : categories) { %>
                            <li>
                                <a href="MainController?action=loadCategory&category=<%= category.getCategoryId() %>">
                                    <%= category.getCategoryName() %>
                                </a>
                            </li>
                    <%  }
                    } else { %>
                        <li><a href="#">Không có danh mục</a></li>
                    <% } %>
                </ul>
            </li>
            <li><a href="#">COLLECTIONS</a></li>
            <li><a href="#" class="highlight">CUỐI MÙA</a></li>
        </ul>
    </nav>       
<div class="logo">
    <a href="MainController?action=loadProducts&page=1">𝓗𝓔𝓛𝓘𝓞𝓢</a>
</div>


    <div class="user-options">
        <a style="color: white" href="<%= request.getContextPath()%>/register.jsp">Đăng ký</a>
        <span style="color: white">/</span> 
        <a style="color: white" href="<%= request.getContextPath()%>/login.jsp"> Đăng nhập</a>
        <a href="#" class="cart">🛒</a>
    </div>
</header>

<!-- TIÊU ĐỀ DANH MỤC -->
<section class="category-header">
    <h2><%= categoryName != null ? categoryName : "Sản phẩm" %></h2>
</section>

<!-- DANH SÁCH SẢN PHẨM -->
<section class="products">
    <div class="product-list">
        <% if (products != null && !products.isEmpty()) {
            for (ProductDTO p : products) { %>
                <div class="product">
                    <img src="<%= p.getImageUrl()%>" alt="<%= p.getName()%>">
                    <h3><%= p.getName()%></h3>
                    <p><strong><%= String.format("%,.0f", p.getPrice())%> VNĐ</strong></p>
                    <p><%= p.getDescription()%></p>
                    <button>Thêm nhanh</button>
                </div>
        <%  }
        } else { %>
            <p>Không có sản phẩm nào trong danh mục này.</p>
        <% } %>
    </div>
</section>

<!-- FOOTER -->
<footer>
    <p>&copy; 2025 Helios. All rights reserved.</p>
</footer>

</body>
</html>
