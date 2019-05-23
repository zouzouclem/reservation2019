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
            <label class="success"><spring:message code="${succcess}"/></label>
        </c:if>
        <c:if test="${signupForm.id == null}">
        <div>
            <form:form method="post" action="/connect/login" modelAttribute="loginForm">
                <fieldset>
                    <c:if test="${not empty error}">
                        <label class="error"><spring:message code="${error}"/></label>
                    </c:if>
                    <h2><spring:message code="connect.login"/></h2>
                    <div>
                        <label for="userName"><spring:message code="connect.userName"/></label>
                        <div>
                            <form:input type="text" path="userName" id="username"/>
                            <form:errors path="userName" cssClass="error"/>
                        </div>
                    </div>
                    <div>
                        <label for="pwd"><spring:message code="connect.password"/></label>
                        <div>
                            <form:input type="password" path="password" id="pwd"/>
                            <form:errors path="password" cssClass="error"/>
                        </div>
                    </div>
                    <div>
                        <input type="submit" value="<spring:message code="connect.login"/>">
                    </div>
                </fieldset>
            </form:form>
        </div>
        </c:if>
        <c:if test="${signupForm.id == null}">
            <c:set var="signupOrUpdate" value="/connect/signup"/>
        </c:if>
        <c:if test="${signupForm.id != null}">
            <c:set var="signupOrUpdate" value="/connect/update"/>
        </c:if>
        <c:if test="${empty success}">
            <div>
                <form:form method="post" action="${signupOrUpdate}" modelAttribute="signupForm">
                    <fieldset>
                        <c:if test="${not empty success}">
                            <label class="success"><spring:message code="${success}"/></label>
                        </c:if>
                        <div style="visibility: hidden;">
                            <form:input type="text" path="id" cssClass="form-control" id="title"/>
                        </div>
                        <h2><spring:message code="connect.signup"/></h2>
                        <div>
                            <label for="login"><spring:message code="connect.userName"/></label>
                            <div>
                                <c:if test="${signupForm.id == null}">
                                    <form:input type="text" path="login" id="login"/>
                                    <form:errors path="login" cssClass="error"/>
                                </c:if>
                                <c:if test="${signupForm.id != null}">
                                    <form:input type="text" path="login" id="login"
                                                readonly="true"/>
                                </c:if>
                            </div>
                        </div>
                        <div>
                            <label for="pwd"><spring:message code="connect.password"/></label>
                            <div>
                                <form:input type="password" path="password" id="pwd"/>
                                <form:errors path="password" cssClass="error"/>
                            </div>
                        </div>
                        <div>
                            <label for="pwdCheck"><spring:message code="connect.passwordCheck"/></label>
                            <div>
                                <form:input type="password" path="passwordCheck" id="pwdCheck"/>
                                <form:errors path="passwordCheck" cssClass="error"/>
                                <br/>
                                <form:errors path="isPasswordMatch" cssClass="error"/>
                            </div>
                        </div>
                        <div>
                            <label for="firstName"><spring:message code="connect.firstName"/></label>
                            <div>
                                <form:input type="firstName" path="firstName" id="firstName"/>
                                <form:errors path="firstName" cssClass="error"/>
                            </div>
                        </div>
                        <div>
                            <label for="lastName"><spring:message code="connect.lastName"/></label>
                            <div>
                                <form:input type="lastName" path="lastName" id="lastName"/>
                                <form:errors path="lastName" cssClass="error"/>
                            </div>
                        </div>
                        <div>
                            <label for="email"><spring:message code="connect.mail"/></label>
                            <div>
                                <c:if test="${signupForm.id == null}">
                                    <form:input type="email" path="email" id="email"/>
                                    <form:errors path="email" cssClass="error"/>
                                </c:if>
                                <c:if test="${signupForm.id != null}">
                                    <form:input type="email" path="email" id="email"
                                                readonly="true"/>
                                </c:if>
                            </div>
                        </div>
                        <div>
                            <label for="langue"><spring:message code="connect.language"/></label>
                            <form:select type="langue" path="langue" id="langue">
                                <form:option value = "FR"><spring:message code="connect.languageFR"/></form:option>
                                <form:option value = "EN"><spring:message code="connect.languageEN"/></form:option>
                            </form:select>
                        </div>
                        <div>
                            <c:if test="${signupForm.id == null}">
                                <input type="submit" value="<spring:message code="connect.signup"/>">
                            </c:if>
                            <c:if test="${signupForm.id != null}">
                                <input type="submit" value="<spring:message code="connect.update"/>">
                            </c:if>
                        </div>
                    </fieldset>
                </form:form>
            </div>
        </c:if>

        <jsp:include page="./assets/footer.jsp" />

    <script>
        $(document).ready(function() {

            $("#firstName").blur(function () {
                var first = $("#firstName").val();
                if(first.length < 3){
                    $('#btnInscription').attr("disabled",true);
                }
            });

        })

    </script>




    </body>
</html>
