<%-- 
    Document   : checkout
    Created on : May 19, 2015, 1:06:07 AM
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
    
    <c:if test="${not empty pstep}">
        
        <c:if test="${pstep eq 1}">
            You are purchasing tickets for ${buysch.movieName} at ${buysch.theaterName} on ${buysch.getTime()} <br><br>
            <form class="navbar-form navbar-center" method="POST" action="pay=${buysch.id}.htm"><div class="form-group">
                Adults:&nbsp;&nbsp;
                <input type="text" class="form-control input-sm" name="adult" placeholder="0"> &nbsp;&nbsp;x $12 Each<br><br>
                Children:&nbsp;&nbsp;
                <input type="text" class="form-control input-sm" name="child" placeholder="0"> &nbsp;&nbsp;x $9 Each<br><br>
                Seniors:&nbsp;&nbsp;
                <input type="text" class="form-control input-sm" name="senior" placeholder="0"> &nbsp;&nbsp;x $7 Each<br><br>
                <button type="submit" class="btn btn-success">GO</button>
            </div></form>
        </c:if>
    
        <c:if test="${pstep eq 2}">
            You are purchasing tickets for ${buysch.movieName} at ${buysch.theaterName} on ${buysch.getTime()} <br>
            You have selected ${adult} adult tickets, ${child} children tickets, ${senior} senior tickets. <br><br>
            Choose a Payment Method:
        </c:if>
    
        <c:if test="${pstep eq 3}">
            Thank you for purchasing! A confirmation will be sent to you with your unique code. Please redeem your tickets at the theater
            with this code!
        </c:if>
        
    </c:if>
    <jsp:include page="footer.jsp" />
<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
</body>	

</html>
