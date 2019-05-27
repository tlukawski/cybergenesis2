package tomasz.lukawski.game.factory;

import tomasz.lukawski.game.GameCommand;
import tomasz.lukawski.game.player.PlayerCharacter;
import tomasz.lukawski.game.CommunicationInterface;

import static tomasz.lukawski.game.GameCommand.LOAD_GAME;

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
