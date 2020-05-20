package ir.ac.aut.game.deck;

import ir.ac.aut.game.configuration.Card;

public class CardDeck extends ObjectDeck {

    public CardDeck(Card... cards) {
        super(cards);
    }

    public Card deal() throws ArrayIndexOutOfBoundsException {
        return (Card) super.deal();
    }
}
