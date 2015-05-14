<%-- 
    Document   : comingSoonPage
    Created on : May 14, 2015, 3:29:53 AM
    Author     : JaeWoong
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
    <link href="assets/css/bootstrap.css" rel="stylesheet" media="screen">
    <link href="assets/css/footer_style.css" rel="stylesheet" media="screen">
  </head>
<!-- /HEADER -->
  
<body role="document">
<jsp:include page="header.jsp" />

<div class="container">
    <div  style="margin-left:70px;" >
     <h1 style="font-size:40px; font-weight: bold;">SEARCH RESULTS</h1>
     <table>
        <tr>
            <td>
                <br><p class="text-warning" style="font-size:20px; font-weight: bold;">Movie List</p><br>
            </td>
        </tr>
        <tr>
            <c:forEach items="${resultMovieList}" varStatus="status" var="listVar">     
                <td>    
                    <div class="col-xs-6 col-lg-3">
                        <center><p><a href="${listVar.title}.htm"></p>
                                    <img src="${listVar.poster}" width="145" height="220"></a><br>
                            <fmt:formatDate type="Date" dateStyle="Long" value="${listVar.releaseDate.time}"></fmt:formatDate></center>
                    </div>
                </td>    
            </c:forEach>        
        </tr>
        <tr>
            <td>
                <br><p class="text-warning" style="font-size:20px; font-weight: bold;">Theater List</p><br>
            </td>
        </tr>
        <tr>
            <c:forEach items="${resultTheaterList}" varStatus="status" var="listVar" >     
                <td>    
                    <div class="col-xs-6 col-lg-3">
                        <center><p>${listVar.name}</p>
                                <p>${listVar.address}"</p> <br>
                        </center>
                    </div>
                </td>    
            </c:forEach>        
        </tr>
 
      
    </table>
    </div>
</div>

<hr><jsp:include page="footer.jsp" />
<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
  </body>
</html>
