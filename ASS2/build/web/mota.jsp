<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Mô Tả Sản Phẩm - Helios</title>
    <!-- Đường dẫn tới file CSS (giả sử bạn để trong thư mục css) -->
    <link rel="stylesheet" href="<%= request.getContextPath()%>/css/mota.css">
</head>
<body>




    <!-- PHẦN MÔ TẢ SẢN PHẨM -->
    <section class="product-detail">
        <div class="product-images">
            <!-- Bạn có thể chèn ảnh sản phẩm thật tại đây -->
            <img src="${pageContext.request.contextPath}/images/DayChuyenTamTiemLuanHoiXa_AnhWeb_2_460x.png" alt="Chill Guy Key Cap Helios Silver">
        </div>
        <div class="product-info">
            <h2>Chill Guy Key Cap Helios Silver</h2>
            <p class="price">Đang nhập để hiển thị giá</p>
            <div class="button-group">
                <button class="btn-buy">Đặt hàng ngay</button>
                <button class="btn-add-cart">Thêm vào giỏ hàng</button>
            </div>
            <p class="short-desc">
                Đánh thức chất riêng của bạn với Helios. Chất liệu bạc S925, được chế tác thủ công.
            </p>
            <ul class="product-specs">
                <li>Trọng lượng: ~2.3 gram</li>
                <li>Kích thước: 0.25 cm</li>
                <li>Chất liệu: Bạc S925</li>
            </ul>
            <p class="long-desc">
                Công dụng: Dùng làm móc khóa, trang trí, và thể hiện cá tính riêng.  
                <br><br>
                Đằng sau mỗi chiếc tác luôn là một câu chuyện riêng biệt...  
                <br>
                Đây là đoạn mô tả chi tiết sản phẩm, giải thích ý nghĩa, câu chuyện thiết kế, quy trình chế tác, v.v.
            </p>
        </div>
    </section>

    <!-- PHẦN GIỚI THIỆU THÊM / CÂU CHUYỆN THƯƠNG HIỆU -->
    <section class="brand-story">
        <h2>Từ bàn tay thủ công đến những thành phẩm tinh xảo...</h2>
        <p>
            Mỗi sản phẩm bạc Helios là kết tinh của thao tác tỉ mỉ, dòng tư tưởng, và lòng tin từ khách hàng.  
            Chúng tôi luôn mong muốn mang đến những thiết kế độc đáo, phù hợp với cá tính của mỗi người.
        </p>
        <p>
            8 năm hành trình chế tác thủ công bạc, chúng tôi tin rằng mỗi sản phẩm là một tác phẩm nghệ thuật riêng biệt.  
            <br>
            Xem thêm &rarr;
        </p>
    </section>

    <!-- PHẦN GỢI Ý SẢN PHẨM LIÊN QUAN / YOU MAY ALSO LIKE -->
    <section class="related-products">
        <h2>You may also like</h2>
        <div class="products-grid">
            <div class="product-card">
                <img src="${pageContext.request.contextPath}/images/DSC06256_460x.png" alt="Nhẫn 1">
                <h3>Do It Differently Helios Silver</h3>
                <p class="price">1.250.000 đ</p>
                <p>★★★★★ 7 đánh giá</p>
                <button class="btn-view">Xem thêm</button>
            </div>
            <div class="product-card">
                <img src="${pageContext.request.contextPath}/images/DSC02671_540x.png" alt="Nhẫn 2">
                <h3>A.E.F W Helios Silver</h3>
                <p class="price">1.900.000 đ</p>
                <p>★★★★★ 3 đánh giá</p>
                <button class="btn-view">Xem thêm</button>
            </div>
            <div class="product-card">
                <img src="${pageContext.request.contextPath}/images/demo-ring.png" alt="Nhẫn 3">
                <h3>Thiết Kế Helios Silver</h3>
                <p class="price">345.000 đ</p>
                <p>★★★★★ 10 đánh giá</p>
                <button class="btn-view">Xem thêm</button>
            </div>
            <div class="product-card">
                <img src="${pageContext.request.contextPath}/images/demo-ring.png" alt="Nhẫn 4">
                <h3>Double Sk Helios Silver</h3>
                <p class="price">510.000 đ</p>
                <p>★★★★★ 5 đánh giá</p>
                <button class="btn-view">Xem thêm</button>
            </div>
        </div>
    </section>

    <!-- FOOTER -->
    <footer class="footer">
        <p>© 2025 Helios. All rights reserved.</p>
    </footer>

</body>
</html>
