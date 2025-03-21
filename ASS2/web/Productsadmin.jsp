<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Products Admin</title>
  <!-- Đường dẫn tới file CSS -->
  <link rel="stylesheet" href="<%= request.getContextPath()%>/css/admin.css">
  <!-- Google Material Icons -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>
<body>
  <!-- NAVBAR -->
  <nav class="navbar">
    <div class="nav-left">
      <h2 class="logo">HELIOS</h2>
      <ul class="nav-menu">
        <li><a href="Homepageadmin.jsp" class="active">Home</a></li>
        <li><a href="Ordersadmin.jsp">Orders</a></li>
        <li><a href="Productsadmin.jsp">Products</a></li>
        <li><a href="Employeesadmin.jsp">Employees</a></li>
        <li><a href="Reviewsadmin.jsp">Reviews</a></li>
      </ul>
    </div>
    <div class="nav-right">
      <img src="../images/avatar.png" alt="Avatar" class="avatar">
    </div>
  </nav>
  
  <!-- SUB-HEADER -->
  <div class="sub-header">
    <h1>Products</h1>
    <input type="text" id="searchInput" class="search-box" placeholder="Search products..." onkeyup="searchTable()">
  </div>
  
  <!-- CONTENT -->
  <div class="content">
    <section class="page-section">
      <div class="table-container">
        <table id="productsTable">
          <thead>
            <tr>
              <!-- Cột đầu tiên: checkbox chọn tất cả -->
              <th><input type="checkbox" onclick="toggleAll('productsTable')"></th>
              <!-- Cột IMAGE -->
              <th>IMAGE</th>
              <!-- Cột PRODUCT ID -->
              <th>PRODUCT ID</th>
              <!-- Cột NAME -->
              <th>NAME</th>
              <!-- Cột PRICE -->
              <th>PRICE</th>
              <!-- Cột MOUNT -->
              <th>MOUNT</th>
              <!-- Cột RATE -->
              <th>RATE</th>
              <!-- Cột cuối cùng: Action -->
              <th>ACTION</th>
            </tr>
          </thead>
          <tbody>
            <!-- Ví dụ một dòng dữ liệu -->
            <tr>
              <td><input type="checkbox"></td>
              <!-- IMAGE (hiển thị ảnh nhỏ) -->
              <td class="image-column">
                <img src="images/DayChuyenShogun_AnhWeb_540x.png" alt="Product Image">
              </td>
              <td>PD-1001</td>
              <td>iPhone</td>
              <td>$999</td>
              <td>10</td>
              <td>4.8</td>
              <td>
                <span class="material-icons edit-icon" onclick="editRow(this)">edit</span>
                <span class="material-icons delete-icon" onclick="deleteRow(this)">delete</span>
              </td>
            </tr>
            <!-- Thêm dữ liệu khác nếu cần -->
          </tbody>
        </table>
      </div>
      <!-- PHÂN TRANG -->
      <div class="pagination">
        <a href="#">&laquo; Previous</a>
        <a href="#" class="active">1</a>
        <a href="#">Next &raquo;</a>
      </div>
    </section>
  </div>
  
  <!-- SCRIPT -->
  <script>
    // Tìm kiếm trong bảng
    function searchTable() {
      const keyword = document.getElementById('searchInput').value.toLowerCase();
      const rows = document.getElementById('productsTable').querySelectorAll('tbody tr');
      rows.forEach(row => {
        const text = row.innerText.toLowerCase();
        row.style.display = text.indexOf(keyword) > -1 ? '' : 'none';
      });
    }
    
    // Chọn / bỏ chọn tất cả checkbox
    function toggleAll(tableId) {
      const table = document.getElementById(tableId);
      const headCB = table.querySelector('thead input[type="checkbox"]');
      const rowCBs = table.querySelectorAll('tbody input[type="checkbox"]');
      rowCBs.forEach(cb => cb.checked = headCB.checked);
    }
    
    // Demo chức năng sửa
    function editRow(elem) {
      alert("Edit row (demo).");
    }
    
    // Demo chức năng xóa
    function deleteRow(elem) {
      alert("Delete row (demo).");
    }
  </script>
</body>
</html>
