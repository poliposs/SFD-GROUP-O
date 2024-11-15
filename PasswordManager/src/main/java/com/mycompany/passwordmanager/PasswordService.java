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
    public static final HashMap<String, String> users = new HashMap<>();
    private static SecretKey key;
    private static Cipher ci;
    private static String website, password, encryption, decryptedText, email, encryptedText, plainText;

    public PasswordService(String website, String password, String encryption, String decryptedText, String email) {
        this.website = website;
        this.password = password;
        this.encryption = encryption;
        this.decryptedText = decryptedText;
        this.email = email;
        this.encryptedText = encryptedText;
        this.plainText = plainText;
    }

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

//    public void menu(Scanner scanner) {
//        String encrypt = null;
//        boolean running = true;
//
//        // Main loop for the CLI
//        while (running) {
//            System.out.println("1. Enter website to encrypt name, email, and password");
//            System.out.println("2. Retrieve password");
//            System.out.println("3. Decrypt password");
//            System.out.println("4. Exit");
//            System.out.println("Enter your choice: ");
//
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // Consume newline
//
//            switch (choice) {
////                case 1:
////                    savePassword();
////                    break;
//                case 2:
//                    try {
//                    retrievePassword();
//                } catch (Exception e) {
//                    System.out.println("Error retrieving password: " + e.getMessage());
//                    e.printStackTrace();
//                }
//                break;
//                case 3:
//                    try {
//                    decryptPassword(encrypt);
//                } catch (Exception e) {
//                    System.out.println("Error decrypting password: " + e.getMessage());
//                    e.printStackTrace();
//                }
//                break;
//                case 4:
//                    running = false;
//                    break;
//                default:
//                    System.out.println("Invalid choice, please try again.");
//            }
//        }
//    }
//    public static String savePassword() {
//        System.out.println("Enter website: ");
//
//        System.out.println("Enter Full name: ");
//
//        System.out.println("Enter email: ");
//
//        System.out.println("Enter password: ");
//
//        String encryptedText = encryptPassword(password);
//
//        users.put(website, encryptedText);
//
////        UserData userData = new UserData(name, email, hashedPassword);
////        users.put(website, encryptedText);
//        System.out.println("Details successfully saved.");
//    }
    public static String retrievePassword() throws Exception {
        System.out.println("Enter website: ");

        encryption = encryptPassword(password);

        if (users.containsKey(website) && users.get(website).equals(encryption)) {
            System.out.println("Verification complete.");
            System.out.println("Encrypted password: " + encryption);
        } else {
            System.out.println("Invalid website.");
        }
        return encryption;
    }

    public static String encryptPassword(String plainText) {
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

    public static String decryptPassword(String encryptedText) throws Exception {
        try {
            byte[] encryptedTextByte = Base64.getDecoder().decode(encryptedText);
            ci.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptedByte = ci.doFinal(encryptedTextByte);
            return new String(decryptedByte);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
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

    public static String getWebsite() {
        return website;
    }

    public static void setWebsite(String website) {
        PasswordService.website = website;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        PasswordService.password = password;
    }

    public static String getEncryption() {
        return encryption;
    }

    public static void setEncryption(String encryption) {
        PasswordService.encryption = encryption;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        PasswordService.email = email;
    }

    public static String decryptedText() {
        return email;
    }

    public static void setDecryptedText(String decryptedText) {
        PasswordService.decryptedText = decryptedText;
    }

    public static String getEncryptedText() {
        return encryptedText;
    }

    public static void setEncryptedText(String encryptedText) {
        PasswordService.encryptedText = encryptedText;
    }

    public static String getPlainText() {
        return plainText;
    }

    public static void setPlainText(String plainText) {
        PasswordService.plainText = plainText;
    }

}
