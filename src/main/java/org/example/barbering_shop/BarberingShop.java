package org.example.barbering_shop;

import org.example.client.Client;
import org.example.client.ClientType;

import java.util.LinkedList;

public class BarberingShop implements BarberingShopInterface {
    private int vipClientCount = 0;
    private int ordClientCount = 0;
    private final LinkedList<Client> seatedClients = new LinkedList<>();
    private final int totalShopSeats = 6;


    public Client addClientToSeat(ClientType clientType) {
        Client client = createClient(clientType);

        if (client.clientType().equals(ClientType.VIP) && seatedClients.size() > 1) {
            addVIPClientToSeat(client);

        } else {
            seatedClients.add(client);
        }
        return client;

    }

    /**
     * This method is used to create a new client of a specific type.
     * @param clientType The type of the client to be created.
     * @return Client The newly created client.
     */
    private Client createClient(ClientType clientType) {

        int clientNumber = clientType.equals(ClientType.VIP) ? ++vipClientCount : ++ordClientCount;
        return new Client(clientType, clientNumber);
    }

    /**
     * This method is used to handle a VIP client in the barbering shop.
     * If the client at the second position is an ordinary client, the VIP client is added at the second position.
     * If the client at the second position is a VIP client, the new VIP client is added after the last VIP client in the queue.
     *
     * @param client The VIP client to be handled.
     */
    private void addVIPClientToSeat(Client client) {
        if (seatedClients.get(1).clientType() == ClientType.ORD) {
            seatedClients.add(1, client);
        } else if (seatedClients.get(1).clientType() == ClientType.VIP) {
            int indexOfLastVipClient = findLastVIPClientIndex();
            seatedClients.add(indexOfLastVipClient + 1, client);
        }
    }

    /**
     * This method is used to find the index of the last VIP client in the seatedClients list.
     * It starts from the end of the list and moves towards the beginning, checking each client's type.
     * If a VIP client is found, it returns the index of that client.
     * If no VIP client is found, it returns the size of the seatedClients list.
     *
     * @return int The index of the last VIP client in the seatedClients list, or the size of the list if no VIP client is found.
     */
    private int findLastVIPClientIndex() {
        for (int i = seatedClients.size() - 1; i >= 0; i--) {
            if (seatedClients.get(i).clientType() == ClientType.VIP) {
                return i;
            }
        }
        return seatedClients.size();
    }

    public void manageSeatsAvailability(ClientType clientType) {
        switch (clientType) {
            case VIP:
                ++vipClientCount;
                System.out.print("  ( +- VIP" + vipClientCount + " )");
                --vipClientCount;
                break;
            case ORD:
                ++ordClientCount;
                System.out.print("  ( +- ORD" + ordClientCount + " )");
                --ordClientCount;
                break;
            default:
                System.out.print("  ( ** NULL )");
        }
    }

    public Client removeClientFromSeat() {
        return seatedClients.pop();
    }

    public void displayShopSeats() {
        System.out.print("\t\t[");
        for (int i = 0; i < totalShopSeats; i++) {
            System.out.print("  " + (i < seatedClients.size() ? seatedClients.get(i) : "----"));
            System.out.print(i < totalShopSeats - 1 ? " :" : "");
        }
        System.out.print(" ]");
    }


    public LinkedList<Client> getSeatedClients() {
        return seatedClients;
    }

    public int getTotalShopSeats() {
        return totalShopSeats;
    }
}
