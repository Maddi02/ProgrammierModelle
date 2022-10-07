import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoccerGames {

    private String homeTeam = " ";
    private String awayTeam = " ";
    private final char seperator = ':';
    private Date venue = new Date();
    private Result result = new Result();

    public SoccerGames(String homeTeam, String awayTeam, Date venue, Result result) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.venue = venue;
        this.result = result;
        setValidGameData();
    }

    public String getHomeTeam() {
        return homeTeam;
    }


    public String getAwayTeam() {
        return awayTeam;
    }

    public Date getVenue() {
        return venue;
    }

    public Result getResult() {
        return result;
    }

    @Override
    public String toString() {
        return venue + " " + homeTeam +  seperator + awayTeam + " " + result.toString();
    }

    private void setValidGameData()
    {
        Pattern p = Pattern.compile("\\s*[a-zA-Z0-9äüöÄÜÖ]{3,}");
        Matcher matchHomeTeam = p.matcher(this.homeTeam);
        Matcher matchAwayTeam = p.matcher(this.awayTeam);
        if(!(matchAwayTeam.matches() && matchHomeTeam.matches()))
        {
            this.homeTeam = "Unknown";
            this.awayTeam = "Unknown";
        }
    }
}


