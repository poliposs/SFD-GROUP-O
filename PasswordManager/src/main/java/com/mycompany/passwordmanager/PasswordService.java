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
import java.security.SecureRandom;

public class PasswordService {

    // Using a static map to store users and their hashed passwords
    public static final HashMap<String, String> users = new HashMap<>();
    private static SecretKey key;
    private static Cipher ci;
    private static String website, password, encryption, decryptedText, email, encryptedText, plainText;
    
     // Character pools for password generation
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";
    
    // Pool of all possible characters
    private static final String ALL_CHARS = UPPER + LOWER + DIGITS + SYMBOLS;

    // SecureRandom ensures cryptographic-grade randomness
    private static final SecureRandom RANDOM = new SecureRandom();

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
    
    public static String generatePassword(int length) {
        // Password length must meet security guidelines
        if (length < 12) {
            throw new IllegalArgumentException("Password length must be at least 12 characters");
        }

        StringBuilder password = new StringBuilder();

        // Step 1: Ensure the password contains at least one character from each category
        password.append(UPPER.charAt(RANDOM.nextInt(UPPER.length()))); // Add one uppercase letter
        password.append(LOWER.charAt(RANDOM.nextInt(LOWER.length()))); // Add one lowercase letter
        password.append(DIGITS.charAt(RANDOM.nextInt(DIGITS.length()))); // Add one digit
        password.append(SYMBOLS.charAt(RANDOM.nextInt(SYMBOLS.length()))); // Add one symbol

        // Step 2: Fill the rest of the password with random characters from all categories
        for (int i = 4; i < length; i++) {
            password.append(ALL_CHARS.charAt(RANDOM.nextInt(ALL_CHARS.length())));
        }

        // Step 3: Shuffle the password to avoid predictable patterns
        return shufflePassword(password.toString());
    }

    /**
     * Shuffles the characters in the password to improve randomness.
     *
     * @param password the password string to shuffle
     * @return a new shuffled password string
     */
    private static String shufflePassword(String password) {
        // Convert the password into a character array for shuffling
        char[] chars = password.toCharArray();
        
        // Fisher-Yates shuffle algorithm for randomizing the order
        for (int i = chars.length - 1; i > 0; i--) {
            int j = RANDOM.nextInt(i + 1); // Select a random index
            char temp = chars[i];         // Swap characters
            chars[i] = chars[j];
            chars[j] = temp;
        }

        // Return the shuffled password as a new string
        return new String(chars);
    }

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
