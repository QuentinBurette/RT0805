package net.activite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.activite.model.Activite;
import net.gps.model.Gps;
import net.gps.dao.GpsDao;

public class ActiviteDao {
	private GpsDao gpsDao = new GpsDao();
	public int LancerActivite(Activite activite) throws ClassNotFoundException {
		
        String INSERT_ACTIVITE_SQL = "INSERT INTO activite" +
            "  (TypeActivite, HeureDebut, HeureFin, DistanceParcourue, CoordonneesGPS, IdUtilisateur) VALUES " +
            " (?, ?, ?, ?, ?, ?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

     
        
        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/database?useSSL=false","root","root");
        		

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACTIVITE_SQL)) {
           
            preparedStatement.setString(1, activite.getTypeActivite());
            preparedStatement.setLong(2, System.currentTimeMillis());
            preparedStatement.setLong(3, System.currentTimeMillis()+ 60 * 60 * 1000);
            preparedStatement.setString(4, "0");
            preparedStatement.setString(5, "49.236443, 4.001705");
            preparedStatement.setString(6, activite.getIdUtilisateur());
            


            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();
            
            Statement stm = connection.createStatement();
        	ResultSet rs = stm.executeQuery("SELECT MAX(IdActivite) AS max_id FROM activite");
        	
        	
        	if(rs.next()) {
        		/*System.out.println(rs.getString(1));
        		Gps gps = new Gps();
        		gps.setLatitude("49.236443");
				 gps.setLongitude("4.001705");
				 gps.setHeureDePassage(System.currentTimeMillis());
        		
        		 gps.setIdActivite(rs.getString(1));
        		 gpsDao.LancerGps(gps);
        		 */
        		 int fin = 10;
        		 Gps[] j = new Gps[fin];
        		 int i=1;
        		
        			 j[i] = new Gps();
             		 j[i].setLatitude("49.236443");
     				 j[i].setLongitude("4.001705");
     				 j[i].setHeureDePassage(System.currentTimeMillis());
             		
             		 j[i].setIdActivite(rs.getString(1));
             		 gpsDao.LancerGps(j[i]);
        		 
        		 
        		 for(i=2; i<fin ;i++) {
        			 double w = Float.parseFloat(j[i-1].getLatitude()) ;
        			 double x = Float.parseFloat(j[i-1].getLongitude()) ;
        			 j[i] = new Gps();
             		 j[i].setLatitude(Float.toString((float) (w+0.001705)));
     				 j[i].setLongitude(Float.toString((float) (x+0.001705)));
     				 j[i].setHeureDePassage(System.currentTimeMillis()+(long)(Math.random())*1000*60);
             		
     				j[i].setIdActivite(rs.getString(1));
             		 gpsDao.LancerGps(j[i]);
        		 }
        		 
			}else {
				System.out.println("erreur");
				
			}

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }
	
	private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }

	}
}
