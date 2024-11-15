/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//https://github.com/poliposs/SFD-GROUP-O

package com.mycompany.passwordmanager;

import java.security.spec.KeySpec;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author paulp
 */

public class RLUserService {
    private HashMap<String, String[]> newUsers = new HashMap<>();
    
    // Generates a new salt for each password
    public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16]; // 16 bytes = 128 bits
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }
    
    // Register method that adds a new user
    public boolean register(String userEmail, String userPassword) {
        if (newUsers.containsKey(userEmail)) {
            return false; // User already exists
        }
        
        // Generate salt and hash the password
        String salt = generateSalt();
        String hashedPassword = saltedHashPassword(userPassword, salt);
        
        // Store both salt and hashed password
        newUsers.put(userEmail, new String[]{salt, hashedPassword});
        return true;
    }

    // Login method to verify user credentials
    public boolean login(String email, String password) {
        String[] userData = newUsers.get(email);
        
        if (userData != null) {
            String salt = userData[0];
            String storedHash = userData[1];
            
            // Hash the provided password with the stored salt
            String hashedPassword = saltedHashPassword(password, salt);
            
            // Compare hashed passwords
            return storedHash.equals(hashedPassword);
        }
        return false; // User does not exist
    }
    
    // Hashes the password with the salt using PBKDF2
    public static String saltedHashPassword(String userPassword, String salt) {
        try {
            KeySpec spec = new PBEKeySpec(userPassword.toCharArray(), salt.getBytes(), 65536, 128);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = factory.generateSecret(spec).getEncoded();
            return Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
