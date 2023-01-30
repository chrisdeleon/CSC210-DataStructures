package com.mycompany.gameprojectlab;
import java.util.Scanner;
import java.util.Random;

/*
 * Chris de Leon
 * CSC210 Data Structures
 * 1/27/2023
 */

public class Game {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        
        /* Code below uses constructors from the Player class to create the two player profiles */
        System.out.println("Enter player one name: ");
        Player playerOne = new Player(input.nextLine());
        System.out.println("Hello, " + playerOne.getName() + " ! Let's play a game!");
        System.out.println("Enter player two name: ");
        Player playerTwo = new Player(input.nextLine());
        System.out.println("Hello, " + playerTwo.getName() + "! It's time to play.");
        
        do {
            
            System.out.println(playerOne.Attack(25));
        } while (playerOne.getHealth() > 0 || playerTwo.getHealth() > 0);
        
        
    }
}