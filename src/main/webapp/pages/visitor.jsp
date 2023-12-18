<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Страница посетителя</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>

<body bgcolor=DarkSeaGreen>
<div class="comicClass">
    Страница посетителя<br><br>
    <form action="visitor" method="post">
    <button class="greenButton" name="buttonType" value="showVisEventsButton"> Просмотреть список предстоящих мероприятий </button><br><br>
    <button class="greenButton" name="buttonType" value="registrationButton"> Зарегистрироваться на мероприятие </button><br><br>
    <button class="greenButton" name="buttonType" value="cancelRegistrationButton"> Отменить регистрацию </button><br><br>
    <button class="greenButton" name="buttonType" value="exitButton"> Выйти </button><br><br>
    </form>
</div>
</body>

</html>
