<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create an account</title>

    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/common.css" rel="stylesheet">
</head>

<body>

<div class="container">

    <table class="table table-striped">
        <h3>Personal Articles</h3>
        <thead>
        <tr class="tr tr-success">
            <td>Id</td>
            <td>Title</td>
            <td>Description</td>
            <td>Tags</td>
            <td>Saved</td>
            <td>Published</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${articleList}" var="article">
            <tr>
                <td>${article.id}</td>
                <td>${article.title}</td>
                <td>${article.description}</td>
                <td>${article.tags}</td>
                <td>${article.saved}</td>
                <td>${article.published}</td>
                <td>
                    <a class="btn btn-info" href="/edit-article?id=${article.id}">Edit</a>
                    <a class="btn btn-danger" onclick="return confirm('Are you sure you want to delete?')" href="/delete-article?id=${article.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</body>
</html>