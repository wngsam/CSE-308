<%-- 
    Document   : giftcardPruchasePage
    Created on : May 13, 2015, 2:09:27 AM
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

<body role="document" >
    <jsp:include page="header.jsp" />
    <div  style="margin-left:70px;" >
    <h1 style="font-size:40px; font-weight: bold;">GIFT CARDS Purchase</h1>
    <br>
   
    <table align="center" width="1200px"><form id="continue" method="POST" action="giftcardSuccess.htm">
        <tr>
            <td>
                <div class="text-warning" style="font-size:20px">Receiver Email Address</div> ${email}<br><br>
                <div class="text-warning" style="font-size:20px">Email Title</div> ${title}<br><br>
                <div class="text-warning" style="font-size:20px">Message</div> ${message}<br><br>
                <div class="text-warning" style="font-size:20px">Amount</div> ${amount}$<br><br>
                <input type="hidden" name="email" value="${email}">
                <input type="hidden" name="title" value="${title}">
                <input type="hidden" name="message" value="${message}">
                <input type="hidden" name="amount" value="${amount}">
            </td>
        </tr>
    <tr>
        <td>
        <div class="form-group">
            <p class="text-warning" style="font-size:20px">First Name:</P>
            <input style="width: 200px" type="firstName" class="form-control input-sm" name="firstName" placeholder="FirstName">
        </div>
        <div class="form-group">
            <p class="text-warning" style="font-size:20px">Last Name:</P>
            <input style="width: 200px" type="lastName" class="form-control input-sm" name="lastName" placeholder="LastName">
        </div>
        <div class="form-group">
            <p class="text-warning" style="font-size:20px">Credit Card Number:</P>
            <p><input maxlength="4" style="width: 80px; height: 30px" type="creditCardNumber"  name="creditCardNumber1" placeholder="  *   *   *   *">-
            <input maxlength="4" style="width: 80px; height: 30px" type="creditCardNumber"  name="creditCardNumber2" placeholder="  *   *   *   *">-
            <input maxlength="4" style="width: 80px; height: 30px" type="creditCardNumber"  name="creditCardNumber3" placeholder="  *   *   *   *">-
            <input maxlength="4" style="width: 80px; height: 30px" type="creditCardNumber"  name="creditCardNumber4" placeholder="  *   *   *   *"></p>
        </div>
        <div class="form-group">
            <p class="text-warning" style="font-size:20px">CCV:</P>
            <input maxlength="3" style="width: 60px" type="ccv" class="form-control input-sm" name="ccv" placeholder="CCV">
        </div>
        <div class="form-group">
            <p class="text-warning" style="font-size:20px">Billing Address:</P>
            <input style="width: 800px" type="billingAddress" class="form-control input-sm" name="billingAddress" placeholder="BillingAddress">
        </div>
        <div class="form-group">
            <p class="text-warning" style="font-size:20px">Zip Code</P>
            <input maxlength="5" style="width: 80px" type="zipCode" class="form-control input-sm" name="zipCode" placeholder="ZipCode">
        </div>
            </td>
        </tr>

       <!-- <p class="text-warning" style="font-size:20px">Preferred Payment? 
        <form:checkbox width="100px" height="100px" path="isPreferred"/></p>-->
       <tr align="right">
           <td>
               <br><button  type="submit" class="btn btn-success" >Purchase</button></br>
           </td>    
       </tr>
    </form>
    </table>
  <!--  </form>-->

    <br><br><br>
    
    </div>       
   

<br><hr>
	
<jsp:include page="footer.jsp" />
<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
</body>	

</html>
