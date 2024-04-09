package org.example;

import org.example.barbering_shop.BarberingShop;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int MAX_SIMULATIONS = 20;

    public static int generateRandomNumber() {
        return new Random().nextInt(4);
    }

    public static void displaySimulationHeader() {
        System.out.println("\tX\t\t\tEvents\t\t\t\t\t\t\tState of the Shop");
        System.out.print("+" + "-".repeat(9) + "+" + "+" + "-".repeat(14) + "+" + "+" + "-".repeat(56) + "+");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BarberingShop barberingShop = new BarberingShop();

        displaySimulationHeader();

        int simulationCount = 0;
        while (simulationCount++ < MAX_SIMULATIONS && scanner.nextLine().equals(" ")) {
            int eventNumber = generateRandomNumber();
            System.out.print(" " + eventNumber + " ---->   ");
            if (eventNumber == 0 && !barberingShop.getShopSeats().isEmpty()) {
                barberingShop.removeClientFromSeat();
            } else if ((eventNumber == 1 || eventNumber == 2 || eventNumber == 3) && barberingShop.getShopSeats().size() < barberingShop.getTotalShopSeats()) {
                int newEventNumber = eventNumber > 1 ? 2 : 1;
                barberingShop.addClientToSeat(newEventNumber);
            } else {
                barberingShop.handleEmptySeatOrFullShop(eventNumber);
            }

            barberingShop.displayShopSeats();
        }

    }
}