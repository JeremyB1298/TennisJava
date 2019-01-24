import java.util.ArrayList;

public class Score {
    private Set sets;

    public Score() {
        this.sets = new Set();
    }

    public Game getGames(int set) {
        return sets.getSet().get(set);
    }
}

