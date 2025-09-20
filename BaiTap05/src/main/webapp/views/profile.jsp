<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Profile</title>
</head>
<body>
<h2>Update Profile</h2>
<form method="post" action="${pageContext.request.contextPath}/profile" enctype="multipart/form-data">
    <label>Fullname:</label><br>
    <input type="text" name="fullname" value="${user.fullname}" required><br><br>

    <label>Phone:</label><br>
    <input type="text" name="phone" value="${user.phone}" required><br><br>

    <label>Avatar:</label><br>
    <input type="file" name="avatar"><br>
    <c:if test="${not empty user.image}">
        <img src="${pageContext.request.contextPath}/uploads/${user.image}" width="120"/>
    </c:if>
    <br><br>

    <button type="submit">Update</button>
</form>
</body>
</html>
