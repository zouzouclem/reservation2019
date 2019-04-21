<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dscohier
  Date: 19/04/2019
  Time: 19:45
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form method="post" action="connect/signup" modelAttribute="signupForm">
        <fieldset>
            <c:if test="${not empty error}">
                <label class="error"><spring:message code="${error}"/></label>
            </c:if>
            <c:if test="${not empty success}">
                <label class="success"><spring:message code="${success}"/></label>
            </c:if>
            <h2>Inscription</h2>
            <div class="form-group">
                <label for="password" class="col-lg-2 control-label">mot de passe</label>
                <div class="col-lg-8">
                    <form:input type="password" path="password" cssClass="form-control" id="password"/>
                    <form:errors path="password" cssClass="error"/>
                </div>
            </div>
            <div class="form-group">
                <label for="firstName" class="col-lg-2 control-label">prénom</label>
                <div class="col-lg-8">
                    <form:input type="firstName" path="firstName" id="firstName"/>
                    <form:errors path="firstName"/>
                </div>
            </div>
            <div class="form-group">
                <label for="lastName" class="col-lg-2 control-label">nom</label>
                <div class="col-lg-8">
                    <form:input type="lastName" path="lastName" id="lastName"/>
                    <form:errors path="lastName"/>
                </div>
            </div>
            <div class="form-group">
                <label for="email" class="col-lg-2 control-label">mail</label>
                <div class="col-lg-8">
                    <form:input type="email" path="email" id="email"/>
                    <form:errors path="email"/>
                </div>
            </div>
            <div class="form-group">
                <label for="langue" class="col-lg-2 control-label">langue</label>
                <div class="col-lg-8">
                    <form:input type="langue" path="langue" id="langue"/>
                </div>
            </div>
            <div class="col-md-offset-5">
                <input type="submit" class="btn btn-primary" value="inscription">
            </div>
        </fieldset>
    </form:form>
</body>
</html>
