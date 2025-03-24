<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tạo tài khoản</title>
    <link rel="stylesheet" href="css/styles.css">

</head>
<body class="register-page">
    <div class="register-container">
        <h2>Tạo tài khoản</h2>
        <form action="RegisterServlet" method="post">
            <input type="text" name="lastname" placeholder="Họ" required>
            <input type="text" name="firstname" placeholder="Tên" required>
            <input type="email" name="email" placeholder="Email" required>
            <input type="text" name="phone" placeholder="Số điện thoại" required>
            <input type="password" name="password" placeholder="Mật khẩu" required>
            <button class="create-account" type="submit">Tạo tài khoản</button>
        </form>
        <a href="MainController?action=loadProducts&page=1 " class="back-link">Quay lại cửa hàng</a>
    </div>
</body>
</html>
