<%-- 
    Document   : userPage
    Created on : Apr 10, 2015, 11:21:11 PM
    Author     : Sam W.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
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
<jsp:include page="header.jsp"/>

 <!-- USER NAV BAR -->
 <div class="container-fluid">
    <div class="row">
        <div class="col-lg-12">
             <div class="page-header">
                 <h1>${currentPerson.firstName}'s Account</h1>
             </div>
             <ul class="nav nav-tabs">
                 <li class="active"><a href="#overview" data-toggle="tab" aria-expanded="true">OVERVIEW</a></li>
                 <li><a href="#history" data-toggle="tab" aria-expanded="false">PURCHASE HISTORY</a></li>
                 <li><a href="#settings" data-toggle="tab" aria-expanded="false">ACCOUNT SETTINGS</a></li>
                 <li><a href="#payment" data-toggle="tab" aria-expanded="false">PAYMENT METHOD</a></li>
             </ul>
            <div id="myTabContent" class="tab-content">
                <div class="tab-pane fade active in" id="overview">
                    <div class="container">                        
                        <center><p class="text-danger">MY THEATERS</p></center><hr>
                        <center><p class="text-danger">MY MOVIES</p></center><hr>
                        <center><p class="text-danger">MY REVIEWS</p></center><hr>                           
                    </div>
                </div>
                <div class="tab-pane fade" id="history">
                     <p>Purchase History</p>
                </div>
                <div class="tab-pane fade" id="settings">                    
                    <form:form action="editUser.htm" modelAttribute="user" method="post">                        
                        <div class="form-group">
                            <p class="text-warning" style="font-size:20px">First Name:</P>
                            <form:input path="firstName"/>
                        </div>
                            
                        <div class="form-group">
                            <p class="text-warning" style="font-size:20px">Last Name:</P>
                            <form:input path="lastName"/>
                        </div>
                        
                        <div class="form-group">
                            <p class="text-warning" style="font-size:20px">Birth Date(dd/mm/yyyy):</P>                            
                            <form:input path="bd"/>
                        </div>
                        
                        <div class="form-group">
                            <p class="text-warning" style="font-size:20px">Zip Code:</P>
                            <form:input path="zipCode"/>
                        </div>                            
                            
                        <br><button type="submit" class="btn btn-success" >Update</button></br>                            
                    </form:form>
                </div>
                <div class="tab-pane fade" id="payment">
                     <p>Payment Methods</p>
                </div>
            </div>
        </div>
    </div>
 </div>
<!--/USER NAV BAR-->

<jsp:include page="footer.jsp" />
<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
  </body>
</html>