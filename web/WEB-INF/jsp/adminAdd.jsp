<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<p class="text-danger" style="font-size:55px">ADD USER</p>
                        
                        <c:if test="${uconfirmation eq true}">
                            User successfully added.
                        </c:if>
                        <c:if test="${uconfirmation eq false}">
                            User could not be added, Duplicate Email.
                        </c:if>
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
                        
                        <hr><p class="text-danger" style="font-size:55px">ADD MOVIE</p>
                        
                        <c:if test="${mconfirmation eq true}">
                            Movie successfully added.
                        </c:if>
                        <c:if test="${mconfirmation eq false}">
                            Movie could not be added, Duplicate Title!
                        </c:if>
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
                                <form:input path="numOfTheaters" placeholder="1"/>
                            </div>
                            
                            <div class="form-group">
                                <p class="text-warning" style="font-size:20px">Theater Average:</P>
                                <form:input path="theaterAverage" placeholder="10000"/>
                            </div>
                            
                            <div class="form-group">
                                <p class="text-warning" style="font-size:20px">Trailer Code:</P>
                                <form:input path="trailer" placeholder="YOUTUBE"/>
                            </div>
                            
                            <br><button type="submit" class="btn btn-success" >Add Movie</button></br>
                        </form:form>
