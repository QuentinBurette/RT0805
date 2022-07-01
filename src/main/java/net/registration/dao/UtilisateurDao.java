package net.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import net.registration.model.Utilisateur;

public class UtilisateurDao {
	
	public int RegisterUtilisateur(Utilisateur utilisateur) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO utilisateur" +
            "  (NomUtilisateur, MotDePasseUtilisateur, MailUtilisateur, AgeUtilisateur) VALUES " +
            " (?, ?, ?, ?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/database?useSSL=false","root","root");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
           
            preparedStatement.setString(1, utilisateur.getNomUtilisateur());
            preparedStatement.setString(2, utilisateur.getMotDePasseUtilisateur());
            preparedStatement.setString(3, utilisateur.getMailUtilisateur());
            preparedStatement.setString(4, utilisateur.getAgeUtilisateur());


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
