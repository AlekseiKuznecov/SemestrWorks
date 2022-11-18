<%@tag description="Default Layout Tag" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@attribute name="title" %>
<%@attribute name="jsGroup" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>

    <link rel="stylesheet" href="<c:url value="/style/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/style/main.css"/>">
</head>
<body>
<%@include file="/WEB-INF/view/parts/_nav.jsp"%>
<%--<nav class="navbar navbar-default">--%>
<%--    <div class="container-fluid">--%>
<%--        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">--%>
<%--            <ul class="nav navbar-nav">--%>
<%--                <li><a href="<c:url value="/"/>">Home</a></li>--%>
<%--            </ul>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</nav>--%>
<div class="container">
    <jsp:doBody/>
</body>
</html>