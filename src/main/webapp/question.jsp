<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 29.06.2024
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
<head>
    <title>Question</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h1 class="h1"><%=request.getAttribute("question")%></h1>
    <br> <br> <br>
    <div class="center">
        <button class="styled" formmethod="get" onclick="location.href='/question?answer=<%=request.getAttribute("nextAnswer1")%>'">
            <%=request.getAttribute("answer1")%>
        </button>
        <button class="styled" formmethod="get" onclick="location.href='/question?answer=<%=request.getAttribute("nextAnswer2")%>'">
            <%=request.getAttribute("answer2")%>
        </button>
    </div>

</body>
</html>
