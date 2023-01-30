/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.Calendar;
import java.util.Locale;  
import java.time.LocalDateTime;   
import java.time.format.DateTimeFormatter;  
import javax.swing.JOptionPane;


/**
 *
 * @author sefaw
 */
public class Machine {
      ResultSet rs = null;
      
    Statement st;
    String  id_user;                  
    String url = "jdbc:mysql://localhost:3306/atm";
    String usernameserver = "root";
    String passwordserver = "1234";
    public boolean checkamount(String id, int value){
        
         try {
              LocalDateTime now = LocalDateTime.now();
              DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
             id_user = id;
       //jLabel14.setText(Integer.toString(pinnumber));
		Connection con = DriverManager.getConnection(url, usernameserver, passwordserver);
                       PreparedStatement st = (PreparedStatement) con.prepareStatement("select sum(amount) as amount from machine_act where id_client=? and id_machine=1 and date=?");
                       st.setString(1, id_user);
                       st.setString(2, dtf.format(now));
                       ResultSet rs = st.executeQuery();
                       String amount ;
                     if (rs.next()) 
                    { 
                        
                                             //   amount = rs.getString("amount");
                    Integer value1 = rs.getInt("amount");
                    if(value1 == 0){
                                                 return true;
                    }
                        
                        else{
                                 if( 500> Float.parseFloat(rs.getString("amount"))+value)
                                 {

                                                             return true;
                                 }
                                 else{

                                     return false;
                                 }
                         
                    }
         }
                        

        
         }catch(SQLException ex){
                 Logger.getLogger(Machine.class.getName()).log(Level.SEVERE,null,ex);
             }  return false;
}
    public void insertwithaction(String id_client,float amount){
        String amo = Float.toString(amount);
         try {
             
             id_user = id_client;
           LocalDateTime now = LocalDateTime.now();
              DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  

//jLabel14.setText(Integer.toString(pinnumber));
		Connection con = DriverManager.getConnection(url, usernameserver, passwordserver);
                       PreparedStatement st = (PreparedStatement) con.prepareStatement("insert into  machine_act (id_client , id_machine,date,amount) values (?,?,?,?)");
                       st.setString(1, id_user);
                       st.setString(2, "1");
                       st.setString(3, dtf.format(now) );
                       st.setFloat(4, amount);
                       
                      st.execute();

                         con.close();
                       }
               
            
                       catch (Exception e)
                       {
                         System.err.println("Got an exception!");
                         System.err.println(e.getMessage());
                       }
}
}
