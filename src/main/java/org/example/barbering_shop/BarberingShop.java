package org.example.barbering_shop;

import java.util.LinkedList;

public class BarberingShop implements BarberingShopInterface{
    //Array to store number of clients that came to the barbering shop
    private final int[] eventCount;

    // List to store the seat information
    private final LinkedList<String> seats;

    // Total number of seats available
    private final int numSeat;

    public BarberingShop() {
        this.eventCount = new int[2];
        this.seats = new LinkedList<>();
        this.numSeat = 6;
    }

    // Method to handle adding new events (VIP or ORD) to seats list
    @Override
    public void addClientToSeat(int eventType) {
        eventCount[eventType-1]++;
        String prefix = (eventType == 1) ? "VIP" : "ORD";
        String eventTypeStr = prefix + eventCount[eventType-1];

        // Add the new client type to seats list based on its type and existing clients
        if (eventType == 1 && seats.size() > 1 && seats.get(1).contains("ORD")){
            seats.add(1, eventTypeStr);

        } else if (eventType == 1 && seats.size() > 1 && seats.get(1).contains("VIP")) {
            int index = findInsertionIndex(seats, eventType);
            seats.add(index +1, eventTypeStr);

        }else {
            seats.add(eventTypeStr);
        }
        System.out.print("  ( ++ " + eventTypeStr + " )"); // Print event addition message

    }

    // Method to handle null events (no client to remove from seat or seats are full)
    @Override
    public void handleNoClientOrFullSeat(int eventType) {

        // Print appropriate message based on the event type
        System.out.print(eventType == 0 ? "  ( ** NULL )" : eventType == 1 ? "  ( +- VIP" + (++eventCount[0]) + " )" : "  ( +- ORD" + (++eventCount[1]) + " )");
    }

    @Override
    public void removeClientFromSeat() {
        String removedSeat = seats.pop();
        System.out.print("  ( -- " + removedSeat + " )");
    }

    // Method to find the last index position of a VIP to insert the new VIP into seats list
    private int findInsertionIndex(LinkedList<String> seats, int eventType) {
        for (int i = seats.size() - 1; i >= 0; i--) {
            if (seats.get(i).contains("VIP")) {
                return i;
            }
        }
        return seats.size(); // Return the end of the list if no VIP event found
    }

    public LinkedList<String> getSeats() {
        return seats;
    }

    public int getNumSeat() {
        return numSeat;
    }
}
