package tomasz.lukawski.cybergenesis.explore

import spock.lang.Unroll
import tomasz.lukawski.cybergenesis.BaseTest
import tomasz.lukawski.cybergenesis.game.explore.ExploreAction
import tomasz.lukawski.cybergenesis.game.explore.ExploreEngine
import tomasz.lukawski.cybergenesis.game.explore.MoveCommand

class ExploreActionTest extends BaseTest {

    def exploreEngine = Mock(ExploreEngine)

    def action = new ExploreAction(communicationInterface, exploreEngine)

    @Unroll
    def "Should move player coordinates with action to x: #x y: #y with #moveCommand command"() {
        given:
        def playerCharacter = getPlayer()
        communicationInterface.getMoveCommand() >> moveCommand

        when:
        action.executeAction(playerCharacter)

        then:
        playerCharacter.playerCoordinates.x == x
        playerCharacter.playerCoordinates.y == y
        1 * exploreEngine.explore(playerCharacter)

        where:
        moveCommand         || x | y
        MoveCommand.FORWARD || 1 | 0
        MoveCommand.LEFT    || 0 | -1
        MoveCommand.RIGHT   || 0 | 1
    }

}
