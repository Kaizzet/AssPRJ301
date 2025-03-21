<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, Product.ProductDTO, Category.CategoryDTO" %>
<%
    List<ProductDTO> products = (List<ProductDTO>) request.getAttribute("products");
    List<CategoryDTO> categories = (List<CategoryDTO>) request.getAttribute("categories");
    int currentPage = (request.getAttribute("currentPage") != null) ? (Integer) request.getAttribute("currentPage") : 1;
    int totalPages = (request.getAttribute("totalPages") != null) ? (Integer) request.getAttribute("totalPages") : 1;
%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Helios Clone</title>
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
            <div class="logo">𝓗𝓔𝓛𝓘𝓞𝓢</div>
            <div class="user-options">
                <a style="color: white" href="<%= request.getContextPath()%>/register.jsp">Đăng ký</a>
                <span style="color: white">/</span> 
                <a style="color: white" href="<%= request.getContextPath()%>/login.jsp"> Đăng nhập</a>
                <a href="#" class="cart">🛒</a>
            </div>
        </header>

        <!-- BANNER -->
        <section class="banner">
            <img src="https://raw.githubusercontent.com/tuanptse/ASSprj/main/ASS2/web/images/banner.jpg" alt="Helios Banner">
        </section>

        <!-- SẢN PHẨM MỚI -->
        <section class="products">
            <h2>Sản phẩm mới</h2>
            <div class="product-list">
                <% if (products != null && !products.isEmpty()) {
                        for (ProductDTO p : products) {%>
                <div class="product">
                    <img src="<%= p.getImageUrl()%>" alt="<%= p.getName()%>">
                    <h3><%= p.getName()%></h3>
                    <p><strong><%= String.format("%,.0f", p.getPrice())%> VNĐ</strong></p>
                    <p><%= p.getDescription()%></p>
                    <button>Thêm nhanh</button>
                </div>
                <%  }
                } else { %>
                <p>Không có sản phẩm nào để hiển thị.</p>
                <% }%>
            </div>
        </section>
        <jsp:include page="paging.jsp"/>

        <!-- FOOTER -->
        <footer>
            <p>&copy; 2025 Helios. All rights reserved.</p>
        </footer>

        <script>
            document.addEventListener("DOMContentLoaded", function () {
                let header = document.querySelector("header");

                // Khi không di chuột vào, header sẽ mất màu
                header.classList.add("transparent");

                // Khi trỏ chuột vào header, nó hiện màu đen
                header.addEventListener("mouseenter", function () {
                    header.classList.remove("transparent");
                });

                // Khi chuột rời khỏi header, nó trở lại trong suốt
                header.addEventListener("mouseleave", function () {
                    header.classList.add("transparent");
                });
            });
        </script>

    </body>
</html>
