package tomasz.lukawski.cybergenesis.loading

import tomasz.lukawski.cybergenesis.BaseTest
import tomasz.lukawski.cybergenesis.game.GameConfigurationSource
import tomasz.lukawski.cybergenesis.game.action.GameCommand
import tomasz.lukawski.cybergenesis.game.loading.PlayerCharacterFacade
import tomasz.lukawski.cybergenesis.game.loading.SaveGameAction

class PlayerCharacterLoadingIntegration extends BaseTest {

    def playerFacade = new PlayerCharacterFacade(communicationInterface)
    def saveGame = new SaveGameAction(communicationInterface)

    def "should be able to load saved character"() {
        given:
        def player = getPlayer()
        saveGame.executeAction(player)
        communicationInterface.read() >> PLAYER_NAME

        when:
        def loadedPlayer = playerFacade.getPlayerCharacter(GameCommand.LOAD_GAME)

        then:
        loadedPlayer == player
    }

    def cleanup() {
        def file = new File(String.format(GameConfigurationSource.SAVE_PATH, PLAYER_NAME))
        if (file.exists()) {
            file.delete()
        }
    }
}
