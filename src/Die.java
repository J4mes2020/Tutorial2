import java.util.concurrent.ThreadLocalRandom;

public class Die {

    public static int roll() {
        return ThreadLocalRandom.current().nextInt(1, 6);
    }
}

