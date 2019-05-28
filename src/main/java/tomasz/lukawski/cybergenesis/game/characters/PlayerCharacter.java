package tomasz.lukawski.cybergenesis.game.characters;

import tomasz.lukawski.cybergenesis.game.explore.MoveCommand;

import java.util.Objects;

public class PlayerCharacter implements Character {

    public static final int BASE_LEVEL = 1;

    private String name;
    private int health;
    private int baseAttack;
    private PlayerCoordinates playerCoordinates;
    private int experience;

    public PlayerCharacter(String name, int health, int baseAttack, int experience, int x, int y) {
        this.name = name;
        this.health = health;
        this.baseAttack = baseAttack;
        this.experience = experience;
        this.playerCoordinates = new PlayerCoordinates(x, y);

    }

    public void movePlayer(MoveCommand moveCommand) {
        this.playerCoordinates.movePlayer(moveCommand);
    }

    public void gainExperience(int experience) {
        this.experience += experience;
    }

    public int getLevel() {
        return experience / 100 + BASE_LEVEL;

    }

    public PlayerCoordinates getPlayerCoordinates() {
        return playerCoordinates;
    }

    public int getExperience() {
        return experience;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public int getAttack() {
        return baseAttack + experience / 10;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerCharacter that = (PlayerCharacter) o;
        return health == that.health &&
                baseAttack == that.baseAttack &&
                experience == that.experience &&
                name.equals(that.name) &&
                playerCoordinates.equals(that.playerCoordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, health, baseAttack, playerCoordinates, experience);
    }
}
