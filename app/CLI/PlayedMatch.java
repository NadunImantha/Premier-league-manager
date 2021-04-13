package CLI;

import java.io.Serializable;

public class PlayedMatch implements Serializable {
    private String ATeam;
    private String BTeam;
    private int ATeamScore;
    private int BTeamScore;
    private String playedDate;

    public PlayedMatch(String playedDate, String ATeam, String BTeam, int ATeamScore, int BTeamScore) {
        this.ATeam = ATeam;
        this.BTeam = BTeam;
        this.ATeamScore = ATeamScore;
        this.BTeamScore = BTeamScore;
        this.playedDate = playedDate;
    }

    // create getters
    public String getATeam() {
        return ATeam;
    }

    public String getBTeam() {
        return BTeam;
    }

    public int getATeamScore() {
        return ATeamScore;
    }

    public int getBTeamScore() {
        return BTeamScore;
    }

    public String getPlayedDate() {
        return playedDate;
    }

    // create setters
    public void setATeam(String ATeam) {
        this.ATeam = ATeam;
    }

    public void setBTeam(String BTeam) {
        this.BTeam = BTeam;
    }

    public void setATeamScore(int ATeamScore) {
        this.ATeamScore = ATeamScore;
    }

    public void setBTeamScore(int BTeamScore) {
        this.BTeamScore = BTeamScore;
    }

    public void setPlayedDate(String playedDate) {
        this.playedDate = playedDate;
    }

}
