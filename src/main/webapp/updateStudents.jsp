<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
	<head>
	<meta charset="UTF-8">
		<title>Add Student</title>
	</head>
	<body>
		<center>
		<h2>Edit Student</h2>
	    <sql:setDataSource var="dbSource" driver="com.mysql.cj.jdbc.Driver"
	                       url="jdbc:mysql://localhost:3306/funfit"
	                       user="root"  password="123456789"/>
	    <sql:query dataSource="${dbSource}" var="studentData">
	        SELECT * FROM students WHERE pid = ?
	        <sql:param value="${param.pid}"/>
	    </sql:query>
	    <core:forEach var="student" items="${studentData.rows}">
	        <form action="StudentsController" method="post">
	            <input type="hidden" name="action" value="update"/>
	            <input type="hidden" name="pid" value="${student.pid}"/>
	            <table>
	                <tr>
	                    <td>First Name:</td>
	                    <td><input type="text" name="fname" value="${student.fname}"/></td>
	                </tr>
	                <tr>
	                    <td>Last Name:</td>
	                    <td><input type="text" name="lname" value="${student.lname}"/></td>
	                </tr>
	                <tr>
	                    <td>Age:</td>
	                    <td><input type="text" name="age" value="${student.age}"/></td>
	                </tr>
	                <tr>
	                    <td>Phone Number:</td>
	                    <td><input type="text" name="phonenumber" value="${student.phonenumber}"/></td>
	                </tr>
	                <tr>
	                    <td>Batch Id:</td>
	                    <td><input type="text" name="bid" value="${student.bid}"/></td>
	                </tr>
	                <tr>
	                    <td colspan="2"><input type="submit" value="UPDATE"/></td>
	                </tr>
	            </table>
	        </form>
	    </core:forEach>
	    <br/>
	    <a href="viewStudents.jsp">Back to Student List</a>
	    </center>
	</body>
</html>