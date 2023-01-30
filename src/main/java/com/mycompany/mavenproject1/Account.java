/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import static com.mycompany.mavenproject1.home.jLabel13;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sefaw
 */
public class Account {
    ResultSet rs = null;
    Statement st;
    String  id_user;                  
    String url = "jdbc:mysql://localhost:3306/atm";
    String usernameserver = "root";
    String passwordserver = "1234";
    
    public String getamount(String id){
        
         try {
             id_user = id;
       //jLabel14.setText(Integer.toString(pinnumber));
		Connection con = DriverManager.getConnection(url, usernameserver, passwordserver);
            if (con != null) {
			System.out.println("Database Connected successfully");
		} else {
			System.out.println("Database Connection failed");
		}
            
            
            
            
                       PreparedStatement st = (PreparedStatement) con.prepareStatement("select amount from account where client_id=? ");
                       st.setString(1, id_user);

                       ResultSet rs = st.executeQuery();

                     if (rs.next()) 
                    { 
                        return rs.getString("amount");
                    }else{
                         return "0";
                     }

        }catch(SQLException ex){
                 Logger.getLogger(Account.class.getName()).log(Level.SEVERE,null,ex);
             }
        
        return "";
}      
    public String checkamount(String id, int value){
        
         try {
             id_user = id;
       //jLabel14.setText(Integer.toString(pinnumber));
       
		Connection con = DriverManager.getConnection(url, usernameserver, passwordserver);
                       PreparedStatement st = (PreparedStatement) con.prepareStatement("select amount from account where client_id=? ");
                       st.setString(1, id_user);

                       ResultSet rs = st.executeQuery();

                     if (rs.next()) 
                    { 
                         float am = Float.parseFloat(rs.getString("amount")) - value;
                         withamount(id_user,am);
                         if(am >=0){
                             return Float.toString(am);
                         }else{
                             return "0";
                         }
                    }else{
                         return "0";
                     }

        }catch(SQLException ex){
                 Logger.getLogger(Account.class.getName()).log(Level.SEVERE,null,ex);
             }
        
        return "";
}
    
     public String amount(String id, int value){
        
         try {
             id_user = id;
       //jLabel14.setText(Integer.toString(pinnumber));
       
		Connection con = DriverManager.getConnection(url, usernameserver, passwordserver);
                       PreparedStatement st = (PreparedStatement) con.prepareStatement("select amount from account where client_id=? ");
                       st.setString(1, id_user);

                       ResultSet rs = st.executeQuery();

                     if (rs.next()) 
                    { 
                         float am = Float.parseFloat(rs.getString("amount")) - value;
                         if(am >=0){
                             return Float.toString(am);
                         }else{
                             return "0";
                         }
                    }else{
                         return "0";
                     }

        }catch(SQLException ex){
                 Logger.getLogger(Account.class.getName()).log(Level.SEVERE,null,ex);
             }
        
        return "";
}
    public void withamount(String id,Float amount){
        
         try {
             id_user=id;
             //jLabel14.setText(Integer.toString(pinnumber));
		Connection con = DriverManager.getConnection(url, usernameserver, passwordserver);
                PreparedStatement st = (PreparedStatement) con.prepareStatement("update account set amount=? where client_id=? ");
                st.setString(1, Float.toString(amount));
                st.setString(2, id_user);
                st.executeUpdate();
              }catch(Exception ex){
                 Logger.getLogger(Account.class.getName()).log(Level.SEVERE,null,ex);
              }
        
}
    
}
