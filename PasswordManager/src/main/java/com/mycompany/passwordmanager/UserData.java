/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.passwordmanager;

/**
 *
 * @author HP
 */
public class UserData {
    private String name;
    private String email;
    private String hashedPassword;
    
    public UserData(String name, String email, String hahsedPassword){
        this.name = name;
        this.email = email;
        this.hashedPassword = hashedPassword;
        
        
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
      
    }
    public String hashedPassword(){
        return hashedPassword;
        
        
    }
}
