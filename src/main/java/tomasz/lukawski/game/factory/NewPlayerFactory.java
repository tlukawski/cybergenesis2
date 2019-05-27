package tomasz.lukawski.game.factory;

import tomasz.lukawski.game.player.PlayerCharacter;
import tomasz.lukawski.game.CommunicationInterface;

import static java.lang.String.format;

class NewPlayerFactory extends AbstractPlayerFactory {

    private static final int START_ATTACK = 10;
    private static final int START_HP = 100;

    NewPlayerFactory(CommunicationInterface communicationInterface) {
        super(communicationInterface);
    }

    @Override
    PlayerCharacter getPlayer() {
        communicationInterface.write("Whats your name traveler ?\n" +
                "Name:");
        String name = communicationInterface.read();

        PlayerCharacter playerCharacter = new PlayerCharacter(name, START_HP, START_ATTACK);

        communicationInterface.write(format("Hey %s youre stats are:\n", name) +
                format("Health: %d\n", playerCharacter.getHealth()) +
                format("Attack: %d", playerCharacter.getAttack()));

        return playerCharacter;
    }


}
