/**
 * File name: Tutor.java
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Date: April, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package transferobjects;

/**
 * The Tutor class is a transfer object that represents a tutor with their
 * unique tutor ID, first name, and last name.
 */
public class Tutor {

    //Declaractions
    private Integer tutorID;
    private String firstName;
    private String lastName;

    /**
     * Gets the tutor ID.
     *
     * @return An Integer representing the tutor ID.
     */
    public Integer getTutorID() {
        return tutorID;
    }

    /**
     * Sets the tutor ID.
     *
     * @param tutorID An Integer representing the tutor ID.
     */
    public void setTutorID(Integer tutorID) {
        this.tutorID = tutorID;
    }

    /**
     * Gets the tutor's first name.
     *
     * @return A String representing the tutor's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the tutor's first name.
     *
     * @param firstName A String representing the tutor's first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the tutor's last name.
     *
     * @return A String representing the tutor's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the tutor's last name.
     *
     * @param lastName A String representing the tutor's last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
