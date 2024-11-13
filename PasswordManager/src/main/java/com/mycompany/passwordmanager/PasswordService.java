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
        this.website = website;
        this.password = password;
        this.name = name;
        this.email = email;
    }
    
    public PasswordService() throws Exception {
        try {
            // Generate a Secret Key for AES encryption
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            this.key = keyGen.generateKey();

            ci = Cipher.getInstance("AES"); //SunJCE provider AES algorithm, mode(optional) and padding schema(optional)  

            String plainText = "AES Symmetric Encryption Decryption";
            System.out.println("Plain Text Before Encryption: " + plainText);

            String encryptedText = encrypt(plainText, key);
            System.out.println("Encrypted Text After Encryption: " + encryptedText);

            String decryptedText = decrypt(encryptedText, key);
            System.out.println("Decrypted Text After Decryption: " + decryptedText);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String encrypt = null;
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
                    decryptPassword(encrypt, scanner);
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

        System.out.println("Enter Full name: ");
        name = scanner.nextLine();

        System.out.println("Enter email: ");
        email = scanner.nextLine();

        System.out.println("Enter password: ");
        password = scanner.nextLine();

        String encryptedText = encryptPassword(password);

        users.put(website, encryptedText);

        System.out.println("Details successfully saved." + key);
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
    
    private static void deletePassword(Scanner scanner){
        System.out.print("Enter website to delete: ");
        String deleteWebsite = scanner.nextLine();     
        
        if(users.containsKey(website)){
            users.remove(deleteWebsite);
            System.out.println("Password for " + deleteWebsite + " has been deleted");   
        }else{
            System.out.println("Deletion successful");
        }
    }
    
    private static void updatePassword(Scanner scanner) {
        System.out.print("Enter website to update: ");
        String websiteToUpdate = scanner.nextLine();

        // Check if the website exists in the storage
        if (users.containsKey(websiteToUpdate)) {
            System.out.print("Enter new password: ");
            String newPassword = scanner.nextLine();

            // Hash the new password
            String hashedNewPassword = hashPassword(newPassword);

            // Update the password in the map
            users.put(websiteToUpdate, hashedNewPassword);

            System.out.println("Password for " + websiteToUpdate + " has been updated successfully.");
        } else {
            System.out.println("No password found for the given website.");
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
}
