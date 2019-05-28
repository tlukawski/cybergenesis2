package tomasz.lukawski.cybergenesis.game.loading;

import tomasz.lukawski.cybergenesis.infrastructure.CommunicationInterface;
import tomasz.lukawski.cybergenesis.game.characters.PlayerCharacter;

import java.io.FileNotFoundException;

public abstract class AbstractPlayerFactory {
    protected CommunicationInterface communicationInterface;

    public AbstractPlayerFactory(CommunicationInterface communicationInterface) {
        this.communicationInterface = communicationInterface;
    }

    abstract PlayerCharacter getPlayer() throws FileNotFoundException;
}
