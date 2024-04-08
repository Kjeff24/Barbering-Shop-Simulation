package org.example.barbering_shop;

import java.util.LinkedList;

public interface BarberingShopInterface {
    // Method to handle adding new events (VIP or ORD) to seats list
    void addClientToSeat(int eventType);

    // Method to handle null events (no client to remove from seat or seats are full)
    void handleNoClientOrFullSeat(int eventType);

    // Remove client from seat
    void removeClientFromSeat();
}
