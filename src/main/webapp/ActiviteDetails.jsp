<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@page import="net.registration.dao.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Activite créée"</title>
</head>
<body>
 <h1>Activite créée et gps lancé!</h1>
 
<%
int timeout = 2;
response.setHeader("Refresh", timeout + "; URL = Historique.jsp");
%>
</body>
</html>