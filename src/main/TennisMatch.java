import java.util.List;

public class TennisMatch {

    private boolean tieBreak;
    private Player player1;
    private Player player2;
    private MatchType matchType;
    private Score score1;
    private Score score2;

    public TennisMatch(Player player1, Player player2,MatchType matchType, Boolean tieBreak) {
        this.player1 = player1;
        this.player2 = player2;
        this.matchType = matchType;
        this.tieBreak = tieBreak;
        score1 = new Score("0","0","0");
        score2 = new Score("0","0","0");
    }

    public void updateWithPointWonBy(Player player) {
        if ( player.getName() == player1.getName() ) {
            score1.setPointWon(updatePointScore(score1.getPointWon(), player1));
        } else {
            score2.setPointWon(updatePointScore(score2.getPointWon(), player2));
        }
    }

    private String updatePointScore(String score, Player player) {

        switch (score) {
            case "0":
                score = "15";
                break;
            case "15":
                score = "30";
                break;
            case "30":
                score = "40";
                break;
            case "40":
                score = "A";
                break;
            case "A":
                playerWonGame(player);
                resetPointPlayer();
                score = "0";
                break;
        default:
            break;
        }

        return score;
    }

    private void playerWonGame(Player player) {
        if (player.getName() == player1.getName()) {
            int gamePlayer = Integer.parseInt(score1.getGameWon());
            gamePlayer++;
            score1.setGameWon(String.valueOf(gamePlayer));
        } else {
            int gamePlayer = Integer.parseInt(score2.getGameWon());
            gamePlayer++;
            score2.setGameWon(String.valueOf(gamePlayer));
        }
    }

    private void resetPointPlayer() {
        score1.setPointWon("0");
        score2.setPointWon("0");
    }
    public String pointsForPlayer(Player player) {
        return "0";
    }

    public int currentSetNumber() {
        return 0;
    }

    public int gamesInCurrentSetForPlayer(Player player) {
        return 0;
    }

    public int gamesInSetForPlayer(int set, Player player) {
        return 0;
    }

    public boolean isFinished() {
        return true;
    }

    public void getScore() {
        System.out.println("Joueur1: " + score1.getPointWon() + " Game :" + score1.getGameWon() + " / Joueur2: "
                + score2.getPointWon() + " Game :" + score2.getGameWon());
    }
}
