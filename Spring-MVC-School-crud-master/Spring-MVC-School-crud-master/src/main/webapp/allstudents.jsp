<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <table border="2px solid black">
         <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Edit</th>
            <th>Delete</th>
         </tr>
         <c:forEach var="student" items="${students1}">
         <tr>
            <td>${student.getId()}</td>
            <td>${student.getName()}</td>
            <td>${student.getAge()}</td>
            <td>${student.getEmail()}</td>
            <td>${student.getPhone()}</td>
            <td><a href="editstudents?id=${student.getId()}">edit</a></td>
            <td><a href="deletestudents?id=${student.getId()}">delete</a></td>
         </tr>
         </c:forEach>
    </table>
</body>
</html>