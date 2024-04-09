package org.example.barbering_shop;

public interface BarberingShopInterface {
    /**
     * This method is used to add a client to a specific seat in the barbering shop.
     * The type of client (VIP or Ordinary) is determined by the eventNumber parameter.
     *
     * @param eventNumber eventNumber An integer representing the type of client.
     *                    1 represents a VIP client and 2 represents an
     */
    void addClientToSeat(int eventNumber);

    /**
     * This method is used to handle the situation when there is no client or the shop is full.
     * The action taken depends on the eventNumber parameter.
     *
     * @param eventNumber eventNumber An integer representing the type of event.
     */
    void handleEmptySeatOrFullShop(int eventNumber);

    /**
     * This method is used to remove a client from a seat in the barbering shop.
     * The client removed is always the one on the main seat at index 0.
     */
    void removeClientFromSeat();

    /**
     * This method is used to display the current state of the seats in the barbering shop.
     * It prints out a visual representation of the seats, with each seat showing whether it's empty or occupied by a VIP or Ordinary client.
     */
    void displayShopSeats();
}
