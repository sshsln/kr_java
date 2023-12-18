<%@ page import="model.Event" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Мои мероприятия</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>

<body bgcolor=DarkSeaGreen>
<div class="comicClass">
    Мои мероприятия

    <table style="border: 1px solid black">
        <thead>
        <tr>
            <th>Название мероприятия</th>
            <th>Дата</th>
            <th>Место проведения</th>
            <th>Зарегистрировалось</th>
        </tr>
        </thead>
        <tbody>
        <% if (request.getAttribute("events") != null) { %>
        <% List<Event> events = (List<Event>) request.getAttribute("events");
            for (Event event : events) { %>
        <tr>
            <td><%= event.getEvent_name() %></td>
            <td><%= event.getDate() %></td>
            <td><%= event.getLocation() %></td>
            <td><%= event.getVis_count() %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <br>
    <form action="show_org_events" method="post">
        <button class="greenButton" name="buttonType" value="organizerButton"> Вернуться на страницу организатора </button>
    </form>
        <% } else { %>
        <% } %>

</body>

</html>
