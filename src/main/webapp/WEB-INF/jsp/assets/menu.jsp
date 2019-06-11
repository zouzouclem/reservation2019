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
                <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/reservation" />">Mes reservations</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Spectacles
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="<c:url value="/show" />">Liste des spectacles</a>
                    <sec:authorize access="hasRole('ADMIN')">
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="<c:url value="/show/add"/>">Ajouter un spectacle</a>
                    <a class="dropdown-item" href="<c:url value="/show/importCSV" />">Importer des spectacles (CSV)</a>
                    <a class="dropdown-item" href="<c:url value="/show/importRSS" />">Importer des spectacles (RSS)</a>
                    </sec:authorize>
                </div>
            </li>
            <sec:authorize access="hasRole('ADMIN')">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/admin/" />">Admin</a>
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