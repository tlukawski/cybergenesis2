package tomasz.lukawski.game.factory;

import tomasz.lukawski.game.CommunicationInterface;
import tomasz.lukawski.game.player.PlayerCharacter;

import java.io.*;

//TODO: exceptions !
class ExistingPlayerFactory extends AbstractPlayerFactory {

    public ExistingPlayerFactory(CommunicationInterface communicationInterface) {
        super(communicationInterface);
    }

    @Override
    PlayerCharacter getPlayer() {
        communicationInterface.write("Existing player name: ");
        String playerName = communicationInterface.read();
        File saveFile = new File(playerName + ".character");
        if (saveFile.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(saveFile));
                String name = reader.readLine();
                int attack = Integer.valueOf(reader.readLine());
                int health = Integer.valueOf(reader.readLine());
                return new PlayerCharacter(name, health, attack);
            } catch (FileNotFoundException e) {
                //Should not happend since we check if file exist before creating fileReader instance
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        } else {
            return this.getPlayer();
        }
    }
}
