<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<jsp:include page="../assets/header.jsp"/>

<body>
<jsp:include page="../assets/menu.jsp"/>

    <c:if test="${ShowForm.id == null}">
        <div>
            <form:form method="post" action="show/add" modelAttribute="showForm">
                <fieldset>
                    <c:if test="${not empty error}">
                        <label class="error">${error}/></label>
                    </c:if>
                    <h2>Shows</h2>
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
                            &lt;%&ndash;<form:input type="text" path="title" id="title"/>
                            <form:errors path="title" cssClass="error"/>&ndash;%&gt;
                        </div>
                    </div>
                    <div>
                        <label for="postUrl">Poster_URL</label>
                        <div>
                            <form:input type="text" path="postUrl" id="postUrl"/>
                            <form:errors path="postUrl" cssClass="error"/>
                        </div>
                    </div>
                    <div>
                        <label for="booking">Bookable</label>
                        <div>
                            <form:input type="checkbox" path="booking" id="booking"/>
                            <form:errors path="booking" cssClass="error"/>
                        </div>
                    </div>
                    <div>
                        <label for="prix">Price</label>
                        <div>
                            <form:input type="text" path="prix" id="prix"/>
                            <form:errors path="prix" cssClass="error"/>
                        </div>
                    </div>
                    <div>
                        <input type="submit" value="Enregistrer">
                    </div>
                </fieldset>
            </form:form>
        </div>
    </c:if>

<jsp:include page="../assets/footer.jsp"/>

</body>