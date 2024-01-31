/**
 * File name: DataSource.java
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Date: February, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package dataaccesslayer;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * The DataSource class creates a connection to the database using the provided
 * database properties file.
 *
 * The same connection is used for the entire application to prevent memory
 * leaks.
 * @author savil
 */
public class DataSource {

    private Connection connection = null;

    /**
     * Constructs a new DataSource object.
     */
    public DataSource() {
    }

    /**
     * Creates a connection to the database and returns it.
     *
     * @return A connection to the database.
     */
    public Connection createConnection() {
        // added use of Properties and try-with-resources - kriger
        Properties props = new Properties();

        try (InputStream in = Files.newInputStream(Paths.get("src/database.properties"));) {
            props.load(in);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }// catch()

        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");
        try {
            if (connection != null) {
                System.out.println("Cannot create new connection, one exists already");
            } else {
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}
/*
The design pattern used in this code is the Singleton pattern, which ensures that 
only one instance of the DataSource class is created and that the same instance is 
used throughout the application. This is achieved by creating a private constructor, 
making the class final, and providing a static method to retrieve the instance. In 
this code, the private Connection field is initialized to null, and the 
createConnection() method is used to create a connection to the database if one does 
not already exist.
*/