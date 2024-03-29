/**
 * this is the main class of the program that simulates a lotto draw
 * it takes WINNING_NUMBERS random numbers from 1 -
 * MAX_NUMBER and then
 * generates a pre
 * determind
 * amount of tickets
 * each ticket contains WINNING_NUMBERS amount of random
 * numbers from 1 - MAX_NUMBER
 * it then checks these WINNING_NUMBERS values against the
 * winning numbers
 * winning numbers are also generated randomly from 1 -
 * MAX_NUMBER
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
        // the amount of tickets to generate
        final int TICKETS = 100;
        // the max number that could be generated
        final int MAX_NUMBER = 40;
        // mthe min number that could be generated
        final int MIN_NUMBER = 1;
        // the amount of winning numbers
        final int WINNING_NUMBERS = 6;
        // the max prize
        int maxPrize = 100000;
        // the min prize
        final int MIN_PRIZE = 10;
        // the list of prizes
        final StrLinkedList PRIZES = new StrLinkedList();
        // the Min matches to recieve a prize
        final int MIN_MATCHES = 5;
        // the prize money that will be given out
        int prizeMoney = 0;
        // the ticket cost
        final int TICKET_COST = 10;
        // total ticket sales
        final int TOTAL_SALES = TICKETS * TICKET_COST;

        // add the prizes to the list
        for (int i = WINNING_NUMBERS + 1; i > 0; i--) {
            // the value of the prize based of 10^2
            double value = maxPrize;
            maxPrize /= 10;

            // check for the MIN_MATCHES for when to start setting the value to 0
            if (i == 1 || i < MIN_MATCHES) {
                value = 0;
            } else if (maxPrize < MIN_PRIZE) {
                value = MIN_PRIZE;
            }

            // add the prize to the list and remove the decimal point from the value
            PRIZES.add("$" + String.format("%f", value).split("\\.")[0]);
        }

        // print out the prizes
        System.out.println("Prizes are...");
        PRIZES.printInLine();

        // add 1 - MAX_NUMBER to a new StrLinkedList as strings
        StrLinkedList possibleNumbersList = new StrLinkedList();
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            possibleNumbersList.add(Integer.toString(i));
        }
        System.out.println("\nPossible Numbers are...");
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
            String prize = PRIZES.getValueAt(matches);
            System.out.print("Ticket(" + (i + 1) + ") " + "wins: " + prize + ", (matches:" + matches + "), ");
            ticket.printInLine();

            // adding the prize that the ticket won to the total prize money
            prizeMoney += Integer.parseInt(prize.substring(1));
        }
        // printing out the total prize money
        System.out.println("\nTotal Prize Money: $" + prizeMoney + ".00");
        System.out.println("Total Ticket Sold: " + TICKETS);
        System.out.println("Total Sales: $" + TOTAL_SALES + ".00");
        System.out.println("Total Profit: $" + (TOTAL_SALES - prizeMoney) + ".00");

    }
}