<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   <c:forEach var="order" items="${vo}">
            <tr>
                <td>${order.mno}</td>
                <td>${order.odno}</td>
                <td>${order.orderAddr}</td>
                <td>${order.orderPhone}</td>
                <td>${order.totalPrice}</td>
                <td>${order.orderDate}</td>
                <td>${order.orderStatus}</td>
                <td>${order.bno}</td>
                <td>${order.count}</td>
            </tr>
        </c:forEach>

</body>
</html>