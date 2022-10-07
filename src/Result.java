import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Result {
    private int pointHomeTeam = -1;
    private int pointAwayTeam = -1;

    private final char seperatorResult = ':';

    public Result(int pointHomeTeam , int pointAwayTeam) {
            this.pointHomeTeam = pointHomeTeam;
            this.pointAwayTeam = pointAwayTeam;
            setPoints();

    }

    public Result() {
        this.pointHomeTeam = -1; // ASCII -
        this.pointAwayTeam = -1; // ASCII -
    }

    public int getPointHomeTeam() throws Exception {
        if(pointHomeTeam >= 0) {
            return pointHomeTeam;
        }
        else {
            throw new Exception("Result not known jet");
        }
    }


    public int getPointAwayTeam() throws Exception
    {
        if(pointAwayTeam >= 0) {
            return pointAwayTeam;
        }
        else {
            throw new Exception("Result not known jet");
        }
    }

    @Override
    public String toString() {

        if(pointHomeTeam >= 0 && pointAwayTeam >= 0) {
            return String.valueOf(pointHomeTeam) + seperatorResult + String.valueOf(pointAwayTeam);
        }
        else
        {
            return "-" + seperatorResult + "-";
        }
    }

    private void setPoints()
    {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(String.valueOf(pointAwayTeam));
        if(!m.matches())
        {
            this.pointHomeTeam = -1;
            this.pointAwayTeam = -1;
        }
    }
}
