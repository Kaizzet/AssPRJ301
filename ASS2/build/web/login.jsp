<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="../css/styles.css">
    <style>
        body {
            background-color: black;
            color: white;
            font-family: Arial, sans-serif;
            text-align: center;
        }
        .login-container {
            width: 300px;
            margin: 100px auto;
            padding: 20px;
        }
        .login-container h2 {
            font-size: 24px;
            margin-bottom: 20px;
        }
        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid white;
            background-color: black;
            color: white;
        }
        .forgot-password {
            display: block;
            margin: 10px 0;
            color: white;
            text-decoration: underline;
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
        .register-link {
            display: block;
            margin-top: 10px;
            color: white;
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h2>Đăng nhập</h2>
        <form action="LoginServlet" method="post">
            <input type="text" name="username" placeholder="Email" required>
            <input type="password" name="password" placeholder="Mật khẩu" required>
            <a href="#" class="forgot-password">Quên mật khẩu?</a>
            <button type="submit">Đăng nhập</button>
        </form>
        <a href="register.jsp" class="register-link">Tạo tài khoản</a>
        <a href="Main.jsp" class="register-link">Quay lại cửa hàng</a>
    </div>
</body>
</html>