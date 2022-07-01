package net.gps.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.gps.dao.GpsDao;
import net.gps.model.Gps;

/**
 * Servlet implementation class RegisterServlet
 */

@WebServlet("/gps")
public class GpsServlet  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GpsDao gpsDao = new GpsDao();
   
	
	public GpsServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Dashboard.jsp");
		dispatcher.forward(request, response);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String Latitude = request.getParameter("Latitude");
		 String Longitude = request.getParameter("Longitude");

		 
		 
		 HttpSession session = request.getSession();
		 String idactivite = (String) session.getAttribute("activite");
		 System.out.println(idactivite);
		 
		 
		 
		 
		 response.setContentType("text/html");
	        try {
	       		
					Gps gps = new Gps();
					 
					gps.setLatitude(Latitude);
					gps.setLongitude(Longitude);
					gps.setIdActivite(idactivite);
					
					 
					 try {
				            gpsDao.LancerGps(gps);
				        } catch (Exception e) {
				            // TODO Auto-generated catch block
				            e.printStackTrace();
				        }

					 	RequestDispatcher dispatcher = request.getRequestDispatcher("/GpsDetails.jsp");
						dispatcher.forward(request, response);
				
				
	        } catch (Exception e) {
	            e.printStackTrace(); 
	        }
		 
		 
		
		 

		 
		 
		/*response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("NomUtilisateur");
		String password = request.getParameter("MotDePasseUtilisateur");
		
	
		Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useSSL=false","root","root");
            
            Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from utilisateur where NomUtilisateur='"+username+"' and MotDePasseUtilisateur='"+password+"'");
			
			if(rs.next()) {
				response.sendRedirect("SmartTrackerHome.jsp");
			}else {
				out.println("Mauvais username ou password");
				
			}
			
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	
        	
        	
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }*/
		
	}

}
