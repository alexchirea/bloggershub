<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:body>

        <div class="container">
            <div class="row">
                <div class="col-4"></div>
                <div class="col-4">
                    <form method="POST" action="${contextPath}/login" class="form-signin">
                        <h2 class="form-heading">Log in</h2>

                        <div class="form-group ${error != null ? 'has-error' : ''}">
                            <span>${message}</span>
                            <input name="username" type="text" class="form-control" placeholder="Username"
                                   autofocus="true"/>
                            <input name="password" type="password" class="form-control" placeholder="Password"/>
                            <span>${error}</span>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
                            <h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>
                        </div>
                    </form></div>
                <div class="col-3"></div>
            </div>
        </div>

    </jsp:body>
</t:genericpage>