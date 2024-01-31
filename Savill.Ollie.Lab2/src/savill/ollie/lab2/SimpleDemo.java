/**
 * File name: SimpleDemo.java
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Date: February, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package savill.ollie.lab2;

/**
 *
 * @author savil
 */
import businesslayer.RecipientsBusinessLogic;
import businesslayer.ValidationException;
import transferobjects.RecipientsDTO;
import transferobjects.ColumnDTO;

import java.util.List;

/**
 * A simple demo class that demonstrates the use of RecipientsBusinessLogic and
 * RecipientsDTO classes. It also demonstrates basic CRUD operations (Create,
 * Read, Update, and Delete) with the data.
 *
 * @author savil
 */
public class SimpleDemo {

    /**
     * Runs the simple demo.
     */
    public void demo() {
        try {
            RecipientsBusinessLogic logic = new RecipientsBusinessLogic();
            List<RecipientsDTO> list = null;
            RecipientsDTO recipient = null;

            //prints all recipients
            System.out.println("Printing Recipients");
            list = logic.getAllRecipients();
            ColumnDTO column = logic.column();
            printColumnHeads(column);
            printRecipients(list);
            printInfo(column);
            System.out.println("Printing One Recipient");
            //print one recipient
            recipient = logic.getRecipient(1);
            printColumnHeads(column);
            printRecipient(recipient);
            System.out.println();
            //add one recipient
            System.out.println("Inserting One Recipient");
            recipient = new RecipientsDTO();
            recipient.setName("NameTestAdd");
            recipient.setYear(2001);
            recipient.setCity("CityTestAdd");
            recipient.setCategory("CategoryTestAdd");
            logic.addRecipient(recipient);
            list = logic.getAllRecipients();
            printColumnHeads(column);
            printRecipients(list);
            //update a recipient
            System.out.println("Updating last recipient");
            Integer updatePrimaryKey = list.get(list.size() - 1).getAwardID();
            recipient = new RecipientsDTO();
            recipient.setAwardID(updatePrimaryKey);
            recipient.setName("NameTestupdate");
            recipient.setYear(1996);
            recipient.setCity("CityTestUpdate");
            recipient.setCategory("CategoryTestUpdate");
            logic.updateRecipient(recipient);
            list = logic.getAllRecipients();
            printColumnHeads(column);
            printRecipients(list);
            //delete a recipient
            System.out.println("Deleting last recipient");
            recipient = list.get(list.size() - 1);
            logic.deleteRecipient(recipient);
            list = logic.getAllRecipients();
            printColumnHeads(column);
            printRecipients(list);
        } catch (ValidationException e) {
            System.err.println(e.getMessage());
        }

    }

    /**
     * Prints the details of a single recipient.
     *
     * @param recipient the recipient to print
     */
    private static void printRecipient(RecipientsDTO recipient) {
        String output = String.format("%s, %s, %s, %s, %s",
                recipient.getAwardID().toString(),
                recipient.getName(),
                recipient.getYear().toString(),
                recipient.getCity(),
                recipient.getCategory());
        System.out.println(output);
    }

    /**
     * Prints the details of a list of recipients.
     *
     * @param recipients the list of recipients to print
     */
    private static void printRecipients(List<RecipientsDTO> recipients) {
        for (RecipientsDTO recipient : recipients) {
            printRecipient(recipient);
        }
        System.out.println();
    }

    /**
     * Prints the column information for the database table.
     *
     * @param blank The `ColumnDTO` object that holds the column information for
     * the table.
     */
    private static void printInfo(ColumnDTO blank) {
        if (blank == null) {
            return;
        }
        System.out.println("Column Information:");
        int columnCount = blank.getColumnCount();
        System.out.println("==============");
        System.out.println("Column Count" + columnCount);

        for (int i = 0; i < columnCount; i++) {
            System.out.println("Column Name: " + blank.getColumnName(i));
            System.out.println("Column Type: " + blank.getColumnType(i));
            System.out.println("Class Type: " + blank.getClassType(i));
        }
    }
    /**
     * Prints the column heads in from of all of the other print statements, so
     * when they are printed, each table has column heads in front.
     * 
     * @param blank The 'ColumnDTO' object that holds the column names
     */
    private static void printColumnHeads(ColumnDTO blank) {
        if (blank == null) {
            return;
        }
        int columnCount = blank.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            System.out.printf(blank.getColumnName(i) + " ");
        }
        System.out.println("");
    }
}
