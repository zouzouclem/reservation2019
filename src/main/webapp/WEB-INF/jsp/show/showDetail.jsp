<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>

<jsp:include page="../assets/header.jsp"/>

<body>
<jsp:include page="../assets/menu.jsp"/>

<h1><spring:message code = "showDet.pageTitle"/></h1>
</br>
 <img src=${show.posterUrl}  class="img-fluid" alt="Responsive image">
</br>
<em><strong><spring:message code = "showDet.showTitle"/> :</strong></em> ${sho.title} (${sho.slug})
</br>
<em><strong><spring:message code = "showDet.showLocation"/> : </strong></em> ${sho.location.designation}
</br>
<em><strong><spring:message code = "showDet.showLocationAdresse"/> :</strong></em> ${sho.location.address}
</br>
<em><strong><spring:message code = "showDet.showBookable"/> :</strong></em> ${sho.bookable}
</br>
<em><strong><spring:message code = "showDet.showPrix"/> :</strong></em> ${sho.price}
</br>
<em><strong><spring:message code = "showDet.showDescription"/> :</strong></em> ${sho.description}
</br>
<jsp:include page="../assets/footer.jsp"/>

</body>
