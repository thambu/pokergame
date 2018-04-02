package com.icm;

/**
 * Created by 139115 on 26/03/2018.
 */
public enum HandTypeEnum {

    HIGH_CARD(1),
    PAIR(2),
    TWO_PAIR(3),
    THREE_OF_A_KIND(4),
    STRAIGHT(5),
    FLUSH(6),
    FULL_HOUSE(7),
    FOUR_OF_A_KIND(8),
    STRAIGHT_FLUSH(9),
    ROYAL_FLUSH(10);

    HandTypeEnum(int handRank) {
        this.handRank = handRank;
    }

    private final int handRank;

    public int getHandRank() {
        return handRank;
    }
}
