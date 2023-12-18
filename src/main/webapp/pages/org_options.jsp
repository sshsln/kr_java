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
    Выберите действие:<br><br>
    <form action="org_options" method="post">
        <button class="greenButton" name="buttonType" value="loginButton">Авторизоваться</button>
        <br><br>
        <button class="greenButton" name="buttonType" value="registerButton">Зарегистрироваться</button>
        <br><br>
        <button class="greenButton" name="buttonType" value="exitButton">Вернуться на главную страницу</button>
        <br><br>
    </form>
</div>
</body>

</html>
