<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Сортувати за період/категорію</title>
</head>
<body>
<h1>Перегляд за період</h1>
<form action="records" method="get">
    <input type="hidden" name="command" value="viewPeriod"/>
    Період з:<input type="date" name="startDate" value=""/>
    Період до:<input type="date" name="endDate" value=""/>
    <hr>
    Витрати та доходи за період: <input type="submit" value="показати">
</form>
<h1>Перегляд за категорією</h1>
<form action="records" method="get">
    <input type="hidden" name="command" value="viewCategory"/>
    Категорія:<select name="category">
    <option value="ШОПІНГ">Шопінг</option>
    <option value="РОЗВАГИ">Розваги</option>
    <option value="СПОРТ">Спорт</option>
    <option value="ТРАНСПОРТ">Транспорт</option>
    <option value="ЗАРПЛАТА"> Заплата</option>
    <option value="ІНВЕСТИЦІЇ">Інвестиції</option>
    <option value="ПОДАРУНОК">Подарунок</option>
    <option value="НАГОРОДА">Нагорода</option>
</select>
    <hr>
    Витрати та доходи в категорії: <input type="submit" value="показати"/>
</form>
</body>
</html>
