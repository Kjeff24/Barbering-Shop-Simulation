package org.example.barbering_shop;

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
    public void testAddClientToSeat(){
        barberingShop.addClientToSeat(1);
        barberingShop.addClientToSeat(1);
        barberingShop.addClientToSeat(2);

        LinkedList<String> seats = barberingShop.getSeats();

        assertEquals("VIP1", seats.get(0));
        assertEquals("VIP2", seats.get(1));
        assertEquals("ORD1", seats.get(2));
    }

    @Test
    void removeClientFromSeat() {
        // Add a VIP client
        barberingShop.addClientToSeat(1);
        assertEquals("VIP1", barberingShop.getSeats().getFirst());

        // Remove the VIP client
        barberingShop.removeClientFromSeat();
        assertTrue(barberingShop.getSeats().isEmpty());
    }
}