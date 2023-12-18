<%--
  Created by IntelliJ IDEA.
  User: mentor
  Date: 28.10.2023
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    Добавление пользователя

    <div>
        <form method="post">
            <input type="hidden" value="${requestScope.session}"/>
            <label for="fio">фио</label>
            <input id="fio" name="fio" type="text">
            <br>
            <label for="login">логин</label>
            <input id="login" name="login" type="text">
            <br>
            <label for="password">пароль</label>
            <input id="password" name="password" type="text">

            <button>Сохранить</button>
        </form>
    </div>
</body>
</html>
