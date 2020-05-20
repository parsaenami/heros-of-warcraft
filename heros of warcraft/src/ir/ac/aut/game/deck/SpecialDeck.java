package ir.ac.aut.game.deck;

import ir.ac.aut.game.configuration.Special;

public class SpecialDeck extends ObjectDeck {

    public SpecialDeck(Special... specials) {
        super(specials);
    }

    public Special deal() throws ArrayIndexOutOfBoundsException {
        return (Special) super.deal();
    }
}
