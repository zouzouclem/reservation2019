<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>


<jsp:include page="../assets/header.jsp"/>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<body>
<jsp:include page="../assets/menu.jsp"/>

<div class="container">

<h2 class="bold"><spring:message code="showList.pageTitle"/></h2>

    <%--TODO Leila Labels--%>
    <%--TODO Leila enlever la checkbox--%>

<c:if test="${not empty success}">
    <label class="success"><spring:message code="${succcess}"/></label>
</c:if>
<table class="table table-striped" id="showListTable">
    <thead>
    <tr>
        <th></th>
        <th scope="col">Titre</th>
        <th scope="col">Lieu</th>
        <th scope="col">Prix</th>
        <th></th>
        <sec:authorize access="hasRole('ADMIN')">
        <th></th>
        <th></th>
        </sec:authorize>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${showList}" var="show">
        <tr>
            <td><input type="checkbox" name="showId" value=${show.id}></td>
            <td>${show.title}</td>
            <td>${show.location}</td>
            <td>${show.price}</td>
            <form:form method="get" action="/show/showDetail/${show.id}">
                <td><button class="btn btn-secondary" type="submit"><spring:message code="showList.Consultation"/></button></td>
            </form:form>
            <sec:authorize access="hasRole('ADMIN')">
            <form:form method="get" action="/show/update/${show.id}" modelAttribute="showForm">
                <td><button class="btn btn-secondary" type="submit"><spring:message code="showList.Modification"/></button></td>
            </form:form>
            <form:form method="get" action="/show/delete/${show.id}" modelAttribute="showForm">
                <td><button class="btn btn-secondary" type="submit"><spring:message code="showList.Suppression"/></button></td>
            </form:form>
            </sec:authorize>
        </tr>
    </c:forEach>

    </tbody>
</table>
</div>

<jsp:include page="../assets/footer.jsp"/>

<script>
    $(document).ready(function () {
        $('#showListTable').DataTable();
    });
</script>
</body>
</html>