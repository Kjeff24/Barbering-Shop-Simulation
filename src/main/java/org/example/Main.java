package org.example;

import org.example.barbering_shop.BarberingShop;
import org.example.client.Client;
import org.example.client.ClientType;

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
            int totalShopSeats = barberingShop.getTotalShopSeats();
            int totalClientSeated = barberingShop.getSeatedClients().size();
            System.out.print(" " + eventNumber + " ---->   ");
            if (eventNumber == 0 && totalClientSeated > 0) {
                Client client = barberingShop.removeClientFromSeat();
                System.out.print("  ( -- " + client + " )");
            } else if (eventNumber > 0 && totalClientSeated < totalShopSeats) {
                ClientType clientType = (eventNumber == 1) ? ClientType.VIP : ClientType.ORD;
                Client client = barberingShop.addClientToSeat(clientType);
                System.out.print("  ( ++ " + client + " )");
            } else {
                if(eventNumber == 0){
                    System.out.print("  ( ** NULL )");
                } else {
                    ClientType clientType = eventNumber == 1 ? ClientType.VIP : ClientType.ORD;
                    barberingShop.manageSeatsAvailability(clientType);

                }
            }

            barberingShop.displayShopSeats();
        }

    }
}