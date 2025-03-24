<%@ page import="java.util.List" %>
<%@ page import="Users.UserDAO" %>
<%@ page import="Users.UserDTO" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Users Admin</title>
  <link rel="stylesheet" href="<%= request.getContextPath()%>/css/admin.css">
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>
<body>
  <nav class="navbar">
    <div class="nav-left">
      <h2 class="logo">HELIOS</h2>
      <ul class="nav-menu">
        <li><a href="Homepageadmin.jsp">Home</a></li>
        <li><a href="Ordersadmin.jsp">Orders</a></li>
        <li><a href="Productsadmin.jsp">Products</a></li>
        <li><a href="Usersadmin.jsp" class="active">Users</a></li>
      </ul>
    </div>
    <div class="nav-right">
      <img src="../images/avatar.png" alt="Avatar" class="avatar">
    </div>
  </nav>

  <div class="sub-header">
    <h1>Users</h1>
    <form method="GET">
        <input type="text" id="searchInput" name="keyword" placeholder="Nhập từ khóa..." 
               value="<%= request.getParameter("keyword") != null ? request.getParameter("keyword") : "" %>"
               onkeyup="searchUsers()">
        <button type="submit">Tìm kiếm</button>
    </form>
  </div>

  <div class="content">
    <section class="page-section">
      <div class="table-container">
        <table id="usersTable">
          <thead>
            <tr>
              <th>USER ID</th>
              <th>NAME</th>
              <th>EMAIL</th>
              <th>PHONE</th>
              <th>ADDRESS</th>
              <th>CREATED_AT</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            <% 
              UserDAO userDAO = new UserDAO();
              String keyword = request.getParameter("keyword");
              List<UserDTO> userList = (keyword != null && !keyword.isEmpty()) 
                                        ? userDAO.searchUsers(keyword) 
                                        : userDAO.getAllUsers();

              if (userList.isEmpty()) { 
            %>
                <tr>
                  <td colspan="7" style="text-align:center;">Không tìm thấy người dùng</td>
                </tr>
            <% } else {
                for (UserDTO user : userList) { %>
                  <tr id="userRow-<%= user.getUserId() %>">
                    <td><%= user.getUserId() %></td>
                    <td><%= user.getName() %></td>
                    <td><%= user.getEmail() %></td>
                    <td><%= user.getPhone() %></td>
                    <td><%= user.getAddress() %></td>
                    <td><%= user.getCreatedAt() %></td>
                    <td>
   
                      <span class="material-icons delete-icon" onclick="confirmDelete(<%= user.getUserId() %>)">delete</span>
                    </td>
                  </tr>
                <% } 
              } %>
          </tbody>
        </table>
      </div>
    </section>
  </div>

  <script>
    function searchUsers() {
      let keyword = document.getElementById('searchInput').value;

      fetch("MainController?action=searchUsers&keyword=" + encodeURIComponent(keyword), {
          method: "GET"
      })
      .then(response => response.json())
      .then(data => {
          let tableBody = document.querySelector("#usersTable tbody");
          tableBody.innerHTML = ""; // Xóa dữ liệu cũ

          if (data.length === 0) {
              tableBody.innerHTML = "<tr><td colspan='7' style='text-align:center'>Không tìm thấy người dùng</td></tr>";
              return;
          }

          data.forEach(user => {
              let row = `<tr id="userRow-${user.userId}">
                  <td>${user.userId}</td>
                  <td>${user.name}</td>
                  <td>${user.email}</td>
                  <td>${user.phone}</td>
                  <td>${user.address}</td>
                  <td>${user.createdAt}</td>
                  <td>
                      <span class="material-icons edit-icon" onclick="editRow(this)">edit</span>
                      <span class="material-icons delete-icon" onclick="confirmDelete(${user.userId})">delete</span>
                  </td>
              </tr>`;
              tableBody.innerHTML += row;
          });
      })
      .catch(error => console.error("Lỗi khi tìm kiếm:", error));
    }

    function confirmDelete(userId) {
      if (confirm("Bạn có chắc chắn muốn xóa người dùng này không?")) {
          fetch("MainController?action=deleteUser&userId=" + userId, {
              method: "GET"
          })
          .then(response => response.json())
          .then(data => {
              if (data.status === "success") {
                  document.getElementById("userRow-" + userId).remove();
              } else {
                  alert("Xóa thất bại: " + data.message);
              }
          })
          .catch(error => console.error("Lỗi khi gửi yêu cầu xóa:", error));
      }
    }

    function editRow(elem) {
      alert("Edit row (demo).");
    }
  </script>

</body>
</html>
