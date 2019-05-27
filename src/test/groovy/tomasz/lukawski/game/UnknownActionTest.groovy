package tomasz.lukawski.game

import spock.lang.Specification
import tomasz.lukawski.game.action.UnknownAction
import tomasz.lukawski.game.player.PlayerCharacter

class UnknownActionTest extends Specification {

    def communicationInterface = Mock(CommunicationInterface)
    def action = new UnknownAction(communicationInterface)

    def static final PLAYER = new PlayerCharacter("test", 0, 0)

    def "should do nothing in unknown action"() {
        when:
        action.executeAction(PLAYER)
        then:
        0 * communicationInterface.getMoveCommand()
        0 * communicationInterface.getGameCommand()
        0 * communicationInterface.read()
        0 * communicationInterface.write(_)
    }

}
