package ir.ac.aut.game.configuration;

import ir.ac.aut.game.cards.MonsterCard;
import ir.ac.aut.game.cards.SpellCard;

public class Field {
    private MonsterCard[] monsters = new MonsterCard[5];
    private SpellCard[] spells = new SpellCard[5];
    private int index = 0;

    public MonsterCard[] getMonsters() {
        return monsters;
    }

    public SpellCard[] getSpells() {
        return spells;
    }

    public void cardTurnEffects(Field enemyField) {
        SpellCard[] eSpells = enemyField.getSpells();
        MonsterCard[] eMonsters = enemyField.getMonsters();
        for (int i = 0; i < 5; i++) {
            if (eSpells[i] != null) {
                eSpells[i].turnEffect(this, enemyField);
            }
            if (eMonsters[i] != null) {
                eMonsters[i].setCanAttack(true);
            }
        }
    }

    public boolean addMonsterCard(MonsterCard card) {
        for (int i = 0; i < 5; i++) {
            if (monsters[i] == null) {
                monsters[i] = card;
                return true;
            }
        }
        return false;
    }

    public boolean addSpellCard(SpellCard card) {
        for (int i = 0; i < 5; i++) {
            if (spells[i] == null) {
                spells[i] = card;
                return true;
            }
        }
        return false;
    }
}
