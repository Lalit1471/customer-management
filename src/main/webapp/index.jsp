<% 
if(session.getAttribute("name") == null){
	response.sendRedirect("login.jsp");
}
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Customer List</title>
    <style>
        .container {
            width: 80%;
            margin: 0 auto;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 8px;
            text-align: center;
        }
        th {
            background-color: #f0f0f0;
        }
        .blue-button {
            background-color: blue;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Customer List</h2>
        <a href="createcustomer.jsp">
        <button class="blue-button">Add Customer</button>
        </a>
        <ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/readcustomer"
					class="nav-link">View Customers</a></li>
			</ul>
        <br><br>
        <table>
        <thead>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Street</th>
                <th>Address</th>
                <th>City</th>
                <th>State</th>
                <th>Email</th>
                <th>Phone Number</th>
                <th>Action</th>
            </tr>
         </thead>
         <tbody>
            <c:forEach items="${customers}" var="customer">
                <tr>
                    <td>${customer.getfname()}</td>
                    <td>${customer.getlname()}</td>
                    <td>${customer.getstreet()}</td>
                    <td>${customer.getaddress()}</td>
                    <td>${customer.getcity()}</td>
                    <td>${customer.getstate()}</td>
                    <td>${customer.getemail()}</td>
                    <td>${customer.getphone()}</td>
                    <td>
                    	<a href="updatecustomer.jsp">
                            <img src="images/update-icon.png" alt="Update">
                        </a>
                        <a href="deletecustomer?firstname=<c:out value='${customer.getfname()}'/>">
                            <img src="images/delete-icon.png" alt="Delete">
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>