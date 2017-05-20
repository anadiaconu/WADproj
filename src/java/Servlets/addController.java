/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Models.Recipe;
import Models.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
@WebServlet(name = "addController")
public class addController extends HttpServlet {

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
       
               
        String name = request.getParameter("Rname");
        String description = request.getParameter("description");
        String time = request.getParameter("time");
        String path = request.getParameter("path");
        String difficulty = request.getParameter("difficulty");
        User user = (User)request.getSession().getAttribute("user");
        
        int diff = 0;
        if("easy".equals(difficulty)) diff = 0;
        else if("difficult".equals(difficulty)) diff = 1;
        
        Recipe r = new Recipe (name, description, time, path, diff, user);
        addRecipe(r);
        request.getRequestDispatcher("recipesView").forward(request, response);
        }
    
    @PersistenceContext (unitName = "WADprojPU")
    private EntityManager em;
        
    @Resource
    private UserTransaction recipeT;
        
    public boolean addRecipe(Recipe r){
        try {
            recipeT.begin();
            em.getTransaction().begin();
            em.persist(r);
            em.flush();
            em.getTransaction().commit();
            recipeT.commit();
        } catch (Exception ex) {
            return false;
        }
        return true;   
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
