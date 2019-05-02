<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>

<jsp:include page="../assets/header.jsp"/>

<body>
<jsp:include page="../assets/menu.jsp"/>

Liste des spectacles




<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col"> Titre</th>
      <th scope="col">Lieu</th>
      <th scope="col">Prix</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${showList}" var="show">
    <tr>
       <td>${show.title}</td>
       <td>${show.locationId}</td>
       <td>${show.price}</td>
    </tr>
   </c:forEach>

  </tbody>
</table>



<jsp:include page="../assets/footer.jsp"/>

</body>
</html>