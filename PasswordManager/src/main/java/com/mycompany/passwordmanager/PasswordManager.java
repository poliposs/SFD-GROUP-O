/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.passwordmanager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Scanner;

public class PasswordManager {

    // Stores users' usernames and hashed passwords
    private static final HashMap<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Choose an option:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    registerUser(scanner);
                    break;
                case 2:
                    if (loginUser(scanner)) {
                        // After login, instantiate the PasswordService class
                        try {
                            PasswordService passwordService = new PasswordService();
                            passwordService.main(new String[0]); // Call PasswordService's menu
                        } catch (Exception e) {
                            System.out.println("Error initializing password manager.");
                        }
                    }
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    /**
     * Method to register a new user by taking username and password,
     * hashing the password, and storing the result.
     */
    private static void registerUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        // Check if username is already taken
        if (users.containsKey(username)) {
            System.out.println("Username already exists. Please choose another one.");
            return;
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Hash the password
        String hashedPassword = hashPassword(password);

        // Store username and hashed password
        users.put(username, hashedPassword);
        System.out.println("Registration successful!");
    }

    /**
     * Method to log in an existing user by verifying the password hash.
     * Returns true if login is successful, false otherwise.
     */
    private static boolean loginUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        // Check if the user exists
        if (!users.containsKey(username)) {
            System.out.println("Username not found. Please register first.");
            return false;
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Hash the entered password
        String hashedPassword = hashPassword(password);

        // Check if hashed password matches stored hash
        if (users.get(username).equals(hashedPassword)) {
            System.out.println("Login successful! Access granted.");
            return true;
        } else {
            System.out.println("Incorrect password. Please try again.");
            return false;
        }
    }

    /**
     * Method to hash a password using SHA-256.
     */
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

