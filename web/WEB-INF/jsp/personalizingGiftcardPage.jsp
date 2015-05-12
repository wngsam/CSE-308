<%-- 
    Document   : personalizingGiftcardPage
    Created on : May 12, 2015, 12:09:34 AM
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
    <h1 style="font-size:40px; font-weight: bold;">GIFT CARDS</h1>
    <br>
    <form class="navbar-form navbar-right" id="login" method="POST" action="login.htm">
    <table>
        <tr>
            <td>&nbsp;&nbsp;2. PERSONALIZE YOUR GIFT &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                Want to mail a card instead? See our physical cards.</td>       
        <tr>
            <td><p style="font-size:40px; font-weight: bold;">GIFT RECIPIENT</p><br><br>Email Address<br>
                <input type="email" class="form-control input-sm" name="email" placeholder="E-mail">
            </td>
        </tr>
        <tr>
            <td><p style="font-size:40px; font-weight: bold;">ADD A PERSONAL MESSAGE</p><br><br>Title:<br>
                <input type="title" class="form-control input-sm" name="title" placeholder="Title"><br>Message:<br>
                <input type="message" class="form-control input-sm" name="meesage" placeholder="Message">   
            </td>
        </tr>
        <tr>
            <td align="right">
                <a href="giftcardPAge.htm">Back</a><button type="submit" class="btn btn-success btn-sm">Continue</button>
            </td>
        </tr>
    </table>
    </form>

    <br><br><br>
    
    </div>       
    
  <form class="navbar-form navbar-right" id="login" method="POST" action="login.htm">
                            <input type="email" class="form-control input-sm" name="email" placeholder="E-mail">
                            <input type="password" class="form-control input-sm" name="password"placeholder="Password">
                            <button type="submit" class="btn btn-success btn-sm">Login</button>
                            <a href="registrationPage.htm" class="btn btn-warning btn-sm">Register</a>
                        </form>
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
