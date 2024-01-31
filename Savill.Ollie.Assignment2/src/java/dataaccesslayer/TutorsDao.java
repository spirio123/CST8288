/**
 * File name: TutorsDao.java
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Date: April, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package dataaccesslayer;

import java.util.List;

import transferobjects.*;

/**
 * Interface for the data access layer of the Tutors application. It defines
 * methods for retrieving and modifying data related to tutors, students, and
 * their courses.
 */
public interface TutorsDao {

    /**
     * Retrieves a list of all tutors.
     *
     * @return a List of Tutor objects
     */
    List<Tutor> getAllTutors();

    /**
     * Retrieves a tutor by their first and last name.
     *
     * @param firstName The first name of the tutor
     * @param lastName The last name of the tutor
     * @return a Tutor object
     */
    Tutor getTutorByTutorId(String firstName, String lastName);

    /**
     * Retrieves a student by their first and last name.
     *
     * @param studentName The first name of the student
     * @param studentLast The last name of the student
     * @return a Student object
     */
    Student getStudentByStudentId(String studentName, String studentLast);
    
    /**
     * Retrieves a grade by the student ID and the course code.
     *
     * @param studentID The ID of the student
     * @param courseCode The course code
     * @return a Grade object
     */
    Grade getGradeByStudentID(Integer studentID, String courseCode);

    /**
     * Retrieves a tutor course by tutor ID and course code.
     *
     * @param tutorID The ID of the tutor
     * @param courseCode The course code
     * @return a TutorCourse object
     */
    TutorCourse getTutorFromTutorTable(Integer tutorID, String courseCode);

    /**
     * Adds a tutor course to the database.
     *
     * @param tutor The TutorCourse object to add
     */
    void addTutorCourse(TutorCourse tutor);
}
