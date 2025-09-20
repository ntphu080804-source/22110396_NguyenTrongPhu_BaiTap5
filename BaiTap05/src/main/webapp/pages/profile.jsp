<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="card p-4">
    <h3>Update Profile</h3>
    <form action="${pageContext.request.contextPath}/profile" method="post" enctype="multipart/form-data">
        <div class="mb-3">
            <label>Full Name</label>
            <input type="text" name="fullname" class="form-control" value="${user.fullname}" required>
        </div>
        <div class="mb-3">
            <label>Phone</label>
            <input type="text" name="phone" class="form-control" value="${user.phone}" required>
        </div>
        <div class="mb-3">
            <label>Avatar</label>
            <input type="file" name="avatar" class="form-control">
        </div>
        <c:if test="${not empty user.avatar}">
            <img src="${pageContext.request.contextPath}/uploads/${user.avatar}" width="100" class="mt-2"/>
        </c:if>
        <button type="submit" class="btn btn-primary mt-3">Update</button>
    </form>
</div>
