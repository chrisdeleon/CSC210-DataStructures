package com.mycompany.callcenter;

import java.util.Scanner;

/**
 * Chris de Leon 
 * 3/26/2023 
 * CSC210
 */
public class CallCenter {

    // defines the head of the linked list
    Ticket head;

    public static class Ticket {
        // stores customer name
        String cusName;

        // stores the problem description
        String problemDescription;

        // points to the next item in the linked list
        Ticket next;

        Ticket(String cusName, String problemDescription) {
            this.cusName = cusName;
            this.problemDescription = problemDescription;
            next = null;
        }
    }

    // creates a new ticket and inserts it into the linked list
    public static void enque(CallCenter o, String cusName, String problemDescription) {
        Ticket newTicket = new Ticket(cusName, problemDescription);

        // if the head of the linked list is empty, the new ticket will be put there
        if (o.head == null) {
            o.head = newTicket;
        } else {
            // creates a new ticket reference and sets it as the linked list head
            Ticket last = o.head;
            // the while loop parses the linked list until it arrives at a node with a null property
            while (last.next != null) {
                last = last.next;
            }
            // termination of the while loop indicates that the program 
            // was able to find the node with a null .next property
            last.next = newTicket;
        }
    }

    // removes the first ticket in the queue
    public static void deque(CallCenter o) {
        Ticket holder = o.head;
        o.head = holder.next;
    }

    // prints the ticket queue
    public static void print(CallCenter o) {
        // indentifies the head of the linked list
        Ticket current = o.head;
        if(o.head == null){ // prints a statement in case list is empty
            System.out.println("\nThe queue is empty. Please add a ticket.\n");
        } else {
            System.out.println("Ticket Queue:");
            // while loop parses linked list until it reaches the last node
            while (current != null) {
                System.out.println(current.cusName + ": " + current.problemDescription);
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // used in conjunction with the do-while loop
        boolean exit = true;

        // creates an instance of a linked list
        CallCenter list = new CallCenter();

        // do-while loop prompts the user to provide entry
        // it terminates if the user enters 4
        do {
            System.out.println("1) Create ticket");
            System.out.println("2) Close ticket");
            System.out.println("3) Display all open tickets");
            System.out.println("4) Exit system");
            int selection = input.nextInt();
            input.nextLine();

            switch (selection) {
                case 1: // creates a ticket
                    System.out.println("Enter customer name: ");
                    String cusName = input.nextLine();
                    System.out.println("Enter problem description:");
                    String problemDescription = input.nextLine();
                    // method to add an item to the queue
                    enque(list, cusName, problemDescription);
                    System.out.println("Ticket added to queue\n" + cusName
                            + ": " + problemDescription + "\n");
                    break;
                case 2: // closes the first ticket in the queue
                    try { // try-catch detects when the queue is already empty
                        deque(list);
                        System.out.println("Ticket closed successfully!");
                    } catch (Exception e){
                        System.out.println("\nIt appears the queue is empty.\n" 
                                + "please add a ticket to the queue before attempting to remove it\n");
                    }
                    break;
                case 3: // prints the entire ticket queue
                    print(list);
                    break;
                case 4: // exits the program
                    exit = false;
                    break;
            }
        } while (exit);
        System.out.println("Good bye!");
    }
}
