package ir.ac.aut.game.cards;

import ir.ac.aut.game.configuration.Card;
import ir.ac.aut.game.configuration.Special;

public abstract class TrapCard extends Card implements Special {

    public TrapCard(String name, String description) {
        super(name, description);
    }

    public boolean equals(Card card) {
        return card instanceof TrapCard && super.equals(card.getName(), card.getDescription());
    }
}
