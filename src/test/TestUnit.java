import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestUnit {

    TennisMatch tennisMatch;
    Player player1;
    Player player2;

    @Before
    public void setUp() throws Exception {
        player1 = new Player("Jeremy");
        player2 = new Player("Thomas");
        tennisMatch = new TennisMatch(player1, player2, MatchType.BEST_OF_FIVE, true);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.getScore();
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.getScore();
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.getScore();
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.getScore();
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.getScore();
    }

}
