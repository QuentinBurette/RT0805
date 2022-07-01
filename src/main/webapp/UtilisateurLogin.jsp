<html>
<head>
<title>SmartTracker</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, intial-scale=1.0">
</head>
<body>

<form action="LoginServlet" method="post">
 <table>
    <tr>
    	<th>Username:</th><th><input type="text" name="NomUtilisateur" required/></th>
    </tr>
    <tr>
    	<th>Password:</th><th><input type="password" name="MotDePasseUtilisateur" required/></th>
    </tr>
    <tr>
    	<th></th>
    	<th><input type="submit" value="login"/></th>
    </tr>
  </table>
</form>

<INPUT TYPE="button" Value="Redirection page register" onclick="window.location='UtilisateurRegister.jsp';">
</body>
</html>
