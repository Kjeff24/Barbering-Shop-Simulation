# Barbering Shop Simulation

This Java program simulates the functioning of a barbering shop according to the given rules. It keeps track of ordinary (ORD) and VIP clients, their seating arrangement, and the movement of clients within the shop.

## Features
- Randomly generates events when the space key is pressed:
    - `-- clientName`: Barber is done trimming the hair of the current client.
    - `++ VIPi`: VIP client has come into the shop and is seated.
    - `++ ORDi`: Ordinary client has come into the shop and is seated.
    - `+- clientName`: Client has come and gone back due to all seats being occupied.
      The seating and movement of customers in the salon follows these rules:
- The seating and movement of customers in the salon follows these rules:
    - When a client comes in, and both main and waiting chairs are empty, he sits in the main
     chair to have his hair trimmed.
    - Any other client who comes into the shop while the main chair is occupied, will sit in the
     waiting chairs according to their arrival order. A client sits only if there is an available chair,
     otherwise he/she will have to leave the shop and come back later, regardless of their type
     ( ORD or VIP ) .
    - When a VIP comes into the shop while and the main chair is occupied and there is an
     available waiting chair, he sits in the first waiting chair so that he/she can be the next to sit in
     the main chair. If there was an ORD client in the first waiting chair, that ORD client has to
     move to the next seat making everyone in the queue to shift backward by one seat.
    - If a VIP is already in the queue, the next VIP who arrives will take seat after the last VIP .
    - When the barber is done with the client in the main chair, the next seated in chair No. 1 takes
     his place and the rest of the clients shift successively to occupy the next chairs and leave the
     empty chair behind them.
    - When clients have their hair trimmed, they leave and do not come back to the shop again.

## Usage

1. Run the program.
2. Press the space key to trigger an event.
3. The program will display the event along with the sitting order of clients in the shop.

## Requirements

- Java JDK installed.
