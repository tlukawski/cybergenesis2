package tomasz.lukawski.cybergenesis.game.loading;

import tomasz.lukawski.cybergenesis.game.action.GameAction;
import tomasz.lukawski.cybergenesis.game.characters.PlayerCharacter;
import tomasz.lukawski.cybergenesis.infrastructure.CommunicationInterface;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static java.lang.String.format;
import static tomasz.lukawski.cybergenesis.game.GameConfigurationSource.SAVE_PATH;

public class SaveGameAction extends GameAction {

    public SaveGameAction(CommunicationInterface communicationInterface) {
        super(communicationInterface);
    }

    @Override
    public void executeAction(PlayerCharacter playerCharacter) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(format(SAVE_PATH, playerCharacter.getName())));
            bufferedWriter.write(playerCharacter.getName() + "\n");
            bufferedWriter.write(playerCharacter.getAttack() + "\n");
            bufferedWriter.write(playerCharacter.getHealth() + "\n");
            bufferedWriter.write(playerCharacter.getExperience() + "\n");
            bufferedWriter.write(playerCharacter.getPlayerCoordinates().getX() + "\n");
            bufferedWriter.write(playerCharacter.getPlayerCoordinates().getY() + "\n");

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
