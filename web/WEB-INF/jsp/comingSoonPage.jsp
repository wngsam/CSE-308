<%-- 
    Document   : comingSoonPage
    Created on : Apr 11, 2015, 3:29:53 PM
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
<!-- /HEADER -->
  
<body role="document">
<jsp:include page="header.jsp" />

<div class="container">
			<hr>
		
		<center><h1><p class="text-info" style="font-size:55px">MOVIES COMING SOON</p></h1></center><hr>
                FILTER MOVIE BY:&nbsp;&nbsp;
                  <div class="btn-group">
                    <a href="#" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                      Genre
                      <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                      <li><a href="#">All</a></li>
                      <li><a href="#">3D</a></li>
                      <li><a href="#">Action/Adventure</a></li>
                      <li><a href="#">Animated</a></li>
                      <li><a href="#">Art House/Foreign</a></li>
                      <li><a href="#">Children's/Family</a></li>
                      <li><a href="#">Comedy</a></li>
                      <li><a href="#">Concert/Special Events</a></li>
                      <li><a href="#">Culture & Society</a></li>
                      <li><a href="#">Documentary</a></li>
                      <li><a href="#">Drama</a></li>
                      <li><a href="#">Epic</a></li>
                      <li><a href="#">Family</a></li>
                      <li><a href="#">Health & Fitness</a></li>
                      <li><a href="#">History</a></li>
                      <li><a href="#">Horror</a></li>
                      <li><a href="#">IMAX</a></li>
                      <li><a href="#">Nature</a></li>
                      <li><a href="#">Music/Performing Arts</a></li>
                      <li><a href="#">Romance</a></li>
                      <li><a href="#">Science & Technology</a></li>
                      <li><a href="#">Suspense/Thriller</a></li>
                      <li><a href="#">Western</a></li>
                    </ul>
                  </div><br><br><br>
<center>
    
    <table>
        <tr>
            <c:forEach items="${comingSoonMovies}" varStatus="status" var="listVar" >     
                <td>    
                    <div class="col-xs-6 col-lg-3">
                            <center><p><a href="${listVar.title}.htm">
                                    <img src="${listVar.poster}" width="145" height="220"></a><br>
                            <fmt:formatDate type="Date" dateStyle="Long" value="${listVar.releaseDate.time}"></fmt:formatDate></center>
                    </div>
                </td>    
                </c:forEach>
        </td>
    </tr>			
      
    </table>
</center>	  
    </div>



<br><br><center>
            <div class="bs-component">
              <ul class="pagination">
                <li class="disabled"><a href="#">&laquo;</a></li>
                <li class="active"><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li><a href="#">&raquo;</a></li>
              </ul>
            </div></center>
<br><br><br><br><hr>

<jsp:include page="footer.jsp" />
<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
  </body>
</html>
