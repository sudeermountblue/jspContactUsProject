<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of ActiveRequests</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Message</th>
                <th>IsActive</th>
            </tr>
            <c:forEach items="${activeList}"  var="user">
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.name}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.message}" /></td>
                    <td><c:out value="${user.isActive}" /></td>
                    <td><form action="dashboard" method="post">
                         <button type="submit" value="${user.id}" name="id">Submit</button>
                    </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div><br>
    
	<div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of ArchivedRequests</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Message</th>
                <th>IsActive</th>
            </tr>
            <c:forEach var="user" items="${archiveList}">
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.name}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.message}" /></td>
                    <td><c:out value="${user.isActive}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>


</body>
</html>