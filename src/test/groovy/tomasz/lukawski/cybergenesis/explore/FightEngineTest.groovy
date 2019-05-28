package tomasz.lukawski.cybergenesis.explore


import tomasz.lukawski.cybergenesis.BaseTest
import tomasz.lukawski.cybergenesis.game.characters.EnemyCharacter
import tomasz.lukawski.cybergenesis.game.explore.FightEngine

class FightEngineTest extends BaseTest {

    public static final int PLAYER_LEVEL_TO_EXP_MULTIPLIER = 100
    def fightEngine = new FightEngine()

    def "player should lose fight"() {
        given:
        def player = getPlayer(PLAYER_LEVEL_TO_EXP_MULTIPLIER * 1)
        def enemy = new EnemyCharacter(5)

        when:
        def result = fightEngine.fight(player, enemy)

        then:
        result == FightEngine.FightResult.LOST

    }

    def "player should win fight"() {
        given:
        def player = getPlayer(PLAYER_LEVEL_TO_EXP_MULTIPLIER * 1)
        def enemy = new EnemyCharacter(1)

        when:
        def result = fightEngine.fight(player, enemy)

        then:
        result == FightEngine.FightResult.WON

    }
}
