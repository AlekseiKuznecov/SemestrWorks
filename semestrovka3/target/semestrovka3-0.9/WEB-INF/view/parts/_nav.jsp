<c:if test="${user != null}">
    <c:if test="${user.getRole() == 'admin'}">
        <li><a href="<c:url value="/car/create"/>">New Car</a></li>
    </c:if>
    <li><a class="nav-link disabled">${user.getUsername()}</a></li>
</c:if>
<c:if test="${user == null}">
    <li><a href="<c:url value="/signin"/>">Sign in</a></li>
</c:if>
<li><a href="/user/list">Users list</a></li>
<li><a href="/">Register</a></li>
<li><a href="/login">Log in</a></li>
<li><a href="list">Home</a></li>
