<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tạo tài khoản</title>
    <link rel="stylesheet" href="../css/styles.css">
    <style>
        body {
            background-color: black;
            color: white;
            font-family: Arial, sans-serif;
            text-align: center;
        }
        .register-container {
            width: 300px;
            margin: 50px auto;
            padding: 20px;
        }
        .register-container h2 {
            font-size: 24px;
            margin-bottom: 20px;
        }
        input[type="text"], input[type="email"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid white;
            background-color: black;
            color: white;
        }
        button {
            width: 100%;
            padding: 10px;
            background-color: #FFA500;
            border: none;
            font-size: 16px;
            cursor: pointer;
            color: black;
        }
        .back-link {
            display: block;
            margin-top: 10px;
            color: white;
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="register-container">
        <h2>Tạo tài khoản</h2>
        <form action="RegisterServlet" method="post">
            <input type="text" name="lastname" placeholder="Họ" required>
            <input type="text" name="firstname" placeholder="Tên" required>
            <input type="email" name="email" placeholder="Email" required>
            <input type="text" name="phone" placeholder="Số điện thoại" required>
            <input type="password" name="password" placeholder="Mật khẩu" required>
            <button type="submit">Tạo tài khoản</button>
        </form>
        <a href="Main.jsp" class="back-link">Quay lại cửa hàng</a>
    </div>
</body>
</html>
