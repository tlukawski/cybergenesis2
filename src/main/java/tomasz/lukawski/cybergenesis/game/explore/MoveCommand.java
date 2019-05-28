package tomasz.lukawski.cybergenesis.game.explore;

import java.util.HashMap;
import java.util.Map;

public enum  MoveCommand {

    LEFT("a"),
    RIGHT("d"),
    FORWARD("w");

    private static Map<String, MoveCommand> MOVE_COMMAND_MAP;

    private String letters;

    MoveCommand(String letters) {
        this.letters = letters;
    }

    public static MoveCommand gameCommandOf(String letter) {
        createCommandMap();
        return MOVE_COMMAND_MAP.get(letter);
    }

    private static void createCommandMap() {
        if (MOVE_COMMAND_MAP == null) {
            MOVE_COMMAND_MAP = new HashMap<>();
            for (MoveCommand gameCommand : MoveCommand.values()) {
                MOVE_COMMAND_MAP.put(gameCommand.letters, gameCommand);
            }
        }
    }
}
