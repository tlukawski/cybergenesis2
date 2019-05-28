package tomasz.lukawski.cybergenesis.explore

import tomasz.lukawski.cybergenesis.BaseTest
import tomasz.lukawski.cybergenesis.game.explore.ExploreEngine
import tomasz.lukawski.cybergenesis.game.explore.FightEngine
import tomasz.lukawski.cybergenesis.infrastructure.RandomGenerator

class ExploreEngineTest extends BaseTest {

    def randomGenerator = Mock(RandomGenerator)

    def fightEngine = Mock(FightEngine)

    def exploreEngine = new ExploreEngine(communicationInterface, randomGenerator, fightEngine)

    def "should gain free experience when rolled over 90"() {
        given:
        def player = getPlayer()
        randomGenerator.randomTo100() >> 100
        randomGenerator.randomTo100() >> 100

        when:
        exploreEngine.explore(player)

        then:
        player.experience == 100
        player.getLevel() == 2
    }

    def "should fight enemy when rolled under 90 and gain experience after won battle"() {
        given:
        def player = getPlayer()
        fightEngine.fight(_,_) >> FightEngine.FightResult.WON
        randomGenerator.randomTo100() >> 89

        when:
        exploreEngine.explore(player)

        then:
        player.experience > 0
    }

    def "should fight enemy when rolled under 90 and lose experience after lost battle"() {
        given:
        def player = getPlayer()
        fightEngine.fight(_,_) >> FightEngine.FightResult.LOST
        randomGenerator.randomTo100() >> 89

        when:
        exploreEngine.explore(player)

        then:
        player.experience < 0
    }

}
