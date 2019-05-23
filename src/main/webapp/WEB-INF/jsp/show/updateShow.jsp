<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<jsp:include page="../assets/header.jsp"/>

<body>
<jsp:include page="../assets/menu.jsp"/>

    <c:if test="${showForm.id != null}">
        <div>

            <form:form method="post" action="/show/update" modelAttribute="showForm">

                <div style="visibility: hidden;">
                    <form:input type="text" path="id" cssClass="form-control" id="title"/>
                </div>
                <fieldset>
                    <c:if test="${not empty error}">
                        <label class="error">${error}/></label>
                    </c:if>
                    <h2><spring:message code="updateShow.pageTitle"/></h2>
                    <div>
                        <label for="slug">Slug</label>
                        <div>
                            <form:input type="text" path="slug" id="slug"/>
                            <form:errors path="slug" cssClass="error"/>
                        </div>
                    </div>
                    <div>
                        <label for="title">Title</label>
                        <div>
                            <form:input type="text" path="title" id="title"/>
                            <form:errors path="title" cssClass="error"/>
                        </div>
                    </div>
                    <div>
                        <label for="posterURL">Poster_URL</label>
                        <div>
                            <form:input type="text" path="posterURL" id="posterURL"/>
                            <form:errors path="posterURL" cssClass="error"/>
                        </div>
                    </div>
                    <div>
                        <label for="location">Location</label>
                        <div>
                            <form:select path="location" items="${locationsList}"/>
                            <form:errors path="location" cssClass="error"/>
                        </div>
                    </div>
                    <div>
                        <label for="bookable">Bookable</label>
                        <div>
                            <form:checkbox path="bookable" id="bookable"/>
                            <form:errors path="bookable" cssClass="error"/>
                        </div>
                    </div>
                    <div>
                        <label for="price">Price</label>
                        <div>
                            <form:input type="text" path="price" id="price"/>
                            <form:errors path="price" cssClass="error"/>
                        </div>
                    </div>
                    <br />
                    <div>
                        <input type="submit" value="Mettre à jour">
                    </div>
                </fieldset>
            </form:form>
        </div>
    </c:if>




<jsp:include page="../assets/footer.jsp"/>

</body>
