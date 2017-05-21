/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Models.Recipe;
import Models.User;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Random;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.transaction.UserTransaction;

/**
 *
 * @author Ana
 */
@WebServlet(name = "addController")
@MultipartConfig
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
        String ingredients = request.getParameter("ingredients");
        String time = request.getParameter("time");
        String difficulty = request.getParameter("difficulty");
        User user = (User)request.getSession().getAttribute("user");
        
        int diff = 0;
        if("easy".equals(difficulty)) diff = 0;
        else if("difficult".equals(difficulty)) diff = 1;
        
        Part filePart = request.getPart("file");
        if(filePart == null) {
            request.getRequestDispatcher("addRecipe.jsp").forward(request, response);
            return;
        }
        OutputStream out = null;
        InputStream filecontent = null;
        try {
            String path = "img" + File.separator + name
                    + time + user.getUsername() + ".jpg";
            out = new FileOutputStream(new File(request.getServletContext().getRealPath(File.separator + path)));
            filecontent = filePart.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            
            Recipe r = new Recipe (name, description,ingredients, time, path, diff, user);
            addRecipe(r);
            request.getRequestDispatcher("myRecipesController").forward(request, response);
        } catch (FileNotFoundException fne) {
            System.out.println(fne.getMessage());
        } finally {
            if (out != null) { out.close(); }
            if (filecontent != null) { filecontent.close(); }
        }
        }
    
    @PersistenceContext (unitName = "WADprojPU")
    private EntityManager em;
        
    @Resource
    private UserTransaction recipeT;
        
    public boolean addRecipe(Recipe r){
        try {
            recipeT.begin();
            em.getTransaction().begin();
            em.merge(r);
            r.getOwner().getRecipes().add(r);
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
