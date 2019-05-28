package tomasz.lukawski.cybergenesis.game.characters;

public class EnemyCharacter implements Character {

    private int level;

    public EnemyCharacter(int level) {
        this.level = level == 0 ? 1 : level;
    }

    @Override
    public int getAttack() {
        return this.level * 10;
    }

    public int getLevel() {
        return this.level;
    }
}
