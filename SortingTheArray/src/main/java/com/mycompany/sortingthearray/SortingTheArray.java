package com.mycompany.sortingthearray;

/**
 * Chris de Leon 
 * 2/25/2023 
 * CSC 210
 */
public class SortingTheArray {

    public static void main(String[] args) {
        WorkingWithArrays obj = new WorkingWithArrays(); // creates instance of WorkingWithArrays object
        
        /* the block of code below sorts the array and prints the original array first and then the sorted one */
        
        obj.sortTheArray();
        obj.printTheArray();
        obj.printTheSortedArray();
        
        /* the block of code below inserts a new number and displays both arrays to reflect the number entered */
        
        obj.insertAnInteger(23, 98); // 23 will be the new value of index 98 in both arrays
        // I chose the numbers above for ease of readability... I wouldn't want you counting up to a number to verify this works :)
        obj.printTheArray();
        obj.printTheSortedArray(); // you will note that the array is no longer sorted because of the insert method
        obj.sortTheArray(); // the array is sorted again
        obj.printTheSortedArray(); // the printed sorted array is correct
        
        

    }

    public static class WorkingWithArrays {

        // two variables that store the potential arrays
        private int[] Array = new int[100];
        private int[] SortedArray = new int[100];

        // the constructor loops through each element of the unordered array and adds a random integer to each element
        public WorkingWithArrays() {
            for (int i = 0; i < this.Array.length; i++) {
                int RandomNumber = (int) (Math.random() * 100);
                Array[i] = RandomNumber;
                SortedArray[i] = RandomNumber;
            }
        }

        // method can insert a value into a specified array index
        // this assignment did not specify which array the number should be inserted in
        public void insertAnInteger(int newValue, int arrayPosition) {
            Array[arrayPosition] = newValue;
            SortedArray[arrayPosition] = newValue;
        }

        
        // uses a bubble sort algorithm to sort the array into ascending order
        // note, this method strictly uses the SortedArray because we want to maintain the integrity of the original array
        public void sortTheArray() {
            // outer loop obtains the number to compare
            for (int i = 0; i < SortedArray.length - 1; i++) { 
                // inner loop obtains the numbers that will be compared to outer loop number
                for (int j = 0; j < SortedArray.length - i - 1; j++) { 
                    if (SortedArray[j] > SortedArray[j + 1]) {
                        int holder = SortedArray[j];
                        SortedArray[j] = SortedArray[j + 1];
                        SortedArray[j + 1] = holder;
                    }
                }
            }
        }

        // prints original, unsorted array
        public void printTheArray() {
            System.out.print("Unsorted Array: ");
            for (int i = 0; i < Array.length; i++) {
                System.out.print(Array[i] + " ");
            }
            System.out.println("");
        }

        // prints the sorted array
        public void printTheSortedArray() {
            System.out.print("Sorted Array: ");
            for (int i = 0; i < SortedArray.length; i++) {
                System.out.print(SortedArray[i] + " ");
            }
            System.out.println("");
        }
    }
}
