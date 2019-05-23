<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>

<jsp:include page="../assets/header.jsp"/>

<body>
<jsp:include page="../assets/menu.jsp"/>

<!-- Aqui metes la definicion de la vista, lo que vas a mostrar-->

<h1>Liste des spectacles</h1>



Image: <img src=${show.posterUrl}  class="img-fluid" alt="Responsive image">
</br>
Title: ${show.title} (${show.slug})</br>
Location: ${show.location} Bookable: ${show.bookable} Price: ${show.price}

<jsp:include page="../assets/footer.jsp"/>

</body>
