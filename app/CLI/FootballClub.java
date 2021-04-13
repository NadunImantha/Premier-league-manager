package CLI;

import java.io.Serializable;

public class FootballClub extends SportClub implements Serializable {
    private int noOfWins;
    private int noOfDraws;
    private int noOfDefeats;
    private int noOfScoredGoals;
    private int noOfReceivedGoals;
    private int noOfPoints;
    private int noOfPlayedMatches;

    public FootballClub(String clubName, String clubLocation) {
        super(clubName, clubLocation);
    }

    public FootballClub(String clubName, String clubLocation, int noOfWins, int noOfDraws, int noOfDefeats, int noOfScoredGoals, int noOfReceivedGoals, int noOfPoints, int noOfPlayedMatches) {
        super(clubName, clubLocation);
        this.noOfWins = noOfWins;
        this.noOfDraws = noOfDraws;
        this.noOfDefeats = noOfDefeats;
        this.noOfScoredGoals = noOfScoredGoals;
        this.noOfReceivedGoals = noOfReceivedGoals;
        this.noOfPoints = noOfPoints;
        this.noOfPlayedMatches = noOfPlayedMatches;
    }

    // create getters
    public int getNoOfWins() {
        return noOfWins;
    }

    public int getNoOfDraws() {
        return noOfDraws;
    }

    public int getNoOfDefeats() {
        return noOfDefeats;
    }

    public int getNoOfScoredGoals() {
        return noOfScoredGoals;
    }

    public int getNoOfReceivedGoals() {
        return noOfReceivedGoals;
    }

    public int getNoOfPoints() {
        return noOfPoints;
    }

    public int getNoOfPlayedMatches() {
        return noOfPlayedMatches;
    }

    // create setters
    public void setNoOfWins(int noOfWins) {
        this.noOfWins = noOfWins;
    }

    public void setNoOfDraws(int noOfDraws) {
        this.noOfDraws = noOfDraws;
    }

    public void setNoOfDefeats(int noOfDefeats) {
        this.noOfDefeats = noOfDefeats;
    }

    public void setNoOfScoredGoals(int noOfScoredGoals) {
        this.noOfScoredGoals = noOfScoredGoals;
    }

    public void setNoOfReceivedGoals(int noOfReceivedGoals) {
        this.noOfReceivedGoals = noOfReceivedGoals;
    }

    public void setNoOfPoints(int noOfPoints) {
        this.noOfPoints = noOfPoints;
    }

    public void setNoOfPlayedMatches(int noOfPlayedMatches) {
        this.noOfPlayedMatches = noOfPlayedMatches;
    }
}
