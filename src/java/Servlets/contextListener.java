package Servlets;


import Models.Recipe;
import Models.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import javax.transaction.UserTransaction;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Web application lifecycle listener.
 *
 * @author Ana
 */

public class contextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /*try {
            sce.getServletContext().setAttribute("recipes", getRecipes());
        } catch (NamingException ex) {
            Logger.getLogger(contextListener.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        sce.getServletContext().setAttribute("nav", getNav(false));
    
    }
    public static void updateNav(HttpServletRequest request){
        boolean loggedIn = false;
        if (request.getSession().getAttribute("user") != null) {
            loggedIn = true;
        }
        request.getServletContext().setAttribute("nav", getNav(loggedIn));
    }

    private static String getNav(boolean loggedIn)
    {
        String nav;
        if(loggedIn) 
             nav  =  "        <nav class=\"text-center\">\n" 
                    + "                    <a href=\"recipesController\" class=\"btn btn-primary btn-sm\">View Recipes</a>\n"
                    + "                    <a href=\"myRecipesController\" class=\"btn btn-primary btn-sm\">My Recipes</a>\n"
                    + "                    <a href=\"addRecipe.jsp\" class=\"btn btn-primary btn-sm\">Add Recipes</a>\n"
                    + "                    <a href=\"logoutController\" class=\"btn btn-danger btn-sm\">Logout</a>\n"
                    + "        </nav>\n";
        else nav =  "        <nav class=\"text-center\">\n"
                    + "                    <a href=\"login.jsp\" class=\"btn btn-success btn-sm\">Login</a>\n"
		    + "                    <a href=\"Register.jsp\" class=\"btn btn-info btn-sm\">Register</a>\n"
                    + "                    <a href=\"recipesController\" class=\"btn btn-primary btn-sm\">View Recipes</a>\n"
                    + "        </nav>\n";
        return nav;
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
