package tomasz.lukawski.game.action;

import tomasz.lukawski.game.GameCommand;
import tomasz.lukawski.game.CommunicationInterface;
import tomasz.lukawski.game.player.PlayerCharacter;

public class AboutCharacterAction extends GameAction {

    public AboutCharacterAction(CommunicationInterface communicationInterface) {
        super(communicationInterface);
    }

    private static final String MESSAGE = "Name: %s Attack: %d Health: %d \n Position x: %d y: %d";

    @Override
    public GameCommand getGameCommand() {
        return GameCommand.ABOUT_CHARACTER;
    }

    @Override
    public void executeAction(PlayerCharacter playerCharacter) {
        communicationInterface.write(String.format(MESSAGE, playerCharacter.getName(), playerCharacter.getAttack(),
                playerCharacter.getHealth(), playerCharacter.getPlayerCoordinates().getX(), playerCharacter.getPlayerCoordinates().getY()));
    }
}
