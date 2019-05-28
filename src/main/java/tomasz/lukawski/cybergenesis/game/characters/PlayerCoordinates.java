package tomasz.lukawski.cybergenesis.game.characters;

import tomasz.lukawski.cybergenesis.game.explore.MoveCommand;

import java.util.Objects;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

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

    //TODO change name
    public int getPlayerDestination() {
        return (int) sqrt(pow(x, 2 + pow(y, 2)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerCoordinates that = (PlayerCoordinates) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
