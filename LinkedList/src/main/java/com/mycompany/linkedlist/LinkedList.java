/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.linkedlist;

/**
 * Chris de Leon 
 * CSC210 
 * 3/5/2023
 */
public class LinkedList {

    // defines the head of the linked list
    LLNode head;

    public static class LLNode {

        // integer for LLNode
        int data;

        // reference for an other LLNode
        LLNode next;

        // constructor for LLNode
        LLNode(int data) {
            this.data = data;
            // this marks the newly created LLNode as the last node
            next = null;
        }
    }
    
    // method for inserting a new LLNode into the linked list
        public static void insert(LinkedList l, int data) {

            // declares a new LLNode
            LLNode newLLNode = new LLNode(data);

            // if there is no LLNode at the head, the new one is set to be the head
            if (l.head == null) {
                l.head = newLLNode;
            } else {
                // creates a new LLNode reference and sets it as the linked list head
                // note, doing this means that the node will have a property of next set as null
                LLNode last = l.head;

                // assignment from above allows the program to parse the entire linked list until it arrives at the node with a null property
                while (last.next != null) {
                    last = last.next;
                }
                // once the while-loop has terminated, it means that the program was able to find
                // the node that had a null .next property which then caused it to replace the last one with the new node
                last.next = newLLNode;
            }
        }

        // method that deletes a node from the linked list
        public static void delete(LinkedList l, int d) {

            // creates a location to temporarily store the link, without this we'll lose the ability to parse the list
            LLNode holder = l.head;
            LLNode previousNode = null;
            
            // logic to delete the head node in the event that it is the one that the user wants to remove
            if (holder != null && holder.data == d){
                l.head = holder.next;
            }
            
            // runs while we're not at the end of the linked list and the key doesn't match
            while (holder != null && holder.data != d){
                // hangs on to the current node's location
                previousNode = holder;
                // moves on to the next node's location
                holder = holder.next;
            }
            
            // if the while loop terminates and there is no result from it, this logic tells the user there was no such node
            if(holder == null){
                System.out.println(d + " not found in linked list.");
            }
            
            // discards the node from the list
            previousNode.next = holder.next;
        }

        // method that prints the entire linked list
        public static void printLinkedList(LinkedList l) {
            // creates a new node and defines it as current and sets it to have the value of the list head
            LLNode current = l.head;

            System.out.println("Linked List:");

            // while-loop parses the entire linked list until it runs into the null node
            while (current != null) {
                System.out.println(current.data + " ");
                // goes to the next node
                current = current.next;
            }
        }
        
        // method that prints one specific node
        public static void printNode(LinkedList l, int key){
            // creates a new node and defines it as current and sets it to have the value of the list head

            LLNode current = l.head;
            int location = 0;
            // while-loop parses the entire linked list until it runs into the matched node
            while (current != null && current.data != key){
                current = current.next;
                location++;
                
            }
            
            // if they input is not in the linked list then this message will print
            if (current == null){
                System.out.println(key + " not found in linked list.");
            }
            
            System.out.println(key + " was found in node " + location);
            
        }

        
        
    public static void main(String[] args) {
        // creates an empty linked list
        LinkedList list = new LinkedList();
        
        // creates nodes with a for-loop
        for (int i = 0; i < 10; i++){
            insert(list, i);
        }
        
        // removes node with int 3 from linked list
        delete(list, 3);

        // prints linked list
        printLinkedList(list);
        
        // searches and prints a specified value (hard-coded)
        // this should print as the 5th node because one node was removed earlier
        printNode(list, 6);
    }
}
