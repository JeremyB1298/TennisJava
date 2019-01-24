import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private Score score;

    public Player(String name) {
        this.name = name;
        this.score = new Score();
    }

    public String getName() {
        return name;
    }

    public Score getScore() {
        return score;
    }
}
