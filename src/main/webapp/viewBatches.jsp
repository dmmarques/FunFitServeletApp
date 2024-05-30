<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<style>
	td {text-align:center}
</style>
<head>
<meta charset="UTF-8">
<title>View Batches</title>
</head>
<body>
	<center>
		<h2>Batch List</h2>
		<table border="1" class="table">
			<tr>
				<th>Batch Id</th>
				<th>Type Of Batch</th>
				<th>Time</th>
				<th>Available Operations</th>
			</tr>
			<core:forEach var="batch" items="${sessionScope.batches}">
				<tr>
					<td><core:out value="${batch.getBid()}"></core:out> </td>
					<td><core:out value="${batch.getTypeofbatch()}"></core:out> </td>
					<td><core:out value="${batch.getTime()}"></core:out> </td>
					<td>
			            <form action="BatchController" method="post">
			                <input type="hidden" name="action" value="delete"/>
			                <input type="hidden" name="bid" value="${batch.getBid()}"/>
			                <input type="submit" value="DELETE" style="color: red"/>
			            </form>
					</td>
				</tr>
			</core:forEach>
		</table>
		<br/>
		<a href="index.jsp">Back</a>
	</center>
</body>
</html>