<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Организатор</title>
    <style type="text/css">
        .comicClass {
            font-family: "Comic Sans MS";
            font-size: 30px;
            font-weight: bold;
            text-align: center;
            margin-top: 30px;
            padding: 30px;
        }

        .greenButton {
            position: relative;
            transition-property: background-color, color;
            transition-duration: 0.5s;
            transition-timing-function: ease-out;
            text-align: center;
            background-color: Green;
            color: black;
            font-family: "Comic Sans MS";
            font-size: 30px;
            border: solid 2px black;
            border-radius: 10px;
            box-shadow: 2px 2px 1px black;
            margin-top: 30px;
        }

        .greenButton:hover {
            position: relative;
            transition-property: background-color, color;
            transition-duration: 0.5s;
            transition-timing-function: ease-out;
            background-color: DarkGreen;
            color: black;
            box-shadow: 2px 2px 1px black;
        }
    </style>
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
