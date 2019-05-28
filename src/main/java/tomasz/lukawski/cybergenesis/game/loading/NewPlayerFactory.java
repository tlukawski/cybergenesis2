package tomasz.lukawski.cybergenesis.game.loading;

import tomasz.lukawski.cybergenesis.game.characters.PlayerCharacter;
import tomasz.lukawski.cybergenesis.infrastructure.CommunicationInterface;

import static tomasz.lukawski.cybergenesis.game.GameConfigurationSource.*;
import static tomasz.lukawski.cybergenesis.game.GameMessageSource.ABOUT_MESSAGE;
import static tomasz.lukawski.cybergenesis.game.GameMessageSource.NEW_PLAYER_MESSAGE;

class NewPlayerFactory extends AbstractPlayerFactory {

    NewPlayerFactory(CommunicationInterface communicationInterface) {
        super(communicationInterface);
    }

    @Override
    PlayerCharacter getPlayer() {
        communicationInterface.write(NEW_PLAYER_MESSAGE);
        String name = communicationInterface.read();

        PlayerCharacter playerCharacter = new PlayerCharacter(name, START_HP, START_ATTACK, START_EXP, START_X, START_Y);

        communicationInterface.write(String.format(ABOUT_MESSAGE, playerCharacter.getName(), playerCharacter.getAttack(),
                playerCharacter.getHealth(), playerCharacter.getExperience(), playerCharacter.getPlayerCoordinates().getX(), playerCharacter.getPlayerCoordinates().getY()));

        return playerCharacter;
    }


}
