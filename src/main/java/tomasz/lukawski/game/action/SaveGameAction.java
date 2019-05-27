package tomasz.lukawski.game.action;

import tomasz.lukawski.game.GameCommand;
import tomasz.lukawski.game.CommunicationInterface;
import tomasz.lukawski.game.player.PlayerCharacter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveGameAction extends GameAction {

    private static final String SAVE_PATH = "%s.character";

    public SaveGameAction(CommunicationInterface communicationInterface) {
        super(communicationInterface);
    }

    @Override
    public GameCommand getGameCommand() {
        return GameCommand.LOAD_GAME;
    }

    @Override
    public void executeAction(PlayerCharacter playerCharacter) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(String.format(SAVE_PATH, playerCharacter.getName())));
            bufferedWriter.write(playerCharacter.getName() + "\n");
            bufferedWriter.write(playerCharacter.getAttack() + "\n");
            bufferedWriter.write(playerCharacter.getHealth() + "\n");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
