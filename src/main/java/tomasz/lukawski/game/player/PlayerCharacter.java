package tomasz.lukawski.game.player;

import tomasz.lukawski.game.MoveCommand;

public class PlayerCharacter {

    private String name;
    private int health;
    private int attack;
    private PlayerCoordinates playerCoordinates;

    private int level;
    private int expirence;

    public PlayerCharacter(String name, int health, int attack) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.level = 1;
        this.expirence = 0;
        this.playerCoordinates = new PlayerCoordinates();
    }

    public void movePlayer(MoveCommand moveCommand) {
        this.playerCoordinates.movePlayer(moveCommand);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public PlayerCoordinates getPlayerCoordinates() {
        return playerCoordinates;
    }

    public int getLevel() {
        return level;
    }

    public int getExpirence() {
        return expirence;
    }
}
