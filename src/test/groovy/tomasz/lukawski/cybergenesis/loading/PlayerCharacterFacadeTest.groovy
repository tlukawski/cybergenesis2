package tomasz.lukawski.cybergenesis.loading

import tomasz.lukawski.cybergenesis.BaseTest
import tomasz.lukawski.cybergenesis.game.action.GameCommand
import tomasz.lukawski.cybergenesis.game.loading.PlayerCharacterFacade

import static tomasz.lukawski.cybergenesis.game.GameConfigurationSource.*

class PlayerCharacterFacadeTest extends BaseTest {

    public static final String PLAYER_NAME = "PlayerName"

    def playerCharacterFacade = new PlayerCharacterFacade(communicationInterface)

    def "should crate new character"() {
        given:
        communicationInterface.read() >> PLAYER_NAME

        when:
        def player = playerCharacterFacade.getPlayerCharacter(GameCommand.NEW_GAME)

        then:
        player.name == PLAYER_NAME
        player.getAttack() == START_ATTACK
        player.experience == START_EXP
        player.health == START_HP
        player.playerCoordinates.x == START_X
        player.playerCoordinates.y == START_Y

    }
}
