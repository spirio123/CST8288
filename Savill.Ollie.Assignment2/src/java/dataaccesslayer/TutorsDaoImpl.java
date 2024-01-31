/**
 * File name: TutorDaoImpl.java
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

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class provides an implementation of the TutorsDao interface for
 * interacting with the database to perform CRUD operations related to tutors,
 * courses, students, and grades.
 */
public class TutorsDaoImpl implements TutorsDao {

    //Declarations
    private final String username;
    private final String password;

    /**
     * A constructor for the username and password provided by the user to log
     * into the database.
     *
     * @param username The username from the User ID field.
     * @param password The password from the password field.
     */
    public TutorsDaoImpl(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Retrieves all tutors and their associated courses from the database.
     *
     * @return a List of Tutor objects.
     */
    @Override
    public List<Tutor> getAllTutors() {
        //Declaractions
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Tutor> tutors = null;
        try {
            DataSource ds = new DataSource(username, password);
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT tutor.tutorID, tutor.firstName, tutor.lastName "
                    + "FROM tutor "
                    + "INNER JOIN tutorcourse ON tutor.tutorID = tutorcourse.tutor_TutorID "
                    + "ORDER BY tutor.tutorID");
            rs = pstmt.executeQuery();
            tutors = new ArrayList<>();
            while (rs.next()) {
                Tutor tutor = new Tutor();
                tutor.setTutorID(rs.getInt("tutor.tutorID"));
                tutor.setFirstName(rs.getString("tutor.firstName"));
                tutor.setLastName(rs.getString("tutor.lastName"));
                tutors.add(tutor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeDatabaseStuff(con, pstmt, rs);
        }
        return tutors;
    }

    /**
     * Retrieves a tutor by their first and last name.
     *
     * @param firstName the first name of the tutor.
     * @param lastName the last name of the tutor.
     * @return a Tutor object or null if not found.
     */
    @Override
    public Tutor getTutorByTutorId(String firstName, String lastName) {
        //Declaractions
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Tutor tutor = null;
        try {
            DataSource ds = new DataSource(username, password);
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT TutorID, FirstName, LastName "
                    + "FROM tutor "
                    + "WHERE FirstName = ? AND LastName = ?");
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                tutor = new Tutor();
                tutor.setTutorID(rs.getInt("TutorID"));
                tutor.setFirstName(rs.getString("FirstName"));
                tutor.setLastName(rs.getString("LastName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeDatabaseStuff(con, pstmt, rs);
        }
        return tutor;
    }

    /**
     * Retrieves a student by their first and last name.
     *
     * @param studentName the first name of the student.
     * @param studentLast the last name of the student.
     * @return a Student object or null if not found.
     */
    @Override
    public Student getStudentByStudentId(String studentName, String studentLast) {
        //Declaractions
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Student student = null;
        try {
            DataSource ds = new DataSource(username, password);
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT studentID, firstName, lastName "
                    + "FROM student "
                    + "WHERE student.firstName = ? AND student.lastName = ?");
            pstmt.setString(1, studentName);
            pstmt.setString(2, studentLast);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                student = new Student();
                student.setStudentID(rs.getInt("studentID"));
                student.setFirstName(rs.getString("firstName"));
                student.setLastName(rs.getString("lastName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeDatabaseStuff(con, pstmt, rs);
        }
        return student;
    }

    /**
     * Retrieves a grade by the student ID, course code, and grade.
     *
     * @param studentID the student ID.
     * @param courseCode the course code.
     * @return a Grade object or null if not found.
     */
    @Override
    public Grade getGradeByStudentID(Integer studentID, String courseCode) {
        //Declaractions
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Grade grades = new Grade();
        try {
            DataSource ds = new DataSource(username, password);
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT student_StudentID, course_CourseCode, GradeCode "
                    + "FROM grade "
                    + "WHERE student_StudentID = ? AND course_CourseCode = ?");
            pstmt.setInt(1, studentID);
            pstmt.setString(2, courseCode);
            //pstmt.setString(3, grade);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Student studentIDs = new Student();
                studentIDs.setStudentID(rs.getInt("student_StudentID"));
                grades.setCourseCode(rs.getString("course_CourseCode"));
                grades.setGrade(rs.getString("GradeCode"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeDatabaseStuff(con, pstmt, rs);
        }
        return grades;
    }

    /**
     * Retrieves a TutorCourse entry by tutor ID and course code.
     *
     * @param tutorID the tutor ID.
     * @param courseCode the course code.
     * @return a TutorCourse object or null if not found.
     */
    @Override
    public TutorCourse getTutorFromTutorTable(Integer tutorID, String courseCode) {
        //Declaractions
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        TutorCourse course = null;
        try {
            DataSource ds = new DataSource(username, password);
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT tutor_TutorID, course_CourseCode "
                    + "FROM tutorCourse "
                    + "WHERE tutor_TutorID = ? AND course_CourseCode = ?");
            pstmt.setInt(1, tutorID);
            pstmt.setString(2, courseCode);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                course = new TutorCourse();
                course.setTutorID(rs.getInt("tutor_TutorID"));
                course.setCourseCode(rs.getString("course_CourseCode"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeDatabaseStuff(con, pstmt, rs);
        }
        return course;
    }

    /**
     * Adds a new TutorCourse entry to the database.
     *
     * @param course the TutorCourse object to be added.
     */
    @Override
    public void addTutorCourse(TutorCourse course) {
        //Declaractions
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource(username, password);
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "INSERT INTO tutorCourse (tutor_TutorID, course_CourseCode) "
                    + "VALUES(?, ?)");
            pstmt.setInt(1, course.getTutorID());
            pstmt.setString(2, course.getCourseCode());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeDatabaseStuff(con, pstmt, rs);
        }
    }

    /**
     * Closes the provided database objects: Connection, PreparedStatement, and
     * ResultSet.
     *
     * @param con the Connection object.
     * @param pstmt the PreparedStatement object.
     * @param rs the ResultSet object.
     */
    public void closeDatabaseStuff(Connection con, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
