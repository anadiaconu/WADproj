
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */
public class Checker {
    
    int x;
    
    public Checker()
    {
     x=0;   
    }
    public static String getHash(String password) {
MessageDigest digest=null;
try {
digest = MessageDigest.getInstance("SHA-1");
} catch (NoSuchAlgorithmException ex) {
ex.printStackTrace();
}
digest.reset();
try {
digest.update(password.getBytes("UTF-8"));
} catch (UnsupportedEncodingException ex) {
ex.printStackTrace();
}
return new BigInteger(1, digest.digest()).toString(16);
}
    public static void insertFunction(String username, String password,String name,String email, String tel, String gender, String country) throws SQLException
   {
       Connection con=null;
       String url = "jdbc:derby://localhost:1527/LAB2db";
       try { 
       con = DriverManager.getConnection(url, "a", "a");
       con.setAutoCommit(false);    
       String sql1 = "INSERT INTO A.users VALUES(?,?,?,?,?,?,?)";
      PreparedStatement preparedStmt = con.prepareStatement(sql1);
      preparedStmt.setString (1,username);
      preparedStmt.setString (2, getHash(password));
      preparedStmt.setString   (3, name);
      preparedStmt.setString (4, email);
      preparedStmt.setString (5, tel);
      preparedStmt.setString   (6, gender);
      preparedStmt.setString (7, country);
      preparedStmt.executeUpdate();       
       con.commit();
       
   }
       catch(SQLException e)
       {
           e.printStackTrace();
           con.rollback();
       }
   }

    public static boolean userExists(String username) throws SQLException
    {
        
        String url="jdbc:derby://localhost:1527/LAB2db";
        Connection con= DriverManager.getConnection(url,"a","a");
        Statement instr=con.createStatement();
        String sql="SELECT * FROM A.users";
        ResultSet rs=instr.executeQuery(sql);
        while(rs.next())
        {
            String s=rs.getString(1);
            System.out.println(s);
            if( !username.trim().equals(s.trim()) ){
                System.out.println("nope");
            } else {
                 System.out.println("found it");
                return true;
            }
        }
        return false;
    }
    
}
