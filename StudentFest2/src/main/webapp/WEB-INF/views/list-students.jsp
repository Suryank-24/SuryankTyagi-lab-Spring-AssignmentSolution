<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8" autocomplete="off">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Students Fest</title>
</head>
<body>

	<div class="container">

		<h3>Students Directory</h3>
		<hr>

		<!-- Add a search form -->
			<form action="/studentFest/students/search" class="form-inline" autocomplete = "off">
				<!-- Add a button -->
		<a href="/studentFest/students/showFormForAdd" class="btn btn-primary btn-sm mb-3"> Add Student </a>
		 <input type="search" name="name" placeholder="Name" class="form-control-sm ml-5 mr-2 mb-3"/>
		  <input type="search" name="department" placeholder="Department" class="form-control-sm mr-2 mb-3" />
		<button type="submit" class="btn btn-success btn-sm mb-3">Search</button>
		<a href="/studentFest/logout" class="btn btn-warning btn-sm mb-3 mx-auto"> Logout </a> 
			</form>
			<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Name</th>
					<th>Department</th>
					<th>Country</th>
					<th>Action</th>
				</tr>
			</thead>
					<tbody>
				<c:forEach items="${Students}" var="student">
					<tr>
						<td><c:out value="${student.name}" /></td>
						<td><c:out value="${student.department}" /></td>
						<td><c:out value="${student.country}" /></td>
						<td>
							<!-- Add "update" button/link --> 
			<a href="/studentFest/students/showFormForUpdate?studentId=${student.id}" class="btn btn-info btn-sm"> Update </a>				
				 <!-- Add "delete" button/link -->
		<a href="/studentFest/students/delete?studentId=${student.id}" class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this employee?'))) return false">Delete </a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>