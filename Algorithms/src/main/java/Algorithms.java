/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 * Chris de Leon
 * 2/2/2023
 * Search Algorithms for CSC-210
 */
public class Algorithms {
    public static void main(String[] args) {
        int Seed = 9999; // hard-coded seed
        /* creates an array of numbers from 1 to 1000 */
        int[] Numbers = new int[10001]; // set at 10,001 since the array is zero-based
        for (int i = 0; i < 10001; i++){
            Numbers[i] = i;
        }
        
        /* ******************* */
        /* END OF STARTER CODE */ 
        /* ******************* */
        
        int ResultOne = LinearRecursion(Numbers, 0, Seed);
        if (ResultOne == -1){
            System.out.println("Number not found.");
        } else {
            System.out.println(Seed + " can be found at array index " + Numbers[ResultOne]);
        }
        
        /* *********************** */
        /* END OF LINEAR RECURSION */ 
        /* *********************** */
    }
    
    /* Linear Recursion Function */
    public static int LinearRecursion(int[] Array, int StartingNumber, int SearchIndex){
        if(Array[StartingNumber] == SearchIndex){
            return StartingNumber; // returns the matching number when a match is found
        } else if (Array[StartingNumber] < SearchIndex){
            return LinearRecursion(Array, StartingNumber + 1, SearchIndex); // recusion happens here
        } else {
            return -1; // if no matching number is found, a -1 is returned
        }
    }
}
