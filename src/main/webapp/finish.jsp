<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 29.06.2024
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="static org.example.consts.Variables.pageStart" %>
<!DOCTYPE html>
<html>
<head>
    <title>Поражение</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<h1 class="h1"><%=request.getAttribute("question")%></h1>
<br/>
<p class="p">Ваше имя: <%=session.getAttribute("playerName")%></p>
<p class="p">Сыграно игр: <%=session.getAttribute("sessionPlay")%></p>
<p class="p">Побед: <%=session.getAttribute("sessionWins")%></p>
<p class="p">Поражений: <%=session.getAttribute("sessionLoses")%></p>
<br/>
<div class="center">
    <button class="styled"><a href=<%=pageStart%> class="button">Начать игру заново</a></button>
</div>
</body>
</html>
