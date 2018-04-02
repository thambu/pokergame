package com.icm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by 139115 on 27/03/2018.
 */
public class PokerGameExecute {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String twoHands = "";
        int player1WinCount = 0;
        int player2WinCount = 0;
        int tie=0;
        while (input.hasNextLine()) {
            twoHands = input.nextLine();
            String player1 = twoHands.substring(0, twoHands.length() / 2);
            String player2 = twoHands.substring(twoHands.length() / 2 + 1, twoHands.length());
            Hand player1Hand = new Hand(player1, "Player 1");
            Hand player2Hand = new Hand(player2, "Player 2");
            String result = HandType.getWinner(player1Hand, player2Hand);
            if (result.equals("Tie.")) tie = tie + 1;
            else if (result.equals("Player 1")) {
                player1WinCount = player1WinCount + 1;
            } else if (result.equals("Player 2")) {
                player2WinCount = player2WinCount + 1;
            }
        }
        System.out.println("Player 1 : " + player1WinCount);
        System.out.println("Player 2 : " + player2WinCount);
    }
}
