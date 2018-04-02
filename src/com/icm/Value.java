package com.icm;

/**
 * Created by 139115 on 26/03/2018.
 */
public enum Value {
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("T", 10),
    JACK("J", 11),
    QUEEN("Q", 12),
    KING("K", 13),
    ACE("A", 14);

    private String cardCode;

    private int cardValue;

    private Value(String cardCode, int cardValue) {

        this.cardValue = cardValue;
        this.cardCode = cardCode;
    }

    public int getCardValue() {
        return cardValue;
    }

    public String getCardCode() {
        return cardCode;
    }


}