package com.icm;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 139115 on 26/03/2018.
 */
public class Hand {

    List<Card> cards = new ArrayList<>();
    private String name;

    public Hand(String handString, String name) throws Exception {
        String[] inputCards = handString.split(" ");
        if (inputCards.length == 5) {
            for (int i = 0; i < inputCards.length; i++) {
                Card card = new Card(inputCards[i]);
                cards.add(card);
            }
            // Sort in reverse order. High rank first.
            this.cards = cards.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            this.name = name;
        } else {
            throw new Exception("Invalid number of Cards");
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}