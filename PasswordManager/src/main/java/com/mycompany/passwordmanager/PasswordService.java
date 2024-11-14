/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.passwordmanager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.HashMap;
import java.util.Scanner;

public class PasswordService {

    // Using a static map to store users and their hashed passwords
    private static final HashMap<String, String> users = new HashMap<>();
    private static SecretKey key;
    private static Cipher ci;
    private static String website, password, name, email;

    public PasswordService(String website, String password, String name, String email) {
        PasswordService.website = website;
        PasswordService.password = password;
        PasswordService.name = name;
        PasswordService.email = email;
    }
    
    public PasswordService() throws Exception {
        // Generate a Secret Key for AES encryption
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        key = keyGen.generateKey();

        // Initialize Cipher
        ci = Cipher.getInstance("AES");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Main loop for the CLI
        while (running) {
            System.out.println("1. Enter website to encrypt name, email and password");
            System.out.println("2. Retrieve password");
            System.out.println("3. Decrypt password");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    savePassword(scanner);
                    break;
                case 2:
                    retrievePassword(scanner);
                    break;
                case 3:
                    decryptPassword(scanner);
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

        scanner.close();
    }

    private static void savePassword(Scanner scanner) {
        System.out.println("Enter website: ");
        website = scanner.nextLine();

        System.out.println("Enter password: ");
        password = scanner.nextLine();

        String encryptedText = encryptPassword(password);

        users.put(website, encryptedText);

        System.out.println("Details successfully saved.");
    }

    private static void retrievePassword(Scanner scanner) {
        System.out.println("Enter website: ");
        website = scanner.nextLine();

        if (users.containsKey(website)) {
            System.out.println("Encrypted password: " + users.get(website));
        } else {
            System.out.println("Invalid website.");
        }
    }
    
    private static void decryptPassword(Scanner scanner) {
        System.out.println("Enter website: ");
        website = scanner.nextLine();

        String encryptedText = users.get(website);
        if (encryptedText != null) {
            String decryptedText = decryptPassword(encryptedText);
            System.out.println("Decrypted password: " + decryptedText);
        } else {
            System.out.println("Invalid website.");
        }
    }

    private static String encryptPassword(String plainText) {
        try {
            ci.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainTextByte = plainText.getBytes();
            byte[] encryptedByte = ci.doFinal(plainTextByte);
            return Base64.getEncoder().encodeToString(encryptedByte);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String decryptPassword(String encryptedText) {
        try {
            byte[] encryptedTextByte = Base64.getDecoder().decode(encryptedText);
            ci.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptedByte = ci.doFinal(encryptedTextByte);
            return new String(decryptedByte);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean deleteWebsite(String website) {
        if (users.containsKey(website)) {
            users.remove(website);
            return true; // Website deleted successfully
        } else {
            return false; // Website not found
        }
    }

    public static boolean updateWebsite(String website, String newName, String newEmail, String newPassword) {
        if (users.containsKey(website)) {
            String encryptedPassword = encryptPassword(newPassword);
            // Update user information (here only password update is shown as an example)
            users.put(website, encryptedPassword);
            return true; // Update successful
        } else {
            return false; // Website not found
        }
    }
}
