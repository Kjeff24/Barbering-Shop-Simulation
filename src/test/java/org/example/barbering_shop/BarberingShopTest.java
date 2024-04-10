package org.example.barbering_shop;

import org.example.client.Client;
import org.example.client.ClientType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class BarberingShopTest {

    private BarberingShop barberingShop;

    @BeforeEach
    void setUp() {
        barberingShop = new BarberingShop();
    }

    @Test
    void addClientToSeat() {
        Client vipClient = barberingShop.addClientToSeat(ClientType.VIP);
        assertTrue(barberingShop.getSeatedClients().contains(vipClient));
        assertEquals(1, barberingShop.getSeatedClients().size());

        Client ordClient = barberingShop.addClientToSeat(ClientType.ORD);
        assertTrue(barberingShop.getSeatedClients().contains(ordClient));
        assertEquals(2, barberingShop.getSeatedClients().size());
    }

    @Test
    void removeClientFromSeat() {
        Client vipClient = barberingShop.addClientToSeat(ClientType.VIP);
        Client removedClient = barberingShop.removeClientFromSeat();
        assertEquals(vipClient, removedClient);
    }

    @Test
    void getTotalShopSeats() {
        assertEquals(6, barberingShop.getTotalShopSeats());
    }

    @Test
    void getSeatedClients() {
        barberingShop.addClientToSeat(ClientType.VIP);
        LinkedList<Client> seatedClients = barberingShop.getSeatedClients();
        assertEquals(1, seatedClients.size());
        assertEquals(ClientType.VIP, seatedClients.get(0).clientType());
    }
}