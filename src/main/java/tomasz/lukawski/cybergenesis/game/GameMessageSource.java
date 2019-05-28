package tomasz.lukawski.cybergenesis.game;

public class GameMessageSource {
    private GameMessageSource() { }

    public static final String EXPLORE_COMMAND_CHOOSE = "Where do you want to go ? Left [a], Forward [w] or Right[d]:";

    public static final String WELCOME_TEXT = "Welcome to CyberGenesis II\n" +
            "Do you want to loading new adventure[ng] or load existing game[lg] ?";
    public static final String GAME_COMMAND_CHOOSE = "What do you would like to do ?\n" +
            "About Character [a], Explore [e], Save GameLoop[s]";

    public static final String FREE_EXP_MESSAGE = "You just found exp implant on the ground ! You have gained: %d exp";
    public static final String AFTER_FIGHT_MESSAGE = "You have %s fight and gained %d experience";
    public static final String ABOUT_MESSAGE = "Name: %s Attack: %d Health: %d Exp: %d\n Position x: %d y: %d";
    public static final String LOAD_GAME_MESSAGE = "Existing characters name: ";
    public static final String NEW_PLAYER_MESSAGE = "Whats your name traveler ?\n Name:";


}
