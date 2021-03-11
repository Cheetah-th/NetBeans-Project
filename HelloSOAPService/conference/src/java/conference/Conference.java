/*
 * Conference.java
 *
 * Created on 28 กันยายน 2550, 18:33 น.
 */

package conference;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author user
 * @version
 */
public class Conference extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String status = request.getParameter("status");
        final int orgFee = 500;
        if(status != null && status.equals("student") )
	{
            int studentFee = orgFee / 2;
            request.setAttribute("regFee", "" + studentFee);
        }
	else if(status != null && status.equals("faculty") )
	{
            int facultyFee = orgFee;
            request.setAttribute("regFee", "" + facultyFee);
        }
        request.getRequestDispatcher("/output.jsp").forward(request, response);
        return;
     }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
