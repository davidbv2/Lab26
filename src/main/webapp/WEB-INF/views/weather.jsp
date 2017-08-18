<%--
  Created by IntelliJ IDEA.
  User: Grand Circus Student
  Date: 8/17/2017
  Time: 11:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Weather Forecast</title>
</head>
<body>

<%--Request Status: ${status}<br>--%>
<%--Production Center: ${prodCenter}<br>--%>

<%--<c:forEach begin="0" end="${arrayday.length()-1}" var="time">--%>
<%--${arrayday.getJSONObject(time).getString("startPeriodName")}--%>
<%--</c:forEach>--%>

<c:forEach var="time" items="${infoarray}">

        <ul>
            <li>${time.day} : ${time.temp} </li>
        </ul>
    </c:forEach>

<%--<ul>--%>
<%--<li>${arrayday} : ${result2}</li>--%>
<%--</ul>--%>


<%--<ul>--%>
    <%--<li>${Th1} : ${ThTemp1} </li>--%>
    <%--<li>${Th2} : ${ThTemp2} </li>--%>
<%--</ul>--%>

</body>
</html>
