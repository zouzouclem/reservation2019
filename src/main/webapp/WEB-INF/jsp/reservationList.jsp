<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>

<jsp:include page="./assets/header.jsp"/>

<body>
<jsp:include page="./assets/menu.jsp"/>

<div class="container">

    <h2><spring:message code="reservation.pageTitle"/></h2>


    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col"><spring:message code="reservation.showTitle"/></th>
            <th scope="col"><spring:message code="reservation.location"/></th>
            <th scope="col"><spring:message code="reservation.address"/></th>
            <th scope="col"><spring:message code="reservation.date"/></th>
            <th scope="col"><spring:message code="reservation.hour"/></th>
            <th scope="col"><spring:message code="reservation.price"/></th>
            <th scope="col"><spring:message code="reservation.place"/></th>
            <th scope="col"><spring:message code="reservation.totalPrice"/></th>


        </tr>
        </thead>
        <tbody>
        <c:forEach items="${Reservations}" var="reservation">
            <tr>
                <td>${reservation.representation.show.title}</td>
                <td>${reservation.representation.location}</td>
                <td> ${reservation.representation.location.getCompleteAddress()}</td>
                <td><fmt:formatDate pattern="dd-MM-yyyy" value="${reservation.representation.whenDate}"/></td>
                <td><fmt:formatDate pattern="HH:mm" value="${reservation.representation.whenDate}"/></td>
                <td>${reservation.representation.show.price} €</td>
                <td>${reservation.places}</td>
                <td>${reservation.places * reservation.representation.show.price} €</td>

            </tr>
        </c:forEach>

        </tbody>
    </table>

</div>
<jsp:include page="./assets/footer.jsp"/>

</body>
