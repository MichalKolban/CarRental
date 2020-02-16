<%--
  Created by IntelliJ IDEA.
  User: Michał
  Date: 06.02.2020
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

Convertin string to upper : <%=  new String("Siemanko").toUpperCase() %>

<br/><br/>

25 multiply by 10 equals = <%= 25*10 %>


<br/><br/>

<%= 75 < 9%>


<br/><br/>

<%

    for(int i=1; i <= 5; i++){
        out.println("Hello michal")
    }

%>

</body>
</html>
