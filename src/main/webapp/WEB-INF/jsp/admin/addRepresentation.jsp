<%--
  Created by IntelliJ IDEA.
  User: dscohier
  Date: 28/03/2019
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<jsp:include page="./../assets/header.jsp" />

<body>
<jsp:include page="./../assets/menu.jsp" />

<div class="container">

    <h2><spring:message code="representation.add.title"/></h2>

    <div class="row">
        <div class="col-md-6">
    <form:form method="post" action="/admin/representation/save" modelAttribute="representationForm">
        <div class="form-group">
            <label for="whenDate"><spring:message code="addRepresentation.date"/></label>
            <div>
                <form:input class="form-control" type="date" path="whenDate" id="whenDate"/>
                <form:errors path="whenDate" cssClass="error"/>

            </div>
        </div>
        <div class="form-group">
            <label for="whenTime"><spring:message code="addRepresentation.time"/></label>
            <div>
                <form:input class="form-control" type="time" path="whenTime" id="whenDate"/>
                <form:errors path="whenTime" cssClass="error"/>
            </div>
        </div>

        <div class="form-group">
            <label for="location"><spring:message code="addRepresentation.Location"/></label>
            <div>
                <form:select class="form-control" path="location" items="${locationsList}"/>
                <form:errors path="location" cssClass="error"/>
            </div>
        </div>
        <form:hidden path="show" />

        <input type="submit" class="btn btn-secondary" value="Enregistrer">

    </form:form>
    </div>
    </div>
</div>

    <jsp:include page="./../assets/footer.jsp" />




</body>
