<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.util.Date " %>
  


<div align="center">
   <a href="LogOutServlet">Log Out</a>
   </div>
<form method="post">

<table>
   <%
   try
   {
	  Connection conn = null;

		 Class.forName("com.mysql.jdbc.Driver").newInstance();
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useSSL=false","root","root");
         
         String id = request.getParameter("id");
          System.out.println(id);
	
		   String query="select Longitude, Latitude, HeureDePassage from gps where IdActivite= '"+id+"'";
		   
	       Statement stmt=conn.createStatement();
	       ResultSet rs=stmt.executeQuery(query);
	    
	       while(rs.next())
	       {
	    	   long test = Long.parseLong(rs.getString("HeureDePassage"));
	    	   Date res = new Date(test);   
	   %>
	       
	     
	      
	       <tr><td>Longitude : <%=rs.getString("Longitude") %></td></tr>
	       <tr><td>Latitude : <%=rs.getString("Latitude") %></td></tr>
	       <tr><td>Date : <%=res %></td></tr>

	       
	      
   

	        <tr><td>---------------------------------------</td></tr>

	   <%
	       }
	   %>
	   </table>
	   <%
	   		
	        rs.close();
	        stmt.close();
	        conn.close();
		   
	   
   }
   catch(Exception e)
   {
        e.printStackTrace();
   }   
   %>
   
</form>