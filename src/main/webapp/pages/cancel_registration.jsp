<%@ page import="model.Event" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Отмена регистрации на мероприятие</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>

<body bgcolor=DarkSeaGreen>
<div class="comicClass">
    Отмена регистрации на мероприятие<br><br>
    <form action="cancel_registration" method="post">
        Ваш email: <input class="comicField" type="email" name="email"/><br><br>
        Выберите мероприятие:
        <select class="comicField" name="event_id">
            <% List<Event> events = (List<Event>) request.getAttribute("events");
                if (events != null) {
                    for (Event event : events) { %>
            <option value="<%= event.getId_e() %>">
                <%= event.getEvent_name() %> - <%= event.getDate() %>
            </option>
            <% }
            } %>
        </select><br>
        <button class="greenButton" name="buttonType" value="cancelRegistrationButton"> Отменить регистрацию</button>
        <br><br>
        <% if (request.getAttribute("successMessage") != null) { %>
        <div class="successMessage"><%= request.getAttribute("successMessage") %>
        </div>
        <% } %>
        <% if (request.getAttribute("errorMessage") != null) { %>
        <div class="errorMessage"><%= request.getAttribute("errorMessage") %>
        </div>
        <% } %>
        <button class="greenButton" name="buttonType" value="visitorButton"> Вернуться на страницу посетителя</button>
    </form>
</div>
</body>
</html>
