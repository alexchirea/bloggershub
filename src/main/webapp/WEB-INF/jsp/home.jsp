<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:body>
        <div class="container">
            <div class="col-md-offset-1 col-md-10">
                    <c:forEach var="article" items="${articles}">

                        <c:url var="viewLink" value="/home/article/view">
                            <c:param name="articleId" value="${article.id}"/>
                        </c:url>

                        <div class="card mt-4">
                            <h5 class="card-header">${article.title}</h5>
                            <div class="card-body">
                                <h5 class="card-title">${article.description}</h5>
                                <p class="card-text">${article.content}</p>
                                <a href="${viewLink}" class="btn btn-primary">Read more</a>
                            </div>
                        </div>

                    </c:forEach>
            </div>
        </div>
    </jsp:body>
</t:genericpage>