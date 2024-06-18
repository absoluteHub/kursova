<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
<h1>Дохід</h1>
<table border="1">
    <thead>
    <tr>
        <th>Категорія</th>
        <th>Сума</th>
        <th>Дата</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="record" items="${incomes}">
        <tr>
            <td><c:out value="${record.category}"/></td>
            <td><c:out value="${record.suma}"/></td>
            <td><c:out value="${record.date}"/></td>
            <td>
                <form action="records" method="get">
                    <input type="hidden" name="command" value="edit">
                    <input type="hidden" name="type" value="income">
                    <input type="hidden" name="id" value="${record.id}">
                    <input type="submit" value="edit">
                </form>
            </td>
            <td>
                <form action="records" method="post">
                    <input type="hidden" name="command" value="delete">
                    <input type="hidden" name="id" value="${record.id}">
                    <input type="submit" value="delete">
                </form>
            </td>
        </tr>

    </c:forEach>
    </tbody>
</table>

<h1>Витрати</h1>
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
    <c:forEach var="record" items="${expenses}">
        <tr>
            <td><c:out value="${record.description}"/></td>
            <td><c:out value="${record.amount}"/></td>
            <td><c:out value="${record.category}"/></td>
            <td><c:out value="${record.suma}"/></td>
            <td><c:out value="${record.date}"/></td>
            <td>
                <form action="records" method="get">
                    <input type="hidden" name="command" value="edit">
                    <input type="hidden" name="type" value="expense">
                    <input type="hidden" name="id" value="${record.id}">
                    <input type="submit" value="edit">
                </form>
            </td>
            <td>
                <form action="records" method="post">
                    <input type="hidden" name="command" value="delete">
                    <input type="hidden" name="id" value="${record.id}">
                    <input type="submit" value="delete">
                </form>
            </td>
        </tr>

    </c:forEach>
    </tbody>
</table>

<hr>
<form action="records" method="get">
    <input type="hidden" name="command" value="createIncome">
    <input type="submit" value="add Income" style="font-size: 12px; padding: 9px 16px;">
</form>
<br>
<form action="records" method="get">
    <input type="hidden" name="command" value="createExpense">
    <input type="submit" value="add Expense" style="font-size: 12px; padding: 9px 16px;">
</form>
<hr>
<a href="records?command=filterRecords">Фільтри записів</a>
</body>
</html>
