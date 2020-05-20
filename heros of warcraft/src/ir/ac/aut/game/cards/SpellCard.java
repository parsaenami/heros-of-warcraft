package ir.ac.aut.game.cards;

import ir.ac.aut.game.configuration.Card;
import ir.ac.aut.game.configuration.Field;

public abstract class SpellCard extends Card {

    public SpellCard(String name, String description) {
        super(name, description);
    }

    public abstract void turnEffect(Field ownerField, Field enemyField);

    public abstract void destroyedEffect(Field ownerField, Field enemyField);

    public boolean equals(Card card) {
        return card instanceof SpellCard && super.equals(card.getName(), card.getDescription());
    }
}
