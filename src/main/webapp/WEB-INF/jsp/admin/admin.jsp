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

<jsp:include page="./../assets/header.jsp" />

<body>
<jsp:include page="./../assets/menu.jsp" />

<div class="container">

    <h2><spring:message code="admin.color.text"/></h2>
    <br/>


    <div class="row">
        <div class="col-sm-3">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title"><spring:message code="admin.default.style"/> </h5>
                    <img src="<c:url value="/resources/images/style-default.PNG" />" class="card-img-top" alt="...">
                </div>
                <a class="btn btn-light" href="<c:url value="/admin/changeColor/default"/>"><spring:message code="admin.default.style.apply"/></a>

            </div>
        </div>
        <div class="col-sm-3">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title"><spring:message code="admin.pink.style"/></h5>
                    <img src="<c:url value="/resources/images/style-pink.PNG" />" class="card-img-top" alt="...">
                </div>
                <a class="btn btn-danger" href="<c:url value="/admin/changeColor/pink"/>"><spring:message code="admin.pink.style.apply"/></a>

            </div>
        </div>
        <div class="col-sm-3">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title"><spring:message code="admin.green.style"/></h5>
                    <img src="<c:url value="/resources/images/style-green.PNG" />" class="card-img-top" alt="...">
                </div>
                <a class="btn btn-success" href="<c:url value="/admin/changeColor/green"/>"><spring:message code="admin.green.style.apply"/></a>

            </div>
        </div>
        <div class="col-sm-3">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title"><spring:message code="admin.blue.style"/></h5>
                    <img src="<c:url value="/resources/images/style-blue.PNG" />" class="card-img-top" alt="...">
                </div>
                <a class="btn btn-primary" href="<c:url value="/admin/changeColor/blue"/>"><spring:message code="admin.blue.style.apply"/></a>

            </div>
        </div>
    </div>





</div>

    <jsp:include page="./../assets/footer.jsp" />




</body>
