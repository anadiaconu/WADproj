/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author student
 */
public class registrationController extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        
        
        boolean valid=true;
        response.setContentType("text/html;charset=UTF-8");
        Set<String>  n=request.getParameterMap().keySet();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"./css/style.css\" type=\"text/css\"/>");
            out.println("<title>Servlet registrationController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println( "   <div id=\"content\">" );
       out.println( " <div class= \"header\">");
        out.println(    "<img src=\"./img/companyLogo.jpg\" width=\"100px\"  />");
        out.println( " <span class=\\\"header-text\\\">COMPANY NAME</span>>");
        out.print("</div>"  );
        out.print("<nav><ul><li><a href=\"#\">Home</a></li><li><a href=\"#\">Register</a></li> <li><a href=\"#\">Contact</a></li></ul></nav>");
            out.println("<h1>Servlet registrationController at " + request.getContextPath() + "</h1>");
            String name = request.getParameter("name"); 
            if(name.equals("")){
              valid=false;
               out.println("<p> Please fill in the name, by entering a first and a last name </p>");
           } 
            else out.println("<p> Name: " + name +"</p>");
            
            String username = request.getParameter("username"); 
            Checker c=new Checker();
            if(username.equals("")){
              
               out.println("<p> Please fill in the username </p>");
           } 
            else
            {
                if(c.userExists(username))
                {
                    
                    out.println("<p> User already exists </p>");
                    valid=false;
                }
                else out.println("<p> Username: " + username +"</p>");  
            }    
            
            String password = request.getParameter("password"); 
            if(password.equals("")){
              
               out.println("<p> Please fill in the password </p>");
           } 
           else
          out.println("<p> Password: " + password +"</p>");
            
          String rpassword = request.getParameter("repassword"); 
          if(rpassword.equals("")){
              
               out.println("<p> Please fill in the repeat password</p>");
           } 
           else
          out.println("<p> Repeat Password: " + rpassword +"</p>");
          if(!password.equals(rpassword)) out.println("<p> Passwords must be the same. </p>");
            String e = request.getParameter("email"); 
            if(e.equals("")){
              
               out.println("<p> Make sure the email itroduced respects the format a@a.a </p>");
           } 
           else
          out.println("<p> Email: " + e +"</p>");
          String gender=request.getParameter("gender");
          out.println("<p> Gender: "+gender+"</p>");    
          String tel=request.getParameter("telephone");
          if(tel.equals("")) out.println("<p> Please fill in the telephone number </p>");
          else out.println("<p> Telephone: "+tel+"</p>");
           String country=request.getParameter("country");
          if(tel.equals("")) out.println("<p> Please choose a country</p>");
          else out.println("<p> Country: "+country+"</p>");
          out.println("</body>");
          out.println("</html>"); 
                  if(valid)
        {
            c.insertFunction(username,password,name,e,tel,gender,country);
        }
                             if(!valid)
           { 
               request.getRequestDispatcher(request.getParameter("viewid")).forward(request, response);
               //response.sendRedirect(request.getHeader("referer"));
           }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(registrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(registrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
