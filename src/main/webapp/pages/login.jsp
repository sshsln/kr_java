<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<div style="
border: black;
margin-top: 20%;
margin-left: 30%;
">

    <form action="" method="post">
        <div>
            <span>Login</span>
            <input name = "login" id = "login" type="text"/>
            <br>
            <span>Password</span>
            <input name = "password" id = "password" type="text"/>
            <br>
            <br>
            <span>${requestScope.errorText}</span>
            <br>
            <br>
            <input style="color: blue" type="submit">
        </div>
    </form>
</div>
</body>
</html>