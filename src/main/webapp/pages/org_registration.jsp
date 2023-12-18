<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Организатор</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>

<body bgcolor=DarkSeaGreen>
<div class="comicClass">
    Организатор, создайте учётную запись:<br><br>
    <form action="org_registration" method="post">
        <label>Логин:</label><br>
        <input class="comicField" name="login" id="login" type="text"/><br>
        <label>Имя организатора:</label><br>
        <input class="comicField" name="org_name" id="org_name" type="text"/><br>
        <label>Пароль:</label><br>
        <input class="comicField" name="password" id="password" type="password"/><br>
        <span>${requestScope.errorText}</span><br>
        <button class="greenButton" name="buttonType" value="organizerButton">Зарегистрироваться</button>
        <br><br>
        <button class="greenButton" name="buttonType" value="orgOptionsButton">Отменить регистрацию</button>
        <br><br>
    </form>
</div>
</body>

</html>
