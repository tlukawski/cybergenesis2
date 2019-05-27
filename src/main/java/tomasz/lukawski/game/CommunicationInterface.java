package tomasz.lukawski.game;


import tomasz.lukawski.game.GameCommand;
import tomasz.lukawski.game.MoveCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommunicationInterface {

    private BufferedReader bufferedReader;

    public CommunicationInterface() {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String read() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new IllegalStateException();
        }
    }

    public void write(String message) {
        System.out.println(message);
    }

    public GameCommand getGameCommand() {
        try {
            return GameCommand.gameCommandOf(bufferedReader.readLine());
        } catch (IOException e) {
            throw new IllegalStateException();
        }
    }

    public MoveCommand getMoveCommand() {
        try {
            return MoveCommand.gameCommandOf(bufferedReader.readLine());
        } catch (IOException e) {
            throw new IllegalStateException();
        }
    }
}
