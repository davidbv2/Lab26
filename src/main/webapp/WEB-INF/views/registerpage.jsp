<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>David's Dark Roast - Registration</title>

</head>
<body>
${inst}
<br>
<form action="formhandler" method="post">
    <fieldset>
        <legend> Coffee Lover Registration </legend>
    First Name: <input type="text" name="firstname"> <br>
    Last Name: <input type="text" name="lastname"> <br>
    Phone #: <input type="number" name="num"> <br>
    Email: <input type ="text" name="email"> <br>
    Favorite type of coffee: <input type="text" name="favcoffee"> <br>

    <input type="submit" name="submit" value="Submit">

    </fieldset>

</form>
</body>
</html>
