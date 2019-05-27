package tomasz.lukawski.game;

import tomasz.lukawski.game.action.*;
import tomasz.lukawski.game.factory.PlayerCharacterFacade;
import tomasz.lukawski.game.player.PlayerCharacter;

import java.util.HashMap;
import java.util.Map;

public class GameLoop {

    private CommunicationInterface communicationInterface;
    private PlayerCharacter playerCharacter;
    private Map<GameCommand, GameAction> gameActions;

    public GameLoop(CommunicationInterface communicationInterface) {
        this.communicationInterface = communicationInterface;

        //TODO think about this ?
        gameActions = new HashMap<>();
        gameActions.put(GameCommand.SAVE_GAME, new SaveGameAction(communicationInterface));
        gameActions.put(GameCommand.ABOUT_CHARACTER, new AboutCharacterAction(communicationInterface));
        gameActions.put(GameCommand.EXPLORE, new ExploreAction(communicationInterface));
        gameActions.put(null, new UnknownAction(communicationInterface));
    }

    public void play() {
        communicationInterface.write("Welcome to CyberGenesis II\n" +
                "Do you want to start new adventure[ng] or load existing game[lg] ?");
        playerCharacter = new PlayerCharacterFacade(communicationInterface).getPlayerCharacter(
                communicationInterface.getGameCommand());

        while (true) {
            communicationInterface.write("What do you would like to do ?\n" +
                    "About Character [a], Explore [e], Save GameLoop[s]");
            gameActions.get(communicationInterface.getGameCommand()).executeAction(playerCharacter);
        }
    }
}
