<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@page import="net.registration.dao.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Activite cr��e"</title>
</head>
<body>
 <h1>Activite cr��e et gps lanc�!</h1>
 
<%
int timeout = 2;
response.setHeader("Refresh", timeout + "; URL = Historique.jsp");
%>
</body>
</html>