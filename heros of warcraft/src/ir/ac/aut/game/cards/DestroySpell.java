package ir.ac.aut.game.cards;

import ir.ac.aut.game.configuration.Field;

public class DestroySpell extends TrapCard {

    public DestroySpell() {
        super("Destroy Spell", "Destroys the enemy’s first spell card");
    }

    @Override
    public void instantEffect(Field owner, Field enemy) {
        SpellCard[] eSpellCards = enemy.getSpells();
        for (int i = 0; i < 5; i++) {
            if (eSpellCards[i] != null) {
                eSpellCards[i] = null;
                return;
            }
        }
    }
}
