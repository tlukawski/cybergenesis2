package tomasz.lukawski.game.action;

import tomasz.lukawski.game.GameCommand;
import tomasz.lukawski.game.CommunicationInterface;
import tomasz.lukawski.game.player.PlayerCharacter;

public class ExploreAction extends GameAction {

    public ExploreAction(CommunicationInterface communicationInterface) {
        super(communicationInterface);
    }

    @Override
    public GameCommand getGameCommand() {
        return null;
    }

    @Override
    public void executeAction(PlayerCharacter playerCharacter) {
        communicationInterface.write("Where do you want to go ? Left [a] Right[d] or Forward [w]:");
        playerCharacter.movePlayer(communicationInterface.getMoveCommand());
    }
}
