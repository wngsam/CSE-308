<%-- 
    Document   : giftcardPage
    Created on : May 11, 2015, 11:07:06 PM
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
    <style>
    .specialColor { 
    padding: 5px;
    color: #000;
    font-size: 12px;
    background: transparent;
    -webkit-appearance: none;
    }</style>
  </head>
<!-- /HEADER <!-- background-size: 1200px,800px;-->

<body role="document">
    <jsp:include page="header.jsp" />
    <div  style="margin-left:70px;" >
    <h1 style="font-size:40px; font-weight: bold;">GIFT CARDS</h1>
    <br>
    <table align ="center"><form id="continue" method="POST" action="personalizingGiftcardPage.htm">
        <tr>
            <td>1. SELECT YOUR CARD + AMOUNT&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                Want to mail a card instead? See our physical cards.</td>
        <tr>
            <td align="center">
                <p style="font-size:20px; font-weight: bold;"><br>PREVIEW</p><br><br>To:<br><br>From:<br><br>
                <img src="assets\img\giftcard.png" style="width:500px;height:380px"><br><br>
                VALUE $50<br><br>Message:<br><br><br>Here is the preview of your gift card. 
                Please confirm that the image above is the gift card you selected before continuing to the checkout page.<br><br>
            </td>
        </tr>
        <tr>
            <td><p style="font-size:40px; font-weight: bold;">CHOOSE A CARD AMOUNT</p><br>
                Card Amount:
                <select id="amount" name="amount">
                  
                    <option class="specialColor" value="100">$100.00</option>
                    <option class="specialColor" value="75">$75.00</option>
                    <option class="specialColor" value="50">$50.00</option>
                    <option class="specialColor" value="25">$25.00</option>
                    <option class="specialColor" value="15">$15.00</option>
                </select>
                
                &nbsp;&nbsp; *Tip: The average price of a movie ticket is $11
            </td>
        </tr>
        <tr>
            <td align="right">
                <button type="submit" class="btn btn-success btn-sm"  >Continue</button>
            </td>
        </tr></form>
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
