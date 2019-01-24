import java.util.ArrayList;

public class Game {

    private ArrayList<String> points;

    public Game() {
        this.points = new ArrayList<>();
        this.points.add("0");
    }

    public String getPointForGame(int game) {
        return points.get(game);
    }

    public ArrayList<String> getAllPoints() {
        return points;
    }

    public void setPointForGame(int game, String score) {
        points.set(game,score);
    }

    public void gameFinish() {
        points.add("0");
    }

    public int gameWin() {
        int win = 0;
        for (String result: points) {
            if (result == "W") {
                win++;
            }
        }
        return win;
    }

}
