<%-- 
    Document   : forgotPassword
    Created on : 2015. 5. 14, 오후 4:55:56
    Author     : DreamRealizer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<!-- /HEADER -->
  
<body role="document">
<jsp:include page="header.jsp"/>

             <div class="page-header">
                 <h1>Forgot Password</h1>
             </div>
<form method="POST" action="resetPassword.htm">   
    <c:choose>
    <c:when test="${empty nonExist}">
                                    <div class="form-group">
                                        <p class="text-warning" style="font-size:20px">E-mail Address:</P>
                                        <input type="email" name="email"/>                                        
                                    </div>     
                                                                       
                                    <br><button type="submit" class="btn btn-success" >Send Me a New Password!</button></br>                            
                                </form>
                                    </c:when>
<c:otherwise>
    <div class="form-group">
                                        <p class="text-warning" style="font-size:20px">E-mail Address:</P>
                                        <input type="email" name="email"/>                                        
                                    </div>     
                                                                       
                                    <br><button type="submit" class="btn btn-success" >Send Me a New Password!</button><p class="text-warning" style="font-size:20px">The e-mail address does not exist. Please verify your e-mail!</P></br>                            
                                </form>
                                        
</c:otherwise>
                                </c:choose>

             
<jsp:include page="footer.jsp" />
<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>

</body>
</html>
