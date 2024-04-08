package com.mycompany.gofish;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author jennyle
 * @author saadkhan
 * @author destinyodia
 * 
 * Date: 07 April 2024
 */

public class PlayersHand {
    private List<GoFishCard> cards;
    private List<Rank> books;


    public int countRank(Rank rank) {
        int count = 0;
            for (GoFishCard card : cards) {
        if (card.getRank() == rank) {
            count++;
        }
    }
    return count;
}

    public PlayersHand() {
        cards = new ArrayList<>();
        books = new ArrayList<>();
    }

    public void addCard(GoFishCard card) {
        cards.add(card);
    }

    public List<GoFishCard> getCards() {
        return cards;
    }

    public void addBook(Rank rank) {
        books.add(rank);
    }

    public List<Rank> getBooks() {
        return books;
    }
    

    public boolean hasRank(Rank rank) {
        int count = 0;
        for (GoFishCard card : cards) {
            if (card.getRank() == rank) {
                count++;
            }
        }
        return count == 4;
    }

    public boolean removeRank(Rank rank) {
        Iterator<GoFishCard> iterator = cards.iterator();
        boolean removed = false;
        while (iterator.hasNext()) {
            GoFishCard card = iterator.next();
            if (card.getRank() == rank) {
                iterator.remove();
                removed = true;
            }
        }
        return removed;
    }
    
}
