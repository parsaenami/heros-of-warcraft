package ir.ac.aut.game.cards;

import ir.ac.aut.game.configuration.Field;
import ir.ac.aut.game.configuration.Special;

public class BlueEyesWhiteDragon extends MonsterCard implements Special {

    public BlueEyesWhiteDragon() {
        super("Blue Eyes White Dragon", "The best card", 3000, true);
    }

    public void instantEffect(Field owner, Field enemy) {
        //owner.addMonsterCard(this);
        owner.addMonsterCard(new BlueEyesWhiteDragon());
    }
}
