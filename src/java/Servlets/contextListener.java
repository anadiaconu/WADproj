package Servlets;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServletRequest;

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
        String nav =  "        <nav align=\"center\">\n"
                    + "                    <a href=\"register.jsp\" class=\"btn btn-primary btn-sm\">Register</a>\n"
                    + "                    <a href=\"login.jsp\" class=\"btn btn-primary btn-sm\">Login</a>\n"
                    + "                    <a href=\"productView\" class=\"btn btn-primary btn-sm\">View Recipes</a>\n";
        if(loggedIn) 
            nav +=    "                    <a href=\"purchaseController\" class=\"btn btn-primary btn-sm\">My Recipes</a>\n"
                    + "                    <a href=\"purchaseController\" class=\"btn btn-primary btn-sm\">Add Recipes</a>\n"
                    + "                    <a href=\"logoutController\" class=\"btn btn-primary btn-sm\">Logout</a>\n";
            nav +=    "        </nav>\n";
        return nav;
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
