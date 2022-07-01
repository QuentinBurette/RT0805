<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@page import="net.registration.dao.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Utilisateur enregistré</title>
</head>
<body>
 <h1>Utilisateur enregistré !</h1>
 
<%
int timeout = 2;
response.setHeader("Refresh", timeout + "; URL = UtilisateurLogin.jsp");
%>
</body>
</html>