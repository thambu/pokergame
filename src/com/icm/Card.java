package com.icm;


/**
 * Created by 139115 on 26/03/2018.
 */

public class Card implements Comparable<Card> {

    private int rank;
    private String value;
    private String suit;

    public Card(String str) {
        value = String.valueOf(str.charAt(0));
        suit = String.valueOf(str.charAt(1));
        rank = ranking(value);
    }

    public int ranking(String cardValue) {
        for (Value value : Value.values()) {
            if (value.getCardCode().equals(cardValue)) {
                return value.getCardValue();
            }
        }
        return -1;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public int compareTo(Card anotherCard) {
        if (this.rank < anotherCard.rank) return -1;
        else if (this.rank > anotherCard.rank) return 1;
        else return 0;
    }

    @Override
    public boolean equals(Object o) {
        Card anotherCard = (Card) o;
        return this.rank == anotherCard.rank;
    }

    @Override
    public int hashCode() {
        return rank;
    }

    @Override
    public String toString() {
        return "[" + value + suit + "]";
    }

}