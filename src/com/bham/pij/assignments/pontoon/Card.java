package com.bham.pij.assignments.pontoon;
// Ryan Arrowsmith 2132159

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Card {

    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    // Enums of inner classes are static anyway, so I don't need to declare them as such.
    public enum Value {

        ACE(1, 11), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10);

        int[] values;

        Value(int... ints) {
            this.values = ints;
        }

        public ArrayList<Integer> getNumericalValue() {
            return (ArrayList<Integer>) Arrays.stream(values).boxed().collect(Collectors.toList());
        }
    }

    // Enums of inner classes are static anyway, so I don't need to declare them as such.
    public enum Suit {

        CLUBS, DIAMONDS, HEARTS, SPADES;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public ArrayList<Integer> getNumericalValue() {
        return (value == null) ? (ArrayList<Integer>) Collections.singletonList(0) : value.getNumericalValue();
    }
}
