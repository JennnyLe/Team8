package com.mycompany.gofish;

/**
 *
 * @author jennyle
 * @author saadkhan
 * @author destinyodia
 * 
 * Date: 07 April 2024
 */

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class GoFishGame extends Game {
    private GoFishDeck deck;
    private PlayersHand playerHand;
    private PlayersHand computerHand;

    public GoFishGame(String name) {
        super(name);
        deck = new GoFishDeck(52);
        playerHand = new PlayersHand();
        computerHand = new PlayersHand();
        dealHands();
    } 
    private void dealHands() {
        for (int i = 0; i < 7; i++) {
            playerHand.addCard(deck.dealCard());
            computerHand.addCard(deck.dealCard());
        }
    }

    public Rank promptForRank(Scanner scanner) {
        while (true) {
            System.out.print("\nYour Turn\nAsk opponent for a rank (e.g. ACE, TWO, THREE etc.): ");
            String input = scanner.nextLine().toUpperCase();
            String end="QUIT";
            if (input.equals(end)) {
                endGame();
            } else {
                try {
                    Rank rank = Rank.valueOf(input);
                    return rank;
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid input. Please enter a valid rank.");
                }
            }
        }
    }
    

    public void checkBooks(PlayersHand hand) {
        for (Rank rank : Rank.values()) {
        if (hand.countRank(rank) == 4) { // If there are 4 cards of the same rank, remove them and add a book
            hand.removeRank(rank);
            hand.addBook(rank);
            System.out.println("Player has a book of " + rank);
        }
    }
}

    public Rank getRandomRank(PlayersHand hand) {
        List<GoFishCard> cards = hand.getCards();
        Random random = new Random();
            return cards.get(random.nextInt(cards.size())).getRank();
    }
    private void endGame() {
        System.out.println();
        System.out.println("Game over!!!");
        if (playerHand.getBooks().isEmpty()){
            System.out.println("Your Books is empty");
        }
        else{
        System.out.println("Your Books: " + playerHand.getBooks());
        }
        if (computerHand.getBooks().isEmpty()){
            System.out.println("Player B's Books is empty");
        }
        else{
        System.out.println("Player B's Books: " + computerHand.getBooks());
        }
        declareWinner();
        System.exit(0);
        
    }
    
    @Override
    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Your Hand: " + playerHand.getCards());
            System.out.println("Your Books: " + playerHand.getBooks());
            Rank rank = promptForRank(scanner);
            
        
      
        // Check if Player B has the requested rank
        boolean playerBHasRank = false;
        for (GoFishCard card : computerHand.getCards()) {
            if (card.getRank().toString().equalsIgnoreCase(rank.toString())) {
            playerBHasRank = true;
            break;
            }
        }

        if (playerBHasRank) {
            System.out.println("Congratulations! Player B has " + rank);
            // Transfer all cards with the requested rank from Player B to Player A
            for (Iterator<GoFishCard> iterator = computerHand.getCards().iterator(); iterator.hasNext();) {
                GoFishCard card = iterator.next();
            if (card.getRank().toString().equalsIgnoreCase(rank.toString())) {
                playerHand.addCard(card);
                iterator.remove();
                }
            }
        }
        else {
                System.out.println("Sorry, Player B does not have that card\nGo fish!!!");
                GoFishCard card = deck.dealCard();
                if (card != null) {
                    playerHand.addCard(card);
                    System.out.println("Draw a card from the deck...\n\n");
                    System.out.println("You drew: " + card);
                }
            }
        checkBooks(playerHand);
        if (playerHand.getCards().isEmpty() || deck.size() == 0) {
            break;
        }

        rank = getRandomRank(computerHand);

        System.out.println("\nPlayerB's turn...");
        System.out.println("Player B asks for: " + rank);

            // Check if Player A has the requested rank
        boolean playerAHasRank = false;
        for (GoFishCard card : playerHand.getCards()) {
            if (card.getRank().toString().equalsIgnoreCase(rank.toString())) {
                playerAHasRank = true;
                break;
            }
        }

        if (playerAHasRank) {
            System.out.println("");
            System.out.println("You have " + rank);
            System.out.println("Please give all the cards of rank " + rank+" to PlayerB");
        // Transfer all cards with the requested rank from Player A to Player B
            for (Iterator<GoFishCard> iterator = playerHand.getCards().iterator(); iterator.hasNext();) {
                GoFishCard card = iterator.next();
                if (card.getRank().toString().equalsIgnoreCase(rank.toString())) {
                    computerHand.addCard(card);
                    iterator.remove();
                }
            }
        }
        else {
            System.out.println("\nYou do not have that card\nPlayerB is going fishing");
            GoFishCard card = deck.dealCard();
            if (card != null) {
                computerHand.addCard(card);
            }
        }
            checkBooks(computerHand);
            if (computerHand.getCards().isEmpty() || deck.size() == 0) {
                break;
            }
        }
        endGame();
}
    @Override
    public void declareWinner() {
        int playerBooks = playerHand.getBooks().size();
        int computerBooks = computerHand.getBooks().size();
        if (playerBooks > computerBooks) {
            System.out.println("You wins!");
        } else if (computerBooks > playerBooks) {
            System.out.println("Player B wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
    
}
