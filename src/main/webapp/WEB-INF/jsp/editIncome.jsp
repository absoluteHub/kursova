<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Income</title>
</head>
<body>
<form action="records" method="post">
    <input type="hidden" name="id" value="${record.id}">
    <input type="hidden" name="command" value="save">
    <input type="hidden" name="type" value="income  ">
    Сума: <input type="number" name="suma" value="${record.suma}"/><br>
    Дата: <input type="date" name="date" value="${record.date}"/><br>
    Категорія:
    <select name="category">
        <option value="ЗАРПЛАТА" ${record.category == 'ЗАРПЛАТА' ? 'selected' : ''}>Зарплата</option>
        <option value="ІНВЕСТИЦІЇ" ${record.category == 'ІНВЕСТИЦІЇ' ? 'selected' : ''}>Інвестиції</option>
        <option value="ПОДАРУНОК" ${record.category == 'ПОДАРУНОК' ? 'selected' : ''}>Подарунок</option>
        <option value="НАГОРОДА" ${record.category == 'НАГОРОДА' ? 'selected' : ''}>Нагорода</option>
    </select><br>

    <input type="submit" value="save" style="font-size: 12px; padding: 9px 16px;">
</form>
</body>
</html>