package tomasz.lukawski.game;

public class MainClass {

    public static void main(String[] args) {
        new GameLoop(new CommunicationInterface()).play();
    }
}
