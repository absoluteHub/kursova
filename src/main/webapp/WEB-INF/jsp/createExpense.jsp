<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create Expense</title>
</head>
<body>
<form action="records" method="post">
    <input type="hidden" name="command" value="create"/>
    <input type="hidden" name="type" value="expense">
    Опис: <input type="text" name="description" value=""/><br>
    Кількість: <input type="number" name="amount" value=""/><br>
    Сума: <input type="number" name="suma" value=""/><br>
    Дата: <input type="date" name="date" value=""/><br>
    Категорія: <select name="category">
    <option value="ШОПІНГ">Шопінг</option>
    <option value="РОЗВАГИ">Розваги</option>
    <option value="СПОРТ">Спорт</option>
    <option value="ТРАНСПОРТ">Транспорт</option>
</select><br>
    <input type="submit" value="save" style="font-size: 12px; padding: 9px 16px;">
</form>
</body>
</html>