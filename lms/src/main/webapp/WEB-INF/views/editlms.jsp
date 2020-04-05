<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="/css/bootstrap.css"      rel="stylesheet">
	<link href="/css/custom.css"      rel="stylesheet">
	<link href="/css/main.css"      rel="stylesheet">
</head>

<body>

 	<div class="form-container">
 	
 	<h1>Edit Leave Details</h1>
 	
	<form:form method="POST" modelAttribute="lms" commandName="lms" class="form-horizontal" action="/editsave">

<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="empId">Employee ID</label>
				<div class="col-md-7">
					<form:hidden path="id"  class="form-control input-sm"/>
					<div class="has-error">
						
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="empId">Employee ID</label>
				<div class="col-md-7">
					<form:input type="text" path="empId" id="empId" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="empId" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="empName">Employee Name</label>
				<div class="col-md-7">
					<form:input type="text" path="empName" id="empName" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="empName" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="leaveTypes">Leave Type</label>
				<div class="col-md-7">
					<form:select path="leaveType" items="${leaveType}" multiple="true" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="leaveType" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="fromDate">From Date</label>
				<div class="col-md-7">
					<form:input type="text" path="fromDate" id="fromDate" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="fromDate" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="toDate">To Date</label>
				<div class="col-md-7">
					<form:input type="text" path="toDate" id="toDate" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="toDate" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="numberofDays">Number of Days</label>
				<div class="col-md-7">
					<form:input type="text" path="numberofDays" id="numberofDays" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="numberofDays" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="manager">Manager</label>
				<div class="col-md-7">
					<form:select path="manager" items="${manager}" multiple="true" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="manager" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="reason">Reason</label>
				<div class="col-md-7">
					<form:input type="text" path="reason" id="reason" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="reason" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="contact">Contact</label>
				<div class="col-md-7">
					<form:input type="text" path="contact" id="contact" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="contact" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="email">Email</label>
				<div class="col-md-7">
					<form:input type="text" path="email" id="email" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="email" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>


		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="ccTo">CC To</label>
				<div class="col-md-7">
					<form:select path="ccTo" items="${ccTo}" multiple="true" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="ccTo" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-actions floatRight">
				<input type="submit" value="Edit" class="btn btn-primary btn-sm">
			</div>
		</div>
	</form:form>
	</div>
</body>
</html>