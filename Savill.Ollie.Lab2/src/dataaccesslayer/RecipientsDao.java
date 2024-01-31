/**
 * File name: RecipientsDAO.java
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
import transferobjects.ColumnDTO;

/**
 * The RecipientsDao interface defines the methods to access and manipulate the
 * Recipients data from a database.
 *
 * @author savil
 */
public interface RecipientsDao {

    List<RecipientsDTO> getAllRecipients();

    RecipientsDTO getRecipientByAwardId(Integer awardID);

    void addRecipient(RecipientsDTO recipient);

    void updateRecipient(RecipientsDTO recipient);

    void deleteRecipient(RecipientsDTO recipient);

    ColumnDTO Column();

}
/*
The code is an example of the Data Access Object (DAO) design pattern. The interface 
RecipientsDao defines the methods to access and manipulate the Recipients data from a 
database. The DAO design pattern separates the data persistence logic from the 
business logic and provides a standard interface for accessing the data. This allows 
for easier maintenance and testing of the application. The RecipientsDao interface 
defines methods for performing CRUD operations (Create, Read, Update, and Delete) on 
the Recipients data.
*/