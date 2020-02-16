<%@ page import="Utils.StringUtils" %>


<html>
<head>
    <title>Title</title>
</head>
<body>

<%= StringUtils.makeItLower("FUN FUN FUN") %>

<br/><br/>


<br/><br/>

Request user agent: <%= request.getHeader("User-Agent")%>

<br/><br/>

Request language : <%= request.getLocale() %>

</body>
</html>
