package com.mycompany.passwordmanager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Scanner;

public class PasswordManager {

    // Stores users' usernames and hashed passwords
//    private static final HashMap<String, String> users = new HashMap<>();

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        boolean running = true;
//        
        RegisterGUI myGUI = new RegisterGUI();
        myGUI.setVisible(true);
        
        PasswordGUI GUI = new PasswordGUI();
        GUI.setVisible(true);
        
//        while (running) {
//            System.out.println("Choose an option:");
//            System.out.println("1. Register");
//            System.out.println("2. Login");
//            System.out.println("3. Exit");
//
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // Consume newline
//
//            switch (choice) {
//                case 1:
//                    registerUser(scanner);
//                    break;
//                case 2:
//                    if (loginUser(scanner)) {
//                        // After login, instantiate and call the menu of PasswordService
//                        PasswordService passwordService = new PasswordService();
//                        passwordService.menu(scanner); // Open PasswordService's menu
//                    }
//                    break;
//                case 3:
//                    running = false;
//                    System.out.println("Exiting...");
//                    break;
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//        }
//        //scanner.close(); // Removed scanner.close() to prevent closing issues
//    }
//
//    private static void registerUser(Scanner scanner) {
//        System.out.print("Enter username: ");
//        String username = scanner.nextLine();
//
//        if (users.containsKey(username)) {
//            System.out.println("Username already exists. Please choose another one.");
//            return;
//        }
//
//        System.out.print("Enter password: ");
//        String password = scanner.nextLine();
//
//        String hashedPassword = hashPassword(password);
//        users.put(username, hashedPassword);
//        System.out.println("Registration successful!");
//    }
//
//    private static boolean loginUser(Scanner scanner) {
//        System.out.print("Enter username: ");
//        String username = scanner.nextLine();
//
//        if (!users.containsKey(username)) {
//            System.out.println("Username not found. Please register first.");
//            return false;
//        }
//
//        System.out.print("Enter password: ");
//        String password = scanner.nextLine();
//
//        String hashedPassword = hashPassword(password);
//
//        if (users.get(username).equals(hashedPassword)) {
//            System.out.println("Login successful! Access granted.");
//            return true;
//        } else {
//            System.out.println("Incorrect password. Please try again.");
//            return false;
//        }
//    }
//
//    private static String hashPassword(String password) {
//        try {
//            MessageDigest md = MessageDigest.getInstance("SHA-256");
//            byte[] hashedBytes = md.digest(password.getBytes());
//            StringBuilder sb = new StringBuilder();
//            for (byte b : hashedBytes) {
//                sb.append(String.format("%02x", b));
//            }
//            return sb.toString();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//            return null;
//        }
    }
}
