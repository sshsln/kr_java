<%@ page import="model.Event" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Редактирование мероприятия</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>

<body bgcolor=DarkSeaGreen>
<div class="comicClass">
    Редактирование мероприятия
    <form action="edit_event" method="post">
        Выберите мероприятие для редактирования:
        <select class="comicField" name="event_id">
            <% List<Event> events = (List<Event>) request.getAttribute("events");
                if (events != null) {
                    for (Event event : events) { %>
            <option value="<%= event.getId_e() %>">
                <%= event.getEvent_name() %> - <%= event.getDate() %> - <%= event.getLocation() %>
            </option>
            <% }
            } %>
        </select><br>
        Новая дата проведения: <input class="comicField" type="datetime-local" name="date" /><br>
        Новое место проведения: <input class="comicField" type="text" name="location" /><br>
        <button class="greenButton" name="buttonType" value="editEventButton"> Подтвердить редактирование </button><br><br>
        <% if (request.getAttribute("successMessage") != null) { %>
        <div class="successMessage"><%= request.getAttribute("successMessage") %></div>
        <% } %>
        <% if (request.getAttribute("errorMessage") != null) { %>
        <div class="errorMessage"><%= request.getAttribute("errorMessage") %></div>
        <% } %>
        <button class="greenButton" name="buttonType" value="organizerButton"> Вернуться на страницу организатора </button>
    </form>
</div>
</body>
</html>
