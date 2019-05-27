package tomasz.lukawski.game

import spock.lang.Specification
import spock.lang.Unroll
import tomasz.lukawski.game.action.ExploreAction
import tomasz.lukawski.game.player.PlayerCharacter

class ExploreActionTest extends Specification {

    def communicationInterface = Mock(CommunicationInterface)

    def action = new ExploreAction(communicationInterface)

    @Unroll
    def "Should move player coordinates with action to x: #x y: #y with #moveCommand command"() {
        given:
        PlayerCharacter playerCharacter = new PlayerCharacter("name", 100, 100)
        communicationInterface.getMoveCommand() >> moveCommand

        when:
        action.executeAction(playerCharacter)

        then:
        playerCharacter.playerCoordinates.x == x
        playerCharacter.playerCoordinates.y == y

        where:
        moveCommand         || x | y
        MoveCommand.FORWARD || 1 | 0
        MoveCommand.LEFT    || 0 | -1
        MoveCommand.RIGHT   || 0 | 1
    }

}
