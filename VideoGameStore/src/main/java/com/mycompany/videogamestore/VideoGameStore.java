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
    public String searchList(){
        String s = "";
        return s;
    }
    
    
    
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
