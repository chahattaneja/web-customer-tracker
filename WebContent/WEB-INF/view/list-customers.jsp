<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	
	<title>Customers List</title>
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css"
	/>
</head>
<body>
	<div id ="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>		
		</div>
	</div>
	<br>
	<input type="button" value="Add Customer"
		onclick="window.location.href='showFormForAdd';return false;"
		class="add-button">
	<br>
	<form:form action="search" method="GET">
	Search Customer:<input type="text" name="theSearchName"/>
	<input type="submit" value="Search" class="add-button">
	</form:form>
	<div id ="conatiner">
		<div id="content">
			<table>
				<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Action</th>
				<c:forEach var="tempCustomer" items="${customers}">
				
				<c:url var="updateLink" value="/customer/showFormForUpdate">
					<c:param name="customerId" value="${tempCustomer.id}"></c:param>
				</c:url>
				
				<c:url var="deleteLink" value="/customer/delete">
					<c:param name="customerId" value="${tempCustomer.id}"></c:param>
				</c:url>
				
					<tr>
						<td>${ tempCustomer.firstName } </td>
						<td>${ tempCustomer.lastName } </td>
						<td>${ tempCustomer.email } </td>
						<td>
							<a href="${ updateLink }">Update</a> 
							| 
							<a href="${ deleteLink }" 
							onclick="if(!(confirm('Are you Sure?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>

</html>