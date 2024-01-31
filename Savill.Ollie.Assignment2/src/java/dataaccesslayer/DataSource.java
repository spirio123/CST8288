/**
 * File name: DataSource.java
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Date: April, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package dataaccesslayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The DataSource class is responsible for creating and managing a single
 * connection to the MySQL database. It prevents multiple connections, avoiding
 * memory leaks.
 *
 * @author Ollie Savill
 */
public class DataSource {

    //Declarations
    private Connection connection = null;
    private final String url = "jdbc:mysql://localhost:3306/tutoring?useSSL=false";
    private String username;
    private String password;

    /**
     * Constructs a new DataSource object using the username and password.
     *
     * @param username username
     * @param password password
     */
    public DataSource(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Creates a new connection to the MySQL database if it doesn't exist. If a
     * connection already exists, a message is printed to the console and the
     * existing connection is returned.
     *
     * @return Connection object representing the connection to the database.
     */
    public Connection createConnection() {
        try {
            if (connection != null) {
                System.out.println("Cannot create new connection, one exists already");
            } else {
                connection = DriverManager.getConnection(url, this.username, this.password);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}
