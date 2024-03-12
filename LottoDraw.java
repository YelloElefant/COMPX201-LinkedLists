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
     * the amount of tickets to generate
     */
    private static final int TICKETS = 100;

    /**
     * the maximum number that can be generated for the winning/possible numbers
     */
    private static final int MAX_NUMBER = 40;

    private static final int WINNING_NUMBERS = 6;

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

        // add 1 - 40 to a new StrLinkedList as strings
        StrLinkedList possibleNumbersList = new StrLinkedList();

        for (int i = 1; i <= MAX_NUMBER; i++) {
            possibleNumbersList.add(Integer.toString(i));
        }

        // randomly select WINNING_NUMBERS amount of the numbers from
        // possibleNumbersList and add them to
        // another StrLinkedList
        StrLinkedList winningNumbersList = new StrLinkedList();

        for (int i = 0; i < WINNING_NUMBERS; i++) {
            int randomIndex = (int) (Math.random() * possibleNumbersList.getLength());
            String randomNumber = possibleNumbersList.getValueAt(randomIndex);
            winningNumbersList.add(randomNumber);
        }

        System.out.println("Winning Numbers are...");
        winningNumbersList.printInLine();

        // generate 100 lotto tickets and check if any of them are winners each
        // conataining WINNING_NUMBERS amount of numbers
        for (int i = 0; i < TICKETS; i++) {
            StrLinkedList ticket = new StrLinkedList();

            // randomly select WINNING_NUMBERS of the numbers from possibleNumbersList and
            // add them to the
            // ticket
            for (int j = 0; j < WINNING_NUMBERS; j++) {
                int randomIndex = (int) (Math.random() * possibleNumbersList.getLength());
                String randomNumber = possibleNumbersList.getValueAt(randomIndex);
                ticket.add(randomNumber);
            }

            int matches = 0;

            // check how many matches the ticket has with the winning numbers
            for (int j = 0; j < WINNING_NUMBERS; j++) {
                if (winningNumbersList.hasValue(ticket.getValueAt(j))) {
                    matches++;
                }
            }

            // print out the results and what the ticket won
            if (matches < 3) {
                System.out.println("Ticket(" + (i + 1) + ") " + "wins: $0");
            } else {
                String numZero = new String(new char[matches - 2]).replace("\0", "0");
                System.out.println("Ticket(" + (i + 1) + ") " + "wins: $1" + numZero);
            }
        }

    }
}
