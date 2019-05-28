package tomasz.lukawski.cybergenesis.game.explore;

import tomasz.lukawski.cybergenesis.game.characters.EnemyCharacter;
import tomasz.lukawski.cybergenesis.game.characters.PlayerCharacter;
import tomasz.lukawski.cybergenesis.infrastructure.CommunicationInterface;
import tomasz.lukawski.cybergenesis.infrastructure.RandomGenerator;

import static tomasz.lukawski.cybergenesis.game.GameMessageSource.AFTER_FIGHT_MESSAGE;
import static tomasz.lukawski.cybergenesis.game.GameMessageSource.FREE_EXP_MESSAGE;

public class ExploreEngine {

    private CommunicationInterface communicationInterface;
    private RandomGenerator randomGenerator;
    private FightEngine fightEngine;


    public ExploreEngine(CommunicationInterface communicationInterface, RandomGenerator randomGenerator, FightEngine fightEngine) {
        this.communicationInterface = communicationInterface;
        this.randomGenerator = randomGenerator;
        this.fightEngine = fightEngine;
    }

    void explore(PlayerCharacter playerCharacter) {
        int random = randomGenerator.randomTo100();
        if (random > 90) {
            int freeExperience = randomGenerator.randomTo100();
            playerCharacter.gainExperience(freeExperience);
            communicationInterface.write(String.format(FREE_EXP_MESSAGE, freeExperience));
        } else {
            EnemyCharacter enemyCharacter = new EnemyCharacter(playerCharacter.getPlayerCoordinates().getPlayerDestination() / 2);
            FightEngine.FightResult result = fightEngine.fight(playerCharacter, enemyCharacter);
            int gainedExperience = getGainedExperience(enemyCharacter, result);
            playerCharacter.gainExperience(gainedExperience);
            communicationInterface.write(String.format(AFTER_FIGHT_MESSAGE, result.name(), gainedExperience));
        }
    }

    private int getGainedExperience(EnemyCharacter enemyCharacter, FightEngine.FightResult result) {
        return result == FightEngine.FightResult.WON ? enemyCharacter.getLevel() * 50 : enemyCharacter.getLevel() * -10;
    }
}
