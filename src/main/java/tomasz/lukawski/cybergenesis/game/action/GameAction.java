package tomasz.lukawski.cybergenesis.game.action;

import tomasz.lukawski.cybergenesis.game.characters.PlayerCharacter;
import tomasz.lukawski.cybergenesis.infrastructure.CommunicationInterface;

public abstract class GameAction {

    protected CommunicationInterface communicationInterface;

    public GameAction(CommunicationInterface communicationInterface) {
        this.communicationInterface = communicationInterface;
    }

    public abstract void executeAction(PlayerCharacter playerCharacter);
}
