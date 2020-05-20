package ir.ac.aut.game.cards;

import ir.ac.aut.game.configuration.Field;

public class PowerCard extends SpellCard {
    private MonsterCard[] monsterCards;

    public PowerCard() {
        super("Power Card", "Increases power of monsters by 100 each turn");
    }

    @Override
    public void turnEffect(Field ownerField, Field enemyField) {
        monsterCards = ownerField.getMonsters();
        for (int i = 0; i < 5; i++) {
            if (monsterCards[i] != null) {
                monsterCards[i].setPower(monsterCards[i].getPower() + 100);
            }
        }
    }

    @Override
    public void destroyedEffect(Field ownerField, Field enemyField) {
        monsterCards = ownerField.getMonsters();
        for (int i = 0; i < 5; i++) {
            if (monsterCards[i] != null) {
                monsterCards[i].setPower(monsterCards[i].getPower() - 300);
            }
        }
    }
}
