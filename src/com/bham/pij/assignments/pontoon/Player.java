package com.bham.pij.assignments.pontoon;
// Ryan Arrowsmith 2132159

import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Player {

    private final String name;
    private final ArrayList<Card> hand;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void dealToPlayer(Card card) {
        hand.add(card);
    }

    public void removeCard(Card card) {
        hand.remove(card);
    }

    public ArrayList<Integer> getNumericalHandValue() {
        return (ArrayList<Integer>) IntStream.range(0, 4 + 1).boxed().mapToInt(i -> getAceValue(hand, i)).boxed().distinct().collect(Collectors.toList());
    }

    public int getBestNumericalHandValue() {
        return getNumericalHandValue().stream().max(Comparator.comparingInt(i -> i)).orElse(0);
    }

    public int getBestValidNumericalHandValue() {
        return getNumericalHandValue().stream().filter(i -> i <= 21).max((Comparator.comparingInt(i -> i))).orElse(0);
    }

    public ArrayList<Card> getCards() {
        return hand;
    }

    public int getHandSize() {
        return hand.size();
    }

    private int getAceValue(ArrayList<Card> cards, int nAces) {
        AtomicInteger aces = new AtomicInteger(nAces);
        return cards.stream().mapToInt(c -> c.getNumericalValue().get((c.getValue().equals(Card.Value.ACE) && (aces.get() > 0)) ? (c.getNumericalValue().get(aces.decrementAndGet() == aces.get() ? 1 : null)) : 0)).sum();
    }
}