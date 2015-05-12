<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<p class="text-danger">ADD USER</p>
                        <form:form action="adduser.htm" modelAttribute="user" method="post">
        
                            <div class="form-group">
                                <p class="text-warning" style="font-size:20px">First Name:</P>
                                <form:input path="firstName" placeholder="First Name"/>
                            </div>
        
                            <div class="form-group">
                                <p class="text-warning" style="font-size:20px">Last Name:</P>
                                <form:input path="lastName" placeholder="Last Name"/>
                            </div>
        
                            <div class="form-group">
                                <p class="text-warning" style="font-size:20px">E-mail:</P>
                                <form:input path="email" placeholder="E-mail"/>
                            </div>
        
                            <div class="form-group">
                                <p class="text-warning" style="font-size:20px">Password:</P>
                                <form:password path="password" placeholder="Password"/>
                            </div>
                            
                            
                            
                            <div class="form-group">
                                <p class="text-warning" style="font-size:20px">Zipcode:</P>
                                <form:input path="zipCode" placeholder="11790"/>
                            </div>
                            
                            <br><button type="submit" class="btn btn-success" >Add User</button></br>
                        </form:form>
                        
                        <hr><p class="text-danger">ADD MOVIE</p>
                        
                        <form:form action="addmovie.htm" modelAttribute="movie" method="post">
                            
                            <div class="form-group">
                                <p class="text-warning" style="font-size:20px">Title:</P>
                                <form:input path="title" placeholder="Title"/>
                            </div>
                            
                            <div class="form-group">
                                <p class="text-warning" style="font-size:20px">Rating:</P>
                                <form:input path="rating" placeholder="PG"/>
                            </div>
                            
                            <div class="form-group">
                                <p class="text-warning" style="font-size:20px">Synopsis:</P>
                                <form:input path="synopsis" placeholder="ABOUT THE MOVIE"/>
                            </div>
                            
                            <div class="form-group">
                                <p class="text-warning" style="font-size:20px">Poster URL:</P>
                                <form:input path="poster" placeholder="URL"/>
                            </div>
                            
                            <div class="form-group">
                                <p class="text-warning" style="font-size:20px">Weekend Gross:</P>
                                <form:input path="weekendGross" placeholder="10000"/>
                            </div>
                            
                            <div class="form-group">
                                <p class="text-warning" style="font-size:20px">Num of Theaters:</P>
                                <form:input path="numOfTheaters" placeholder="11"/>
                            </div>
                            
                            <div class="form-group">
                                <p class="text-warning" style="font-size:20px">Trailer Code:</P>
                                <form:input path="trailer" placeholder="YOUTUBE"/>
                            </div>
                            
                            <br><button type="submit" class="btn btn-success" >Add Movie</button></br>
                        </form:form>
