package tomasz.lukawski.game.action;

import tomasz.lukawski.game.GameCommand;
import tomasz.lukawski.game.CommunicationInterface;
import tomasz.lukawski.game.player.PlayerCharacter;

public class UnknownAction extends GameAction {

    public UnknownAction(CommunicationInterface communicationInterface) {
        super(communicationInterface);
    }

    @Override
    public GameCommand getGameCommand() {
        return null;
    }

    @Override
    public void executeAction(PlayerCharacter playerCharacter) {

    }
}
