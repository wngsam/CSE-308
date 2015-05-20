<%-- 
    Document   : nearbyTheaters
    Created on : May 20, 2015, 2:24:49 PM
    Author     : Desktop
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- HEADER -->
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="assets\img\favicon.ico">

    <title>Samdango</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="assets/css/nav_style.css" rel="stylesheet" media="screen">
    <link href="assets/css/footer_style.css" rel="stylesheet" media="screen">
    <link href="assets/css/bootstrap.css" rel="stylesheet" media="screen">
  </head>
<!-- /HEADER <!-- background-size: 1200px,800px;-->

<body role="document" >
    <jsp:include page="header.jsp" />
    <b>Nearby Theaters!</b><br><br>
    
    <c:forEach var="t" items="${nearbytheaters}" varStatus="count">
        ${t.name}<br>
        ${t.address}<br>
        ${t.phone}<br><br><br>
        <c:forEach var="sch" items="${currentMovie.schedules}" varStatus="count">
            <c:if test="${sch.theaterId eq t.id}">
                <a href="buy=${sch.id}.htm" class="btn btn-primary">${sch.getTime()}</a>
            </c:if>
        </c:forEach>
                <br><br>
    </c:forEach>
    
    <jsp:include page="footer.jsp" />
<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
</body>	

</html>
