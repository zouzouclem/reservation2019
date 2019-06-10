<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<jsp:include page="../assets/header.jsp"/>

<body>
<jsp:include page="../assets/menu.jsp"/>

    <c:if test="${fileForm.id == null}">
        <div>
            <form:form method="post" action="/show/importCSV" modelAttribute="fileForm">
                <fieldset>
                    <c:if test="${not empty error}">
                        <label class="error">${error}/></label>
                    </c:if>
                    <h2><spring:message code="importShowCSV.pageTitle"/></h2>
                    <div>
                        <label for="file"><spring:message code="importShowCSV.File"/></label>
                        <div>
                            <form:input type="file" path="file" id="file" accept=".csv"/>
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
    </c:if>
<jsp:include page="../assets/footer.jsp"/>
</body>