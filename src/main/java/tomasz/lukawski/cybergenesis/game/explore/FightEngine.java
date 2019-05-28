package tomasz.lukawski.cybergenesis.game.explore;

import tomasz.lukawski.cybergenesis.game.characters.Character;

public class FightEngine {

    FightResult fight(Character player, Character enemy) {
        if (player.getAttack() >= enemy.getAttack()) {
            return FightResult.WON;
        } else {
            return FightResult.LOST;
        }
    }

    enum FightResult {
        WON,
        LOST
    }
}
