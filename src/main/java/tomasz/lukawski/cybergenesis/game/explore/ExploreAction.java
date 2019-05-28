package tomasz.lukawski.cybergenesis.game.explore;

import tomasz.lukawski.cybergenesis.game.characters.PlayerCharacter;
import tomasz.lukawski.cybergenesis.game.action.GameAction;
import tomasz.lukawski.cybergenesis.infrastructure.CommunicationInterface;

import static tomasz.lukawski.cybergenesis.game.GameMessageSource.EXPLORE_COMMAND_CHOOSE;

public class ExploreAction extends GameAction {

    private final ExploreEngine exploreEngine;

    public ExploreAction(CommunicationInterface communicationInterface, ExploreEngine exploreEngine) {
        super(communicationInterface);
        this.exploreEngine = exploreEngine;
    }

    @Override
    public void executeAction(PlayerCharacter playerCharacter) {
        communicationInterface.write(EXPLORE_COMMAND_CHOOSE);
        playerCharacter.movePlayer(communicationInterface.getMoveCommand());
        exploreEngine.explore(playerCharacter);
    }
}
