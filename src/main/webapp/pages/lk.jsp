<%--
  Created by IntelliJ IDEA.
  User: mentor
  Date: 21.10.2023
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    личный кабинет

    <%if(true){%>
        <table style="border: 1px solid black">
            <thead>
                <tr>
                    <th>Логин</th>
                </tr>
            </thead>
            <tbody>
            ${requestScope.users}
            <c:forEach items="${requestScope.users}" var="user">
                    <tr>
                        <td>${requestScope.users}</td>
                    </tr>
            </c:forEach>

            </tbody>
        </table>
        <div>
            <form method="post">
                <input type="hidden" id="session" name="session" value="${requestScope.session}">
                <button>Добавить</button>
            </form>
        </div>
    <%}else{%>

    <%}%>

</body>
</html>
