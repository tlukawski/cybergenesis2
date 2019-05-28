package tomasz.lukawski.cybergenesis.infrastructure;

import java.util.Random;

public class RandomGenerator {

    private static final Random RANDOM = new Random();
    private static final int LOW = 1;
    private static final int HIGH = 100;

    public int randomTo100() {
        return randomTo(HIGH);
    }

    public int randomTo(int high) {
        return RANDOM.nextInt(high - LOW) + LOW;
    }
}
