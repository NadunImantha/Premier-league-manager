package CLI;

import java.util.Comparator;

public class GoalDeferenceComparator implements Comparator<FootballClub> {
    // sort in descending order
    @Override
    public int compare(FootballClub club1, FootballClub club2) {
        if (club1.getNoOfPoints() > club2.getNoOfPoints())
            return -1;

        else if (club1.getNoOfPoints() == club2.getNoOfPoints()){
            int goalDeferenceClub1 = club1.getNoOfScoredGoals() - club1.getNoOfReceivedGoals(); // calculate club 1 goal deference
            int goalDeferenceClub2 = club2.getNoOfScoredGoals() - club2.getNoOfReceivedGoals(); // calculate club 2 goal deference

            if (goalDeferenceClub1 > goalDeferenceClub2)
                return 0;
            else
                return 1;
        }

        else
            return 1;
    }
}
