package com.bham.pij.assignments.pontoon;
// Ryan Arrowsmith 2132159

import java.util.Arrays;

public class Pontoon extends CardGame {

    public Pontoon(int pontoon) {
        super(pontoon);
    }

    @Override
    public void dealInitialCards() {
        Arrays.stream(players).forEach(p -> {
            p.dealToPlayer(deck.dealRandomCard());
            p.dealToPlayer(deck.dealRandomCard());
        });
    }

    public void twist(Player player) {
        while (player.getBestNumericalHandValue() < 16) player.dealToPlayer(deck.dealRandomCard());
    }

    @Override
    public int compareHands(Player hand1, Player hand2) {
        int rank1 = findRank(hand1);
        int rank2 = findRank(hand2);
        if (rank1 > rank2) {
            return -1;
        }
        if (rank1 < rank2) {
            return 1;
        }
        return (rank1 != 1) ? 0 : Integer.compare(hand2.getBestValidNumericalHandValue(), hand1.getBestValidNumericalHandValue());
    }

    public int findRank(Player hand) {
        int value = hand.getBestValidNumericalHandValue();
        int size = hand.getHandSize();
        return (value > 21) ? 0 : ((value == 21) && size == 2) ? 4 : (size == 5) ? 3 : (value < 21 ? 1 : 2);
    }
}
