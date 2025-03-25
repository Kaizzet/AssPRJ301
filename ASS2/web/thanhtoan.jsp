<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thanh Toán - Helios</title>
    <!-- Link tới file CSS (giả sử bạn để trong thư mục css) -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/thanhtoan.css">
</head>
<body>

<!-- HEADER (nếu cần) -->


<!-- NỘI DUNG TRANG THANH TOÁN -->
<div class="checkout-container">
    <!-- CỘT BÊN TRÁI: Thông tin liên hệ & giao hàng -->
    <div class="checkout-left">
        <!-- LIÊN HỆ -->
        <section class="section-contact">
            <h2>Liên hệ</h2>
            <div class="input-group">
                <label for="contactInput">Email hoặc số điện thoại di động</label>
                <input type="text" id="contactInput" placeholder="Nhập email hoặc số điện thoại">
            </div>
            <div class="checkbox-group">
                <input type="checkbox" id="subscribe">
                <label for="subscribe">Giữ tôi cập nhật các ưu đãi qua email</label>
            </div>
        </section>

        <!-- GIAO HÀNG -->
        <section class="section-shipping">
            <h2>Giao hàng</h2>
            <!-- Quốc gia/khu vực -->
            <div class="input-group">
                <label for="country">Quốc gia/Khu vực</label>
                <select id="country">
                    <option value="vn">Việt Nam</option>
                    <option value="us">Hoa Kỳ</option>
                    <option value="jp">Nhật Bản</option>
                    <!-- Thêm tuỳ chọn khác nếu cần -->
                </select>
            </div>
            <!-- Tên & Họ -->
            <div class="input-row">
                <div class="input-group">
                    <label for="firstName">Tên</label>
                    <input type="text" id="firstName" placeholder="Tên">
                </div>
                <div class="input-group">
                    <label for="lastName">Họ</label>
                    <input type="text" id="lastName" placeholder="Họ">
                </div>
            </div>
            <!-- Địa chỉ, Thành phố -->
            <div class="input-group">
                <label for="address">Địa chỉ</label>
                <input type="text" id="address" placeholder="Số nhà, tên đường...">
            </div>
            <div class="input-row">
                <div class="input-group">
                    <label for="city">Thành phố</label>
                    <input type="text" id="city" placeholder="VD: Hà Nội, TP.HCM...">
                </div>
                <div class="input-group">
                    <label for="postalCode">Mã bưu chính (nếu có)</label>
                    <input type="text" id="postalCode" placeholder="VD: 100000">
                </div>
            </div>
            <!-- Điện thoại -->
            <div class="input-group">
                <label for="phone">Điện thoại</label>
                <input type="text" id="phone" placeholder="Số điện thoại">
            </div>
            <!-- Phương thức vận chuyển -->
            <section class="section-delivery">
                <h3>Phương thức vận chuyển</h3>
                <div class="delivery-option">
                    <input type="radio" id="ship-free" name="delivery" checked>
                    <label for="ship-free">Miễn phí</label>
                </div>
                <!-- Nếu có nhiều tuỳ chọn, thêm ở đây -->
            </section>
        </section>
    </div>

    <!-- CỘT BÊN PHẢI: Tóm tắt đơn hàng -->
    <div class="checkout-right">
        <div class="order-summary">
            <div class="summary-item">
                <img src="${pageContext.request.contextPath}/images/ring-demo.png" alt="Mẫu Lotus Ring Helios Silver">
                <div class="item-info">
                    <p class="item-name">Mẫu Lotus Ring Helios Silver</p>
                    <p class="item-size">Size 7</p>
                    <p class="item-price">1.250.000 đ</p>
                </div>
            </div>
            <hr>
            <div class="summary-fee">
                <div class="fee-row">
                    <span>Tổng phụ</span>
                    <span>1.250.000 đ</span>
                </div>
                <div class="fee-row">
                    <span>Vận chuyển</span>
                    <span>MIỄN PHÍ</span>
                </div>
            </div>
            <hr>
            <div class="summary-total">
                <div class="fee-row">
                    <span class="total-label">Tổng</span>
                    <span class="total-amount">1.250.000 đ</span>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- FOOTER (nếu cần) -->
<footer class="footer">
    <p>© 2025 Helios. All rights reserved.</p>
</footer>

</body>
</html>
