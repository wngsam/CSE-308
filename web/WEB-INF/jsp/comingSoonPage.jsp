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


<!--MAINBODY-->
<div class="container">
			<hr>
		<!-- 2nd half -->
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
            <td>
                <c:forEach items="${comingSoonMovies}" varStatus="status" var="listVar" >     
			<div class="col-xs-6 col-lg-3">
                            <c:url value='/viewMovieInfo/${listVar.title}.htm' /><br>
                            ${listVar.title}<br>
                            <center><p><a href="viewMovieInfo/${listVar.title}.htm">
                                    <img src="${listVar.poster}" width="145" height="220"></a><br>
                            <fmt:formatDate type="Date" dateStyle="Long" value="${listVar.releaseDate.time}"></fmt:formatDate></center>
                        </div>
                </c:forEach>
        </td>
    </tr>			
      
    </table>
	  
    </div>
</center>


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
<br><br><br><br>

<!--/MAINBODY--><hr>



<!-- COUPONS -->
<center><a href="offerspage.htm"><p class="text-success" style="font-size:55px">OFFERS</p></a><hr>
<div class="row">
			<div class="col-xs-6 col-lg-3">
			  <img src="assets\img\offer1.jpg" width="275" height="275"><br></br>
              <center><p>Sign Up for our Daily Newsletter for the latest movie news and great deals!</p></center>
              <center><p><button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal4">View details &raquo;</button></p></center>
            </div><!--/.col-xs-6.col-lg-4-->
			
			<div class="col-xs-6 col-lg-3">
			  <img src="assets\img\offer2.jpg" width="275" height="275"><br></br>
              <center><p>Enter Today for a chance to win a trip to Australia!</p><p><h6> Offer ends Jan 20, 2016. </h6></p></center>
              <center><p><button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal5">View details &raquo;</button></p></center>
            </div><!--/.col-xs-6.col-lg-4-->
			
			<div class="col-xs-6 col-lg-3">
			  <img src="assets\img\offer3.jpg" width="275" height="275"><br></br>
				<center><p>Family Deal! Purchase 2 or more tickets and get the next ticket 50% off!</p></center>
              <center><p><button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal6">View details &raquo;</button></p></center>
            </div><!--/.col-xs-6.col-lg-4-->
			
			<div class="col-xs-6 col-lg-3">
			  <img src="assets\img\offer4.jpg" width="275" height="275"><br></br>
              <center> <p>Go to any theater in Stony Brook and mention us to get a free large soda!</p></center>
              <center><p><button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal7">View details &raquo;</button></p></center>
            </div><!--/.col-xs-6.col-lg-4-->
	  </div></center>
<!-- INFO POPUP MODALS -->
<div class="modal fade" id="myModal4" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Daily Newsletter</h4>
      </div>
      <div class="modal-body">
      <!-- REGISTER BODY -->
        <div class="row row-offcanvas">
        <form class="form-horizontal">
          <fieldset>

            <legend><center><h1><p class="text-info" style="font-size:55px">Registration</p></h1></center></legend>

            <div class="form-group">
              <label for="inputEmail" class="col-lg-4 control-label">Email</label>
              <div class="col-xs-6 col-lg-4">
                <input type="text" class="form-control" id="inputEmail" placeholder="Email">
              </div>
            </div>

                <div class="form-group">
              <label for="inputName" class="col-lg-4 control-label">Name</label>
              <div class="col-xs-6 col-lg-4">
                <input type="text" class="form-control" id="inputName" placeholder="Name">
              </div>
            </div>


                <div class="form-group">
              <center>
                <button type="submit" class="btn btn-success">SIGN UP</button>
              </center>
            </div>

          </fieldset>
        </form>
        </div>
        <!-- /REGISTER BODY -->
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="myModal5" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Win a Trip to Australia!</h4>
      </div>
      <div class="modal-body">
          
        <!-- REGISTER BODY -->
        <div class="row row-offcanvas">
        <form class="form-horizontal">
          <fieldset>

            <legend><center><h1><p class="text-info" style="font-size:55px">Registration</p></h1></center></legend>

            <div class="form-group">
              <label for="inputEmail" class="col-lg-4 control-label">Email</label>
              <div class="col-xs-6 col-lg-4">
                <input type="text" class="form-control" id="inputEmail" placeholder="Email">
              </div>
            </div>

                <div class="form-group">
              <label for="inputName" class="col-lg-4 control-label">Name</label>
              <div class="col-xs-6 col-lg-4">
                <input type="text" class="form-control" id="inputName" placeholder="Name">
              </div>
            </div>


                <div class="form-group">
              <center>
                <button type="submit" class="btn btn-success">JOIN NOW!</button>
              </center>
            </div>

          </fieldset>
        </form>
        </div>
        <!-- /REGISTER BODY -->
          
        </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="myModal6" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Purchase 2 or more tickets and get the next ticket 50% off!</h4>
      </div>
      <div class="modal-body">
          <p>Offer valid only between 8AM to 10PM. Tickets must be purchased at full pricing. </p>
        </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="myModal7" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Free Large Soda!</h4>
      </div>
      <div class="modal-body">
          <p>Sign in to the theatre on your smartphone through Yelp and show it to the cashier to receive a free large soda!</p>
        </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
<!-- /COUPONS -->


<jsp:include page="footer.jsp" />
<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
  </body>
</html>
