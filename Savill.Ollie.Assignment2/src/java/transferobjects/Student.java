/**
 * File name: Student.java
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Date: April, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package transferobjects;

/**
 * The Student class is a transfer object that represents a student with their
 * unique student ID, first name, and last name.
 */
public class Student {

    //Declaractions
    private Integer studentID;
    private String firstName;
    private String lastName;

    /**
     * Gets the student ID.
     *
     * @return An Integer representing the student ID.
     */
    public Integer getStudentID() {
        return studentID;
    }

    /**
     * Sets the student ID.
     *
     * @param studentID An Integer representing the student ID.
     */
    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    /**
     * Gets the student's first name.
     *
     * @return A String representing the student's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the student's first name.
     *
     * @param firstName A String representing the student's first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the student's last name.
     *
     * @return A String representing the student's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the student's last name.
     *
     * @param lastName A String representing the student's last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
