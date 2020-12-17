package com.bham.pij.assignments.pontoon;

public class Test {

    public static void main(String[] args) {
        Player player = new Player("bob");
        player.dealToPlayer(new Card(Card.Suit.CLUBS, Card.Value.ACE));
        player.dealToPlayer(new Card(Card.Suit.CLUBS, Card.Value.ACE));
        player.dealToPlayer(new Card(Card.Suit.CLUBS, Card.Value.ACE));
        player.dealToPlayer(new Card(Card.Suit.CLUBS, Card.Value.ACE));
        player.getNumericalHandValue().forEach(System.out::println);
        System.out.print(player.getNumericalHandValue());
        System.out.println(player.getBestNumericalHandValue());
    }
}
