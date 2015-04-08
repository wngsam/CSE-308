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
    <link href="assets/css/bootstrap.css" rel="stylesheet" media="screen">
  </head>
<!-- /HEADER -->
  
<body role="document">
<jsp:include page="header.jsp" /><hr>



<!-- REGISTER BODY -->
<div class="row row-offcanvas">
<form class="form-horizontal">
  <fieldset>
  
    <legend><center><p class="text-primary" style="font-size:55px">Registration</p>
	<p class="text-default" style="font-size:20px">JOIN SAMDANGO FOR FREE!</p>
	</center></legend>
	
    <div class="form-group">
      <label for="inputEmail" class="col-lg-4 control-label">Email</label>
      <div class="col-xs-4 col-lg-4">
        <input type="text" class="form-control" id="inputEmail" placeholder="Email">
      </div>
    </div>
	
	<div class="form-group">
      <label for="inputName" class="col-lg-4 control-label">Name</label>
      <div class="col-xs-4 col-lg-4">
        <input type="text" class="form-control" id="inputName" placeholder="Name">
      </div>
    </div>
	
    <div class="form-group">
      <label for="inputPassword" class="col-lg-4 control-label">Password</label>
      <div class="col-xs-4 col-lg-4">
        <input type="password" class="form-control" id="inputPassword" placeholder="Password">
      </div>
    </div>
	
	<div class="form-group">
      <label for="confirmPassword" class="col-lg-4 control-label">Confirm<br>Password</label>
      <div class="col-xs-4 col-lg-4">
        <input type="password" class="form-control" id="confirmPassword" placeholder="Confirm Password">
      </div>
    </div>
	
    <div class="form-group">
       <center><p><button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal3">JOIN AGAIN! &raquo;</button></p></center>
       <center><p><button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal4">JOIN NOW! &raquo;</button></p></center>
    </div>
	
  </fieldset>
</form>
</div>
<!-- /REGISTER BODY -->

<!-- INFO POPUP MODALS -->
<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        
        <h4 class="modal-title" id="myModalLabel">Registration</h4>
      </div>
      <div class="modal-body">
      <!-- REGISTER BODY -->
        <div class="row row-offcanvas">
        <form class="form-horizontal">
          <fieldset>

            <legend><center><h1><p class="text-danger" style="font-size:55px">Invalid Email!</p></h1></center></legend>

          </fieldset>
        </form>
        </div>
        <!-- /REGISTER BODY -->
        
      </div>
      <div class="modal-footer">
          <a href="registrationpage.htm" button type="button" class="btn btn-danger">Register Again</button></a>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="myModal4" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        
        <h4 class="modal-title" id="myModalLabel">Registration</h4>
      </div>
      <div class="modal-body">
      <!-- REGISTER BODY -->
        <div class="row row-offcanvas">
        <form class="form-horizontal">
          <fieldset>

            <legend><center><h1><p class="text-success" style="font-size:55px">SUCCESS!</p></h1></center></legend>

          </fieldset>
        </form>
        </div>
        <!-- /REGISTER BODY -->
        
      </div>
      <div class="modal-footer">
          <a href="userpage.htm" button type="button" class="btn btn-danger">Proceed to Profile</button></a>
      </div>
    </div>
  </div>
</div>

<!-- /MODALS -->


<!-- PICS -->
<br><center>
<a class ="highlight_footerIcon">
	<img src="assets\img\reg1.png">
</a>
<a class ="highlight_footerIcon">
	&nbsp&nbsp&nbsp&nbsp
	<img src="assets\img\reg2.png">
</a>
<a class ="highlight_footerIcon">
	&nbsp&nbsp&nbsp&nbsp
	<img src="assets\img\reg3.png">
</a>
<a class ="highlight_footerIcon">
	&nbsp&nbsp&nbsp&nbsp
	<img src="assets\img\reg4.png">
</a>
	<br></br>
	<br><img src="assets\img\reg5.png"></br>
</center></br>
<!-- /PICS -->



<jsp:include page="footer.jsp" />
<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
  </body>
</html>