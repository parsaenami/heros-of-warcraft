package ir.ac.aut.game.configuration;

import ir.ac.aut.game.cards.MonsterCard;
import ir.ac.aut.game.cards.SpellCard;
import ir.ac.aut.game.cards.TrapCard;
import ir.ac.aut.game.deck.CardDeck;
import ir.ac.aut.game.deck.SpecialDeck;

/**
 * Created by admin on 2017/04/25 ,0025.
 */
public class Player {
    private CardDeck mainDeck;
    private SpecialDeck specialDeck;
    private Card[] hand = new Card[5];
    private Special nextSpecial;
    private int lifePoints;

    public Player(CardDeck mainDeck, SpecialDeck specialDeck, int lifePoints) {
        this.mainDeck = mainDeck;
        this.specialDeck = specialDeck;
        this.lifePoints = lifePoints;
    }

    public Player(CardDeck mainDeck, SpecialDeck specialDeck) {
        this(mainDeck, specialDeck, 5000);
    }

    public Card[] getHand() {
        return hand;
    }

    public void setHand(Card[] hand) {
        this.hand = hand;
    }

    public Special getNextSpecial() {
        return nextSpecial;
    }

    public void setNextSpecial(Special nextSpecial) {
        this.nextSpecial = nextSpecial;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public boolean draw(int count) {
        for (int i = 0; i < count; i++) {
            if (hand[i] == null) {
                hand[i] = mainDeck.deal();
            }
        }
        return count == 5 || mainDeck.size() != 0;
    }

    public void drawSpecialCard() {
        if (nextSpecial == null) {
            nextSpecial = specialDeck.deal();
        }
    }

    public void nextTurnPrep() {
        if (!mainDeck.isEmpty()) {
            draw(1);
        } else {
            lifePoints -= 500;
        }
        if (nextSpecial == null) {
            drawSpecialCard();
        }
    }

    public boolean playCardFromHand(int whichCard, Field myField) {
        if (whichCard >= 0 && whichCard <= 4 && hand[whichCard] != null) {
            if (hand[whichCard] instanceof MonsterCard) {
                for (int i = 0; i < myField.getMonsters().length; i++) {
                    if (myField.getMonsters()[i] == null) {
                        myField.addMonsterCard((MonsterCard) hand[whichCard]);
                        hand[whichCard] = null;
                        return true;
                    }
                }
            } else if (hand[whichCard] instanceof SpellCard) {
                for (int i = 0; i < myField.getSpells().length; i++) {
                    if (myField.getSpells()[i] == null) {
                        myField.addSpellCard((SpellCard) hand[whichCard]);
                        hand[whichCard] = null;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean playSpecial(Field myField) {
        if (nextSpecial != null) {
            if (nextSpecial instanceof MonsterCard) {
                for (int i = 0; i < myField.getMonsters().length; i++) {
                    if (myField.getMonsters()[i] == null) {
                        myField.addMonsterCard((MonsterCard) nextSpecial);
                        nextSpecial = null;
                        return true;
                    }
                }
            } else if (nextSpecial instanceof TrapCard) {
                nextSpecial = null;
                return true;
            }
        }
        return false;
    }

    public void changeLifePoints(int change) {
        lifePoints += change;
    }

    public boolean isDefeated() {
        return lifePoints <= 0;
    }
}
