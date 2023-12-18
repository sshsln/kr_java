<%@ page import="model.Event" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Предстоящие мероприятия</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <style> table {
        border-collapse: collapse;
    }

    table, th, td {
        border: 1px solid black;
    } </style>
</head>

<body bgcolor=DarkSeaGreen>
<div class="comicClass">
    Предстоящие мероприятия<br><br>
        <% if (request.getAttribute("events") != null) { %>
    <table>
        <thead>
        <tr>
            <th>Название мероприятия</th>
            <th>Дата</th>
            <th>Организатор</th>
            <th>Место проведения</th>
        </tr>
        </thead>
        <tbody>
        <% List<Event> events = (List<Event>) request.getAttribute("events");
            for (Event event : events) { %>
        <tr>
            <td><%= event.getEvent_name() %>
            </td>
            <td><%= event.getDate() %>
            </td>
            <td><%= event.getOrganizerName() %>
            </td>
            <td><%= event.getLocation() %>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
        <% } else { %>
        <% } %>
    <br><span>${requestScope.errorText}</span><br><br>
    <form action="show_vis_events" method="post">
        <button class="greenButton" name="buttonType" value="visitorButton"> Вернуться на страницу посетителя</button>
    </form>
</body>
</html>
