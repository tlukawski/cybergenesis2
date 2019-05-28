package tomasz.lukawski.cybergenesis;

import tomasz.lukawski.cybergenesis.game.GameLoop;
import tomasz.lukawski.cybergenesis.infrastructure.CommunicationInterface;
import tomasz.lukawski.cybergenesis.infrastructure.RandomGenerator;

public class MainClass {

    public static void main(String[] args) {
        new GameLoop(new CommunicationInterface(), new RandomGenerator()).play();
    }
}
