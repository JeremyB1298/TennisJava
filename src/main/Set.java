import java.util.ArrayList;

public class Set {

    ArrayList<Game> set;

    public Set() {
        this.set = new ArrayList<>();
        this.set.add(new Game());
    }

    public ArrayList<Game> getSet() {
        return set;
    }
}
