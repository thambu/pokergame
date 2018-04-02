package com.icm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by 139115 on 27/03/2018.
 */
public final class HandType {

    public static HandTypeEnum getHand(List<Card> handCards) {
        if (isARoyalFlush(handCards)) return HandTypeEnum.ROYAL_FLUSH;
        else if (isStraightFlush(handCards)) return HandTypeEnum.STRAIGHT_FLUSH;
        else if (isFourOfAKind(handCards)) return HandTypeEnum.FOUR_OF_A_KIND;
        else if (isFullHouse(handCards)) return HandTypeEnum.FULL_HOUSE;
        else if (isFlush(handCards)) return HandTypeEnum.FLUSH;
        else if (isStraight(handCards)) return HandTypeEnum.STRAIGHT;
        else if (isThreeOfAKind(handCards)) return HandTypeEnum.THREE_OF_A_KIND;
        else if (isTwoPair(handCards)) return HandTypeEnum.TWO_PAIR;
        else if (isPair(handCards)) return HandTypeEnum.PAIR;
        else return HandTypeEnum.HIGH_CARD;
    }

    public static boolean isStraightFlush(List<Card> cards) {
        return isStraight(cards) && isFlush(cards) && !isARoyal(cards);
    }

    public static boolean isARoyalFlush(List<Card> cards) {
        return isStraight(cards) && isFlush(cards) && isARoyal(cards);
    }

    public static boolean isARoyal(List<Card> cards) {
        return cards.stream().allMatch(card -> card.getRank() >= 10);
    }

    // Items are sorted in descending order.
    public static boolean isStraight(List<Card> cards) {
        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i).getRank() != cards.get(i + 1).getRank() + 1) {
                return false;
            }
        }
        return true;
    }


    public static boolean isFlush(List<Card> cards) {
        return cards.stream().allMatch(card -> card.getSuit().equals(cards.get(0).getSuit()));
    }


    public static boolean isPair(List<Card> cards) {
        if (numberOfSameRankCard(cards, 2) == 1)
            return true;
        return false;
    }


    public static boolean isTwoPair(List<Card> cards) {
        if (numberOfSameRankCard(cards, 2) == 2)
            return true;
        return false;
    }

    public static boolean isFourOfAKind(List<Card> cards) {
        if (numberOfSameRankCard(cards, 4) == 1)
            return true;
        return false;
    }

    public static boolean isThreeOfAKind(List<Card> cards) {
        if (numberOfSameRankCard(cards, 3) == 1)
            return true;
        return false;
    }

    public static boolean isFullHouse(List<Card> cards) {
        if (numberOfSameRankCard(cards, 3) == 1 && numberOfSameRankCard(cards, 2) == 1) {
            return true;
        }
        return false;
    }

    public static long numberOfSameRankCard(List<Card> cards, int count) {
        Map<Integer, Long> ranksMap = cards.stream().collect(Collectors.groupingBy(Card::getRank, Collectors.counting()));
        return ranksMap.entrySet().stream().filter(card -> card.getValue() == count).count();
    }

    public static String getWinner(Hand hand1, Hand hand2) {
        HandTypeEnum hand1Rank = new HandType().getHand(hand1.getCards());
        HandTypeEnum hand2Rank = new HandType().getHand(hand2.getCards());
        int cmp = hand1Rank.compareTo(hand2Rank);
        if (cmp > 0) return hand1.getName();
        else if (cmp < 0) return hand2.getName();
        else {
            switch (hand1Rank) {
                case PAIR:
                case TWO_PAIR:
                    cmp = compareSameKindOfCard(hand1, hand2, 2);
                    break;
                case THREE_OF_A_KIND:
                case FULL_HOUSE:
                    cmp = compareSameKindOfCard(hand1, hand2, 3);
                    break;
                case FOUR_OF_A_KIND:
                    cmp = compareSameKindOfCard(hand1, hand2, 4);
                    break;
                case HIGH_CARD:
                case STRAIGHT:
                case FLUSH:
                case STRAIGHT_FLUSH:
                case ROYAL_FLUSH:
                    cmp = compareCardRank(hand1, hand2);
                    break;
            }
        }
        return cmp > 0 ? hand1.getName() : cmp < 0 ? hand2.getName() : "Tie.";
    }

    public static int compareCardRank(Hand hand1, Hand hand2) {
        List<Card> hand1Cards = hand1.getCards();
        List<Card> hand2Cards = hand2.getCards();
        for (int i = 0; i < hand1Cards.size(); i++) {
            if (hand1Cards.get(i).compareTo(hand2Cards.get(i)) != 0) {
                return hand1Cards.get(i).compareTo(hand2Cards.get(i));
            }
        }
        return 0;
    }

    public static int compareSameKindOfCard(Hand hand1, Hand hand2, int numberOfTimeSameValue) {
        List<Integer> hand1Cards = getCardRank(hand1.getCards(), numberOfTimeSameValue);
        List<Integer> hand2Cards = getCardRank(hand2.getCards(), numberOfTimeSameValue);
        for (int i = 0; i < hand1Cards.size(); i++) {
            if (hand1Cards.get(i).compareTo(hand2Cards.get(i)) != 0) {
                return hand1Cards.get(i).compareTo(hand2Cards.get(i));
            }
        }
        return 0;
    }


    public static List<Integer> getCardRank(List<Card> cards, int numberOfTimeSameValue) {
        List<Integer> sameRankList = new ArrayList<>();
        List<Integer> nonSameRankList = new ArrayList<>();
        Map<Integer, Long> ranksMap = cards.stream().collect(Collectors.groupingBy(Card::getRank, Collectors.counting()));
        for (Map.Entry<Integer, Long> entry : ranksMap.entrySet()) {
            if (entry.getValue() == numberOfTimeSameValue) {
                sameRankList.add(entry.getKey());
            } else {
                nonSameRankList.add(entry.getKey());
            }
        }
        Collections.sort(sameRankList, Collections.reverseOrder());
        Collections.sort(nonSameRankList, Collections.reverseOrder());
        sameRankList.addAll(nonSameRankList);
        return sameRankList;
    }

}
