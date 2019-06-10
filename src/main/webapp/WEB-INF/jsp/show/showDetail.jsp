<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<jsp:include page="../assets/header.jsp"/>

<body>
<jsp:include page="../assets/menu.jsp"/>

<div class="container">

    <h2 class="pb-2"><spring:message code="showDet.pageTitle"/></h2>

    <div class="card" style="width: 25rem;">
        <img src="${show.posterUrl}" class="img-fluid" alt="Responsive image"
             onerror="this.onerror=null;this.src='<c:url value="/resources/images/default-show.jpg"/>';">
        <div class="card-body">
            <h5 class="card-title"></h5>
            <p class="card-text">
            <div class="row">
                <dt class="col-sm-5"><spring:message code="showDet.showTitle"/>:</dt>
                <dd class="col-sm-7">${show.title} (${show.slug})</dd>
            </div>

            <div class="row">
                <dt class="col-sm-5"><spring:message code="showDet.showLocation"/>:</dt>
                <dd class="col-sm-7">${show.location.designation}</dd>
            </div>

            <div class="row">
                <dt class="col-sm-5"><spring:message code="showDet.showLocationAdresse"/>:</dt>
                <dd class="col-sm-7">${show.location.address}</dd>
            </div>

            <div class="row">
                <dt class="col-sm-5"><spring:message code="showDet.showBookable"/>:</dt>
                <dd class="col-sm-7">${show.bookable}</dd>
            </div>

            <div class="row">
                <dt class="col-sm-5"><spring:message code="showDet.showPrix"/>:</dt>
                <dd class="col-sm-7">${show.price}</dd>
            </div>

            <div class="row">
                <dt class="col-sm-5"><spring:message code="showDet.showDescription"/>:</dt>
                <dd class="col-sm-7"> ${show.description}</dd>
            </div>
            </p>
            <form:form method="get" action="/admin/representation/add/${show.id}">

                <a href="#" class="btn btn-secondary">book</a>
                <sec:authorize access="hasRole('ADMIN')">
                    <input type="submit" class="btn btn-secondary" value="Add Representation">
                </sec:authorize>
            </form:form>

        </div>
    </div>

    <%--Title: ${show.title} (${show.slug})</br>--%>
    <%--Location: ${show.location} Bookable: ${show.bookable} Price: ${show.price}--%>

</div>
<jsp:include page="../assets/footer.jsp"/>

</body>
