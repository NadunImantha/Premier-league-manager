package CLI;

import java.io.Serializable;

public abstract class SportClub implements Serializable {
    private String clubName;
    private String clubLocation;
    private String clubStatistics;

    // constructor
    public SportClub(String clubName, String clubLocation) {
        this.clubName = clubName;
        this.clubLocation = clubLocation;
    }

    // Create getters
    public String getClubName() {
        return clubName;
    }

    public String getClubLocation() {
        return clubLocation;
    }

    public String getClubStatistics() {
        return clubStatistics;
    }

    // Create setters

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public void setClubLocation(String clubLocation) {
        this.clubLocation = clubLocation;
    }

    public void setClubStatistics(String clubStatistics) {
        this.clubStatistics = clubStatistics;
    }

}
