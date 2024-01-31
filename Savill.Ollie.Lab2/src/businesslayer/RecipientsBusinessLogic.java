/**
 * File name: RecipientsBusinessLogic.java
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Date: February, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package businesslayer;

import java.util.List;
import dataaccesslayer.RecipientsDao;
import dataaccesslayer.RecipientsDaoImpl;
import transferobjects.RecipientsDTO;
import transferobjects.ColumnDTO;

/**
 * This class represents the business logic for Recipients, defining the
 * operations that can be performed on the data access layer, such as adding,
 * updating, and deleting recipients, as well as retrieving recipient data. The
 * class uses an instance of RecipientsDaoImpl to interact with the data access
 * layer, which is responsible for reading and writing recipient data to the
 * database. The class also defines validation rules for the recipient data,
 * ensuring that the data is correct and meets certain criteria before it is
 * passed to the data access layer.
 *
 * @author savi
 */
public class RecipientsBusinessLogic {

    private static final int NAME_MAX_LENGTH = 30;
    private static final int CITY_MAX_LENGTH = 50;
    private static final int CATEGORY_MAX_LENGTH = 50;

    private RecipientsDao recipientsDao = null;

    /**
     * Constructor that initializes a new instance of RecipientsDaoImpl to
     * interact with the data access layer.
     */
    public RecipientsBusinessLogic() {
        recipientsDao = new RecipientsDaoImpl();
    }

    /**
     * Retrieves a list of all recipients from the data access layer.
     *
     * @return a list of RecipientsDTO objects representing all recipients in
     * the database
     */
    public List<RecipientsDTO> getAllRecipients() {
        return recipientsDao.getAllRecipients();
    }

    /**
     * Retrieves a recipient with the specified recipientID from the data access
     * layer.
     *
     * @param recipientID the ID of the recipient to retrieve
     * @return a RecipientsDTO object representing the recipient with the
     * specified ID, or null if the recipient does not exist in the database
     */
    public RecipientsDTO getRecipient(Integer recipientID) {
        return recipientsDao.getRecipientByAwardId(recipientID);
    }

    /**
     * Retrieves column DTO from the data access layer.
     *
     * @return a ColumnDTO object containing information about the columns of
     * the table
     */
    public ColumnDTO column() {
        return recipientsDao.Column();
    }

    /**
     * Adds a new recipient to the database.
     *
     * @param recipient a RecipientsDTO object representing the recipient to add
     * @throws ValidationException if the recipient data is not valid according
     * to the validation rules defined in this class
     */
    public void addRecipient(RecipientsDTO recipient) throws ValidationException {
        cleanRecipient(recipient);
        validateRecipient(recipient);
        recipientsDao.addRecipient(recipient);
    }

    /**
     * Updates an existing recipient in the database.
     *
     * @param recipient a RecipientsDTO object representing the recipient to
     * update
     * @throws ValidationException if the recipient data is not valid according
     * to the validation rules defined in this class
     */
    public void updateRecipient(RecipientsDTO recipient) throws ValidationException {
        cleanRecipient(recipient);
        validateRecipient(recipient);
        recipientsDao.updateRecipient(recipient);
    }

    /**
     * Deletes a recipient from the data access layer.
     *
     * @param recipient A recipient object to delete.
     */
    public void deleteRecipient(RecipientsDTO recipient) {
        recipientsDao.deleteRecipient(recipient);
    }

    private void cleanRecipient(RecipientsDTO recipient) {
        if (recipient.getName() != null) {
            recipient.setName(recipient.getName().trim());
        }

        if (recipient.getCity() != null) {
            recipient.setCity(recipient.getCity().trim());
        }
        if (recipient.getCategory() != null) {
            recipient.setCity(recipient.getCategory().trim());
        }
    }

    private void validateRecipient(RecipientsDTO recipient) throws ValidationException {
        validateString(recipient.getName(), "Name", NAME_MAX_LENGTH, true);
        validateInt(recipient.getYear(), "Year");
        validateString(recipient.getCity(), "City", CITY_MAX_LENGTH, true);
        validateString(recipient.getCategory(), "Category", CATEGORY_MAX_LENGTH, true);
    }

    private void validateString(String value, String fieldName, int maxLength, boolean isNullAllowed)
            throws ValidationException {
        if (value == null && isNullAllowed) {
            // return; // null permitted, nothing to validate
        } else if (value == null && !isNullAllowed) {
            throw new ValidationException(String.format("%s cannot be null",
                    fieldName));
        } else if (value.length() == 0) {
            throw new ValidationException(String.format("%s cannot be empty or only whitespace",
                    fieldName));
        } else if (value.length() > maxLength) {
            throw new ValidationException(String.format("%s cannot exceed %d characters",
                    fieldName, maxLength));
        }
    }

    private void validateInt(int value, String fieldName)
            throws ValidationException {
        if (value <= 0) {
            throw new ValidationException(String.format("%s cannot be a negative number",
                    fieldName));
        }
    }

}
