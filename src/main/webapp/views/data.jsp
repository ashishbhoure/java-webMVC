<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>View Students </h3>
	
	<a href="/">Add new Student</a>
	<table border="1">
		
		<thead>
			<tr>
				<th>S.No</th>
				<th>Name</th>
				<th>Email</th>
				<th>Gender</th>
				<th>Course</th>
				<th>Timing</th>
			</tr>
			
		</thead>
		
		<tbody>
			<c:forEach items="${students}" var="student" varStatus="index">
				<tr>
					<td>${index.count}</td>
					<td>${student.name}</td>
					<td>${student.email}</td>
					<td>${student.gender}</td>
					<td>${student.course}</td>
					<td>${student.timings}</td>
					
				</tr>
				
			</c:forEach>
		</tbody>
	
	</table>
</body>
</html>