package tomasz.lukawski.cybergenesis.game.characters;

import tomasz.lukawski.cybergenesis.game.action.GameAction;
import tomasz.lukawski.cybergenesis.infrastructure.CommunicationInterface;

import static tomasz.lukawski.cybergenesis.game.GameMessageSource.ABOUT_MESSAGE;

public class AboutCharacterAction extends GameAction {

    public AboutCharacterAction(CommunicationInterface communicationInterface) {
        super(communicationInterface);
    }

    @Override
    public void executeAction(PlayerCharacter playerCharacter) {
        communicationInterface.write(String.format(ABOUT_MESSAGE, playerCharacter.getName(), playerCharacter.getAttack(),
                playerCharacter.getHealth(), playerCharacter.getExperience(), playerCharacter.getPlayerCoordinates().getX(), playerCharacter.getPlayerCoordinates().getY()));
    }
}
