<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>BloggersHub</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/common.css" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
</head>
<body>

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <c:url value="/" var="homeUrl" />
        <a class="navbar-brand" href="${homeUrl}">BloggersHub</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="${homeUrl}">Home</a>
                </li>
                <li class="nav-item">
                    <c:url value="/articles" var="articlesUrl" />
                    <a class="nav-link" href="${articlesUrl}">Articles</a>
                </li>
            </ul>
            <form class="form-inline mt-2 mt-md-0">
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <a href="/logout" class="btn btn-primary ml-3">Logout</a>
                </c:if>
                <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <a href="/login" class="btn btn-success ml-3">Login</a>
                    <a href="/registration" class="btn btn-warning ml-3">Register</a>
                </c:if>
            </form>
        </div>
    </nav>
    <div id="body">
        <jsp:doBody/>
    </div>
    <div id="pagefooter">
        <jsp:invoke fragment="footer"/>
    </div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</body>
</html>