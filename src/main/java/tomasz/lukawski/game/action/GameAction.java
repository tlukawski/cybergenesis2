package tomasz.lukawski.game.action;

import tomasz.lukawski.game.GameCommand;
import tomasz.lukawski.game.CommunicationInterface;
import tomasz.lukawski.game.player.PlayerCharacter;

public abstract class GameAction {

    CommunicationInterface communicationInterface;

    public GameAction(CommunicationInterface communicationInterface) {
        this.communicationInterface = communicationInterface;
    }

    public abstract GameCommand getGameCommand();

    public abstract void executeAction(PlayerCharacter playerCharacter);
}
