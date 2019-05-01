<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dscohier
  Date: 19/04/2019
  Time: 19:45
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="./assets/header.jsp" />

    <body>
    <jsp:include page="./assets/menu.jsp" />

    <c:if test="${not empty success}">
            <label class="success">Votre compte a bien été créer</label>
        </c:if>
        <c:if test="${signupForm.id == null}">
        <div>
            <form:form method="post" action="connect/login" modelAttribute="loginForm">
                <fieldset>
                    <c:if test="${not empty error}">
                        <label class="error">${error}/></label>
                    </c:if>
                    <h2>Login</h2>
                    <div>
                        <label for="userName">Login</label>
                        <div>
                            <form:input type="text" path="userName" id="username"/>
                            <form:errors path="userName" cssClass="error"/>
                        </div>
                    </div>
                    <div>
                        <label for="pwd">mot de passe</label>
                        <div>
                            <form:input type="password" path="password" id="pwd"/>
                            <form:errors path="password" cssClass="error"/>
                        </div>
                    </div>
                    <div>
                        <input type="submit" value="se connecter">
                    </div>
                </fieldset>
            </form:form>
        </div>
        </c:if>
        <c:if test="${signupForm.id == null}">
            <c:set var="signupOrUpdate" value="connect/signup"/>
        </c:if>
        <c:if test="${signupForm.id != null}">
            <c:set var="signupOrUpdate" value="update"/>
        </c:if>
        <c:if test="${empty success}">
            <div>
                <form:form method="post" action="${signupOrUpdate}" modelAttribute="signupForm">
                    <fieldset>
                        <c:if test="${not empty success}">
                            <label class="success">Votre compte a bien été créer</label>
                        </c:if>
                        <div style="visibility: hidden;">
                            <form:input type="text" path="id" cssClass="form-control" id="title"/>
                        </div>
                        <h2>Inscription</h2>
                        <div>
                            <label for="login">login</label>
                            <div>
                                <c:if test="${signupForm.id == null}">
                                    <form:input type="text" path="login" cssClass=" form-control" id="login"/>
                                    <form:errors path="login" cssClass="error"/>
                                </c:if>
                                <c:if test="${signupForm.id != null}">
                                    <form:input type="text" path="login" cssClass=" form-control" id="login"
                                                readonly="true"/>
                                </c:if>
                            </div>
                        </div>
                        <div>
                            <label for="pwd">mot de passe</label>
                            <div>
                                <form:input type="password" path="password" id="pwd"/>
                                <form:errors path="password" cssClass="error"/>
                            </div>
                        </div>
                        <div>
                            <label for="firstName">prénom</label>
                            <div>
                                <form:input type="firstName" path="firstName" id="firstName"/>
                                <form:errors path="firstName" cssClass="error"/>
                            </div>
                        </div>
                        <div>
                            <label for="lastName">nom</label>
                            <div>
                                <form:input type="lastName" path="lastName" id="lastName"/>
                                <form:errors path="lastName" cssClass="error"/>
                            </div>
                        </div>
                        <div>
                            <label for="email">mail</label>
                            <div>
                                <form:input type="email" path="email" id="email"/>
                                <form:errors path="email" cssClass="error"/>
                            </div>
                        </div>
                        <div>
                            <label for="langue">langue</label>
                            <div>
                                <form:input type="langue" path="langue" id="langue"/>
                            </div>
                        </div>
                        <div>
                            <c:if test="${signupForm.id == null}">
                                <input type="submit" value="inscription">
                            </c:if>
                            <c:if test="${signupForm.id != null}">
                                <input type="submit" value="mettre à jour">
                            </c:if>
                        </div>
                    </fieldset>
                </form:form>
            </div>
        </c:if>

        <jsp:include page="./assets/footer.jsp" />

    </body>
</html>
