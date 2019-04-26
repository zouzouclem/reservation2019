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
    <head>
        <title>Title</title>
        <link href="<c:url value="/resources/css/myCss.css" />" rel="stylesheet">
    </head>
    <body>
        <c:if test="${not empty success}">
            <label class="success">Votre compte a bien été créer</label>
        </c:if>
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
        <c:if test="${empty success}">
            <div>
                <form:form method="post" action="connect/signup" modelAttribute="signupForm">
                    <fieldset>
                        <c:if test="${not empty success}">
                            <label class="success">Votre compte a bien été créer</label>
                        </c:if>
                        <h2>Inscription</h2>
                        <div>
                            <label for="login">login</label>
                            <div>
                                <form:input type="login" path="login" id="login"/>
                                <form:errors path="login" cssClass="error"/>
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
                            <input type="submit" value="inscription">
                        </div>
                    </fieldset>
                </form:form>
            </div>
        </c:if>
    </body>
</html>
