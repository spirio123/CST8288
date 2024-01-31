/**
 * File name: TutorsEnrolled.java
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Date: April, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package viewlayer;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businesslayer.TutorsBusinessLogic;
import transferobjects.*;
import java.util.List;

/**
 * This class is a servlet that generates an HTML page displaying the list of
 * enrolled tutors. It processes requests for both HTTP GET and POST methods and
 * communicates with the TutorsBusinessLogic layer to fetch the required data.
 */
public class TutorsEnrolled extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"tutor.css\">");
            out.println("<title>Tutors Summary View</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<header>");
            out.println("<h1>Tutors available</h1>");
            out.println("</header>");
            out.println("<main>");
            //Thae parameters for the username and password
            String username = (String) request.getParameter("username");
            String password = (String) request.getParameter("password");
            TutorsBusinessLogic logic = new TutorsBusinessLogic(username, password);
            //The parameters for the first name, last name and course
            String firstName = (String) request.getParameter("firstName");
            String lastName = (String) request.getParameter("lastName");
            String courseCode = (String) request.getParameter("course");
            logic.Mainrun(firstName, lastName, courseCode);
            //The required error message
            out.println("<p>" + logic.message + "</p>");
            List<Tutor> tutors = logic.getAllTutors();
            //The table with all of the tutors
            out.println("<table border=\"1\">");
            out.println("<tr>");
            out.println("<td>TutorID</td>");
            out.println("<td>First Name</td>");
            out.println("<td>Last Name</td>");
            out.println("</tr>");
            for (Tutor tutor : tutors) {
                out.printf("<tr><td>%d</td><td>%s</td><td>%s</td></tr>",
                        tutor.getTutorID(), tutor.getFirstName(), tutor.getLastName());
            }
            out.println("</table>");
            out.println("</main>");
            out.println("<footer>");
            out.println("<p>Author: Ollie Savill</p>");
            out.println("<p>Date completed: April 6th, 2023</p>");
            out.println("</footer>");
            out.println("</body>");
            out.println("</html>");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
