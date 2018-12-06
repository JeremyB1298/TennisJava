public class Score {
    private String pointWon;
    private String setwon;
    private String gameWon;

    public Score(String pointWon, String setwon, String gameWon) {
        this.pointWon = pointWon;
        this.setwon = setwon;
        this.gameWon = gameWon;
    }

    public void setPointWon(String pointWon) {
        this.pointWon = pointWon;
    }

    public void setSetwon(String setwon) {
        this.setwon = setwon;
    }

    public void setGameWon(String gameWon) {
        this.gameWon = gameWon;
    }

    public String getPointWon() {
        return pointWon;
    }

    public String getSetwon() {
        return setwon;
    }

    public String getGameWon() {
        return gameWon;
    }
}

