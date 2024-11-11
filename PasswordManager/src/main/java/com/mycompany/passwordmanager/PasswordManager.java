/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.passwordmanager;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author paulp
 */
public class PasswordManager {

    public static void main(String[] args) { 
        private static final
                Map<String, String> users = new HashMap<>();
        
        public static void main(String[] args){
            Scanner scanner = new Scanner (System.in);
            boolean running = true;
            
            while (running){
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.println("Ennter your choice");
                
                int choice = scanner.nextInt();
                
                scanner.nextLine();
                
                switch (choice){
                    case 1:
                        registerUser(scanner);
                        
                        break;
                    case 2:
                        loginUser(scanner);
                        break;
                    case 3 :
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice , choose again");
                    
                }
                
                
                
                
            }
        }
        private static void registerUser(Scanner scanner){
            System.out.print("Enter username:");
            String username = scanner.nextLine();
            
            System.out.print("Enter password:");
            String password  = scanner.nextLie();
            
            String hashedPassword = hashedPassword(password);
            users.put(username, hashedPassword);
            
            System.out.print("User is registered succesfully");
            
        }
            private static void loginuser(Scanner scanner ){
                System.out.print("Enter username:");
                String username = scanner.nextLine();
                
                System.out.print("Enter password:");
                String password = scanner.nextLine();
                
                String hashedPassword = new hashedPassword(password);
                if(users.containsKey(username) && users.get(username).equals(hahsedPassword)){
                    System.out.println("Login succesful.");
                }else{
                    System.out.println("Invalid username or password.");
                    
                }
                
            }
            private static String hashPassword(String password){
                try{
                    MessageDigest md = MessageDigest.getInstance("SHA- 256");
                    byte[]
                            hashedBytes = md.Digest(password.getBytes());
                    StringBuilder sb = new StringBuilder();
                    for(byte b : hashedBytes){
                        sb.append(String.format("%02x", b));
                    }
                        return sb.toString();
                }catch (NoSuchAlgorithmException e){
                    e.printStackTrace();
                    return null;
                    
                    
                    }
                }
            }
    
}
