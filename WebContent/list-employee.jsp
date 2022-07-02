<%@page import="com.simplilearn.dao.EmployeeDao"%>
<%@page import="com.simplilearn.entity.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
		table, th, td {
			border: 1px solid black;
		}
	</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		List<Employee> employees = EmployeeDao.listEmployeesUsingCriteria();
		request.setAttribute("emplist", employees);
	%>

	

	<table style="width:100%">
		<tr>
			<th>Employee Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Salary</th>
			<th>Department</th>
		</tr>

		<core:forEach items="${emplist}" var="emp">
			<tr>
				<td>${emp.getId()}</td>
				<td>${emp.getFirstName()}</td>
				<td>${emp.getLastName()}</td>
				<td>${emp.getSalary()}</td>
				<td>${emp.getDepartment()}</td>
			</tr>
		</core:forEach>
	</table>
</body>
</html>