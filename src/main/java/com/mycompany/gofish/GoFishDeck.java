package com.mycompany.gofish;

/**
 *
 * @author jennyle
 * @author saadkhan
 * @author destinyodia
 * 
 * Date: 07 April 2024
 */

public class GoFishDeck extends GroupOfCards{
    // private final List<GoFishCard> cards ;

    
    public GoFishDeck(int size) {
        super(size);
        // cards = new ArrayList<>();
        // for (Suit suit : Suit.values()) {
        //     for (Rank rank : Rank.values()) {
        //         cards.add(new GoFishCard(rank, suit));
        //     }
        // }
        // shuffle();
    }
    

    public GoFishCard dealCard() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(0);
    }

    public int size() {
        return cards.size();
    }
    
  
    
}
