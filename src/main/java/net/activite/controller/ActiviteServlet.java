package net.activite.controller;




import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.activite.dao.ActiviteDao;
import net.activite.model.Activite;



/**
 * Servlet implementation class RegisterServlet
 */

@WebServlet("/activite")
public class ActiviteServlet  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ActiviteDao activiteDao = new ActiviteDao();
	
   
	
	public ActiviteServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Dashboard.jsp");
		dispatcher.forward(request, response);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String TypeActivite = request.getParameter("TypeActivite");
		 String HeureDebut = request.getParameter("HeureDebut");
		 String HeureFin = request.getParameter("HeureFin");
		 String DistanceParcourue = request.getParameter("DistanceParcourue");
		 String CoordonneesGPS = request.getParameter("CoordonneesGPS");
		 
		 
		 HttpSession session = request.getSession();
		 String nom = (String) session.getAttribute("nom");
		 System.out.println(nom);
		 
		 
		 
		 response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		 Connection con = null;
	        try {
	            Class.forName("com.mysql.jdbc.Driver").newInstance();
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useSSL=false","root","root");
	            
	            Statement stm = con.createStatement();
				ResultSet rs = stm.executeQuery("select IdUtilisateur from utilisateur where NomUtilisateur='"+nom+"'");
				
				if(rs.next()) {
					Activite activite = new Activite();
					
					 
					 activite.setTypeActivite(TypeActivite);
					 activite.setHeureDebut(HeureDebut);
					 activite.setHeureFin(HeureFin);
					 activite.setDistanceParcourue(DistanceParcourue);
					 activite.setCoordonneesGPS(CoordonneesGPS);
					 
					 activite.setIdUtilisateur(rs.getString(1));
					 
					 
					 
					
					 
					 try {
				            activiteDao.LancerActivite(activite);
				            
				        } catch (Exception e) {
				            // TODO Auto-generated catch block
				            e.printStackTrace();
				        }

					 	RequestDispatcher dispatcher = request.getRequestDispatcher("/ActiviteDetails.jsp");
						dispatcher.forward(request, response);
				}else {
					out.println("Erreur");
					
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
