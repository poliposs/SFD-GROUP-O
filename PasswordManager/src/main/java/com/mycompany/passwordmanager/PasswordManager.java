/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package com.mycompany.passwordmanager;

/**
 *https://github.com/poliposs/SFD-GROUP-O
 * @author paulp
 */

public class PasswordManager {

    public static void main(String[] args) {

        RegisterGUI myGUI = new RegisterGUI();
        myGUI.setVisible(true);
        
        PasswordGUI myG = new PasswordGUI();
        myG.setVisible(true);
    }
}
