package LinkedLists;

import LinkedLists.*;

public class LottoDraw {
    public static void main(String[] args) {

        // add 1 - 40 to a new StrLinkedList as strings

        StrLinkedList possibleNumbersList = new StrLinkedList();
        for (int i = 1; i <= 40; i++) {
            possibleNumbersList.add(Integer.toString(i));

        }

        // randomly select 6 of the numbers from possibleNumbersList and add them to
        // another StrLinkedList
        StrLinkedList winningNumbersList = new StrLinkedList();
        for (int i = 0; i < 6; i++) {
            int randomIndex = (int) (Math.random() * possibleNumbersList.getLength());
            String randomNumber = possibleNumbersList.getValueAt(randomIndex);
            winningNumbersList.add(randomNumber);
        }
        System.out.println("Winning Numbers are...");
        winningNumbersList.print();

        // generate 100 lotto tickets and check if any of them are winners each
        // conataining 6 numbers
        for (int i = 0; i < 1000; i++) {
            StrLinkedList ticket = new StrLinkedList();
            for (int j = 0; j < 6; j++) {
                int randomIndex = (int) (Math.random() * possibleNumbersList.getLength());
                String randomNumber = possibleNumbersList.getValueAt(randomIndex);
                ticket.add(randomNumber);
            }
            int matches = 0;
            for (int j = 0; j < 6; j++) {
                if (winningNumbersList.hasValue(ticket.getValueAt(j))) {
                    matches++;
                }
            }

            if (matches < 3) {
                // System.out.println("Ticket(" + (i + 1) + ") " + "wins: $0");
            } else {
                String numZero = new String(new char[matches - 2]).replace("\0", "0");
                System.out.println("Ticket(" + (i + 1) + ") " + "wins: $1" + numZero);

            }
        }

    }
}
