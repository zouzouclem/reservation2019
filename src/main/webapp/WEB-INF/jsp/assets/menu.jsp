<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">APP</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/"><spring:message code="menu.Home"/><span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/reservation" />"><spring:message code="menu.myShows"/></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    <spring:message code="menu.Shows"/>
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="<c:url value="/show" />"><spring:message code="menu.showsList"/></a>
                    <sec:authorize access="hasRole('ADMIN')">
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="<c:url value="/show/add"/>"><spring:message code="menu.addShow"/></a>
                    <a class="dropdown-item" href="<c:url value="/admin/show/importCSV" />"><spring:message code="menu.importShowsCSV"/></a>
                    <a class="dropdown-item" href="<c:url value="/admin/show/importRSS" />"><spring:message code="menu.importShowsRSS"/></a>
                    <a class="dropdown-item" href="<c:url value="/allShows" />"><spring:message code="menu.webService"/></a>

                    </sec:authorize>
                </div>
            </li>
            <sec:authorize access="hasRole('ADMIN')">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/admin/" />"><spring:message code="menu.admin"/></a>
                </li>
            </sec:authorize>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <sec:authorize access="isAuthenticated()">
                <li class="nav-item"><a class="nav-link" href="<c:url value="/connect/modifyProfil"/>"><spring:message code="menu.modify"/></a></li>
                <li class="nav-item"><a class="nav-link" href="<c:url value="/logout"/>"><spring:message code="menu.logout"/></a></li>
            </sec:authorize>
            <sec:authorize access="isAnonymous()">
                <li class="nav-item"><a class="nav-link" href="<c:url value="/connect"/>"><spring:message code="menu.login"/></a></li>
            </sec:authorize>
            <li><p><a href="?language=en">EN</a>/<a href="?language=fr">FR</a></li>
            </p>
        </ul>
    </div>
</nav>