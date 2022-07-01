package net.gps.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.gps.model.Gps;

public class GpsDao {
	
	public int LancerGps(Gps gps) throws ClassNotFoundException {
        String INSERT_GPS_SQL = "INSERT INTO gps" +
            "  (Latitude, Longitude, HeureDePassage, IdActivite) VALUES " +
            " (?, ?, ?, ?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

     
        
        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/database?useSSL=false","root","root");
        		

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_GPS_SQL)) {
           
            preparedStatement.setString(1, gps.getLatitude());
            preparedStatement.setString(2, gps.getLongitude());
            preparedStatement.setLong(3, gps.getHeureDePassage());
            preparedStatement.setString(4, gps.getIdActivite());
            


            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

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
