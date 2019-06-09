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
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %><html>

<jsp:include page="./assets/header.jsp" />

<body>
<jsp:include page="./assets/menu.jsp" />
<div class="container">


    <h2><spring:message code="welcome.text"/></h2>


    <sec:authorize access="isAuthenticated()">
        <sec:authentication property="principal.username" var="username" />
      <span>Bonjour ${username}</span>
    </sec:authorize>


</div>

</body>
