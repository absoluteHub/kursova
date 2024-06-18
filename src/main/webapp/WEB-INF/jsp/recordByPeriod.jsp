<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Перегляд за період</title>
</head>
<body>
<h2>Витрати за період</h2>
<table border="1">
    <thead>
    <tr>
        <th>Опис</th>
        <th>Кількість</th>
        <th>Категорія</th>
        <th>Сума</th>
        <th>Дата</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="expense" items="${expensesDate}">
        <tr>
            <td><c:out value="${expense.date}"/></td>
            <td><c:out value="${expense.description}"/></td>
            <td><c:out value="${expense.amount}"/></td>
            <td><c:out value="${expense.category}"/></td>
            <td><c:out value="${expense.suma}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<h2>Дохід за період</h2>
<table border="1">
    <thead>
    <tr>
        <th>Категорія</th>
        <th>Сума</th>
        <th>Дата</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="income" items="${incomesDate}">
        <tr>
            <td><c:out value="${income.date}"/></td>
            <td><c:out value="${income.suma}"/></td>
            <td><c:out value="${income.category}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
