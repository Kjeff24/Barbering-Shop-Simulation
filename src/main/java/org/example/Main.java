package org.example;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Hashtable<Integer, Integer> event = new Hashtable<>();

        event.put(0, 0);
        event.put(1, 0);
        event.put(2, 0);

        LinkedList<String> seats = new LinkedList<>();

        int numSeat = 6;

        System.out.print("\tX");
        System.out.print("\t\t\tEvents");
        System.out.print("\t\t\t\t\t\t\tState of the Shop\n");
        System.out.print("+" + "-".repeat(9) + "+");
        System.out.print("+" + "-".repeat(14) + "+");
        System.out.print("+" + "-".repeat(56) + "+");

        int count = 0;
        while (count < 100) {
            String userInput = scanner.nextLine();

            // Check if the input contains space character
            boolean containsSpace = userInput.trim().isEmpty();

            if (containsSpace) {
                int x = new Random().nextInt(4);
                System.out.print(" " + x + " ---->   ");
                if (seats.size() < numSeat || x == 0) {
                    if (x == 0 && !seats.isEmpty() && !seats.getFirst().isEmpty()) {
                        String removedSeat = seats.pop();
                        System.out.print("  ( -- " + removedSeat + " )      ");
                    } else if (x == 1) {
                        event.put(x, event.getOrDefault(x, 0) + 1);
                        if (seats.size() > 1 && seats.get(1).contains("ORD")) {
                            seats.add(1, "VIP" + event.get(1));
                            System.out.print("  ( ++ VIP" + event.get(1) + " )      ");
                        } else if (seats.size() > 1 && seats.get(1).contains("VIP")) {
                            int lastIndex = -1;
                            for (int i = seats.size() - 1; i >= 0; i--) {
                                String element = seats.get(i);
                                if (element.contains("VIP")) {
                                    lastIndex = i;
                                    break;
                                }
                            }
                            seats.add(lastIndex + 1, "VIP" + event.get(1));

                            System.out.print("  ( ++ VIP" + event.get(1) + " )      ");
                        } else {
                            seats.add("VIP" + event.get(1));
                            System.out.print("  ( ++ VIP" + event.get(1) + " )      ");
                        }
                    } else if (x == 2 || x == 3) {
                        event.put(2, event.getOrDefault(2, 0) + 1);
                        seats.add("ORD" + event.get(2));
                        System.out.print("  ( ++ ORD" + event.get(2) + " )      ");
                    } else {
                        System.out.print("  ( ** NULL )      ");
                    }
                } else {
                    event.put(x, event.getOrDefault(x, 0) + 1);
                    if(x == 1){
                        System.out.print("  ( +- VIP" + event.get(1) + " )      ");
                    }else {
                        System.out.print("  ( +- ORD" + event.get(2) + " )      ");
                    }
                }
                System.out.print("[");
                for (int i = 0; i < seats.size(); i++) {
                    // Check if this is the last seat
                    if (i == seats.size() - 1) {
                        System.out.print("  " + seats.get(i) + " ");
                    } else {
                        System.out.print("  " + seats.get(i) + " :");
                    }
                }
                for (int i = 0; i < numSeat - seats.size(); i++) {
                    if (seats.size() == 0) {
                        if (i == 4) {
                            System.out.print("  ----  ");
                        }
                        else {

                            System.out.print("  ---- :");
                        }
                    } else {
                        System.out.print(": ----  ");
                    }
                }
                System.out.print("]");
            } else {
                System.out.println("The input does not contain the space key.");
                break;
            }

            count++;
        }

    }
}