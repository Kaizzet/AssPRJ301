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
                    <button class="add-to-cart" data-product-id="<%= p.getProductId()%>">Thêm nhanh</button>
                </div>
        <%  }
        } else { %>
            <p>Không có sản phẩm nào trong danh mục này.</p>
        <% } %>
    </div>
</section>

<!-- FOOTER -->
<footer class="footer">
            <div class="footer-container">
            <!-- Cột 1: KẾT NỐI VỚI CHÚNG TÔI -->
            <div class="footer-column">
            <h2>KẾT NỐI VỚI CHÚNG TÔI</h2>
            <p>
                HELIOS Shop ra đời nhằm mục đích đem đến các dòng sản phẩm trang sức dành cho mọi người: 
                từ vòng tay thanh lịch, dây chuyền, khuyên tai độc đáo đến những món quà tinh tế. 
                Mỗi chiếc tác phẩm đều là tâm huyết và sáng tạo, 
                với hy vọng mang đến trải nghiệm tuyệt vời cho khách hàng.
            </p>
            <p>Hotline tư vấn:</p>
            
            <p>Hỗ trợ: 0981.551.616</p>
            <p>Email: support@helios.vn</p>
            <!-- Logo/badge minh họa -->
            
            </div>

        <!-- Cột 2: CHĂM SÓC KHÁCH HÀNG -->
        

        <!-- Cột 3: VỀ CHÚNG TÔI -->
        
        </div>
    </footer>

</body>
</html>
