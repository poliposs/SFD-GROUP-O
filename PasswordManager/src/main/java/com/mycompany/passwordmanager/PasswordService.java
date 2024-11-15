/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//https://github.com/poliposs/SFD-GROUP-O
package com.mycompany.passwordmanager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.HashMap;
import java.security.SecureRandom;

public class PasswordService {

    // Using a static map to store users and their hashed passwords
    public static final HashMap<String, String> users = new HashMap<>();
    private static SecretKey key;
    private static Cipher ci;
    private static String website, password, encryption;
    
     // Character pools for password generation
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";
    
    // Pool of all possible characters
    private static final String ALL_CHARS = UPPER + LOWER + DIGITS + SYMBOLS;

    // SecureRandom ensures cryptographic-grade randomness
    private static final SecureRandom RANDOM = new SecureRandom();

    static {
        try {
            // Initialises the Cipher in a static block
            ci = Cipher.getInstance("AES");
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            key = keyGen.generateKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static String hashedEmail(String email) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(email.getBytes());
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

    public static String retrievePassword() throws Exception {
        System.out.println("Enter website: ");

        encryption = encryptPassword(password);

        if (users.containsKey(website) && users.get(website).equals(encryption)) { // checks if a website is there and if it matches its password
            System.out.println("Verification complete.");
            System.out.println("Encrypted password: " + encryption);
        } else {
            System.out.println("Invalid website.");
        }
        return encryption;
    }

    public static String encryptPassword(String plainText) {
        try {
            ci.init(Cipher.ENCRYPT_MODE, key); // Intialises the cipher
            byte[] plainTextByte = plainText.getBytes(); // Puts the text to bytes
            byte[] encryptedByte = ci.doFinal(plainTextByte); // the encryption
            return Base64.getEncoder().encodeToString(encryptedByte);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decryptPassword(String encryptedText) throws Exception {
        try {
            byte[] encryptedTextByte = Base64.getDecoder().decode(encryptedText); // Grabs the encrypted text and puts it to bytes  
            ci.init(Cipher.DECRYPT_MODE, key); // Intialises the cipher
            byte[] decryptedByte = ci.doFinal(encryptedTextByte); // The decryption
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

}
