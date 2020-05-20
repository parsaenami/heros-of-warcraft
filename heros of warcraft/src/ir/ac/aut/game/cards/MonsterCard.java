package ir.ac.aut.game.cards;

import ir.ac.aut.game.configuration.Card;

public class MonsterCard extends Card {
    private int power;
    private int basePower;
    private boolean canAttack;

    public MonsterCard(String name, String description, int power, boolean canAttack) {
        super(name, description);
        this.power = power;
        this.canAttack = canAttack;
    }

    public MonsterCard(String name, String description, int power) {
        this(name, description, power, false);
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getBasePower() {
        return basePower;
    }

    public boolean getCanAttack() {
        return canAttack;
    }

    public void setCanAttack(boolean canAttack) {
        this.canAttack = canAttack;
    }

    public boolean equals(String name, String description, int power, int basePower) {
        return super.equals(name, description) && this.power == power && this.basePower == basePower;
    }

    public String toString() {
        return super.toString() + " | " + "Power: " + this.power + " | " + "Can Attack: " + this.canAttack;
    }
}
