<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Smart Tracker Register</title>
</head>
<body>
 <div align="center">
  <h1>Enregistrer Utilisateur</h1>
  <form action="<%= request.getContextPath() %>/register" method="post">
   <table style="with: 80%">
    <tr>
     <td>Pseudo</td>
     <td><input type="text" name="NomUtilisateur" /></td>
    </tr>
    <tr>
     <td>Mot de passe</td>
     <td><input type="password" name="MotDePasseUtilisateur" /></td>
    </tr>
    <tr>
     <td>Mail</td>
     <td><input type="text" name="MailUtilisateur" /></td>
    </tr>
    <tr>
     <td>Age</td>
     <td><input type="password" name="AgeUtilisateur" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
  <INPUT TYPE="button" Value="Redirection page login" onclick="window.location='UtilisateurLogin.jsp';">
 </div>
</body>
</html>