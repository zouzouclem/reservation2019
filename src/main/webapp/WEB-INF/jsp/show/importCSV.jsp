<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<jsp:include page="../assets/header.jsp"/>

<body>
<jsp:include page="../assets/menu.jsp"/>
<div class="container">

    <c:choose>
        <c:when test="${fileForm.id == null && isAdmin}">
            <div>
                <form:form method="post" action="/admin/show/importCSV" modelAttribute="fileForm">
                    <fieldset>
                        <c:if test="${not empty error}">
                            <label class="error">${error}/></label>
                        </c:if>
                        <h2><spring:message code="importShowCSV.pageTitle"/></h2>
                        <div class="col-md-4">
                            <div class="custom-file">
                                <label for="file" class="custom-file-label"><spring:message
                                        code="importShowCSV.File"/></label>
                                <div>
                                    <form:input class="custom-file-input" type="file" path="file" id="file"
                                                accept=".csv"/>
                                    <form:errors path="file" cssClass="error"/>
                                </div>
                            </div>
                        </div>
                        <br/>
                        <div>
                            <input type="submit" class="btn btn-secondary" value="Import" disabled>
                        </div>
                    </fieldset>
                </form:form>
            </div>
            <div>
                <a class="btn" href="<c:url value="/admin/show/exportCSV"/>"><spring:message code="exportShowCSV.button"/></a>
            </div>
        </c:when>
        <c:otherwise>
            <spring:message code="authentication.adminNeeded"/>
        </c:otherwise>
    </c:choose>
</div>
<jsp:include page="../assets/footer.jsp"/>
<script>
    $(document).ready(function() {
        $('input[type="file"]').change(function() {
            var selectedFile = $('input[type=file]').val();
            if (null == selectedFile ||selectedFile == "") {
                $('input[type="submit"]').attr("disabled", true);
            } else {
                $('input[type="submit"]').removeAttr("disabled");
            }
        });
    });
</script>
</body>