/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.stacks;

/**
 *
 * Chris de Leon
 * Kai
 */

/* In class project, 

Find a partner and co-code:

Utlizing an array or linked list (Your choice) create a Stack class that using FIFO

Be sure to account for OVERFLOW and UNDERFLOW if/when appropriate

Pop()
Push()
inStack() – checks to see if there is anything in the stack and returns appropriate message)
Peek()
Main method

Create tests for the methods created in the  Stack class

Show work when finished */


public class Stacks {
    
    public static void inStack(int[] a){
        for(int i = 0; i < a.length; i++){
            if (i == a.length - 1){
                System.out.println("Array is full");
            }
        }
    }
    
    public static void peek(int [] a){
        int reader = 0;
        for(int i = 0; i < a.length; i++){
            reader = a[i];
        }
        System.out.println("The top of the array is "+ reader);
    }
    
    public static void push(int [] a, int key) {
        // creates a new array that is the length of the original one, plus one
        int [] b = new int[a.length + 1];
        
        int i; // for the counter
        
        // copies the old array elements to the new array
        for (i = 0; i <= a.length - 1; i++) {
            b[i] = a[i];
        }
        
        // sets the last index of the array equal to the new value
        b[i] = key;
        
        
        // prints the array with the pushed element
        for(i = 0; i < b.length; i++){
            System.out.println(b[i]);
        }
    }
    
    public static int[] pop(int [] a){
        
        // checks if array is empty
        if (a == null){
            return a;
        }
        
        // for loop "moves" all the elements one position, which "removes" the first element
        for(int i = 0; i < a.length - 1; i++){
            a[i] = a[i + 1];
        }
        
        // returns the new array
        return a;
    }

    public static void main(String[] args) {
        int [] array = new int[8]; // defines array with length of 8
        
        // fills array with 8 integers
        for(int i = 0; i < array.length; i++){
            array[i] = i;
            System.out.println(array[i]);
        }
        
       
        // pops element from array
        pop(array);
        
     
        // line for readability
        System.out.println("\n");
        
        // pushes new element into array
        push(array, 12);
        
       peek(array);
        
       inStack(array);
        
        
        
        
    }
}
