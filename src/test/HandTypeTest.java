package test;

import com.icm.Hand;
import junit.framework.TestCase;
import com.icm.HandTypeEnum;
import com.icm.HandType;
import org.junit.Assert;

/**
 * Created by 139115 on 2/04/2018.
 */
public class HandTypeTest extends TestCase {


    public void testHighHand() throws Exception {
        String highCard = "7S 3C 9S KC 6C";
        Hand hand = new Hand(highCard, "");
        Assert.assertEquals(HandTypeEnum.HIGH_CARD, HandType.getHand(hand.getCards()));
    }

    public void testPairHand() throws Exception {
        String pairCard = "7S 3C 9S KC KC";
        Hand hand = new Hand(pairCard, "");
        Assert.assertEquals(HandTypeEnum.PAIR, HandType.getHand(hand.getCards()));
    }

    public void testTwoPairHand() throws Exception {
        String twoPairCard = "7S 7C 9S KC KC";
        Hand hand = new Hand(twoPairCard, "");
        Assert.assertEquals(HandTypeEnum.PAIR, HandType.getHand(hand.getCards()));
    }

    public void testThreeOfKindHand() throws Exception {
        String threeOfKindHard = "7S 6C KS KC KC";
        Hand hand = new Hand(threeOfKindHard, "");
        Assert.assertEquals(HandTypeEnum.THREE_OF_A_KIND, HandType.getHand(hand.getCards()));
    }

    public void testStraightHand() throws Exception {
        String straightHand = "2S 3C 4S 5C 6C";
        Hand hand = new Hand(straightHand, "");
        Assert.assertEquals(HandTypeEnum.STRAIGHT, HandType.getHand(hand.getCards()));
    }

    public void testFlushHand() throws Exception {
        String flushHand = "2C 3C 9C 5C 6C";
        Hand hand = new Hand(flushHand, "");
        Assert.assertEquals(HandTypeEnum.FLUSH, HandType.getHand(hand.getCards()));
    }

    public void testFullHouseHand() throws Exception {
        String fullHouseHand = "3C 3S 9C 9C 9S";
        Hand hand = new Hand(fullHouseHand, "");
        Assert.assertEquals(HandTypeEnum.FULL_HOUSE, HandType.getHand(hand.getCards()));
    }

    public void testFourOfKindHand() throws Exception {
        String fourOfKindHand = "3C 9S 9C 9C 9S";
        Hand hand = new Hand(fourOfKindHand, "");
        Assert.assertEquals(HandTypeEnum.FOUR_OF_A_KIND, HandType.getHand(hand.getCards()));
    }

    public void testStraightFlushHand() throws Exception {
        String straightFlushHand = "2C 3C 4C 5C 6C";
        Hand hand = new Hand(straightFlushHand, "");
        Assert.assertEquals(HandTypeEnum.STRAIGHT_FLUSH, HandType.getHand(hand.getCards()));
    }

    public void testRoyalFlushHand() throws Exception {
        String royalFlushHandHand = "TC JC QC KC AC";
        Hand hand = new Hand(royalFlushHandHand, "");
        Assert.assertEquals(HandTypeEnum.ROYAL_FLUSH, HandType.getHand(hand.getCards()));
    }

    public void testEqualHighCardHand() throws Exception {
        Hand player1Hand = new Hand("AH 4C 3S 8C 2H", "Player 1");
        Hand player2Hand = new Hand("5D 7S 6C 4H JH", "Player 2");
        Assert.assertEquals("Player 1", HandType.getWinner(player1Hand, player2Hand));
    }

    public void testEqualPairHand() throws Exception {
        Hand player1Hand = new Hand("AH 4C 8S 8C 2H", "Player 1");
        Hand player2Hand = new Hand("5D 7S 6C JH JH", "Player 2");
        Assert.assertEquals("Player 2", HandType.getWinner(player1Hand, player2Hand));
    }

    public void testEqualTwoPairHand() throws Exception {
        Hand player1Hand = new Hand("AH 4C 8S 8C 4H", "Player 1");
        Hand player2Hand = new Hand("5D 7S 7C JH JH", "Player 2");
        Assert.assertEquals("Player 2", HandType.getWinner(player1Hand, player2Hand));
    }

    public void testEqualThreeOfKindHand() throws Exception {
        Hand player1Hand = new Hand("AH 8C 8S 8C 4H", "Player 1");
        Hand player2Hand = new Hand("5D 7S 7C 7H JH", "Player 2");
        Assert.assertEquals("Player 1", HandType.getWinner(player1Hand, player2Hand));
    }

    public void testEqualStraightHand() throws Exception {
        Hand player1Hand = new Hand("5H 6C 7S 8C 9H", "Player 1");
        Hand player2Hand = new Hand("7D 8S 9C TH JH", "Player 2");
        Assert.assertEquals("Player 2", HandType.getWinner(player1Hand, player2Hand));
    }

    public void testEqualFlushHand() throws Exception {
        Hand player1Hand = new Hand("AC 8C 8S 8C 4C", "Player 1");
        Hand player2Hand = new Hand("5H 7H 7H JH JH", "Player 2");
        Assert.assertEquals("Player 1", HandType.getWinner(player1Hand, player2Hand));
    }

    public void testEqualFullHouseHand() throws Exception {
        Hand player1Hand = new Hand("4C 8C 8S 8C 4C", "Player 1");
        Hand player2Hand = new Hand("JH 7H 7H JH JH", "Player 2");
        Assert.assertEquals("Player 2", HandType.getWinner(player1Hand, player2Hand));
    }

    public void testEqualFourOfKindHand() throws Exception {
        Hand player1Hand = new Hand("4C 8C 8S 8C 8C", "Player 1");
        Hand player2Hand = new Hand("7H 7H 7H 7H JH", "Player 2");
        Assert.assertEquals("Player 1", HandType.getWinner(player1Hand, player2Hand));
    }

    public void testEqualStraightFlushtHand() throws Exception {
        Hand player1Hand = new Hand("4C 5C 6S 7C 8C", "Player 1");
        Hand player2Hand = new Hand("8H 9H TH JH QH", "Player 2");
        Assert.assertEquals("Player 2", HandType.getWinner(player1Hand, player2Hand));
    }

}
