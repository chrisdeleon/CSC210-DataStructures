package com.mycompany.gameprojectlab;

/*
 * Chris de Leon
 * CSC210 Data Structures
 * 1/27/2023
 */

public class Weapon {
    private String weaponType;
    private String weaponAction;
    
    // constructor for different weapons
    public Weapon(String weaponType, String weaponAction){
        this.weaponType = weaponType;
        this.weaponAction = weaponAction;
    }
    
    // getter for the weapon action and type
    public String getWeapon(){ 
        String s = this.weaponAction + " " + this.weaponType;
        return s;
    }
    
    // this string reads the roll number and then produces the weapon name, weapon action, and the roll damage
    public String strike(int roll){
        return "The " + this.weaponType + " " + this.weaponAction + ". It causes " + roll + " damage";
    }    
}