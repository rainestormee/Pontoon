package com.bham.pij.assignments.pontoon;
// Ryan Arrowsmith 2132159

public abstract class CardGame {

    protected int nplayers;
    protected Deck deck;
    protected Player[] players;

    public CardGame(int nplayers) {
        this.nplayers = nplayers;
        players = new Player[nplayers];
        this.deck = new Deck();

        for (int i = 0; i < nplayers; i++) {
            players[i] = new Player("Player " + i);
        }

        dealInitialCards();
    }

    public abstract void dealInitialCards();

    public abstract int compareHands(Player hand1, Player hand2);

    public Deck getDeck() {
        return deck;
    }

    public Player getPlayer(int i) {
        return players[i];
    }

    public int getNumPlayers() {
        return nplayers;
    }
}
