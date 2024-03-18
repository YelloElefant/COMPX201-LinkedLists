/**
 * this is the main class of the program that simulates a lotto draw
 * it takes {@link LottoDraw#WINNING_NUMBERS} random numbers from 1 -
 * {@link LottoDraw#MAX_NUMBER} and then
 * generates a pre
 * determind
 * amount of tickets
 * each ticket contains {@link LottoDraw#WINNING_NUMBERS} amount of random
 * numbers from 1 - {@link LottoDraw#MAX_NUMBER}
 * it then checks these {@link LottoDraw#WINNING_NUMBERS} values against the
 * winning numbers
 * winning numbers are also generated randomly from 1 -
 * {@link LottoDraw#MAX_NUMBER}
 * then prints out what each ticket won based on the amount of matches they have
 * with the winning numbers
 * 
 * @author Alexander Trotter
 * @version 1.0
 * @since 2024-03-13
 */
public class LottoDraw {

    /**
     * the main method of the program
     * it generates the winning numbers and then generates the tickets
     * and checks them against the winning numbers
     * then prints out what each ticket won
     * based on how many matches they have with the winning numbers
     * 
     * @param args - the command line arguments
     */
    public static void main(String[] args) {
        /**
         * the amount of tickets to generate
         */
        final int TICKETS = 100;

        /**
         * the amount of possible numbers
         */
        final int MAX_NUMBER = 40;

        /**
         * the amount of winning numbers
         */
        final int WINNING_NUMBERS = 6;

        /**
         * the list of prizes
         */
        final StrLinkedList PRIZES = new StrLinkedList();

        // add the prizes to the list
        PRIZES.add("$100000");
        PRIZES.add("$10000");
        PRIZES.add("$1000");
        PRIZES.add("$100");
        PRIZES.add("$10");
        PRIZES.add("$0");
        PRIZES.add("$0");
        PRIZES.add("$0");

        // add 1 - MAX_NUMBER to a new StrLinkedList as strings
        StrLinkedList possibleNumbersList = new StrLinkedList();
        for (int i = 1; i <= MAX_NUMBER; i++) {
            possibleNumbersList.add(Integer.toString(i));
        }
        System.out.println("Possible Numbers are...");
        possibleNumbersList.printInLine();

        // randomly select WINNING_NUMBERS amount of the numbers from
        // possibleNumbersList and add them to winningNumbersList
        StrLinkedList winningNumbersList = new StrLinkedList();
        for (int i = 0; i < WINNING_NUMBERS; i++) {
            int randomIndex = (int) (Math.random() * possibleNumbersList.getLength());
            String randomNumber = possibleNumbersList.getValueAt(randomIndex);
            winningNumbersList.add(randomNumber);
        }

        System.out.println("\nWinning Numbers are...");
        winningNumbersList.printInLine();
        System.out.println("\nTickets and there winnings...");

        // generate 100 lotto tickets and check if any of them are winners each
        // conataining WINNING_NUMBERS amount of numbers
        for (int i = 0; i < TICKETS; i++) {

            // start new ticket
            StrLinkedList ticket = new StrLinkedList();

            // randomly select WINNING_NUMBERS of the numbers from possibleNumbersList and
            // add them to the ticket and make sure there are no duplicates
            for (int j = 0; j < WINNING_NUMBERS; j++) {
                int randomIndex = (int) (Math.random() * possibleNumbersList.getLength());
                String randomNumber = possibleNumbersList.getValueAt(randomIndex);
                ticket.add(randomNumber);
                possibleNumbersList.remove(randomNumber);
            }

            // add the numbers back to the possibleNumbersList
            for (int j = 0; j < WINNING_NUMBERS; j++) {
                possibleNumbersList.add(ticket.getValueAt(j));
            }

            // to count how many matches the ticket has with the winning numbers
            int matches = 0;

            // check how many matches the ticket has with the winning numbers
            for (int j = 0; j < WINNING_NUMBERS; j++) {
                if (winningNumbersList.hasValue(ticket.getValueAt(j))) {
                    matches++;
                }
            }

            // print out the results and what the ticket won
            System.out.print("Ticket(" + (i + 1) + ") " + "wins: " + PRIZES.getValueAt(matches) + ", ");
            ticket.printInLine();
        }

    }
}