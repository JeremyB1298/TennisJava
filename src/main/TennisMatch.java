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
        if (isFinished()) {
            System.out.println("Match terminé");
        } else {
            if ( player.getName() == player1.getName() ) {
                if (player1.getScore().decisifGame == null) {
                    player1.getScore().getGames(actualSet).setPointForGame(actualGame,updatePointScore(player1.getScore().getGames(actualSet).getPointForGame(actualGame),player1));

                } else {
                    player1.getScore().decisifGame.setPointForGame(0,String.valueOf(Integer.valueOf(player1.getScore().decisifGame.getPointForGame(0)) + 1));
                }
                if (tieBreak) {
                    endSetWithTieBreak();
                }
                else {
                    endSetWithoutTieBreak();
                }
            } else {
                if (player2.getScore().decisifGame == null) {
                    player2.getScore().getGames(actualSet).setPointForGame(actualGame, updatePointScore(player2.getScore().getGames(actualSet).getPointForGame(actualGame), player2));
                } else {
                    player2.getScore().decisifGame.setPointForGame(0,String.valueOf(Integer.valueOf(player2.getScore().decisifGame.getPointForGame(0)) + 1));
                }
                if (tieBreak) {
                    endSetWithTieBreak();
                }
                else {
                    endSetWithoutTieBreak();
                }
            }
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

    public boolean endSetWithTieBreak() {
        if (player1.getScore().getGames(actualSet).gameWin() == 6 && player2.getScore().getGames(actualSet).gameWin() <=4
                || player2.getScore().getGames(actualSet).gameWin() == 6 && player1.getScore().getGames(actualSet).gameWin() <=4) {
            setPlayerWinSetWithoutTieBreak();
            return true;
        } else if (player1.getScore().getGames(actualSet).gameWin() == 7 && player2.getScore().getGames(actualSet).gameWin() == 5
                || player2.getScore().getGames(actualSet).gameWin() == 7 && player1.getScore().getGames(actualSet).gameWin() == 5) {
            setPlayerWinSetWithoutTieBreak();
            return true;
        }
        else if (player1.getScore().getGames(actualSet).gameWin() >= 6 && player2.getScore().getGames(actualSet).gameWin() >=6
        && player1.getScore().decisifGame == null && player2.getScore().decisifGame == null) {
            player1.getScore().decisifGame = new Game();
            player2.getScore().decisifGame = new Game();
            return false;
        } else if (player1.getScore().decisifGame != null && player2.getScore().decisifGame != null) {

            if (Integer.valueOf(player1.getScore().decisifGame.getPointForGame(0))  == 7
                    && Integer.valueOf(player2.getScore().decisifGame.getPointForGame(0))  <= 5 ) {
                setPlayerWinSetWithTieBreak(player1);
                player1.getScore().decisifGame = null;
                player2.getScore().decisifGame = null;
                return true;
            }
            if (Integer.valueOf(player2.getScore().decisifGame.getPointForGame(0))  == 7
                    && Integer.valueOf(player1.getScore().decisifGame.getPointForGame(0))  <= 5) {
                setPlayerWinSetWithTieBreak(player2);
                player1.getScore().decisifGame = null;
                player2.getScore().decisifGame = null;
                return true;
            } else if (Integer.valueOf(player2.getScore().decisifGame.getPointForGame(0))  >= 6
                    && Integer.valueOf(player1.getScore().decisifGame.getPointForGame(0))  >= 6) {
                if (Integer.valueOf(player2.getScore().decisifGame.getPointForGame(0)) +2 == Integer.valueOf(player1.getScore().decisifGame.getPointForGame(0))) {
                    setPlayerWinSetWithTieBreak(player1);
                    player1.getScore().decisifGame = null;
                    player2.getScore().decisifGame = null;
                    return true;
                } else if (Integer.valueOf(player1.getScore().decisifGame.getPointForGame(0)) +2 == Integer.valueOf(player2.getScore().decisifGame.getPointForGame(0))) {
                    setPlayerWinSetWithTieBreak(player2);
                    player1.getScore().decisifGame = null;
                    player2.getScore().decisifGame = null;
                    return true;
                } else {
                    return false;
                }
            }
            else {
                return false;

            }
        } else {
                return false;
            }
        }

    public boolean endSetWithoutTieBreak() {

        if (player1.getScore().getGames(actualSet).gameWin() == 6 && player2.getScore().getGames(actualSet).gameWin() <=4
            || player2.getScore().getGames(actualSet).gameWin() == 6 && player1.getScore().getGames(actualSet).gameWin() <=4) {
            setPlayerWinSetWithoutTieBreak();
            return true;
        } else if (player1.getScore().getGames(actualSet).gameWin() >=5 && player2.getScore().getGames(actualSet).gameWin() >=5){
            if (player1.getScore().getGames(actualSet).gameWin() == player2.getScore().getGames(actualSet).gameWin()+2
                    || player1.getScore().getGames(actualSet).gameWin() + 2 == player2.getScore().getGames(actualSet).gameWin()) {
                setPlayerWinSetWithoutTieBreak();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private void setPlayerWinSetWithTieBreak(Player player) {
            player.getScore().getSets().winSet();
            actualSet++;
            resetGamePlayer();
    }

    private void setPlayerWinSetWithoutTieBreak() {
        if (player1.getScore().getGames(actualSet).gameWin() > player2.getScore().getGames(actualSet).gameWin()) {
            player1.getScore().getSets().winSet();
            actualSet++;
            resetGamePlayer();
        } else {
            player2.getScore().getSets().winSet();
            actualSet++;
            resetGamePlayer();
        }
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

    private void resetGamePlayer() {
        actualGame = 0;
        player1.getScore().getSets().resetGame();
        player2.getScore().getSets().resetGame();
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

        if (player1.getScore().decisifGame == null && player2.getScore().decisifGame == null) {
            return player.getScore().getGames(set-1).gameWin();
        } else {
            return Integer.valueOf(player.getScore().decisifGame.getPointForGame(0));
        }

    }

    public boolean isFinished() {
            if (player1.getScore().getSets().winSet == matchType.numberOfSetsToWin()) {
                return true;
            } else if (player2.getScore().getSets().winSet == matchType.numberOfSetsToWin()) {
                return true;
            }
        return false;
    }

    public void getScore() {
        System.out.println("Joueur1: " + player1.getScore().getGames(actualSet).getPointForGame(actualGame) + " Game :" + player1.getScore().getGames(actualSet).gameWin() + " / Joueur2: "
                + player2.getScore().getGames(actualSet).getPointForGame(actualGame) + " Game :" + player2.getScore().getGames(actualSet).gameWin());
    }
}
