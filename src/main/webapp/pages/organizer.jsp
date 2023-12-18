<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Страница организатора</title>
  <link rel="stylesheet" type="text/css" href="styles.css">
</head>

<body bgcolor=DarkSeaGreen>
<div class="comicClass">
  Страница организатора<br><br>
  <form action="organizer" method="post">
    <button class="greenButton" name="buttonType" value="createEventButton"> Создать мероприятие </button><br><br>
    <button class="greenButton" name="buttonType" value="showOrgEventsButton"> Посмотреть данные своих мероприятий </button><br><br>
    <button class="greenButton" name="buttonType" value="editEventButton"> Редактировать данные о мероприятии </button><br><br>
    <button class="greenButton" name="buttonType" value="deleteEventButton"> Отменить мероприятие </button><br><br>
    <button class="greenButton" name="buttonType" value="exitButton"> Выйти </button><br><br>
  </form>
</div>
</body>

</html>
