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
    Организатор, введите логин и пароль:<br><br>
    <form action="org_login" method="post">
        <label>Логин:</label><br>
        <input class="comicField" name="login" id="login" type="text" /><br>
        <label>Пароль:</label><br>
        <input class="comicField" name="password" id="password" type="password" /><br>
        <span>${requestScope.errorText}</span><br><br>
        <button class="greenButton" name="buttonType" value="organizerButton"> Войти </button><br><br>
    <button class="greenButton" name="buttonType" value="orgOptionsButton"> Отменить вход </button><br><br>
    </form>
</div>
</body>

</html>
