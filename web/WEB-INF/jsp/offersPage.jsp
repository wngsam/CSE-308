<%-- 
    Document   : offersPage
    Created on : Apr 11, 2015, 2:21:37 PM
    Author     : Desktop
--%>
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



<!-- OFFERS MAIN BODY -->
<center><h1><p class="text-success" style="font-size:55px">OFFERS</p></h1><hr>
<div class="row">
    <c:forEach var="listVar" items="${offers}">     

			<div class="col-xs-6 col-lg-3">
			  <img src="assets\img\offer1.jpg" width="275" height="275"><br></br>
                          <center><p><c:out value="${listVar.name}"/></p></center>
              <center><p><c:out value="${listVar.content}"/></p></center>
              <center><p><button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal4">View details &raquo;</button></p></center>
            </div><!--/.col-xs-6.col-lg-4-->
			
        </c:forEach>			
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

<!-- /OFFERS MAIN BODY -->








<!-- GIFT CARDS MAIN BODY -->
<center><h1><p class="text-success" style="font-size:55px">GIFT CARDS</p></h1><hr>
<div class="row">
			<div class="col-xs-6 col-lg-3">
			  <img src="assets\img\sam1.jpg" width="275" height="275"><br></br>
              <center><p>$25 SamDango gift card!</p></center>
              <center><p><button type="button" class="btn btn-default" >Purchase card! &raquo;</button></p></center>
            </div><!--/.col-xs-6.col-lg-4-->
			
			<div class="col-xs-6 col-lg-3">
			  <img src="assets\img\sam2.jpg" width="275" height="275"><br></br>
              <p>$50 SamDango gift card!</p>
              <center><p><button type="button" class="btn btn-default" >Purchase card! &raquo;</button></p></center>
            </div><!--/.col-xs-6.col-lg-4-->
			
			<div class="col-xs-6 col-lg-3">
			  <img src="assets\img\sam3.jpg" width="275" height="275"><br></br>
				<center><p>$75 SamDango gift card!</p></center>
              <center><p><button type="button" class="btn btn-default" >Purchase card! &raquo;</button></p></center>
            </div><!--/.col-xs-6.col-lg-4-->
			
			<div class="col-xs-6 col-lg-3">
			  <img src="assets\img\sam4.jpg" width="275" height="275"><br></br>
              <center> <p>$100 SamDango gift card!</p></center>
              <center><p><button type="button" class="btn btn-default" >Purchase card! &raquo;</button></p></center>
            </div><!--/.col-xs-6.col-lg-4-->
	  </div></center>

<!-- INFO POPUP MODALS GIFT CARDS-->
<div class="modal fade" id="myModal8" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">$25 SamDango gift card</h4>
      </div>
      <div class="modal-body">
      <!-- REGISTER BODY -->
        <div class="row row-offcanvas">
        <form class="form-horizontal">
          <fieldset>

            <legend><center><h1><p class="text-info" style="font-size:55px">Purchase</p></h1></center></legend>

                <div class="form-group">
              <center>
                <button type="submit" class="btn btn-success">Click here to purchase!</button>
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

<div class="modal fade" id="myModal9" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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

            <legend><center><h1><p class="text-info" style="font-size:55px">Purchase</p></h1></center></legend>

                <div class="form-group">
              <center>
                <button type="submit" class="btn btn-success">Click here to purchase!</button>
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

<div class="modal fade" id="myModal10" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Purchase 2 or more tickets and get the next ticket 50% off!</h4>
      </div>
      <!-- REGISTER BODY -->
        <div class="row row-offcanvas">
        <form class="form-horizontal">
          <fieldset>

            <legend><center><h1><p class="text-info" style="font-size:55px">Purchase</p></h1></center></legend>

                <div class="form-group">
              <center>
                <button type="submit" class="btn btn-success">Click here to purchase!</button>
              </center>
            </div>

          </fieldset>
        </form>
        </div>
        <!-- /REGISTER BODY -->
              <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="myModal11" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Free Large Soda!</h4>
      </div>
      <!-- REGISTER BODY -->
        <div class="row row-offcanvas">
        <form class="form-horizontal">
          <fieldset>

            <legend><center><h1><p class="text-info" style="font-size:55px">Purchase</p></h1></center></legend>

                <div class="form-group">
              <center>
                <button type="submit" class="btn btn-success">Click here to purchase!</button>
              </center>
            </div>

          </fieldset>
        </form>
        </div>
        <!-- /REGISTER BODY -->
              <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<!-- /GIFTCARDS MAIN BODY -->





<jsp:include page="footer.jsp" />
<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
  </body>
</html>
