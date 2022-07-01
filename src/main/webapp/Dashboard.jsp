<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Creer activité</title>
</head>
<body>
<div align="center">
   <a href="LogOutServlet">Log Out</a>
   <div>
     <a href="javascript:history.back()">Page Précédente</a>
     </div>
   
   </div>
 <div align="center">
  <h1>Creer activité</h1>
  <form action="<%= request.getContextPath() %>/activite" method="post">
   <select name="TypeActivite" id="TypeActivite">
    <option value="Natation">Natation</option>
    <option value="Jogging">Jogging</option>
    <option value="Marche a pied">Marche a pied</option>
</select>

   <input type="submit" value="Valider" />
  </form>
 </div>

 
 <div align="center">
  <h1>Historique</h1>
  <INPUT TYPE="button" Value="historique" onclick="window.location='Historique.jsp';">
 </div>

 <div align="center">
 <%Object user =session.getAttribute("nom");%>
<%=user%>

 </div>
</body>
</html>