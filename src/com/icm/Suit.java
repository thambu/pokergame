package com.icm;

/**
 * Created by 139115 on 26/03/2018.
 */
public enum Suit {

    Diamonds("D", 1),
    Hearts("H", 2),
    Spades("S", 3),
    Clubs("C", 4);

    private final String suitCode;
    private final int suitValue;

    Suit(String code, int value) {
        this.suitCode = code;
        this.suitValue = value;
    }

    public String getSuitCode() {
        return suitCode;
    }

    public int getSuitValue() {
        return suitValue;
    }
}