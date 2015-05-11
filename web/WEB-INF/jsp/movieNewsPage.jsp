<%-- 
    Document   : movieNewsPage
    Created on : May 9, 2015, 8:45:18 PM
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
    <link href="assets/css/footer_style.css" rel="stylesheet" media="screen">
    <link href="assets/css/bootstrap.css" rel="stylesheet" media="screen">
  </head>
<!-- /HEADER -->
  
<body role="document">
<jsp:include page="header.jsp" />
<p style="font-size:40px; font-weight: bold;">&nbsp;&nbsp;&nbsp;&nbsp;MOVIE NEWS</p>
    <div class="container">
        <table style="width:100%;height:450px">
            <tr valign="top">
                <td style="padding:15px"><a href="movieNews1.htm"><img src="assets\img\movieNews\movieNews1.jpg" style="width:304px;height:228px"></a><br><br>
                        <p style="font-size:20px; font-weight: bold;">WEEKEND TICKET WITH REESE WITHERSPOON AND SOFIA VERGARA</p></td>
                <td style="padding:15px;"><a href="movieNews2.htm"><img src="assets\img\movieNews\movieNews2.jpg" style="width:304px;height:228px"></a><br><br>
                    <p style="font-size:20px; font-weight: bold;">MOM'S MOVIE MINUTE - AVENGERS: AGE OF ULTRON</p></td>
                <td style="padding:15px;"><a href="movieNews3.htm"><img src="assets\img\movieNews\movieNews3.jpg" style="width:304px;height:228px"></a><br><br>
                    <p style="font-size:20px; font-weight: bold;">REEL KIDS: GEEK WEEK</p></td>
                <td style="padding:15px;"><a href="movieNews4.htm"><img src="assets\img\movieNews\movieNews4.jpg" style="width:304px;height:228px"></a><br><br>
                    <p style="font-size:20px; font-weight: bold;">FRONTRUNNERS SEASON 3 WRAP-UP</p></td>
            </tr>
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
