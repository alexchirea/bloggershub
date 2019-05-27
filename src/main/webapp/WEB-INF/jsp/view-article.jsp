<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:body>
        <div class="container">
            <div class="col-md-offset-2 col-md-7">
                <div class="panel panel-info">
                    <div class="panel-body">
                        <h1>${article.title}</h1>
                        <h2>${article.description}</h2>
                        <p>${article.content}</p>
                        <p><a href="like?articleId=${article.id}" class="btn btn-success"> <i class="fas fa-thumbs-up"></i>Like</a> </p>
                        <p><a href="dislike?articleId=${article.id}" class="btn btn-warning"> <i class="fas fa-thumbs-down"></i>Like</a> </p>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:genericpage>