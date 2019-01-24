public class TennisMatch {

    private boolean tieBreak;
    private Player player1;
    private Player player2;
    private MatchType matchType;
    private int actualGame;
    private int actualSet;

    public TennisMatch(Player player1, Player player2,MatchType matchType, Boolean tieBreak) {
        this.player1 = player1;
        this.player2 = player2;
        this.matchType = matchType;
        this.tieBreak = tieBreak;
        this.actualGame = 0;
        this.actualSet = 0;
    }

    public void updateWithPointWonBy(Player player) {
        if ( player.getName() == player1.getName() ) {
            player1.getScore().getGames(actualSet).setPointForGame(actualGame,updatePointScore(player1.getScore().getGames(actualSet).getPointForGame(actualGame),player1));
        } else {
            player2.getScore().getGames(actualSet).setPointForGame(actualGame,updatePointScore(player2.getScore().getGames(actualSet).getPointForGame(actualGame),player2));
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
                if (playerAvantage()) {
                    score = "A";
                } else if (player1WinAvantage()) {
                        score = "A";
                        player2.getScore().getGames(actualSet).setPointForGame(actualGame,"40");
                    } else if (player2WinAvantage()) {
                        score = "A";
                        player1.getScore().getGames(actualSet).setPointForGame(actualGame,"40");
                    }
                 else {
                    playerWonGame(player);
                    resetPointPlayer();
                    score = "W";
                }
                break;
            case "A":
                playerWonGame(player);
                resetPointPlayer();
                score = "W";
                break;
        default:
            break;
        }

        return score;
    }

    private boolean playerAvantage() {
        if (player1.getScore().getGames(actualSet).getPointForGame(actualGame) == "40" && player2.getScore().getGames(actualSet).getPointForGame(actualGame) == "40") {
            return true;
        }
        return false;
    }

    private boolean player1WinAvantage() {
        if (player1.getScore().getGames(actualSet).getPointForGame(actualGame) == "40" && player2.getScore().getGames(actualSet).getPointForGame(actualGame) == "A") {
            return true;
        }
        return false;
    }

    private boolean player2WinAvantage() {
        if (player2.getScore().getGames(actualSet).getPointForGame(actualGame) == "40" && player1.getScore().getGames(actualSet).getPointForGame(actualGame) == "A") {
            return true;
        }
        return false;
    }

    /*public boolean setFinishWithoutTieBreak() {
        if (matchType == MatchType.BEST_OF_THREE) {
            if (player2.getScore().getSets().winSet == 2 || player1.getScore().getSets().winSet == 2) {
                return true;
            }
            return false;
        } else {
            if (player2.getScore().getSets().winSet == 3 || player1.getScore().getSets().winSet == 3) {
                return true;
            }
            return false;
        }
    }*/

    public boolean endSetWithoutTieBreak() {

        if (player1.getScore().getGames(actualSet).gameWin() == 6 && player2.getScore().getGames(actualSet).gameWin() <=4
            || player2.getScore().getGames(actualSet).gameWin() == 6 && player1.getScore().getGames(actualSet).gameWin() <=4) {
            return true;
        } else {

        }

        return false;
    }

    private void playerWonGame(Player player) {
        if (player.getName() == player1.getName()) {
            int gamePlayer = player1.getScore().getGames(actualSet).gameWin();
            gamePlayer++;
        } else {
            int gamePlayer = player2.getScore().getGames(actualSet).gameWin();
            gamePlayer++;
        }
    }

    private void resetPointPlayer() {
        actualGame++;
        player1.getScore().getGames(actualSet).gameFinish();
        player2.getScore().getGames(actualSet).gameFinish();
    }


    public String pointsForPlayer(Player player) {
        return player.getScore().getGames(actualSet).getPointForGame(actualGame);
    }

    public int currentSetNumber() {
        return actualSet + 1;
    }

    public int gamesInCurrentSetForPlayer(Player player) {
        return player.getScore().getGames(actualSet).gameWin();
    }

    public int gamesInSetForPlayer(int set, Player player) {
        return 0;
    }

    public boolean isFinished() {
        return true;
    }

    public void getScore() {
        System.out.println("Joueur1: " + player1.getScore().getGames(actualSet).getPointForGame(actualGame) + " Game :" + player1.getScore().getGames(actualSet).gameWin() + " / Joueur2: "
                + player2.getScore().getGames(actualSet).getPointForGame(actualGame) + " Game :" + player2.getScore().getGames(actualSet).gameWin());
    }
}
