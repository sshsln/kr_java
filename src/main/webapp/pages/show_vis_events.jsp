<%@ page import="model.Event" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Предстоящие мероприятия</title>
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

        table {
            border-collapse: collapse;
        }

        table, th, td {
            border: 1px solid black;
            font-size: 30px;
            text-align: center;
        }
    </style>
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
    <span>${requestScope.errorText}</span><br>
    <form action="show_vis_events" method="post">
        <button class="greenButton" name="buttonType" value="visitorButton"> Вернуться на страницу посетителя</button>
    </form>
</body>
</html>
