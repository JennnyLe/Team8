package com.mycompany.gofish;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jennyle
 * @author saadkhan
 * @author destinyodia
 * 
 * Date: 07 April 2024
 */

public class GoFish {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("GO FISH GAME!!!\n\nRules Of The Game\nPlayer A asks Player B for a specific card,"
                + " for example, \"Do you have any Fours?\"\n" +
"Player A, who asked for the card is considered the player who is \"fishing”. The player “fishing” must have at\n" +
"least one card of the number that was asked in their hand.\n" +
"If Player B has Fours, they must hand over all the Fours in their hand.\n" +
"If Player B has none, they \"Go fish!\" \n" +
"If Player A gets one or more Fours, they are entitled to ask Player B or another player for another card.\n" +
"Player A can ask for the same card or a different one.\n\n" +
"When a player makes a catch, they must reveal the card so that the catch is verified. If a player gets the\n" +
"fourth card of a book, the player shows all four cards, places them on the table face up in front of everyone\n" +
"and plays again.\n" +
"If the player goes fishing without \"making a catch\" (does not receive a card they asked for), the turn passes\n" +
"to the next player.\n" +
"The game ends when all thirteen books have been won. The winner is the player with the most books.\n" +
"\nYou can decide to QUIT anytime by Typing 'QUIT' in the response box and see your SCORE.");
        
        System.out.println("\n\n\n");

        System.out.print("Enter the name of Player A: ");
        String playerAName = scanner.nextLine(); // Read the name of Player A

        GoFishGame game = new GoFishGame("Go Fish Mulitiplayer Game");
        ArrayList<Player> players = game.getPlayers(); 
        players.add(new HumanPlayer(playerAName)); // Pass the name of Player A
        players.add(new ComputerPlayer("Computer"));

       System.out.print("The Players are:\n");
        for (Player player: players) {
            System.out.println(player);
        }
        System.out.println();
        System.out.println("PlayerA is " + players.get(0) + " and PlayerB is " + players.get(1));
        System.out.println();
        game.play();
    }
}
