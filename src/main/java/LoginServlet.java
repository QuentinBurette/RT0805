

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class LoginServlet
 */

@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
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
				HttpSession session = request.getSession();
				session.setAttribute("nom", username);
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
        }
		
	}

}
