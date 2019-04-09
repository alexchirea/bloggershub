<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>BloggersHub :: Articles</title>

    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/common.css" rel="stylesheet">
</head>

<body>
<div class="container">
    <div class="col-md-offset-1 col-md-10">
        <hr />

        <input type="button" value="Add Article"
               onclick="window.location.href='new'; return false;"
               class="btn btn-primary" />
        <br/><br/>
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Articles</div>
            </div>
            <div class="panel-body">
                <table class="table table-striped table-bordered">
                    <tr>
                        <th>Title</th>
                        <th>Description</th>
                        <th>Tags</th>
                        <th>Votes</th>
                        <th>Views</th>
                        <th>Action</th>
                    </tr>

                    <c:forEach var="article" items="${articles}">
                        <c:url var="updateLink" value="/articles/update">
                            <c:param name="articleId" value="${article.id}" />
                        </c:url>
                        <c:url var="deleteLink" value="/articles/delete">
                            <c:param name="articleId" value="${article.id}" />
                        </c:url>

                        <tr>
                            <td>${article.title}</td>
                            <td>${article.description}</td>
                            <td>${article.tags}</td>
                            <td>${article.votes}</td>
                            <td>${article.views}</td>

                            <td>
                                <a href="${updateLink}">Update</a> | <a href="${deleteLink}"
                                     onclick="if (!(confirm('Are you sure you want to delete this article?'))) return false">Delete</a>
                            </td>

                        </tr>

                    </c:forEach>

                </table>

            </div>
        </div>
    </div>

</div>
</body>
</html>