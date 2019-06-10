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


    <form:form method="post" action="/show/update" modelAttribute="showForm">

        <div style="visibility: hidden;">
            <form:input type="text" path="id" cssClass="form-control" id="title"/>
        </div>
        <fieldset>
            <c:if test="${not empty error}">
                <label class="error">${error}/></label>
            </c:if>
            <h2><spring:message code="updateShow.pageTitle"/></h2>

            <div class="row">
                <div class="col-md-6">

                    <div class="form-group">
                        <label for="slug"><spring:message code="updateShow.Slug"/></label>
                        <div>
                            <form:input class="form-control" type="text" path="slug" id="slug"/>
                            <form:errors path="slug" cssClass="error"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="title"><spring:message code="updateShow.Title"/></label>
                        <div>
                            <form:input class="form-control" type="text" path="title" id="title"/>
                            <form:errors path="title" cssClass="error"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="posterURL"><spring:message code="updateShow.PosterURL"/></label>
                        <div>
                            <form:input class="form-control" type="text" path="posterURL" id="posterURL"/>
                            <form:errors path="posterURL" cssClass="error"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="location"><spring:message code="updateShow.Location"/></label>
                        <div>
                            <form:select class="form-control" path="location" items="${locationsList}"/>
                            <form:errors path="location" cssClass="error"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="bookable"><spring:message code="updateShow.Bookable"/></label>
                        <div>
                            <form:checkbox path="bookable" id="bookable"/>
                            <form:errors path="bookable" cssClass="error"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="price"><spring:message code="updateShow.Price"/></label>
                        <div>
                            <form:input class="form-control" type="text" path="price" id="price"/>
                            <form:errors path="price" cssClass="error"/>
                        </div>
                    </div>
                    <br/>
                    <div>
                        <%--TODO philippe label--%>
                            <button class="btn btn-secondary" type="submit"><spring:message code="updateShow.maj"/>
                    </div>
                </div>
            </div>

        </fieldset>
    </form:form>
</div>


<jsp:include page="../assets/footer.jsp"/>

</body>
