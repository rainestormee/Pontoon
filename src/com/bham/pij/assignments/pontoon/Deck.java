package com.bham.pij.assignments.pontoon;
// Ryan Arrowsmith 2132159

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Deck {

    ArrayList<Card> cards = new ArrayList<>();

    public Deck() {
        reset();
    }

    public void reset() {
        cards = new ArrayList<>();
        Arrays.stream(Card.Value.values()).forEach(v -> Arrays.stream(Card.Suit.values()).forEach(s -> cards.add(new Card(s, v))));
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card getCard(int i) {
        return cards.get(i);
    }

    public Card dealRandomCard() {
        Random random = new Random();
        int i = random.nextInt(size());
        Card card = getCard(i);
        cards.remove(card);
        return card;
    }

    public int size() {
        return cards.size();
    }
}
