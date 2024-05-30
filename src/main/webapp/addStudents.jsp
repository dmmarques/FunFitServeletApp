<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<html>
	<head>
	<meta charset="UTF-8">
		<title>Add Student</title>
	</head>
	<body>
		<center>
		<h2>Add Student</h2>
		<form action="StudentsController" method="post">
			<label>First name</label>
			<input type="text" name="fname"><br/>
			<label>Last name</label>
			<input type="text" name="lname"><br/>
			<label>Age</label>
			<input type="number" name="age"><br/>
			<label>Phone Number</label>
			<input type="text" name="phonenumber"><br/>
			
			<label>Batch</label>
			<select name="bid">
				<core:forEach var="bid" items="${sessionScope.batches}">
					<option value="<core:out value="${bid.getBid()}"></core:out>"> <core:out value="${bid.getTypeofbatch()}"></core:out> 
					- 
					<core:out value="${bid.getTime()}"></core:out></option>
				</core:forEach>
			</select>
			<br/>
			<input type="submit" value="Add Student"/>
			<input type="reset" value="Reset"/>
		</form>
		<br/>
		<a href="index.jsp">Back</a>
		</center>
	</body>
</html>