<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create Income</title>
</head>
<body>
<form action="records" method="post">
    <input type="hidden" name="command" value="create"/>
    <input type="hidden" name="type" value="income">
    Сума: <input type="number" name="suma" value=""/><br>
    Дата: <input type="date" name="date" value=""/><br>
    Категорія: <select name="category">
    <option value="ЗАРПЛАТА"> Заплата</option>
    <option value="ІНВЕСТИЦІЇ">Інвестиції</option>
    <option value="ПОДАРУНОК">Подарунок</option>
    <option value="НАГОРОДА">Нагорода</option>
</select><br>
    <input type="submit" value="save" style="font-size: 12px; padding: 9px 16px;">
</form>
</body>
</html>