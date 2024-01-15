<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" 
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" 
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
      crossorigin="anonymous">

</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-primary">
          <a class="navbar-brand" href="#">Employee Managment System</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" 
                    data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" 
                    aria-expanded="false" aria-label="Toggle navigation">
               <span class="navbar-toggler-icon"></span>
            </button>

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav mr-auto mb-auto mb-2 mb-lg-0">
             <li class="nav-item ">
                 <a class="nav-link action" aria-current="page" href="home">Home</a>
             </li>
             <li class="nav-item">
                 <a class="nav-link" href="addEmp">Add Emp</a>
             </li>
          </ul>
        </div>
     </nav>
     <div class="conatiner">
         <div class="row">
            <div class="col-md-6 offset-md-3">
               <div class="card">
                 <div class="card-header text-center">
                    <h3>Add Emp</h3>
                    <c:if test="${not empty msg }">
                        <h5 class="text-success">${msg }</h5>
                        <c:remove var="msg "/>
                    </c:if>
                 </div>
                 <div class="card-body">
                    <form action="createEmp" method=post>
                       <div class="md-3">
                          <label>Enter Full Name</label>
                          <input type="text" name="fullName" class="form-control">
                       </div>
                       <div class="md-3">
                          <label>Enter Address1</label><input type="text" 
                                 name="address1" class="form-control">
                       </div>
                       <div class="md-3">
                          <label>Enter Email</label><input type="text" 
                                 name="email" class="form-control">
                       </div>
                       <div class="md-3">
                          <label>Enter Password</label><input type="text" 
                                 name="password" class="form-control">
                       </div>
                       <div class="md-3">
                          <label>Enter Designation</label><input type="text" 
                                 name="designation" class="form-control">
                       </div>
                       <div class="md-3">
                          <label>Enter Salary</label><input type="text" 
                                 name="salary" class="form-control">
                       </div>
                       <button class="btn btn-primary">Submit</button>
                    </form>
                 </div>
               </div>
            </div>
         </div>
     </div>
   
</body>
</html>