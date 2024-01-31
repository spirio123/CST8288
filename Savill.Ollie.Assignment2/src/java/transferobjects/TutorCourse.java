/**
 * File name: TutorCourse.java
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Date: April, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package transferobjects;

/**
 * The TutorCourse class is a transfer object that represents the relationship
 * between a tutor and a course they are responsible for. It includes the tutor
 * ID, course code, and course name.
 */
public class TutorCourse {

    private String courseCode;
    private Integer tutorID;

    /**
     * Gets the course code.
     *
     * @return A String representing the course code.
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Sets the course code.
     *
     * @param courseCode A String representing the course code.
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

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
}
