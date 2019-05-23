<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>

<jsp:include page="./assets/header.jsp"/>

<body>
<jsp:include page="./assets/menu.jsp"/>

<spring:message code = "reservation.pageTitle"/>


<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col"> <spring:message code = "reservation.identification"/></th>
      <th scope="col"> <spring:message code = "reservation.showTitle"/></th>
      <th scope="col"><spring:message code = "reservation.location"/></th>
      <th scope="col"><spring:message code = "reservation.date"/></th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${Reservations}" var="reservation">
    <tr>
       <td>${reservation.id}</td>
       <td>${reservation.show.title}</td>
       <td>${reservation.location.address}</td>
       <td>${reservation.whenDate}</td>

    </tr>
   </c:forEach>

  </tbody>
</table>

<jsp:include page="./assets/footer.jsp"/>

</body>
