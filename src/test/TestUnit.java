import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestUnit {

    TennisMatch tennisMatch;
    Player player1;
    Player player2;

    @Before
    public void setUp() throws Exception {
        player1 = new Player("Jeremy");
        player2 = new Player("Thomas");
        tennisMatch = new TennisMatch(player1, player2, MatchType.BEST_OF_THREE, true);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void player1TakeAdvantage() {
        tennisMatch.updateWithPointWonBy(player1);// 15 à 0
        tennisMatch.updateWithPointWonBy(player1);// 30 à 0
        tennisMatch.updateWithPointWonBy(player1);// 40 à 0
        tennisMatch.updateWithPointWonBy(player2);// 40 à 15
        tennisMatch.updateWithPointWonBy(player2);// 40 à 30
        tennisMatch.updateWithPointWonBy(player2);// 40 à 40
        tennisMatch.updateWithPointWonBy(player2);// 40 à A
        tennisMatch.updateWithPointWonBy(player1);// A à 40
        //tennisMatch.getScore();
        assertEquals("40",tennisMatch.pointsForPlayer(player2));
        assertEquals("A",tennisMatch.pointsForPlayer(player1));
    }

    @Test
    public void player2TakeAdvantage() {
        tennisMatch.updateWithPointWonBy(player1);// 15 à 0
        tennisMatch.updateWithPointWonBy(player1);// 30 à 0
        tennisMatch.updateWithPointWonBy(player1);// 40 à 0
        tennisMatch.updateWithPointWonBy(player2);// 40 à 15
        tennisMatch.updateWithPointWonBy(player2);// 40 à 30
        tennisMatch.updateWithPointWonBy(player2);// 40 à 40
        tennisMatch.updateWithPointWonBy(player1);// A à 40
        tennisMatch.updateWithPointWonBy(player2);// 40 à A

        assertEquals("40",tennisMatch.pointsForPlayer(player1));
        assertEquals("A",tennisMatch.pointsForPlayer(player2));
    }

    @Test
    public void player1WinGame() {
        tennisMatch.updateWithPointWonBy(player1);// 15 à 0
        tennisMatch.updateWithPointWonBy(player1);// 30 à 0
        tennisMatch.updateWithPointWonBy(player1);// 40 à 0
        tennisMatch.updateWithPointWonBy(player2);// 40 à 15
        tennisMatch.updateWithPointWonBy(player2);// 40 à 30
        tennisMatch.updateWithPointWonBy(player1);// W à 30
        tennisMatch.getScore(); // game : 1 à 0
        assertEquals(1,tennisMatch.gamesInCurrentSetForPlayer(player1));
    }

    @Test
    public void player2WinWithTieBreak() {
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);

        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);

        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);

        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);

        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);

        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);

        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);

        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);

        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);

        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);

        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);

        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);

        //tie break score 6-6

        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);

        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);

        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);

        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);

        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);

        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);

        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);

        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);

        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);

        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);

        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);

        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);

        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);

        assertTrue(tennisMatch.isFinished());
    }

    @Test
    public void player2Win() {
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);

        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);

        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);

        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);

        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);

        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);

        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);

        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);

        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);

        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);

        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);

        assertEquals(5,tennisMatch.gamesInCurrentSetForPlayer(player1));
        assertEquals(6,tennisMatch.gamesInCurrentSetForPlayer(player2));

        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);

        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);

        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);

        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);

        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);

        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);

        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);

        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);

        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);

        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);

        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);

        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);

        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);

        assertTrue(tennisMatch.isFinished());
    }

}
