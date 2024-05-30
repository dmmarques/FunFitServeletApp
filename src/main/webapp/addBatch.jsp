<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>Create Batch</title>
	</head>
	<body>
		<center>
			<h2>Add Batch Details</h2>
			<form action="BatchController" method="post">
				<label>TypeOfBatch</label>
				<select name="typeofbatch">
					<option value="">Select Batch</option>
					<option value="Morning">Morning</option>
					<option value="Afternoon">Afternoon</option>
					<option value="Evening">Evening</option>
				</select>
				<br/>
				<label>Time</label>
				<select name="time">
				<option value="">Time Slot</option>
				<%
				for(int i=1,j=2;i<=12 && j<13;i++,j++){
					%>
					<option value="<%=i%>-<%=j %>"><%=i%>-<%=j%></option>
					<% 
				}
				%>
				</select>
				<br/>
				<input type="submit" value="Add Batch"/>
				<input type="reset" value="Reset"/>
			</form>
			<br/>
			<a href="index.jsp">Back</a>
		</center>
	</body>
</html>