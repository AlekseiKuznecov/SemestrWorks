<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${user != null}">
    <li>${user.getUsername()}</li>
    <c:if test="${user.getRole() == 'admin'}">
        <li><a href="<c:url value="/car/create"/>">New Car</a></li>
    </c:if>
</c:if>
<c:if test="${user == null}">
    <li><a href="<c:url value="/signin"/>">Sign in</a></li>
    <li><a href="/RentCar/registration">Register</a></li>
</c:if>
<%--<li><a href="/user/list">Users list</a></li>--%>
<%--<li><a href="/login">Log in</a></li>--%>
<li><a href="/RentCar/car/list">Home</a></li>
