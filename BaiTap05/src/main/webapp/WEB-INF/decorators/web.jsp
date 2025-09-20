<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${sitemeshPage.title}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    ${sitemeshPage.head}
</head>
<body>
    <div>
        <%@ include file="/commons/web/header.jsp"%>
    </div>

    <div class="container mt-3">
        ${sitemeshPage.body}
    </div>

    <div>
        <%@ include file="/commons/web/footer.jsp"%>
    </div>
</body>
</html>
