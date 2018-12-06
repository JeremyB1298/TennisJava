import org.junit.After;
import org.junit.Before;

public class Test {

    TennisMatch tennisMatch;

    @Before
    public void setUp() throws Exception {
        Player player1 = new Player("Jeremy");
        Player player2 = new Player("Thomas");
        tennisMatch = new TennisMatch(player1, player2, MatchType.BEST_OF_FIVE, true);
        tennisMatch.updateWithPointWonBy(player1);
        System.out.println("Score1: " + player1.getScore() + " / " + "Score2: " + player2.getScore());
    }

    @After
    public void tearDown() throws Exception {
    }


}
