package tomasz.lukawski.cybergenesis.game.action;

import tomasz.lukawski.cybergenesis.game.characters.PlayerCharacter;
import tomasz.lukawski.cybergenesis.infrastructure.CommunicationInterface;

public class UnknownAction extends GameAction {

    public UnknownAction(CommunicationInterface communicationInterface) {
        super(communicationInterface);
    }

    @Override
    public void executeAction(PlayerCharacter playerCharacter) {

    }
}
