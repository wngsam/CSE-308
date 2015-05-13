<%-- 
    Document   : movieNews1
    Created on : May 9, 2015, 9:44:14 PM
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

    <title>Yggdrasil</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="assets/css/nav_style.css" rel="stylesheet" media="screen">
    <link href="assets/css/footer_style.css" rel="stylesheet" media="screen">
    <link href="assets/css/bootstrap.css" rel="stylesheet" media="screen">
  </head>
<!-- /HEADER <!-- background-size: 1200px,800px;-->

<body role="document" class="movieinfo_bg">
    <jsp:include page="header.jsp" />
    <div  style="margin-left:70px;" >
    <hr><h1 style="font-weight: bold">WEEKEND TICKET</h1>
    <br>
        <table align="center" style="width:1300px">
            <tr>
                <td><embed width="1300px" height="750px"src="${movieNewsTrailer}"></td>
            </tr>
            <tr>
                <td><font size="6" weight="bold"><br>${movieNewsContent1}</font><br>
                    <font size="4">${movieNewsContent2}</font></td>
            </tr>
        </table>
         
    <br><br><br>
    </div>       

<!-- /MAIN MOVIE BODY -->
<br><hr>
		
<jsp:include page="footer.jsp" />
<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
  </body>

</html>
