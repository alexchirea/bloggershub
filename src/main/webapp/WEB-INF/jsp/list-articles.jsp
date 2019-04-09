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

                <input type="button" value="Add Article"
                       onclick="window.location.href='new'; return false;"
                       class="btn btn-primary"/>
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
                                    <c:param name="articleId" value="${article.id}"/>
                                </c:url>
                                <c:url var="deleteLink" value="/articles/delete">
                                    <c:param name="articleId" value="${article.id}"/>
                                </c:url>
                                <c:url var="publishLink" value="/articles/publish">
                                    <c:param name="articleId" value="${article.id}"/>
                                </c:url>
                                <c:url var="unpublishLink" value="/articles/unpublish">
                                    <c:param name="articleId" value="${article.id}"/>
                                </c:url>

                                <tr>
                                    <td>${article.title}
                                        <c:if test="${empty article.published}">
                                            <span class="badge badge-pill badge-secondary">Draft</span>
                                        </c:if>
                                        <c:if test="${not empty article.published}">
                                            <span class="badge badge-pill badge-success">Published</span>
                                        </c:if>
                                    </td>
                                    <td>${article.description}</td>
                                    <td>${article.tags}</td>
                                    <td>${article.votes}</td>
                                    <td>${article.views}</td>

                                    <td>
                                        <c:if test="${empty article.published}">
                                            <a href="${publishLink}" class="btn btn-sm btn-success">Publish</a> |
                                        </c:if>
                                        <c:if test="${not empty article.published}">
                                            <a href="${unpublishLink}" class="btn btn-sm btn-warning">Unpublish</a> |
                                        </c:if>
                                        <a href="${updateLink}" class="btn btn-sm btn-primary">Update</a> |
                                        <a href="${deleteLink}"  class="btn btn-sm btn-danger" onclick="if (!(confirm('Are you sure you want to delete this article?'))) return false">Delete</a>
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