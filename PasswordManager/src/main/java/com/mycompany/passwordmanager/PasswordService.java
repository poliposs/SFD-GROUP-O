/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.passwordmanager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Scanner;

public class PasswordService {

    // Using a static map to store users and their hashed passwords
    private static final HashMap<String, String> users = new HashMap<>();
    private SecretKey key;
    
        public PasswordService() {
        try {
            // Generate a Secret Key for AES encryption
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            this.key = keyGen.generateKey();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Main loop for the CLI
        while (running) {
            System.out.println("1. Register a website and password");
            System.out.println("2. Retrieve password");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    savePasword(scanner);
                    break;
                case 2:
                    retrievePassword(scanner);
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

        scanner.close();
    }

    private static void savePasword(Scanner scanner){
        System.out.print("Enter website: ");
        String website = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        String hashedPassword = hashPassword(password);
        
        
        users.put(website, hashedPassword);
        
        System.out.println("User registered successfully.");
    }

    private static void retrievePassword(Scanner scanner) {
        System.out.print("Enter website: ");
        String website = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        String hashedPassword = hashPassword(password);

        if (users.containsKey(website) && users.get(website).equals(hashedPassword)) {
            System.out.println("Login successful.");
            System.out.println("Password: "+ password + "\n" + "Hashed password: " + hashedPassword);
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
