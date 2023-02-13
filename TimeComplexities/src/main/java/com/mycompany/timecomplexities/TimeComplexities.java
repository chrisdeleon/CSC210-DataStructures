package com.mycompany.timecomplexities;

/**
 * Chris de Leon
 * CSC210 - Time Complexities
 * 2/12/2023
 */

public class TimeComplexities {
    public static void main(String[] args) {
        
        // creates an array with 100,000 elements
        int[] Array = new int[100000];
        
        
        // intializes each element of the array with its corresponding number
        for(int i = 0; i < 100000; i++){
            Array[i] = i;
        }
        
        // instantiates the AsymptoticAnalysis class
        AsymptoticAnalysis obj = new AsymptoticAnalysis();
        
        // Assigns the array to the objects array property
        obj.setArray(Array);
        
        obj.Linear(99999); // runs the linear time complexity method, you can change which element to locate
        
        obj.Constant(); // runs the constant time complexity method
        
        System.out.println("\n*************** Logarithm Time Complexity ****************\n");
        double startTime = System.nanoTime();
        int result = obj.Logarithm(obj.getArray(), 99999, 0, obj.getArray().length - 1);
        double endTime = System.nanoTime() - startTime;
        System.out.println("The selected search index can be found at array index: " + obj.getArray()[result]);
        System.out.println("Total iterations: " + obj.getCounter());
        System.out.println("Total time to find element: " + (endTime / 1000000000) + " seconds");

        obj.Quadratic(); //  runs the quadratic time complexity
    }
}


class AsymptoticAnalysis {
        
        private int[] Array;
        
        int counter; // this variable is used to count the iterations in the logarithm time complexity
        
        // default no-arg constructor
        public void AsymptoticAnalysis(){
        }
        
        
        // this returns the array created from the main method that is stored in the private variable
        public int[] getArray(){
            return Array;
        }
        
        // this sets the array created in the main method to the private method
        public void setArray (int[] Array){
            this.Array = Array;
        }
        
        // returns the counter
        public int getCounter(){
            return counter;
        }
        
        
        public void Linear(int target){
            /* This method, in a linear time complexity, parses every array element without skipping any. */
            
            
            // the variable targetElement is used to target the wanted index
            int targetElement = target;
            
            double entireArrayTime = System.nanoTime(); // tracks how long it takes to print the entire array
            double findStart = System.nanoTime(); // tracks how long it takes to find the element
            double entireArrayDuration = 0;
            double findDuration = 0;
            int location = 0; // variable that stores the array element where the target was found

            int i; // this variable doubles as the counter for iterations to complete the algorithm
            for(i = 0; i < this.Array.length; i++){
                if (this.Array[targetElement] == this.Array[i]){
                    findDuration = System.nanoTime() - findStart; // marks the time now and subtracks it from the time that the search started
                    location = this.Array[i];
                }
            }
            double endEntireArray = System.nanoTime() - entireArrayTime;
             // marks the end of the run of the algorithm
            System.out.println("\n***************** Linear Time Complexity *****************\n");
            System.out.println(targetElement + " was located at index: " + location);
            System.out.println("Total iterations: " + i);
            System.out.println("Linear time complexity total time: " + (endEntireArray / 1000000000) + " seconds");
            System.out.println("Total time to find element: " + (findDuration / 1000000000) + " seconds");
            // the total time is divided by one million because the two variables are nano seconds
        }
        
        
        public void Constant(){
            /* A constant linear time complexity always takes the same amount of retrieval time.
               Of course, there are several factors that go in to the run-time of a program so exact results aren't common. */
            
            double start = System.nanoTime();
            
            // targets the middle of the array, regardless of size (i.e. this location is always constant)
            int middle = this.Array.length / 2;
            double duration = System.nanoTime() - start;
            System.out.println("\n***************** Constant Time Complexity *****************\n");
            System.out.println("The middle of the array is: " + this.Array[middle]);
            System.out.println("Total iterations will always be 1");
            System.out.println("Total time: " + (duration / 1000000000) + " seconds");
        }
        
        
        public int Logarithm(int[] Array, int SearchIndex, int Lowest, int Highest){
            /* This method is a binary search which is an example of a logarithm time complexity, in theory, the larger
            that the array is, the quicker it'll be compared to a linear search */
            
            this.counter = this.counter + 1; // tracks the total iterations for the logarithm search
            int Middle = (Lowest + Highest) / 2; // retrieves the middle of the array
            
            if (SearchIndex == Array[Middle]){ // if the number is the same as the middle, the middle is returned
                return Middle;
            } else if (SearchIndex < Array[Middle]){ // if number is to the left of the middle, the right is discarded
                return Logarithm(Array, SearchIndex, Lowest, Middle - 1);
            } else { // if the number is to the right of the middle, the left is discarded
                return Logarithm(Array, SearchIndex, Middle + 1, Highest);
            }
        }
        
        
        public void Quadratic(){
            /* This method searches the entire array for duplicates. 
               The nested for-loop causes this time complexity to be O(n^2).
               Without the for-loop, it would be O(n) */
            
            int counter = 0; // counter for iterations
            int duplicate = 0; // counter for duplicates
            
            double start = System.nanoTime();
            for(int outer = 0; outer < this.Array.length; outer++){ // outer loop grabs a number to compare
                for(int inner = 0; inner < this.Array.length; inner++){ // inner loop compares each element to the current outer loop element
                    counter++; 
                    if(outer == inner){
                        duplicate++;
                    }
                }
            }
            double duration = System.nanoTime() - start;
            System.out.println("\n***************** Quadratic Time Complexity *****************\n");
            System.out.println("Total iterations: " + counter);
            System.out.println("Total time: " + (duration / 1000000000) + " seconds\n");
        }
    }
