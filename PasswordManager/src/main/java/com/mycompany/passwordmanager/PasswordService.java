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

    static {
        try {
            // Initialize Cipher in static block
            ci = Cipher.getInstance("AES");
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            key = keyGen.generateKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void menu(Scanner scanner) {
        String encrypt = null;
        boolean running = true;

        // Main loop for the CLI
        while (running) {
            System.out.println("1. Enter website to encrypt name, email, and password");
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
                    try {
                        retrievePassword(scanner);
                    } catch (Exception e) {
                        System.out.println("Error retrieving password: " + e.getMessage());
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        decryptPassword(encrypt, scanner);
                    } catch (Exception e) {
                        System.out.println("Error decrypting password: " + e.getMessage());
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }


    private static void savePassword(Scanner scanner) {
        System.out.println("Enter website: ");
        website = scanner.nextLine();

        System.out.println("Enter Full name: ");
        name = scanner.nextLine();

        System.out.println("Enter email: ");
        email = scanner.nextLine();

        System.out.println("Enter password: ");
        password = scanner.nextLine();

        String encryptedText = encryptPassword(password);

        users.put(website, encryptedText);
        
//        UserData userData = new UserData(name, email, hashedPassword);
//        users.put(website, encryptedText);

        System.out.println("Details successfully saved.");
    }

    private static void retrievePassword(Scanner scanner) throws Exception {
        System.out.println("Enter website: ");
        website = scanner.nextLine();

        String encryption = encryptPassword(password);

        if (users.containsKey(website) && users.get(website).equals(encryption)) {
            System.out.println("Verification complete.");
            System.out.println("Encrypted password: " + encryption);
        } else {
            System.out.println("Invalid website.");
        }
    }

    public static String encryptPassword(String plainText) {
        try {
            if (ci == null) {
                ci = Cipher.getInstance("AES");
            }
            if (key == null) {
                KeyGenerator keyGen = KeyGenerator.getInstance("AES");
                keyGen.init(128);
                key = keyGen.generateKey();
            }
            ci.init(Cipher.ENCRYPT_MODE, key);

            byte[] plainTextByte = plainText.getBytes();
            byte[] encryptedByte = ci.doFinal(plainTextByte);
            return Base64.getEncoder().encodeToString(encryptedByte);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decryptPassword(String encryptedText, Scanner scanner) throws Exception {
        System.out.println("Enter website: ");
        website = scanner.nextLine();

        if (encryptedText == null) {
            encryptedText = users.get(website);
            if (encryptedText == null) {
                System.out.println("Invalid website key.");
                return null;
            }
        }

        Base64.Decoder decoder = Base64.getDecoder();
        byte[] encryptedTextByte = decoder.decode(encryptedText);
        ci.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedByte = ci.doFinal(encryptedTextByte);
        String decryptedText = new String(decryptedByte);
        System.out.println("Here is your password: " + decryptedText);
        return decryptedText;
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
        public static boolean deleteWebsite(String website){
            if (users.containsKey(website)){
                users.remove(website);
                return true;// return if 'website' is deleted succesfully
                
            }else{
                return false;//return if 'website' isnt found 
            }
        }
//            public static boolean updateWebsite(String website, String name,String newEmail,String newPassword){
//                if(users.containsKey(website)){
//                    String hashedPassword = hashedPassword(newPassword);//hash the new password 
//                    UserData updateData = new UserData(newName, newEmail, hashedPassword);
//                    users.put(website, updateData);//update the entry with new data
//                    return true;//succesful
//                    
//                }else{
//                    return false; //website not found 
//                }
//            }
        }
 

