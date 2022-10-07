import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;


public class SoccerGamesTest {


    @Test
    void testResultWithRegex() {
        SoccerGames fußballspieleKnownResult = null;
        SoccerGames fußballspieleUnknownResult = null;
        try {
            fußballspieleKnownResult = new SoccerGames("Schalke", "Muenchen", new SimpleDateFormat("MM-dd-yyyy").parse("11-03-2010"), new Result(1, 2));
            fußballspieleUnknownResult = new SoccerGames("Schalke", "Muenchen", new SimpleDateFormat("MM-dd-yyyy").parse("11-03-2010"), new Result());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Pattern p = Pattern.compile("(Mon|Tue|Wed|Thu|Fri|Sat|Sun)\\s*(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)\\s*\\d{1,2}\\s*\\d{1,2}:\\d{1,2}:\\d{1,2}\\s*(CET)\\s*\\d{4}\\s*[a-zA-Z0-9äüöÄÜÖ]{2,}\\s*(:)\\s*[a-zA-Z0-9äüöÄÜÖ]{2,}\\s*(\\d+|(-))(:)(\\d+|(-))");
        Matcher m = p.matcher(fußballspieleKnownResult.toString());
        assertTrue(m.matches());
        m = p.matcher(fußballspieleUnknownResult.toString());
        assertTrue(m.matches());
    }


    @Test
    void TestSoccerGame() throws Exception {
        SoccerGames fußballspieleKnownResult = null;
        SoccerGames fußballspieleUnknownResult = null;
        try {
            fußballspieleKnownResult = new SoccerGames("Schalke", "Muenchen", new SimpleDateFormat("MM-dd-yyyy").parse("11-03-2010"), new Result(1, 2));
            fußballspieleUnknownResult = new SoccerGames("Schalke", "Muenchen", new SimpleDateFormat("MM-dd-yyyy").parse("11-03-2010"), new Result());
        }
        catch (ParseException e)
        {
            throw new RuntimeException(e);
        }
        assertEquals(fußballspieleKnownResult.getResult().getPointAwayTeam(),2);
        assertEquals(fußballspieleKnownResult.getResult().getPointHomeTeam(),1);
        assertEquals(fußballspieleKnownResult.getAwayTeam(),"Muenchen");
        assertEquals(fußballspieleKnownResult.getHomeTeam(),"Schalke");
        assertEquals(fußballspieleKnownResult.getVenue(), new SimpleDateFormat("MM-dd-yyyy").parse("11-03-2010"));


        SoccerGames finalFußballspieleUnknownResult = fußballspieleUnknownResult;
        Exception exception = assertThrows(Exception.class, () -> finalFußballspieleUnknownResult.getResult().getPointAwayTeam());
        assertEquals("Result not known jet", exception.getMessage());
    }
}
