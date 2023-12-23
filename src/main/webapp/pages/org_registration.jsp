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

        .comicField {
            font-family: "Comic Sans MS";
            font-size: 30px;
            border: solid 2px black;
            border-radius: 10px;
            box-shadow: 2px 2px 1px black;
            margin-top: 30px;
        }
    </style>
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
