<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.util.Date " %>

<div align="center">
   <a href="LogOutServlet">Log Out</a>
   <div>
     <a href="javascript:history.back()">Page Précédente</a>
     </div>
   </div>
<form method="post">

<table>
   <%
   try
   {
	  Connection conn = null;
		 String nom = (String) session.getAttribute("nom");
	
		 
		 Class.forName("com.mysql.jdbc.Driver").newInstance();
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useSSL=false","root","root");
         
         Statement stm2 = conn.createStatement();
		ResultSet rs2 = stm2.executeQuery("select IdUtilisateur from utilisateur where NomUtilisateur='"+nom+"'");
			
	  
	  
	   if(rs2.next()) {
		   String query="select IdActivite,TypeActivite,HeureDebut,HeureFin,DistanceParcourue,CoordonneesGPS from activite where IdUtilisateur='"+rs2.getString(1)+"'";
		   
	       Statement stmt=conn.createStatement();
	       ResultSet rs=stmt.executeQuery(query);
	     
	       while(rs.next())
	       {
	    	   long test = Long.parseLong(rs.getString("HeureDebut"));
	    	   long test2 = Long.parseLong(rs.getString("HeureFin"));
	    	   Date res = new Date(test);  
	    	   Date res2 = new Date(test2); 
	    	   String id = rs.getString("IdActivite");
	   %>
	       
	        <tr><td><a href="GpsDetails.jsp?id=<%=id%>"><%=rs.getString("TypeActivite")%></a></td></tr>
	       <tr><td>Heure de début : <%=res %></td></tr>
	       <tr><td>Heure de fin : <%=res2 %></td></tr>
	       <tr><td>Distance parcourue :<%=rs.getString("DistanceParcourue") %></td></tr>
	       <tr><td>Coordonnées gps : <%=rs.getString("CoordonneesGPS") %></td></tr>
	     
	      
   

	        <tr><td>---------------------------------------</td></tr>

	   <%
	       }
	   %>
	   </table>
	   <%
	   		rs2.close();
	  		stm2.close();
	        rs.close();
	        stmt.close();
	        conn.close();
		   
	   
	   }else {
			out.println("Erreur");
			
		}
	   
	   
	   
   }
   catch(Exception e)
   {
        e.printStackTrace();
   }   
   %>
   
</form>