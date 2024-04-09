package org.example.client;

public record Client(ClientType clientType, int clientNumber) {

    @Override
    public String toString() {
        return clientType.name() + clientNumber;
    }
}
