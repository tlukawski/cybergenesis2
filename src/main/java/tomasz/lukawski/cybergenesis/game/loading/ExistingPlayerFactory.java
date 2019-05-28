package tomasz.lukawski.cybergenesis.game.loading;

import tomasz.lukawski.cybergenesis.game.characters.PlayerCharacter;
import tomasz.lukawski.cybergenesis.infrastructure.CommunicationInterface;

import java.io.*;

import static tomasz.lukawski.cybergenesis.game.GameMessageSource.LOAD_GAME_MESSAGE;

class ExistingPlayerFactory extends AbstractPlayerFactory {

    public ExistingPlayerFactory(CommunicationInterface communicationInterface) {
        super(communicationInterface);
    }

    @Override
    PlayerCharacter getPlayer() {
        communicationInterface.write(LOAD_GAME_MESSAGE);
        String playerName = communicationInterface.read();
        File saveFile = new File(playerName + ".character");
        if (saveFile.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(saveFile));
                String name = reader.readLine();
                int attack = Integer.valueOf(reader.readLine());
                int health = Integer.valueOf(reader.readLine());
                int exp = Integer.valueOf(reader.readLine());
                int x = Integer.valueOf(reader.readLine());
                int y = Integer.valueOf(reader.readLine());
                return new PlayerCharacter(name, health, attack, exp, x, y);
            } catch (FileNotFoundException e) {
                //Should not happen since we check if file exist before creating fileReader instance
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        } else {
            return this.getPlayer();
        }
    }
}
