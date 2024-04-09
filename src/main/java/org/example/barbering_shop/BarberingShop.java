package org.example.barbering_shop;

import org.example.client.Client;
import org.example.client.ClientType;

import java.util.LinkedList;

public class BarberingShop implements BarberingShopInterface{
    private int vipClientCount = 0;
    private int ordClientCount = 0;
    private final LinkedList<String> shopSeats = new LinkedList<>();
    private final int totalShopSeats = 6;

    public void addClientToSeat(int eventNumber) {
        ClientType clientType = (eventNumber == 1) ? ClientType.VIP : ClientType.ORD;
        int clientNumber = (eventNumber == 1) ? ++vipClientCount : ++ordClientCount;
        Client client = new Client(clientType, clientNumber);

        if (eventNumber == 1 && shopSeats.size() > 1 && shopSeats.get(1).contains(ClientType.ORD.name())){
            shopSeats.add(1, String.valueOf(client));

        } else if (eventNumber == 1 && shopSeats.size() > 1 && shopSeats.get(1).contains(ClientType.VIP.name())) {
            int index = findLastVIPClientIndex(shopSeats);
            shopSeats.add(index +1, String.valueOf(client));

        }else {
            shopSeats.add(String.valueOf(client));
        }
        System.out.print("  ( ++ " + client + " )");

    }

    public void handleEmptySeatOrFullShop(int eventNumber) {
        switch(eventNumber) {
            case 0:
                System.out.print("  ( ** NULL )");
                break;
            case 1:
                ++vipClientCount;
                System.out.print("  ( +- VIP" + vipClientCount + " )");
                --vipClientCount;
                break;
            default:
                ++ordClientCount;
                System.out.print("  ( +- ORD" + ordClientCount + " )");
                --ordClientCount;
        }
    }

    public void removeClientFromSeat() {
        String removedSeat = shopSeats.pop();
        System.out.print("  ( -- " + removedSeat + " )");
    }

    public void displayShopSeats() {
        System.out.print("\t\t[");
        for (int i = 0; i < totalShopSeats; i++) {
            System.out.print("  " + (i < shopSeats.size() ? shopSeats.get(i) : "----"));
            System.out.print(i < totalShopSeats - 1 ? " :" : "");
        }
        System.out.print(" ]");
    }

    /**
     * This method determines the last index position of a VIP client in the seats.
     * It iterates over the seats from the end to the start and returns the index of the last VIP client found.
     * If no VIP client is found, it returns the size of the seats.
     *
     * @param shopSeats A LinkedList representing the seats in the barbering shop.
     * @return The index of the last VIP client in the seats, or the size of the seats if no VIP client is found.
     */
    private int findLastVIPClientIndex(LinkedList<String> shopSeats) {
        for (int i = shopSeats.size() - 1; i >= 0; i--) {
            if (shopSeats.get(i).contains(ClientType.VIP.name())) {
                return i;
            }
        }
        return shopSeats.size();
    }

    public LinkedList<String> getShopSeats() {
        return shopSeats;
    }

    public int getTotalShopSeats() {
        return totalShopSeats;
    }
}
