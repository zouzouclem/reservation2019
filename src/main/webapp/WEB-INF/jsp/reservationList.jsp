<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>

<jsp:include page="./assets/header.jsp"/>

<body>
<jsp:include page="./assets/menu.jsp"/>

Liste des reservations


<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col"> ID</th>
      <th scope="col"> Titre</th>
      <th scope="col">Lieu</th>
      <th scope="col">Date</th>
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
