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
    static Cipher ci;
    private static String website, password, name, email;

    public PasswordService(String website, String password) {
        this.website = website;
        this.password = password;
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

    private static void savePasword(Scanner scanner) {
        System.out.print("Enter website: ");
        website = scanner.nextLine();

        System.out.print("Enter password: ");
        password = scanner.nextLine();

        String hashedPassword = hashPassword(password);

        users.put(website, hashedPassword);

        System.out.println("User registered successfully.");
    }

    private static void retrievePassword(Scanner scanner) {
        System.out.print("Enter website: ");
        website = scanner.nextLine();

        System.out.print("Enter password: ");
        password = scanner.nextLine();

        String hashedPassword = hashPassword(password);

        if (users.containsKey(website) && users.get(website).equals(hashedPassword)) {
            System.out.println("Login successful.");
            System.out.println("Password: " + password + "\n" + "Hashed password: " + hashedPassword);
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    public static String encrypt(String plainText, SecretKey secretKey)
            throws Exception {
        plainText = password;
        byte[] plainTextByte = plainText.getBytes();
        ci.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedByte = ci.doFinal(plainTextByte);
        Base64.Encoder encoder = Base64.getEncoder();
        String encryptedText = encoder.encodeToString(encryptedByte);
        return encryptedText;
    }

    public static String decrypt(String encryptedText, SecretKey secretKey)
            throws Exception {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] encryptedTextByte = decoder.decode(encryptedText);
        ci.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedByte = ci.doFinal(encryptedTextByte);
        String decryptedText = new String(decryptedByte);
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
