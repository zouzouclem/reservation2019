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
                <sec:authorize access="hasRole('ADMIN')">
                    <input type="submit" class="btn btn-secondary" value="Add Representation">
                </sec:authorize>
            </form:form>


            <div>
                <h4>Representations:</h4>

                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">Date</th>
                        <th scope="col"></th>

                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach items="${representations}" var="representation">
                        <tr>
                            <td>${representation.whenDate}</td>

                            <td>
                                <form:form method="get" action="/reservation/booking/${representation.id}">
                                    <button type="submit" class="btn btn-secondary"><spring:message
                                            code="showDet.booking"/></button>

                                </form:form>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>
<jsp:include page="../assets/footer.jsp"/>


</body>
