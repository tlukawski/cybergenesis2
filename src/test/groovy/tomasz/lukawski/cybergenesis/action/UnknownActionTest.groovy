package tomasz.lukawski.cybergenesis.action

import tomasz.lukawski.cybergenesis.BaseTest
import tomasz.lukawski.cybergenesis.game.action.UnknownAction

class UnknownActionTest extends BaseTest {

    def action = new UnknownAction(communicationInterface)

    def "should do nothing in unknown action"() {
        when:
        action.executeAction(getPlayer())
        then:
        0 * communicationInterface.getMoveCommand()
        0 * communicationInterface.getGameCommand()
        0 * communicationInterface.read()
        0 * communicationInterface.write(_)
    }

}
