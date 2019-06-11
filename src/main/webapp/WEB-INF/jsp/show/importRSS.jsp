<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<jsp:include page="../assets/header.jsp"/>

<body>
<jsp:include page="../assets/menu.jsp"/>

<c:choose>
    <c:when test="${fileForm.id == null && isAdmin}">        <div>
            <form:form method="post" action="/show/importRSS" modelAttribute="fileForm">
                <fieldset>
                    <c:if test="${not empty error}">
                        <label class="error">${error}/></label>
                    </c:if>
                    <h2><spring:message code="importShowCSV.pageTitle"/></h2>
                    <div>
                        <label for="file"><spring:message code="importShowRSS.File"/></label>
                        <div>
                            <form:input type="file" path="file" id="file" accept=".xml"/>
                            <form:errors path="file" cssClass="error"/>
                        </div>
                    </div>
                    <br />
                    <div>
                        <input type="submit" value="Import">
                    </div>
                </fieldset>
            </form:form>
        </div>
    </c:when>
    <c:otherwise>
        <spring:message code="authentication.adminNeeded"/>
    </c:otherwise>
</c:choose>
<jsp:include page="../assets/footer.jsp"/>
</body>