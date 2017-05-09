/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Models.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

/**
 *
 * @author Ana
 */
@WebServlet(name = "registrationController")
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
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String maillist = request.getParameter("maillist");
        
        int gen = 0;
        System.out.println(gender);
        if("male".equals(gender)) gen=0;
        else if("female".equals(gender)) gen=1;
        
        String mail = "0";
        if(maillist != null) mail = "1";
        
        String password = request.getParameter("password");
        
        if(userExists(username)!=null){
            request.setAttribute("usernameerror", "Username already in use!");
            request.getRequestDispatcher("Register.jsp");
            return;
        }
        User u = new User (name, username, password, email, gen);
        addUser(u);
        
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
        @PersistenceContext (unitName = "WADprojPU")
        private EntityManager em;
        
        @Resource
        private UserTransaction userT;
    
        public boolean addUser(User u){
         try {
            userT.begin();
            em.getTransaction().begin();
            em.persist(u);
            em.flush();
            em.getTransaction().commit();
            userT.commit();
        } catch (Exception ex) {
            return false;
        }
        return true;   
        }
        
        public User userExists (String user){
            Query q = em.createQuery("SELECT u FROM User u WHERE u.username='"+user+"'");
            if(q.getResultList().isEmpty())
                return null;
            return (User)q.getResultList().get(0);
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
