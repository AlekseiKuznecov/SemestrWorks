<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:mainLayout title="Car list">

<div class="text-info">Доступных машин на сайте : ${carCount}</div>
    <div class="cars-list"></div>
    <c:forEach items="${cars}" var="car">
        <div class="car-card">
            <div class="car-header">
                <h3 class="car-name"><a href="<c:url value="/car/detail?id=${car.id}"/>">${car.getBrand()} ${car.getModel()} </a></h3>
                <span class="car-info">${car.getPrice()} ₽</span>
                <div class="clearfix"></div>
            </div>
        </div>
    </c:forEach>
</div>
</t:mainLayout>