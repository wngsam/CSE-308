<%-- 
    Document   : checkout
    Created on : May 19, 2015, 1:06:07 AM
    Author     : Desktop
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
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
<!-- /HEADER <!-- background-size: 1200px,800px;-->

<body role="document" >
    <jsp:include page="header.jsp" />
    
    <c:if test="${not empty pstep}">
        
        <c:if test="${pstep eq 1}">
            You are purchasing tickets for ${buysch.movieName} at ${buysch.theaterName} on ${buysch.getTime()} <br><br>
            <form class="navbar-form navbar-center" method="POST" action="pay=${buysch.id}.htm"><div class="form-group">
                Adults:&nbsp;&nbsp;
                <input type="text" class="form-control input-sm" name="adult" placeholder="0"> &nbsp;&nbsp;x $12 Each<br><br>
                Children:&nbsp;&nbsp;
                <input type="text" class="form-control input-sm" name="child" placeholder="0"> &nbsp;&nbsp;x $9 Each<br><br>
                Seniors:&nbsp;&nbsp;
                <input type="text" class="form-control input-sm" name="senior" placeholder="0"> &nbsp;&nbsp;x $7 Each<br><br>
                <button type="submit" class="btn btn-success">GO</button>
            </div></form>
        </c:if>
    
        <c:if test="${pstep eq 2}">
            You are purchasing tickets for ${buysch.movieName} at ${buysch.theaterName} on ${buysch.getTime()} <br>
            You have selected ${adult} adult tickets, ${child} children tickets, ${senior} senior tickets. <br><br>
            Total: $${totalCost}<br><br>
            
            <c:if test="${empty currentPerson}">
                Please enter your information below. <br><br>
                <form class="navbar-form navbar-center" method="POST" action="postcheckout=${buysch.id},${tickets},${totalCost}.htm"><div class="form-group">
                    Email:&nbsp;&nbsp;
                    <input type="email" class="form-control input-sm" name="email" placeholder="Email"> &nbsp;&nbsp;<br><br>
                    First Name:&nbsp;&nbsp;
                    <input type="text" class="form-control input-sm" name="firstname" placeholder="First Name"> &nbsp;&nbsp;<br><br>
                    Last Name:&nbsp;&nbsp;
                    <input type="text" class="form-control input-sm" name="lastname" placeholder="Last Name"> &nbsp;&nbsp;<br><br>
                    Credit Card Number
                    <input type="text" class="form-control input-sm" name="ccn" placeholder="Credit Card Number"> &nbsp;&nbsp;<br><br>
                    CCV:&nbsp;&nbsp;
                    <input type="text" class="form-control input-sm" name="ccv" placeholder="CCV"> &nbsp;&nbsp;<br><br>
                    Address:&nbsp;&nbsp;
                    <input type="text" class="form-control input-sm" name="address" placeholder="Address"> &nbsp;&nbsp;<br><br>
                    
                    <button type="submit" class="btn btn-success">Submit</button>
                </div></form>
            </c:if>
                
            <c:if test="${not empty currentPerson}">
                Select a payment method or enter a new one! <br><br>
                Available Payment Methods:<br><br>
                
                <div class="btn-group"><a href="#" class="btn btn-default dropdown-toggle" data-toggle="dropdown">Credit Cards</a>
                    <ul class="dropdown-menu">
                        <c:if test="${not empty currentPerson.paymentMethods}">
                            <c:forEach var="pm" items="${currentPerson.paymentMethods}" varStatus="count">
                                <li><a href="usercheckout2=${buysch.id},${tickets},${totalCost},${pm.id}.htm">${pm.creditCardNum}</a></li>
                            </c:forEach>
                        </c:if>
                        <c:if test="${empty currentPerson.paymentMethods}">
                            <li><a href="#">None</a></li>
                        </c:if>
                    </ul>
                </div>
                
            <form:form action="usercheckout=${buysch.id},${tickets},${totalCost}.htm" modelAttribute="paymentmethod" method="post">
        
            <div class="form-group">
                <p class="text-warning" style="font-size:20px">First Name:</P>
                <form:input path="firstName" placeholder="First Name"/>
            </div>
            <div class="form-group">
                <p class="text-warning" style="font-size:20px">Last Name:</P>
                <form:input path="lastName" placeholder="Last Name"/>
            </div>
            <div class="form-group">
                <p class="text-warning" style="font-size:20px">Credit Card Number:</P>
                <form:input path="creditCardNum" placeholder="Credit Card #"/>
            </div>
            <div class="form-group">
                <p class="text-warning" style="font-size:20px">CCV:</P>
                <form:input path="ccv" placeholder="CCV"/>
            </div>
            <div class="form-group">
                <p class="text-warning" style="font-size:20px">Address:</P>
                <form:input path="address" placeholder="Address"/>
            </div>
            <div class="form-group">
                <p class="text-warning" style="font-size:20px">Zipcode:</P>
                <form:input path="zipCode" placeholder="Zipcode"/>
            </div>
            
            <br><button type="submit" class="btn btn-success" >Submit</button>
            </form:form>
            
            </c:if>
            
        </c:if>
    
        <c:if test="${pstep eq 3}">
            Thank you for purchasing! A confirmation will be sent to you with your unique code. Please redeem your tickets at the theater
            with this code: <b>${bill.id}</b>!
            
        </c:if>
        
    </c:if>
    <jsp:include page="footer.jsp" />
<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
</body>	

</html>
