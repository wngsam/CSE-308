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
    <link href="assets/css/bootstrap.css" rel="stylesheet" media="screen">
  </head>
<!-- /HEADER -->
  
<body role="document">
<jsp:include page="header.jsp" />


<!-- MAIN BOXOFFICE BODY-->
<center><h1><p class="text-danger" style="font-size:55px">Top Box Office + Weekend Results</p></h1></center>
<table class="table table-striped table-hover " style="font-size:25px">
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
    
    <tr>
      <tr class="danger">
      <td>1</td>
      <c:forEach var="listVar" items="${boxOfficeMovies}"> 
      <td>${listVar.title}</td>
      </c:forEach>   
      <td>$20.69M</td>
      <td>$5234</td>
	  <td>3020</td>
	  <td>1</td>
	  <td>20.69M</td>
    </tr>
    
    <tr>
	<tr class="success">
      <td>2</td>
      <td>Shaun of the Dead</td>
      <td>$19.99M</td>
      <td>$5110</td>
	  <td>2990</td>
	  <td>2</td>
	  <td>$40.33M</td>
    </tr>
    <tr class="info">
      <td>3</td>
      <td>Return of The Seawolf</td>
      <td>$19.22M</td>
      <td>$5009</td>
	  <td>2976</td>
	  <td>4</td>
	  <td>$79.22M</td>
    </tr>
	<tr>
      <td>4</td>
      <td>David: King of Israel</td>
      <td>$18.71M</td>
      <td>$4992</td>
	  <td>2898</td>
	  <td>3</td>
	  <td>$78.61M</td>
    </tr>
	<tr>
      <td>5</td>
      <td>Jinjja Namja</td>
      <td>$18.11M</td>
      <td>$4912</td>
	  <td>2877</td>
	  <td>3</td>
	  <td>$77.09M</td>
    </tr>
    <tr>
      <td>6</td>
      <td>Hearthstone: Heroes of Newerth</td>
      <td>$18.01M</td>
      <td>$4811</td>
	  <td>2871</td>
	  <td>5</td>
	  <td>$76.88M</td>
    </tr>
    <tr>
      <td>7</td>
      <td>Nugget Killer</td>
      <td>$15.33M</td>
      <td>$4700</td>
	  <td>2866</td>
	  <td>2</td>
	  <td>$75.18</td>
    </tr>
	<tr>
      <td>8</td>
      <td>Seawolf</td>
      <td>$15.03M</td>
      <td>$4610</td>
	  <td>2816</td>
	  <td>3</td>
	  <td>$74.15</td>
    </tr>
	<tr>
      <td>9</td>
      <td>League of Draven</td>
      <td>$14.73M</td>
      <td>$4600</td>
	  <td>2766</td>
	  <td>6</td>
	  <td>$81.18</td>
    </tr>
	<tr>
      <td>10</td>
      <td>WWE Champion</td>
      <td>$13.33M</td>
      <td>$4100</td>
	  <td>2566</td>
	  <td>15</td>
	  <td>$97.19</td>
    </tr>
  </tbody>
</table> 
<!-- /MAIN BOXOFFICE BODY -->









<jsp:include page="footer.jsp" />
<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
  </body>
</html>
