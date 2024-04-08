package com.mycompany.gofish;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jennyle
 * @author saadkhan
 * @author destinyodia
 * 
 * Date: 07 April 2024
 */

public class GoFishGameTest {
    
    public GoFishGameTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of promptForRank method, of class GoFishGame.
     */
    @Test
    // Test with a valid rank as input
    public void testPromptForRankGood() {
        System.out.println("promptForRank Good Test");
        String input = "ACE"; // Valid rank
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        GoFishGame instance = new GoFishGame("Player A");
        Rank result = instance.promptForRank(scanner);
        assertEquals(Rank.ACE, result); // We expect the input to be converted to Rank.ACE
    }

    @Test
    // Test promptForRank with bad input
    public void testPromptForRankBad() {
        System.out.println("promptForRank Bad Test");
        String input = "INVALID\n"; // Bad input
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        GoFishGame instance = new GoFishGame("Player A");
        Rank result = instance.promptForRank(scanner);
        assertNull(result); // We expect null as the input is invalid
    }

    @Test
    // Test promptForRank with boundary input (empty input)
    public void testPromptForRankBoundary() {
        System.out.println("promptForRank Boundary Test");
        String input = "\n"; // Empty input
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        GoFishGame instance = new GoFishGame("Player A");
        Rank result = instance.promptForRank(scanner);
        assertNull(result); // We expect null as the input is empty
    }



    /**
     * Test of checkBooks method, of class GoFishGame.
     */
    @Test
    // Four cards of same rank are dealt to create a book
    public void testCheckBooksGood() {
        System.out.println("checkBooks Good Test");
        PlayersHand hand = new PlayersHand();
        hand.addCard(new GoFishCard(Rank.ACE, Suit.HEARTS));
        hand.addCard(new GoFishCard(Rank.ACE, Suit.DIAMONDS));
        hand.addCard(new GoFishCard(Rank.ACE, Suit.CLUBS));
        hand.addCard(new GoFishCard(Rank.ACE, Suit.SPADES));
        GoFishGame instance = new GoFishGame("Player A");
        instance.checkBooks(hand);
        assertEquals(1, hand.getBooks().size()); // We expect 1 book of ACE
    }

    @Test
    // No cards are dealt so no books are detected
    public void testCheckBooksBad() {
        System.out.println("checkBooks Bad Test");
        PlayersHand hand = new PlayersHand(); // Empty hand
        GoFishGame instance = new GoFishGame("Player A");
        instance.checkBooks(hand);
        assertEquals(0, hand.getBooks().size()); // We expect no books
    }

    @Test
    // Only three cards are dealt so no books are detected as we are short one card
    public void testCheckBooksBoundary() {
        System.out.println("checkBooks Boundary Test");
        PlayersHand hand = new PlayersHand();
        hand.addCard(new GoFishCard(Rank.ACE, Suit.HEARTS));
        hand.addCard(new GoFishCard(Rank.ACE, Suit.DIAMONDS));
        hand.addCard(new GoFishCard(Rank.ACE, Suit.CLUBS));
        GoFishGame instance = new GoFishGame("Player A");
        instance.checkBooks(hand);
        assertEquals(0, hand.getBooks().size()); // We expect no books because it's one card short for a book
    }
    
    @Test
    // Test getRandomRank with good input
    public void testGetRandomRankGood() {
        System.out.println("getRandomRank Good Test");
        PlayersHand hand = new PlayersHand();
        hand.addCard(new GoFishCard(Rank.ACE, Suit.HEARTS));
        hand.addCard(new GoFishCard(Rank.TWO, Suit.DIAMONDS));
        hand.addCard(new GoFishCard(Rank.THREE, Suit.CLUBS));
        GoFishGame instance = new GoFishGame("Player A");
        Rank result = instance.getRandomRank(hand);
        assertNotNull(result); // We expect a non-null result
    }

    @Test
    // Test getRandomRank with bad input (empty hand)
    public void testGetRandomRankBad() {
        System.out.println("getRandomRank Bad Test");
        PlayersHand hand = new PlayersHand(); // Empty hand
        GoFishGame instance = new GoFishGame("Player A");
        Rank result = instance.getRandomRank(hand);
        assertNull(result); // We expect null as the hand is empty
    }

    @Test
    // Test getRandomRank with boundary input (hand with only one card)
    public void testGetRandomRankBoundary() {
        System.out.println("getRandomRank Boundary Test");
        PlayersHand hand = new PlayersHand();
        hand.addCard(new GoFishCard(Rank.ACE, Suit.HEARTS)); // Only one card
        GoFishGame instance = new GoFishGame("Player A");
        Rank result = instance.getRandomRank(hand);
        assertNotNull(result); // We expect a non-null result even with one card
    }

    /**
     * Test of getRandomRank method, of class GoFishGame.
    @Test
    public void testGetRandomRank() {
        System.out.println("getRandomRank");
        PlayersHand hand = null;
        GoFishGame instance = null;
        Rank expResult = null;
        Rank result = instance.getRandomRank(hand);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    } */

    /**
     * Test of play method, of class GoFishGame.
    @Test
    public void testPlay() {
        System.out.println("play");
        GoFishGame instance = null;
        instance.play();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    } */

    /**
     * Test of declareWinner method, of class GoFishGame.
    @Test
    public void testDeclareWinner() {
        System.out.println("declareWinner");
        GoFishGame instance = null;
        instance.declareWinner();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    } */
    
}
