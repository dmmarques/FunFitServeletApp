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
<title>View Students</title>
</head>
<body>
	<center>
		<h2>Student List</h2>
		<table border="1" class="table">
			<tr>
				<th>Student Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
				<th>Phone Number</th>
				<th>Batch Id</th>
				<th colspan=3>Available Operations</th>
			</tr>
			<core:forEach var="student" items="${sessionScope.students}">
				<tr>
					<td><core:out value="${student.getPid()}"></core:out> </td>
					<td><core:out value="${student.getFname()}"></core:out> </td>
					<td><core:out value="${student.getLname()}"></core:out> </td>
					<td><core:out value="${student.getAge()}"></core:out> </td>
					<td><core:out value="${student.getPhonenumber()}"></core:out> </td>
					<td><core:out value="${student.getBid()}"></core:out> </td>
					<th>			            
						<form action="StudentsController" method="post">
			                <input type="hidden" name="action" value="delete"/>
			                <input type="hidden" name="pid" value="${student.getPid()}"/>
			                <input type="submit" value="DELETE" style="color: red"/>
                    	</form>
                    </th>
                    <th>
           				<form action="updateStudents.jsp" method="get">
                        	<input type="hidden" name="pid" value="${student.getPid()}"/>
                        	<input type="submit" value="UPDATE" style="color: green"/>
                    	</form>
                    </th>
				</tr>
		</core:forEach>
		</table>
		<br/>
		<a href="index.jsp">Back</a>
		</body>
	</center>
</body>
</html>