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
                <div class="panel-body">
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <h2>Adauga comentariu</h2>
                        <form:form action="${pageContext.request.contextPath}/comments/save"  cssClass="form-horizontal"
                                   method="post" modelAttribute="comment">
                            <input type="hidden" id="articleId" name="articleId" value="${article.id}">
                            <div class="form-group">
                                <label for="message" class="col-md-3 control-label">Message</label>
                                <div class="col-md-9">
                                    <form:textarea path="message" cssClass="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-offset-3 col-md-9">
                                    <form:button cssClass="btn btn-primary">Submit</form:button>
                                </div>
                            </div>
                        </form:form>
                    </c:if>
                    <h2>Comentarii</h2>
                    <c:forEach var="comentariu" items="${comments}">
                        <p>${comentariu.message} -- ${comentariu.username}</p>
                    </c:forEach>
                </div>
            </div>
        </div>
    </jsp:body>
</t:genericpage>