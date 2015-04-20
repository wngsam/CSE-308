<%-- 
    Document   : boxOfficePage
    Created on : Apr 11, 2015, 2:21:37 PM
    Author     : Desktop
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<center><h1><p class="text-danger" style="font-size:55px">Top Box Office + Weekend Results</p></h1></center>
<div class="container">
    <table class="table table-striped table-hover" style="font-size:25px">
        <thead>
            <tr>
                <th>Rank</th>
                <th>Title</th>
                <th>Weekend Gross</th>
                <th># Of Theaters</th>
                <th>Theater Average</th>
                <th>Weeks Released</th>
                <th>Total Gross</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="movie" items="${boxOfficeMovies}" varStatus="count"> 
                <tr class="default">
                    <td>${count.count}</td>
                    <td>${movie.title}</td>
                    <td>${movie.weekendGross}</td>
                    <td>${movie.numOfTheaters}</td>
                    <td>${movie.theaterAverage}</td>
                    <td>X</td>
                    <td>X</td>
                </tr>
            </c:forEach>   
        </tbody>
    </table> 
</div>

<jsp:include page="footer.jsp" />
<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
  </body>
</html>