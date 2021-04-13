package CLI;

import java.io.Serializable;

public class SchoolFootballClub extends FootballClub implements Serializable {
    private String schoolName;

    public SchoolFootballClub(String clubName, String clubLocation, String schoolName) {
        super(clubName, clubLocation);
        this.schoolName = schoolName;
    }

    public SchoolFootballClub(String clubName, String schoolName, String clubLocation, int noOfWins, int noOfDraws, int noOfDefeats, int noOfScoredGoals, int noOfReceivedGoals, int noOfPoints, int noOfPlayedMatches) {
        super(clubName, clubLocation, noOfWins, noOfDraws, noOfDefeats, noOfScoredGoals, noOfReceivedGoals, noOfPoints, noOfPlayedMatches);
        this.schoolName = schoolName;
    }

    // create getter
    public String getSchoolName() {
        return schoolName;
    }

    // create setter
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
