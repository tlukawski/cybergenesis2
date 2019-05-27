package tomasz.lukawski.game.player;

import tomasz.lukawski.game.MoveCommand;

public class PlayerCoordinates {

    private int x;
    private int y;

    public PlayerCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public PlayerCoordinates() {
    }

    public void movePlayer(MoveCommand command) {
        if (MoveCommand.FORWARD == command) {
            this.x++;
        } else if (MoveCommand.LEFT == command) {
            this.y--;
        } else if (MoveCommand.RIGHT == command) {
            this.y++;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
