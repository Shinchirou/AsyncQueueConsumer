<%--
  Created by IntelliJ IDEA.
  User: bostasze
  Date: 6/6/20
  Time: 2:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
<fieldset>
  <form action="RegisterServlet" method="post">
    <h1>New User</h1>
    <p>Please fill in the form to register new user</p><br>
    <p>E-mail: <input type="text" name="email" value="email"></p>	<br>
    <p>
      Rights: <input type="radio" name="rights" value="User" checked>User
      <input type="radio" name="rights" value="Superuser">Superuser	</p>	<br>
    <p>Access to application:
      <input type="checkbox" name="access1" value="TCstudio">TCstudio
      <input type="checkbox" name="access2" value="TCserver">TCserver
      <input type="checkbox" name="access3" value="TCsite">TCsite
    </p><br>
    <input type="submit" value="Register">
  </form>
</fieldset>
</body>
</html>
