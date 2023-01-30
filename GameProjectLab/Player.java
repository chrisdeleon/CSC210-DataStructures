package com.mycompany.gameprojectlab;
import java.util.ArrayList;

/*
 * Chris de Leon
 * CSC210 Data Structures
 * 1/27/2023
 */

public class Player {
    private String name;
    private int health = 100;
    private ArrayList<Weapon> Weapons = new ArrayList<Weapon>(); // stores the weapons
    
    
    public Player(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getHealth(){
        return this.health;
    }
    
    // this method receives the damage amount and deducts it from health
    public String Attack(int damage){
        this.health = this.health - damage; 
        
        return this.name + " now has " + this.health + " health points!";
    }
}
