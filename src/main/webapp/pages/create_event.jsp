<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Создание мероприятия</title>
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
    Создание мероприятия<br><br>
    <form action="create_event" method="post">
        Название мероприятия: <input class="comicField" type="text" name="event_name"/><br><br>
        <%
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            calendar.add(java.util.Calendar.HOUR, 1);
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
            String minDatetime = sdf.format(calendar.getTime());
        %>
        Дата проведения: <input class="comicField" type="datetime-local" name="date" min="<%= minDatetime %>"/><br><br>
        Место проведения: <input class="comicField" type="text" name="location"/><br><br>
        <button class="greenButton" name="buttonType" value="createEventButton"> Создать</button>
        <br><br>
        <% if (request.getAttribute("successMessage") != null) { %>
        <div class="successMessage"><%= request.getAttribute("successMessage") %>
        </div>
        <% } %>
        <% if (request.getAttribute("errorMessage") != null) { %>
        <div class="errorMessage"><%= request.getAttribute("errorMessage") %>
        </div>
        <% } %>
        <button class="greenButton" name="buttonType" value="organizerButton"> Вернуться на страницу организатора
        </button>
    </form>
</div>
</body>
</html>
