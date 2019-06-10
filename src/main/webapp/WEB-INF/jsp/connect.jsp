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
<jsp:include page="./assets/header.jsp"/>

<body>
<jsp:include page="./assets/menu.jsp"/>

<div class="container">
    <div class="row">
        <c:if test="${not empty success}">
            <label class="success"><spring:message code="${succcess}"/></label>
        </c:if>

        <div class="col-md-6">
            <c:if test="${signupForm.id == null}">
                <form:form method="post" action="/connect/login" modelAttribute="loginForm">
                    <fieldset>
                        <h2><spring:message code="connect.login"/></h2>
                        <div class="form-group"><label for="userName"><spring:message code="connect.userName"/></label>
                            <div>
                                <form:input class="form-control" type="text" path="userName" id="username"/>
                                <form:errors path="userName" cssClass="error"/>
                            </div>
                        </div>
                        <div class="form-group"><label for="pwd"><spring:message code="connect.password"/></label>
                            <div>
                                <form:input class="form-control" type="password" path="password" id="pwd"/>
                                <form:errors path="password" cssClass="error"/>
                            </div>
                        </div>
                        <div>
                            <input type="submit" class="btn btn-secondary" value="<spring:message code="connect.login"/>">
                        </div>
                    </fieldset>
                </form:form>
            </c:if>
            <c:if test="${signupForm.id == null}">
                <c:set var="signupOrUpdate" value="/connect/signup"/>
                <c:set var="signupOrUpdateTitle" value="connect.signup"/>
            </c:if>
            <c:if test="${signupForm.id != null}">
                <c:set var="signupOrUpdate" value="/connect/update"/>
                <c:set var="signupOrUpdateTitle" value="connect.modify"/>
            </c:if>
            <c:if test="${not empty error}">
                <label class="error"><spring:message code="${error}"/></label>
            </c:if>
        </div>
        <div class="col-md-6">

            <c:if test="${empty success}">
                <form:form method="post" action="${signupOrUpdate}" modelAttribute="signupForm">
                    <fieldset>
                        <c:if test="${not empty success}">
                            <label class="success"><spring:message code="${success}"/></label>
                        </c:if>

                        <h2><spring:message code="${signupOrUpdateTitle}"/></h2>
                        <div class="form-group">
                            <label for="login"><spring:message code="connect.userName"/></label>
                            <div>
                                <c:if test="${signupForm.id == null}">
                                    <form:input class="form-control" type="text" path="login" id="login"/>
                                    <form:errors path="login" cssClass="error"/>
                                </c:if>
                                <c:if test="${signupForm.id != null}">
                                    <form:input class="form-control" type="text" path="login" id="login"
                                                readonly="true"/>
                                </c:if>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="myPsw"><spring:message code="connect.password"/></label>
                            <div>
                                <form:input class="form-control" type="password" path="password" id="myPsw"/>
                                <form:errors path="password" cssClass="error"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="myPswCheck"><spring:message code="connect.passwordCheck"/></label>
                            <div>
                                <form:input class="form-control" type="password" path="passwordCheck" id="myPswCheck"/>
                                <form:errors path="passwordCheck" cssClass="error"/>
                                <br/>
                                <form:errors path="isPasswordMatch" cssClass="error"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="firstName"><spring:message code="connect.firstName"/></label>
                            <div>
                                <form:input class="form-control" type="firstName" path="firstName" id="firstName"/>
                                <form:errors path="firstName" cssClass="error"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lastName"><spring:message code="connect.lastName"/></label>
                            <div>
                                <form:input class="form-control" type="lastName" path="lastName" id="lastName"/>
                                <form:errors path="lastName" cssClass="error"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="email"><spring:message code="connect.mail"/></label>
                            <div>
                                <c:if test="${signupForm.id == null}">
                                    <form:input class="form-control" type="email" path="email" id="email"/>
                                    <form:errors path="email" cssClass="error"/>
                                </c:if>
                                <c:if test="${signupForm.id != null}">
                                    <form:input class="form-control" type="email" path="email" id="email"
                                                readonly="true"/>
                                </c:if>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="langue"><spring:message code="connect.language"/></label>
                            <form:select type="langue" path="langue" id="langue" class="form-control">
                                <form:option value="FR"><spring:message code="connect.languageFR"/></form:option>
                                <form:option value="EN"><spring:message code="connect.languageEN"/></form:option>
                            </form:select>
                        </div>
                        <div class="form-group">
                            <c:if test="${signupForm.id == null}">
                                <input type="submit" class="btn btn-secondary" value="<spring:message code="connect.signup"/>" id="btnInscription"
                                       disabled>
                            </c:if>
                            <c:if test="${signupForm.id != null}">
                                <input type="submit" class="btn btn-secondary" value="<spring:message code="connect.update"/>">
                            </c:if>
                        </div>
                        <div style="visibility: hidden;">
                            <form:input class="form-control" type="text" path="id" cssClass="form-control" id="title"/>
                        </div>
                    </fieldset>
                </form:form>
            </c:if>
        </div>

    </div>
</div>
<jsp:include page="./assets/footer.jsp"/>

<script>
    $(document).ready(function () {

        $("#login").blur(function () {
            callValidations();
        });

        $("#myPsw").blur(function () {
            callValidations();
        });

        $("#myPswCheck").blur(function () {
            callValidations();
        });

        $("#firstName").blur(function () {
            callValidations();
        });

        $("#lastName").blur(function () {
            callValidations();
        });

        $("#email").blur(function () {
            callValidations();
        });

        function callValidations() {
            validationLogin();
            validationPassword();
            validationPasswordMatch();
            validationFirstName();
            validationLastName();
            validationEmail();
            $('#btnInscription').attr("disabled", false);
        }

        function validationLogin() {
            var login = $("#login").val();
            if (login.length < 1) {
                $('#btnInscription').attr("disabled", true);
                throw new Error("Invalid login");
            }
        }

        function validationPassword() {
            var regex = new RegExp("^(?=.*[$&+,:;=?@#|'<>.^*()%!-])(?=.*[A-Z]).{6,}$");
            var pwd = document.getElementById("myPsw").value;
            if (!pwd.match(regex)) {
                $('#btnInscription').attr("disabled", true);
                throw new Error("Invalid password");
            }
        }

        function validationPasswordMatch() {
            var pwd = document.getElementById("myPsw").value;
            var myPswCheck = document.getElementById("myPswCheck").value;
            if (pwd != myPswCheck) {
                $('#btnInscription').attr("disabled", true);
                throw new Error("Invalid password check");
            }
        }

        function validationFirstName() {
            var first = $("#firstName").val();
            if (first.length < 1) {
                $('#btnInscription').attr("disabled", true);
                throw new Error("Invalid first name");
            }
        }

        function validationLastName() {
            var last = $("#lastName").val();
            if (last.length < 1) {
                $('#btnInscription').attr("disabled", true);
                throw new Error("Invalid last name");
            }
        }

        function validationEmail() {
            var regex = new RegExp("[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,3})");
            if (!$("#email").val().match(regex)) {
                $('#btnInscription').attr("disabled", true);
                throw new Error("Invalid mail");
            }
        }
    })
</script>
</body>
</html>
