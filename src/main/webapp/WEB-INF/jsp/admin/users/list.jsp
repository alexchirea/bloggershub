<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:body>
        <div class="container">
            <div class="col-md-offset-1 col-md-10">
                <hr/>
                <br/><br/>
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <div class="panel-title">Users</div>
                    </div>
                    <div class="panel-body">
                        <table class="table table-striped table-bordered">
                            <tr>
                                <th>Username</th>
                                <th>Nume</th>
                                <th>Prenume</th>
                                <th>Email</th>
                                <th>Action</th>
                            </tr>

                            <c:forEach var="user" items="${users}">
                                <c:url var="banLink" value="/users/ban">
                                    <c:param name="id" value="${user.id}"/>
                                </c:url>
                                <c:url var="unbanLink" value="/users/unban">
                                    <c:param name="id" value="${user.id}"/>
                                </c:url>

                                <tr>
                                    <td>${user.username}
                                        <c:if test="${user.isBanned == 0}">
                                            <span class="badge badge-pill badge-success">Activ</span>
                                        </c:if>
                                        <c:if test="${user.isBanned != 0}">
                                            <span class="badge badge-pill badge-danger">Banat</span>
                                        </c:if>
                                    </td>
                                    <td>${user.firstName}</td>
                                    <td>${user.lastName}</td>
                                    <td>${user.email}</td>

                                    <td>
                                        <c:if test="${user.isBanned == 0}">
                                            <a href="${banLink}" class="btn btn-sm btn-primary">Ban</a> |
                                        </c:if>
                                        <c:if test="${user.isBanned != 0}">
                                            <a href="${unbanLink}" class="btn btn-sm btn-primary">Unban</a> |
                                        </c:if>
                                    </td>

                                </tr>

                            </c:forEach>

                        </table>

                    </div>
                </div>
            </div>

        </div>
    </jsp:body>
</t:genericpage>