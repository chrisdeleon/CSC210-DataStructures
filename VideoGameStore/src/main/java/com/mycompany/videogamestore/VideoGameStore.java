package com.mycompany.videogamestore;

/**
 * Chris de Leon
 * 3/14/2023
 * CSC210
 */
public class VideoGameStore {
    
    // defines node head
    Node head;
    
        
    public static class Node {
        
        // attributes of the linked list, one for the data, one for the next node
        String data; // for title of video game
        int id; // for the Node's ID
        Node next; // to target next node
        Node left = null; // for binary tree, left side
        Node right = null; // for binary tree, right side
        
        // node constructor
        Node(int id, String data){
            this.data = data;
            this.id = id;
            next = null;
        }
    }
    
    // method to insert a new node in the linked list
    public static void insert(VideoGameStore o, int id, String data){
        // new node declaration
        Node newNode = new Node(id, data);
        
        // if the head is empty, this new node is set as the head
        if (o.head == null){
            o.head = newNode;
            
            // else, create a last node and set it equal to the head
            // and parse the list until the next node returns null
        } else {
            Node last = o.head;
            while(last.next != null){
                last = last.next;
            }
            // set the node that returned null as the newNode
            last.next = newNode;
        }
    }
    
    // method to find item in linked list inventory
    public static void searchList(VideoGameStore o, int id){
        String s; // used to print statements
        Node current = o.head; // creates a "current" attribute in the node and sets it equal to the linked list head
        Node previous = null; // creates a "previous" attribute in the node and sets it to null
        
        // while the current node's id does not match the request id
        // and while the next node is not null
        while (current.id != id && current.next != null){
            // set the previous node equal to the current node
            previous = current;
            // move on to the next node, aka the one that follows the current one
            current = current.next;
        }
        
        // once the while loop breaks, it either never found the matching node
        // or it did, so the following statements respond to both of those results
        if(current.next == null){
            s = id + " not found. Please try a different ID.";
        } else {
            s = current.data;
        }
        System.out.println(s);
    }
    

    public static void printList(VideoGameStore o){
        // creates current attribute in node and sets it equal to the linked list head
        Node current = o.head;

        System.out.println("Linked List:");

        // while-loop parses the entire linked list until it runs into the null node
        while (current != null) {
            System.out.println(current.data + " (ID: " + current.id + ")");
            // sets the current node attribute equal to the node's next attribute, aka the next node
            current = current.next;
        }
    }
    
    public static void main(String[] args) {
        // creates a new linked list
        VideoGameStore store = new VideoGameStore();
        
        // inserts different items into the linked list
        insert(store, 1998, "Mario Kart");
        insert(store, 2011, "Minecraft");
        insert(store, 1984, "Tetris");
        insert(store, 1980, "Pac-Man");
        insert(store, 2007, "Bloons Tower Defense");
        
        // searches the list for different items
        // for debugging, should print Tetris
        searchList(store, 1984); 
        // debugging, should return not-found statement
        searchList(store, 1111); 
        
        // prints the linked list
        printList(store);
    }
}
