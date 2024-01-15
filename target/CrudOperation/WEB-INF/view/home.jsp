<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@page isELIgnored="false" %>     
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
             <li class="nav-item">
                 <a class="nav-link" href="register">Register</a>
             </li>
             <li class="nav-item">
                 <a class="nav-link" href="login">Login</a>
             </li>
      
          </ul>
        </div>
     </nav>
     
     <div class="container">
        <div class="row">
           <div class="col-md-12">
             <div class="card"> 
                <div class="card-header text-center">
                     <h4>All Employee Details</h4>
                     <c:if test="${not empty msg }">
                        <h5 calss="text-success">${msg }</h5>
                        <c:remove var="msg "/>
                    </c:if>
                 </div>
                   <div class="card-bady">
                       <table class="table">
                          <thead>
                              <tr>
                                  <th scope="col">Id</th>
                                  <th scope="col">Full Name</th>
                                  <th scope="col">Address1</th>
                                  <th scope="col">Email</th>
                                  <th scope="col">Password</th>
                                  <th scope="col">Designation</th>
                                  <th scope="col">Salary</th>
                                  <th scope="col">Action</th>
                             </tr>
                          </thead>
                          <tbody>
                          <c:forEach items="${employeelist }" var="employee">                          
                             <tr>
                                 <th scope="row">${employee.id }</th>
                                 <td>${employee.fullName }</td>
                                 <td>${employee.address1 }</td>
                                 <td>${employee.email }</td>
                                 <td>${employee.password}</td>
                                 <td>${employee.designation }</td>
                                 <td>${employee.salary }</td>
                                 <td><a href="editEmp/${employee.id}" class="btn btn-sm btn-primary">Edit</a>
                                     <a href="deleteEmp/${employee.id}" class="btn btn-sm btn-danger">Delete</a>
                                 </td>
                            </tr>
                           </c:forEach>
                        </tbody>
                      </table>
                   </div>
                </div>
             </div>
           </div>
        </div>
</body>
</html>