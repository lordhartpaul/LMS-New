<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="/css/bootstrap.css"      rel="stylesheet">
	<link href="/css/custom.css"      rel="stylesheet">
	<link href="/css/main.css"      rel="stylesheet">
</head>
<body>
<h1 align="center">Leave Management System</h1>
<table id="t02"  cellpadding="2">
<tr>
<th>
<a  href="/apply"><h2>Home Page:Apply New Leave</h2></a>

</th>

<th>

<a  align ="right" href="/delete"><h2>Delete All Leaves</h2></a>
</th>
</tr>
</table>
<table >
<tr>


  <th>Page No : 
<c:forEach var="count" items="${pageCount}"  varStatus="theCount"> 
<a align="right" href="/viewlmss/${theCount.count}">${theCount.count}</a>   
</c:forEach>  
</th>

</tr>

</table>
   
<form:form  class="form-horizontal" >
<table id="t01" border="2" width="70%" cellpadding="2">
<tr><th>Id</th><th>Employee Id</th><th>Employee Name</th>
<th>Leave Type</th><th>From Date</th><th>To Date</th>
<th>Number of Days</th><th>Manager</th><th>Reason</th>
<th>Contact</th><th>Email</th><th>CC To</th>
<th>Edit</th><th>Delete</th></tr>  

   <c:forEach var="lms" items="${list}"> 
   <tr>  
   <td>${lms.id}</td>  
   <td>${lms.empId}</td> 
   <td>${lms.empName}</td>   
   <td>${lms.leaveType}</td> 
   <td>${lms.fromDate}</td> 
   <td>${lms.toDate}</td>    
   <td>${lms.numberofDays}</td> 
   <td>${lms.manager}</td> 
   <td>${lms.reason}</td> 
   <td>${lms.contact}</td> 
   <td>${lms.email}</td> 
   <td>${lms.ccTo}</td>      
  <td><a href="/editlms/${lms.id}">Edit</a></td>  
   <td><a href="/deletelms/${lms.id}">Delete</a></td>  
   </tr>  
   </c:forEach> 
   
   
   </table>  
   <br/>
   
  
   </form:form>
</body>
</html>