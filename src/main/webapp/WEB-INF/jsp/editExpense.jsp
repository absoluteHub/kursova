<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit record</title>
</head>
<body>
<form action="records" method="post">
    <input type="hidden" name="id" value="${record.id}">
    <input type="hidden" name="command" value="save">
    <input type="hidden" name="type" value="expense">
    Опис: <input type="text" name="description" value="${record.description}"/><br>
    Кількість: <input type="number" name="amount" value="${record.amount}"/><br>
    Сума: <input type="number" name="suma" value="${record.suma}"/><br>
    Дата: <input type="date" name="date" value="${record.date}"/><br>
    Категорія:
    <select name="category">
        <option value="ШОПІНГ" ${record.category == 'ШОПІНГ' ? 'selected' : ''}>Шопінг</option>
        <option value="РОЗВАГИ" ${record.category == 'РОЗВАГИ' ? 'selected' : ''}>Розваги</option>
        <option value="СПОРТ" ${record.category == 'СПОРТ' ? 'selected' : ''}>Спорт</option>
        <option value="ТРАНСПОРТ" ${record.category == 'ТРАНСПОРТ' ? 'selected' : ''}>Транспорт</option>
    </select><br>
    <input type="submit" value="save" style="font-size: 12px; padding: 9px 16px;">
</form>
</body>
</html>