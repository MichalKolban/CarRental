<%--
  Created by IntelliJ IDEA.
  User: Michał
  Date: 06.02.2020
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%!

    String makeItLower(String data){
        return data.toLowerCase();
    }
%>

Lower case HELLO WORLD : <%= makeItLower("HELLO WORLD")%>

</body>
</html>
