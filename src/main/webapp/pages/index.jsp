<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Портал для онлайн-регистрации на мероприятия</title>
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
    Портал для онлайн-регистрации на мероприятия<br><br>
    <form action="index" method="post">
        <button class="greenButton" name="buttonType" value="organizer"> Я - организатор</button>
        <br><br>
        <button class="greenButton" name="buttonType" value="visitor"> Я - посетитель</button>
        <br><br>
    </form>
</div>

</body>

</html>
