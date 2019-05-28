package tomasz.lukawski.cybergenesis.game.loading;

import tomasz.lukawski.cybergenesis.infrastructure.CommunicationInterface;
import tomasz.lukawski.cybergenesis.game.characters.PlayerCharacter;
import tomasz.lukawski.cybergenesis.game.action.GameCommand;

import static tomasz.lukawski.cybergenesis.game.action.GameCommand.LOAD_GAME;

public class PlayerCharacterFacade {

    private CommunicationInterface communicationInterface;

    public PlayerCharacterFacade(CommunicationInterface communicationInterface) {
        this.communicationInterface = communicationInterface;
    }

    public PlayerCharacter getPlayerCharacter(GameCommand gameCommand) {
        if (gameCommand == LOAD_GAME) {
            return new ExistingPlayerFactory(communicationInterface).getPlayer();
        } else {
            return new NewPlayerFactory(communicationInterface).getPlayer();
        }
    }
}
