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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

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
        try {
            sce.getServletContext().setAttribute("recipes", getRecipes());
        } catch (NamingException ex) {
            Logger.getLogger(contextListener.class.getName()).log(Level.SEVERE, null, ex);
        }
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
             nav  =  "        <nav align=\"center\">\n" 
                    + "                    <a href=\"recipes.jsp\" class=\"btn btn-primary btn-sm\">View Recipes</a>\n"
                    + "                    <a href=\"myRecipesController\" class=\"btn btn-primary btn-sm\">My Recipes</a>\n"
                    + "                    <a href=\"addRecipe.jsp\" class=\"btn btn-primary btn-sm\">Add Recipes</a>\n"
                    + "                    <a href=\"logoutController\" class=\"btn btn-primary btn-sm\">Logout</a>\n"
                    + "        </nav>\n";
        else nav =  "        <nav align=\"center\">\n"
                    + "                    <a href=\"register.jsp\" class=\"btn btn-primary btn-sm\">Register</a>\n"
                    + "                    <a href=\"login.jsp\" class=\"btn btn-primary btn-sm\">Login</a>\n"
                    + "                    <a href=\"productView\" class=\"btn btn-primary btn-sm\">View Recipes</a>\n"
                    + "        </nav>\n";
        return nav;
    }
    
    public static HashMap<Integer, Recipe> getRecipes() throws NamingException
    {
        try{
            Connection con;
            DataSource ds;
            Context ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:/WADproj");
            con = ds.getConnection("a", "a");
            String sql = "SELECT * FROM recipes";
            Statement instr = con.createStatement();
            HashMap<Integer, Recipe> recipes = new HashMap<>();
            ResultSet res = instr.executeQuery(sql);
            while(res.next())
            {
                int id = res.getInt(1);
                String name = res.getString(2);
                String description = res.getString(3);
                String time = res.getString(4);
                String path = res.getString(5);
                int difficulty = res.getInt(6);
                User user;
                user = (User)res.getObject(7);
                System.out.println(name);
                recipes.put(id, new Recipe(name, description, time, path, difficulty, user));
            }
            con.close();
            return recipes;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
    
    public static HashMap<Integer, Recipe> getRecipesMap(HttpServletRequest request)
    {
        HashMap<Integer, Recipe> recipes = (HashMap)request.getServletContext().getAttribute("recipes");
        if(recipes == null) recipes = new HashMap<>();
        return recipes;
    }
    
    public static int getUserID(String user) throws NamingException
    {
        int id = -1;
        try { 
            Connection con;
            DataSource ds;
            Context ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:/WADproj");
            con = ds.getConnection("a", "a");
            Statement instr = con.createStatement();
            String sql = "SELECT id FROM users WHERE username='"+user+"'";
            System.out.println(sql);
            ResultSet rs = instr.executeQuery(sql);
            rs.next();
            id = rs.getInt(1);
            con.close();
        } catch (SQLException ex) {
            id = -1;
        }
        return id;
    }
    
    public static HashMap<Integer, Recipe> getAllUserRecipes(String user, HttpServletRequest request) throws NamingException
    {
        try {
            HashMap<Integer, Recipe> recipes = getRecipesMap(request);
            int uid = getUserID(user);
            Connection con;
            DataSource ds;
            Context ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:/WADproj");
            con = ds.getConnection("a", "a");
            Statement instr = con.createStatement();
            System.out.println("user "+uid);
            String sql = "SELECT id, date, totalPrice FROM purchases WHERE user="+uid;
            ResultSet res = instr.executeQuery(sql);
            System.out.println("bla1");
            while(res.next())
            {
                int id = res.getInt(1);
                String name = res.getString(2);
                String description = res.getString(3);
                String time = res.getString(4);
                String path = res.getString(5);
                int difficulty = res.getInt(6);
                User owner = (User)res.getObject(7);
                System.out.println(name);
                recipes.put(id, new Recipe(name, description, time, path, difficulty, owner));
            }            
            con.close();
            return recipes;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
