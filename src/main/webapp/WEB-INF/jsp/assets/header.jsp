<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>

<head>
    <title>Reservations</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
          integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">

    <c:if test="${styleColor == 'default'}">
        <link href="<c:url value="/resources/css/myCss.css" />" rel="stylesheet">
    </c:if>
    <c:if test="${styleColor== 'blue'}">
        <link href="<c:url value="/resources/css/color-blue.css" />" rel="stylesheet">
    </c:if>
    <c:if test="${styleColor== 'pink'}">
        <link href="<c:url value="/resources/css/color-pink.css" />" rel="stylesheet">
    </c:if>
    <c:if test="${styleColor== 'green'}">
        <link id="style" href="<c:url value="/resources/css/color-green.css" />" rel="stylesheet">
    </c:if>

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" type="text/css"
          href="https://cdn.datatables.net/buttons/1.5.6/css/buttons.bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/select/1.3.0/css/select.bootstrap.min.css">


</head>