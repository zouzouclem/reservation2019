<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<jsp:include page="../assets/header.jsp"/>

<body>
<jsp:include page="../assets/menu.jsp"/>

Liste des spectacles



<table class="table table-striped">
  <thead>
    <tr>
        <th></th>
      <th scope="col">Titre</th>
      <th scope="col">Lieu</th>
      <th scope="col">Prix</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${showList}" var="show">
    <tr>
        <td><input type="checkbox" name="showId" value=${show.id}></td>
       <td>${show.title}</td>
       <td>${show.locationId}</td>
       <td>${show.price}</td>
        <form:form method="get" action="/show/update/${show.id}" modelAttribute="showForm">
            <td><input type="submit" name="update" value="Modifier">
            </td>
        </form:form>
        <form:form method="get" action="/show/delete/${show.id}" modelAttribute="showForm">
            <td><input type="submit" name="delete" value="Supprimer"></td>
        </form:form>

    </tr>
   </c:forEach>

  </tbody>
</table>



<jsp:include page="../assets/footer.jsp"/>

</body>
</html>