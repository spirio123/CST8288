/**
 * File name: Grade.java
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Date: April, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package transferobjects;

/**
 * The Grade class is a transfer object that represents a student's grade for a
 * specific course.
 *
 * @author savil
 */
public class Grade {

    //Declarations
    private String grade;
    private String courseCode;

    /**
     * Gets the grade of the student for the course.
     *
     * @return A String representing the student's grade.
     */
    public String getGrade() {
        return grade;
    }

    /**
     * Sets the grade of the student for the course.
     *
     * @param grade A String representing the student's grade.
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * Gets the course code associated with the grade.
     *
     * @return A String representing the course code.
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Sets the course code associated with the grade.
     *
     * @param courseCode A String representing the course code.
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
