package org.example;

import org.example.barbering_shop.BarberingShop;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int MAX_SIMULATIONS = 20;

    public static void displayInitialHeader() {
        System.out.println("\tX\t\t\tEvents\t\t\t\t\t\t\tState of the Shop");
        System.out.print("+" + "-".repeat(9) + "+" + "+" + "-".repeat(14) + "+" + "+" + "-".repeat(56) + "+");
    }

    public static int generateRandomNumber() {
        return new Random().nextInt(4);
    }

    private static void displaySeats(LinkedList<String> seats, int numSeat) {
        System.out.print("\t\t[");
        // Loop through all the seats
        for (int i = 0; i < numSeat; i++) {
            // If the current index is less than the size of the seats list, print the seat
            // Otherwise, print "----" to represent an empty seat
            System.out.print("  " + (i < seats.size() ? seats.get(i) : "----"));
            // If the current index is not the last one, print " :" to separate the seats
            System.out.print(i < numSeat - 1 ? " :" : "");
        }
        System.out.print(" ]");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BarberingShop barberingShop = new BarberingShop();
        LinkedList<String> seats = barberingShop.getSeats();
        int numSeat = barberingShop.getNumSeat();

        displayInitialHeader();

        int simulationCount = 0;
        while (simulationCount++ < MAX_SIMULATIONS) {
            if (scanner.nextLine().equals(" ")) {
                int x = generateRandomNumber();
                System.out.print(" " + x + " ---->   ");
                if (x == 0 && !seats.isEmpty()) { // If there are occupied seats Remove client from the main seat after trimming
                    barberingShop.removeClientFromSeat();
                } else if (x == 1 && seats.size() < numSeat) { // Add VIP to seat if there are available seats
                    barberingShop.addClientToSeat(1);
                } else if ((x == 2 || x == 3) && seats.size() < numSeat) { // Add ORD to seat if there are available seats
                    barberingShop.addClientToSeat(2);
                } else { // Perform operation when seats are full or no client to be removed from main seat
                    barberingShop.handleNoClientOrFullSeat(x);
                }
            } else {
                System.out.println("Invalid input.");
                break;
            }

            displaySeats(seats, numSeat);
        }

    }
}