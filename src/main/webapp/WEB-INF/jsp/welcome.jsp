<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:body>
        <div class="container">
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <form id="logoutForm" method="POST" action="${contextPath}/logout">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
                <div class="jumbotron">
                    <h1 class="display-4">Hello, ${pageContext.request.userPrincipal.name}!</h1>
                    <hr class="my-4">
                    <p class="lead">
                        <a href="/articles/my" class="btn btn-success">My articles</a>
                        <a onclick="document.forms['logoutForm'].submit()" class="btn btn-danger">Logout</a>
                    </p>
                </div>
            </c:if>
        </div>
    </jsp:body>
</t:genericpage>