package com.mycompany.videogamestore;

import java.util.Scanner;

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
        Node(int id, String data) {
            this.data = data;
            this.id = id;
            next = null;
        }

        // getter used for finding a specified node data
        public String getData() {
            return data;
        }
    }

    // code provided in-class
    void insertNode(int id, String data) {
        head = insertHelper(head, id, data);
    }

    // code provided in-class
    Node insertHelper(Node subRoot, int id, String data) {
        if (subRoot == null) {
            subRoot = new Node(id, data);
            return subRoot;
        }
        if (id < subRoot.id) {
            subRoot.left = insertHelper(subRoot.left, id, data);
        } else if (id > subRoot.id) {
            subRoot.right = insertHelper(subRoot.right, id, data);
        }
        return subRoot;
    }

    // prints the entire binary tree
    public void printBinaryTree(Node node) {
        // tester to see if tree is empty
        if (node == null) {
            return;
        }

        // tests left side of node
        printBinaryTree(node.left);

        // prints the node's ID
        System.out.print("ID: " + node.id + " Title: " + node.data + "\n");

        // tests right side of node
        printBinaryTree(node.right);
    }

    // method to find a specified node
    public Node findNode(Node head, int key) {
        //tester to see if tree is empty
        if (head == null) {
            return null;
        }
        // parses the left nodes until a match is found
        Node leftNode = findNode(head.left, key);
        if (leftNode != null) {
            return leftNode;
        }
        // checks the head node
        if (head.id == key) {
            return head;
        }
        // or parses the right nodes until a match is found
        Node rightNode = findNode(head.right, key);
        if (rightNode != null) {
            return rightNode;
        }
        // if no node if found, null is returned
        return null;
    }

    /* MAIN CLASS */
    public static void main(String[] args) {
        // creates a scanner
        Scanner input = new Scanner(System.in);
        // creates a new linked list
        VideoGameStore store = new VideoGameStore();

        // inserts the items into a binary tree
        store.insertNode(1998, "Mario Kart");
        store.insertNode(2011, "Minecraft");
        store.insertNode(1984, "Tetris");
        store.insertNode(1980, "Pac-Man");
        store.insertNode(2007, "Bloons Tower Defense");

        // variable used to terminate 
        Boolean exit = true;

        // the menu that the user interacts with is a do-while loop below. 
        do {
            System.out.println("Enter option:");
            System.out.println("1. Search for video game by ID.");
            System.out.println("2. Print video game list.");
            System.out.println("3. Exit");
            int selection = input.nextInt();

            if (selection == 1) {
                System.out.println("You selected search for video game by ID. Please enter the video game ID:");
                int gameID = input.nextInt();
                try {
                    System.out.println("\nID: " + gameID + " returns:");
                    System.out.println("\n" + store.findNode(store.head, gameID).getData() + "\n");
                } catch (Exception e) {
                    System.out.println("Null. There is no game with ID " + gameID + ".\n");
                }
            } else if (selection == 2) {
                System.out.println("You selected to print the video game list. The video game list is below:");
                // calls printBinaryTree function
                store.printBinaryTree(store.head);
            } else {
                exit = false;
            }
        } while (exit);
        System.out.println("Good bye!");
    }
}
