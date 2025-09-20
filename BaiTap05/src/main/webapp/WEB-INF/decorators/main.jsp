<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${sitemeshPage.title}</title>

    <!-- Bootstrap CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Sitemesh head -->
    ${sitemeshPage.head}
</head>
<body>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">MyApp</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        </div>
    </nav>

    <!-- Content -->
    <div class="container mt-4">
        ${sitemeshPage.body}
    </div>

    <!-- Footer -->
    <footer class="bg-light text-center text-lg-start mt-5">
        <div class="text-center p-3">
            © 2025 MyApp. All rights reserved.
        </div>
    </footer>

    <!-- Bootstrap JS -->
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
</body>
</html>
