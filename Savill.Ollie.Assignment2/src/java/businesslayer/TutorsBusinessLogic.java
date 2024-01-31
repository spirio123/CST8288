/**
 * File name: TutorBusinessLogic.java
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Date: April, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package businesslayer;

import java.util.List;
import dataaccesslayer.TutorsDaoImpl;

import transferobjects.*;

import dataaccesslayer.TutorsDao;

/**
 * This class is responsible for handling business logic related to tutors,
 * students, and their courses. It validates inputs before inserting them into
 * the database and communicates with the TutorsDao layer to fetch and update
 * the required data.
 */
public class TutorsBusinessLogic {

    private TutorsDao tutorsDao = null;

    /**
     * Constructor for the TutorsBusinessLogic class. Initializes the TutorsDao
     * object for data access.
     *
     * @param username The username for the connection
     * @param password The password for the connection
     */
    public TutorsBusinessLogic(String username, String password) {
        tutorsDao = new TutorsDaoImpl(username, password);
    }

    /**
     * Retrieves a list of all tutors.
     *
     * @return a List of Tutor objects
     */
    public List<Tutor> getAllTutors() {
        return tutorsDao.getAllTutors();
    }

    /**
     * Retrieves a tutor by their first name and last name.
     *
     * @param firstName The first name of the tutor
     * @param lastName The last name of the tutor
     * @return a Tutor object
     */
    public Tutor getTutor(String firstName, String lastName) {
        return tutorsDao.getTutorByTutorId(firstName, lastName);
    }

    /**
     * Retrieves a student by their first name and last name.
     *
     * @param firstName The first name of the student
     * @param lastName The last name of the student
     * @return a Student object
     */
    public Student getStudent(String firstName, String lastName) {
        return tutorsDao.getStudentByStudentId(firstName, lastName);
    }

    /**
     * Retrieves a grade by the student ID and course code.
     *
     * @param studentID The ID of the student
     * @param courseCode The course code
     * @return a Grade object
     */
    public Grade getGrade(Integer studentID, String courseCode) {
        return tutorsDao.getGradeByStudentID(studentID, courseCode);
    }

    /**
     * Retrieves a tutor course by tutor ID and course code.
     *
     * @param tutorID The ID of the tutor
     * @param courseCode The course code
     * @return a TutorCourse object
     */
    public TutorCourse getTutorCourse(Integer tutorID, String courseCode) {
        return tutorsDao.getTutorFromTutorTable(tutorID, courseCode);
    }

    /**
     * Adds a tutor course to the database.
     *
     * @param course The TutorCourse object to add
     */
    public void addTutorCourse(TutorCourse course) {
        tutorsDao.addTutorCourse(course);
    }

    public String message = ""; //this will be a message you can parse in view

    /**
     * Main method that runs the business logic for adding a tutor to a specific
     * course. This method checks if the tutor is a student, has a grade of A-,
     * A, or A+ in the course, and if they are not already assigned to the
     * course. If all conditions are met, the tutor is added to the tutorcourse
     * table.
     *
     * @param firstName The first name of the tutor
     * @param lastName The last name of the tutor
     * @param courseCode The course code of the course the tutor is being added
     * to
     */
    public void Mainrun(String firstName, String lastName, String courseCode) {

        //Get tutor by first name and last name 
        Tutor tutor = getTutor(firstName, lastName);

        //check if they're in the student table       
        Student student = getStudent(firstName, lastName);
        if (student == null) {
            message = String.format("%s %s not found in student table", firstName, lastName);
            return;
        }

        //check if they got a grade of A-, A, or A+ in the grades table for that specific course
        Grade grades = getGrade(student.getStudentID(), courseCode);
        if (grades.getGrade() == null) {
            message = String.format("%s %s doesn't have any recorded grades", firstName, lastName);
            return;
        }
        if (!grades.getGrade().contains("A")) {
            message = String.format("%s %s 's grade isn't high enough", firstName, lastName);
            return;
        }

        //check if they're in the tutorcourse table using their TutorId and the coursecode
        TutorCourse tutorCourse = getTutorCourse(tutor.getTutorID(), courseCode);
        if (tutorCourse != null) {
            message = String.format("%s %s already assigned to course %s", tutor.getFirstName(), tutor.getLastName(), courseCode);
            return;
        }

        // Add tutor to tutorcourse table
        TutorCourse courses = new TutorCourse();
        courses.setTutorID(tutor.getTutorID());
        courses.setCourseCode(courseCode);
        addTutorCourse(courses);

        //message for adding them to the course if all conditions are met
        message = String.format("%s %s added to course %s", tutor.getFirstName(), tutor.getLastName(), courseCode);
    }
}
