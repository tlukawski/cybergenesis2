package tomasz.lukawski.cybergenesis.game;

import tomasz.lukawski.cybergenesis.game.action.GameAction;
import tomasz.lukawski.cybergenesis.game.action.GameCommand;
import tomasz.lukawski.cybergenesis.game.action.UnknownAction;
import tomasz.lukawski.cybergenesis.game.characters.AboutCharacterAction;
import tomasz.lukawski.cybergenesis.game.characters.PlayerCharacter;
import tomasz.lukawski.cybergenesis.game.explore.ExploreAction;
import tomasz.lukawski.cybergenesis.game.explore.ExploreEngine;
import tomasz.lukawski.cybergenesis.game.explore.FightEngine;
import tomasz.lukawski.cybergenesis.game.loading.PlayerCharacterFacade;
import tomasz.lukawski.cybergenesis.game.loading.SaveGameAction;
import tomasz.lukawski.cybergenesis.infrastructure.CommunicationInterface;
import tomasz.lukawski.cybergenesis.infrastructure.RandomGenerator;

import java.util.HashMap;
import java.util.Map;

import static tomasz.lukawski.cybergenesis.game.GameMessageSource.GAME_COMMAND_CHOOSE;
import static tomasz.lukawski.cybergenesis.game.GameMessageSource.WELCOME_TEXT;

public class GameLoop {

    private CommunicationInterface communicationInterface;
    private PlayerCharacter playerCharacter;
    private Map<GameCommand, GameAction> gameActions;

    public GameLoop(CommunicationInterface communicationInterface, RandomGenerator randomGenerator) {
        this.communicationInterface = communicationInterface;

        FightEngine fightEngine = new FightEngine();
        ExploreEngine exploreEngine = new ExploreEngine(communicationInterface, randomGenerator, fightEngine);

        gameActions = new HashMap<>();
        gameActions.put(GameCommand.SAVE_GAME, new SaveGameAction(communicationInterface));
        gameActions.put(GameCommand.ABOUT_CHARACTER, new AboutCharacterAction(communicationInterface));
        gameActions.put(GameCommand.EXPLORE, new ExploreAction(communicationInterface, exploreEngine));
        gameActions.put(null, new UnknownAction(communicationInterface));
    }

    public void play() {
        communicationInterface.write(WELCOME_TEXT);
        playerCharacter = new PlayerCharacterFacade(communicationInterface).getPlayerCharacter(
                communicationInterface.getGameCommand());

        while (true) {
            communicationInterface.write(GAME_COMMAND_CHOOSE);
            gameActions.get(communicationInterface.getGameCommand()).executeAction(playerCharacter);
        }
    }
}
