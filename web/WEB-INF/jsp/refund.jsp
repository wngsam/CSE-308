<%-- 
    Document   : refund
    Created on : May 20, 2015, 1:50:21 AM
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
    <c:if test="${not empty currentPerson}">
    <c:if test="${rstep == 1}">
        Enter your transaction code to get a refund, this cannot be undone. <br><br>
        <form class="container-fluid" method="POST" action="refund.htm"><div class="form-group">
            <input type="text" class="form-control input-sm" name="code" placeholder="Transaction Code">
            <button type="submit" class="btn btn-success">REFUND</button>
        </div></form>
    </c:if>
        
    <c:if test="${rstep == 2}">
        Transaction ${t.id} Refund Processed!<br>
        ${t.cost} Refunded!
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
