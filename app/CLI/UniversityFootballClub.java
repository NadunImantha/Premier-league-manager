package CLI;

import java.io.Serializable;

public class UniversityFootballClub extends FootballClub implements Serializable {
    private String uniName;

    public UniversityFootballClub(String clubName, String clubLocation, String uniName) {
        super(clubName, clubLocation);
        this.uniName = uniName;
    }

    public UniversityFootballClub(String clubName, String uniName, String clubLocation, int noOfWins, int noOfDraws, int noOfDefeats, int noOfScoredGoals, int noOfReceivedGoals, int noOfPoints, int noOfPlayedMatches) {
        super(clubName, clubLocation, noOfWins, noOfDraws, noOfDefeats, noOfScoredGoals, noOfReceivedGoals, noOfPoints, noOfPlayedMatches);
        this.uniName = uniName;
    }

    // create getters
    public String getUniName() {
        return uniName;
    }

    // create setters
    public void setUniName(String uniName) {
        this.uniName = uniName;
    }
}
