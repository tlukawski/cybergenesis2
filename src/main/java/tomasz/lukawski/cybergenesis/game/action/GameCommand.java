package tomasz.lukawski.cybergenesis.game.action;

import java.util.HashMap;
import java.util.Map;

public enum GameCommand {

    NEW_GAME("ng"),
    LOAD_GAME("lg"),
    SAVE_GAME("s"),
    ABOUT_CHARACTER("a"),
    EXPLORE("e");

    private static Map<String, GameCommand> GAME_COMMAND_MAP;

    private String letters;

    GameCommand(String letters) {
        this.letters = letters;
    }

    public static GameCommand gameCommandOf(String letter) {
        createCommandMap();
        return GAME_COMMAND_MAP.get(letter);
    }

    private static void createCommandMap() {
        if (GAME_COMMAND_MAP == null) {
            GAME_COMMAND_MAP = new HashMap<>();
            for (GameCommand gameCommand : GameCommand.values()) {
                GAME_COMMAND_MAP.put(gameCommand.letters, gameCommand);
            }
        }
    }
}
