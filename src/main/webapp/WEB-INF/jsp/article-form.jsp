<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>BloggersHub :: New Article</title>

    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/common.css" rel="stylesheet">
</head>

<body>
<div class="container">
    <div class="col-md-offset-2 col-md-7">
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Add Article</div>
            </div>
            <div class="panel-body">
                <form:form action="save" cssClass="form-horizontal"
                           method="post" modelAttribute="article">

                    <form:hidden path="id" />

                    <div class="form-group">
                        <label for="title" class="col-md-3 control-label">Title</label>
                        <div class="col-md-9">
                            <form:input path="title" cssClass="form-control" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="description" class="col-md-3 control-label">Description</label>
                        <div class="col-md-9">
                            <form:input path="description" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="tags" class="col-md-3 control-label">Tags</label>
                        <div class="col-md-9">
                            <form:input path="tags" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="content" class="col-md-3 control-label">Content</label>
                        <div class="col-md-9">
                            <form:textarea path="content" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-offset-3 col-md-9">
                            <form:button cssClass="btn btn-primary">Submit</form:button>
                        </div>
                    </div>

                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>