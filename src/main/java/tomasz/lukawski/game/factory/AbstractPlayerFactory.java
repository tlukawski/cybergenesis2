package tomasz.lukawski.game.factory;

import tomasz.lukawski.game.player.PlayerCharacter;
import tomasz.lukawski.game.CommunicationInterface;

import java.io.FileNotFoundException;

public abstract class AbstractPlayerFactory {
    protected CommunicationInterface communicationInterface;

    public AbstractPlayerFactory(CommunicationInterface communicationInterface) {
        this.communicationInterface = communicationInterface;
    }

    abstract PlayerCharacter getPlayer() throws FileNotFoundException;
}
