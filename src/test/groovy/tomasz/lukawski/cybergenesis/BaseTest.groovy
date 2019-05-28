package tomasz.lukawski.cybergenesis

import spock.lang.Specification
import tomasz.lukawski.cybergenesis.game.characters.PlayerCharacter
import tomasz.lukawski.cybergenesis.infrastructure.CommunicationInterface

class BaseTest extends Specification {

    def communicationInterface = Mock(CommunicationInterface)

    def static final PLAYER_NAME = "test"

    def getPlayer() {
        return getPlayer(0)
    }

    def getPlayer(int experience) {
        return new PlayerCharacter(PLAYER_NAME, 100, 10, experience, 0, 0)
    }
}
