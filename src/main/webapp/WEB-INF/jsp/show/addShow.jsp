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
    <form:form method="post" action="/show/add" modelAttribute="showForm">
        <fieldset>
            <c:if test="${not empty error}">
                <label class="error">${error}/></label>
            </c:if>
            <h2><spring:message code="addShow.pageTitle"/></h2>

            <div class="row">
                <div class="col-md-6">

                    <div class="form-group">
                        <label for="slug"><spring:message code="addShow.Slug"/></label>
                        <div>
                            <form:input class="form-control" type="text" path="slug" id="slug"/>
                            <form:errors path="slug" cssClass="error"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="title"><spring:message code="addShow.Title"/></label>
                        <div>
                            <form:input class="form-control" type="text" path="title" id="title"/>
                            <form:errors path="title" cssClass="error"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="posterURL"><spring:message code="addShow.PosterURL"/></label>
                        <div>
                            <form:input class="form-control" type="text" path="posterURL" id="posterURL"/>
                            <form:errors path="posterURL" cssClass="error"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="location"><spring:message code="addShow.Location"/></label>
                        <div>
                            <form:select class="form-control" path="location" items="${locationsList}"/>
                            <form:errors path="location" cssClass="error"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="bookable"><spring:message code="addShow.Bookable"/></label>
                        <div>
                            <form:checkbox  path="bookable" id="bookable"/>
                            <form:errors path="bookable" cssClass="error"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="price"><spring:message code="addShow.Price"/></label>
                        <div>
                            <form:input class="form-control" type="number" path="price" id="price"/>
                            <form:errors path="price" cssClass="error"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="description"><spring:message code="addShow.descriptionShow"/></label>
                        <div>
                            <form:textarea class="form-control" path="description" id="description" rows="5" cols="33"/>
                            <form:errors path="description" cssClass="error"/>
                        </div>
                    </div>
                    <br/>
                    <div>
                        <button class="btn btn-secondary" type="submit"><spring:message code="addShow.Save"/></button>
                    </div>

                </div>
            </div>
        </fieldset>
    </form:form>
        <c:if test="${isAdmin}">
            <input type="file" name="csvImporter" onChange="importCSV()" />
        </c:if>
</div>
<jsp:include page="../assets/footer.jsp"/>

<script type="text/javascript">
function importCSV() {
    var fileUlr = ${'csvImporter'}.target.files[0].name;
    $.ajax({
        type : 'POST',
        url : '/show/importCSV',
        data : {
            fileUrl :fileUrl
        },
        success : alert('File imported successfully')
    )};
}
</script>
</body>