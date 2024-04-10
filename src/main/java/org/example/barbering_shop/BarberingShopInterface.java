package org.example.barbering_shop;

import org.example.client.Client;
import org.example.client.ClientType;

public interface BarberingShopInterface {

    /**
     * This method is used to add a client to a seat in the barbering shop.
     *
     * @param clientType The type of client to be added.
     * @return Client The newly added client
     */
    Client addClientToSeat(ClientType clientType);

    /**
     * This method is used to manage the availability of seats, whether all seats are full or empty.
     * @param clientType The type of the client for which the seats availability is to be managed.
     */
    void manageSeatsAvailability(ClientType clientType);

    /**
     * This method is used to remove a client from a seat in the barbering shop.
     * @return Client The client that was removed from the seat.
     */
    Client removeClientFromSeat();

    /**
     * This method is used to display the current state of the seats in the barbering shop.
     */
    void displayShopSeats();
}
