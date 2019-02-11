import java.util.ArrayList;

public class Set {

    ArrayList<Game> set;
    int winSet;

    public Set() {
        this.set = new ArrayList<>();
        this.set.add(new Game());
        this.winSet =  0;
    }

    public ArrayList<Game> getSet() {
        return set;
    }

    public int getSetWin() {
        return winSet;
    }
    public void resetGame() {
        set.add(new Game());
    }

    public void winSet() {
        this.winSet = this.winSet + 1;
    }
}
