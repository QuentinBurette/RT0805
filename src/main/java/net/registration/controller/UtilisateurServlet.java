package net.registration.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.registration.dao.UtilisateurDao;
import net.registration.model.Utilisateur;

/**
 * Servlet implementation class RegisterServlet
 */

@WebServlet("/register")
public class UtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurDao utilisateurDao = new UtilisateurDao();
   
	
	public UtilisateurServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/UtilisateurRegister.jsp");
		dispatcher.forward(request, response);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 String NomUtilisateur = request.getParameter("NomUtilisateur");
		 String MotDePasseUtilisateur = request.getParameter("MotDePasseUtilisateur");
		 String MailUtilisateur = request.getParameter("MailUtilisateur");
		 String AgeUtilisateur = request.getParameter("AgeUtilisateur");
		 
		
		 Utilisateur utilisateur = new Utilisateur();
	
		 utilisateur.setNomUtilisateur(NomUtilisateur);
		 utilisateur.setMotDePasseUtilisateur(MotDePasseUtilisateur);
		 utilisateur.setMailUtilisateur(MailUtilisateur);
		 utilisateur.setAgeUtilisateur(AgeUtilisateur);
		 
		 request.getSession().setAttribute("nomuser", NomUtilisateur);
		 
		 try {
	            utilisateurDao.RegisterUtilisateur(utilisateur);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

		 	RequestDispatcher dispatcher = request.getRequestDispatcher("/UtilisateurDetails.jsp");
			dispatcher.forward(request, response);

		 
		 
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
