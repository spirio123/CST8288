/**
 * File name: RecipientsDAOImpl.java
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Date: February, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package dataaccesslayer;

import java.util.List;

import transferobjects.RecipientsDTO;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;
import transferobjects.ColumnDTO;

/**
 *
 * @author savil
 */
public class RecipientsDaoImpl implements RecipientsDao {

    /**
     * ColumnDTO object to hold metadata about the table columns.
     */
    ColumnDTO columns = null;

    /**
     * Retrieves the ColumnDTO object containing metadata about the table
     * columns.
     *
     * @return the ColumnDTO object
     */
    @Override
    public ColumnDTO Column() {
        return columns;
    }

    /**
     * Retrieves a list of all recipients in the 'Recipients' table.
     *
     * @return a list of RecipientsDTO objects
     */
    @Override
    public List<RecipientsDTO> getAllRecipients() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;
        ArrayList<RecipientsDTO> recipients = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT AwardID, Name, Year, City, Category FROM Recipients ORDER BY AwardID");
            rs = pstmt.executeQuery();
            recipients = new ArrayList<>();

            rsmd = rs.getMetaData();// get meta
            while (rs.next()) {
                RecipientsDTO recipient = new RecipientsDTO();
                recipient.setAwardID(rs.getInt("AwardID"));
                recipient.setName(rs.getString("Name"));
                recipient.setYear(rs.getInt("Year"));
                recipient.setCity(rs.getString("City"));
                recipient.setCategory(rs.getString("Category"));
                recipients.add(recipient);
            }

            //call columnDTO, pass in values
            ColumnDTO column = new ColumnDTO();

            column.setColumnCount(rsmd.getColumnCount()); //this

            for (int i = 1; i <= column.getColumnCount(); i++) {
                column.setColumnName(rsmd.getColumnName(i));
                column.setColumnType(rsmd.getColumnTypeName(i));
                column.setClassType(rsmd.getColumnClassName(i));
            }

            columns = column;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return recipients;
    }

    /**
     * Retrieves a recipient from the 'Recipients' table with the specified
     * award ID.
     *
     * @param awardID the award ID of the recipient to retrieve
     * @return the RecipientsDTO object representing the retrieved recipient, or
     * null if no recipient with the specified award ID was found
     */
    @Override
    public RecipientsDTO getRecipientByAwardId(Integer awardID) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        RecipientsDTO recipient = null;
        ResultSetMetaData rsmd = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT AwardID, Name, Year, City, Category FROM Recipients WHERE AwardID = ?");
            pstmt.setInt(1, awardID);
            rs = pstmt.executeQuery();
            rsmd = rs.getMetaData();// get meta
            while (rs.next()) {
                recipient = new RecipientsDTO();
                recipient.setAwardID(rs.getInt("AwardID"));
                recipient.setName(rs.getString("Name"));
                recipient.setYear(rs.getInt("Year"));
                recipient.setCity(rs.getString("City"));
                recipient.setCategory(rs.getString("Category"));
            }
            //call columnDTO, pass in values
            ColumnDTO column = new ColumnDTO();
            column.setColumnCount(rsmd.getColumnCount()); //this

            for (int i = 1; i <= column.getColumnCount(); i++) {
                column.setColumnName(rsmd.getColumnName(i));
                column.setColumnType(rsmd.getColumnTypeName(i));
                column.setClassType(rsmd.getColumnClassName(i));
            }

            columns = column;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return recipient;
    }

    /**
     * Adds a recipient to the database.
     *
     * @param recipient a RecipientsDTO object to be added to the database
     */
    @Override
    public void addRecipient(RecipientsDTO recipient) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            // do not insert AwardID, it is generated by Database
            pstmt = con.prepareStatement(
                    "INSERT INTO Recipients (Name, Year, City, Category) "
                    + "VALUES(?, ?, ?, ?)");
            pstmt.setString(1, recipient.getName());
            pstmt.setInt(2, recipient.getYear());
            pstmt.setString(3, recipient.getCity());
            pstmt.setString(4, recipient.getCategory());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * Updates a recipient in the database.
     *
     * @param recipient a RecipientsDTO object to be updated in the database
     */
    @Override
    public void updateRecipient(RecipientsDTO recipient) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "UPDATE Recipients SET Name = ?, "
                    + "Year = ?, " + "City = ?," + "Category = ? WHERE AwardID = ?");
            pstmt.setString(1, recipient.getName());
            pstmt.setInt(2, recipient.getYear());
            pstmt.setString(3, recipient.getCity());
            pstmt.setString(4, recipient.getCategory());
            pstmt.setInt(5, recipient.getAwardID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * Deletes a recipient from the database.
     *
     * @param recipient a RecipientsDTO object to be deleted from the database
     */
    @Override
    public void deleteRecipient(RecipientsDTO recipient) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "DELETE FROM Recipients WHERE AwardID = ?");
            pstmt.setInt(1, recipient.getAwardID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
/*
This code is an implementation of the Data Access Object (DAO) pattern. The 
RecipientsDaoImpl class serves as the implementation of the RecipientsDao interface, 
which defines the methods for accessing recipient data. The class contains methods 
for retrieving all recipients, retrieving a recipient by award ID, and adding a new 
recipient.

The DAO pattern separates the data access logic from the business logic of an 
application. It allows the application to interact with the data source (in this 
case, a database) through an interface, rather than directly interacting with the 
data source. This helps to decouple the application from the data source and makes 
it easier to change the data source or the data access logic without affecting the 
rest of the application.
*/